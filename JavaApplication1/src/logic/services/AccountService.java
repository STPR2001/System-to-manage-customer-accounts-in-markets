package logic.services;

import java.sql.*;
import db.DBConnection;
import java.io.PrintWriter;
import java.util.ArrayList;
import logic.classes.Account;
import java.util.logging.Logger;
import logic.classes.Debt;
import logic.classes.FullAccount;
import logic.classes.GeneralData;
import logic.classes.Password;
import logic.classes.Payment;
import logic.classes.PaymentInterval;
import logic.classes.User;

public class AccountService {

    private Connection connection = new DBConnection().getConnection();

    public AccountService() {
    }

    public void desactiveAccount(String accountId) {
        try {
            String queryString = "update accounts set is_active = false where id = ?";
            PreparedStatement query = connection.prepareStatement(queryString);
            query.setString(1, accountId);
            query.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger("error deactivating account");
        }
    }

    public void setVerificationAccount(String accountId) {
        try {
            String queryString = "update accounts set verified = true where id = ?";
            PreparedStatement query = connection.prepareStatement(queryString);
            query.setString(1, accountId);
            query.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger("Error verifying account");
        }
    }

    public ArrayList<Payment> getAllPaymentTransactionsByOrgId(String orgId) {
        ArrayList<Payment> paymentTransactions = new ArrayList();

        try {
            //SELECT * FROM sale_transactions WHERE account_id IN (SELECT id FROM accounts WHERE organization_id=)
            String queryString = "select * from payment_transactions where account_id IN (select id from accounts where organization_id = ?) ORDER BY created_at DESC";//
            PreparedStatement query = connection.prepareStatement(queryString);
            query.setString(1, orgId);

            ResultSet result = query.executeQuery();

            GeneralData attributes;

            while (result.next()) {
                attributes = new GeneralData(
                        result.getInt("id"),
                        result.getDate("created_at"),
                        result.getDate("updated_at")
                );

                Float totalAmount = result.getFloat("total_amount");
                String status = result.getString("status");

                Payment payment = new Payment(
                        status, //cambié el constructor a String por ahora, luego si quieren lo ponemos en enum pero me parecio medio innecesario ahora mismo, mucha comparacion con los ifs y despues igual tenes que enviar un string
                        attributes,
                        totalAmount,
                        result.getString("account_id")
                );
                paymentTransactions.add(payment);
            }

        } catch (SQLException e) {
            Logger.getLogger("Error trying to get payment transactions");
        }

        return paymentTransactions;
    }

    public ArrayList<Debt> getAllDebtTransactionsByOrgId(String orgId) {
        ArrayList<Debt> debtTransactions = new ArrayList();

        try {
            //SELECT * FROM sale_transactions WHERE account_id IN (SELECT id FROM accounts WHERE organization_id=)
            String queryString = "select * from sale_transactions where account_id IN (select id from accounts where organization_id = ?) ORDER BY created_at DESC";
            PreparedStatement query = connection.prepareStatement(queryString);
            query.setString(1, orgId);

            ResultSet result = query.executeQuery();

            GeneralData attributes;

            while (result.next()) {
                attributes = new GeneralData(
                        result.getInt("id"),
                        result.getDate("created_at"),
                        result.getDate("updated_at")
                );
                Float initialPrice = result.getFloat("initial_price");
                Debt debt = new Debt(
                        initialPrice,
                        attributes,
                        result.getFloat("total_amount"),
                        result.getString("detail"),
                        result.getBoolean("confirmed"),
                        result.getString("account_id")
                );
                debtTransactions.add(debt);
            }

        } catch (SQLException e) {
            Logger.getLogger("Error trying to get debt transactions");
        }

        return debtTransactions;

    }

    public ArrayList<Debt> getAccountDebtTransactions(String id) {
        ArrayList<Debt> debtTransactions = new ArrayList();

        try {
            String queryString = "select * from sale_transactions where account_id = ?";
            PreparedStatement query = connection.prepareStatement(queryString);
            query.setString(1, id);

            ResultSet result = query.executeQuery();

            GeneralData attributes;

            while (result.next()) {
                attributes = new GeneralData(
                        result.getInt("id"),
                        result.getDate("created_at"),
                        result.getDate("updated_at")
                );
                Float initialPrice = result.getFloat("initial_price");
                Debt debt = new Debt(
                        initialPrice,
                        attributes,
                        result.getFloat("total_amount"),
                        result.getString("detail"),
                        result.getBoolean("confirmed"),
                        result.getString("account_id")
                );
                debtTransactions.add(debt);
            }

        } catch (SQLException e) {
            Logger.getLogger("Error trying to get debt transactions");
        }

        return debtTransactions;
    }

    // Given an organization id, it returns the info of those users
    // that have accounts on that organization
    public ArrayList<Account> getAccountsByOrganizationId(String organizationId) {
        ArrayList<Account> accounts = new ArrayList();

        try {
            String queryString = "select A.* from accounts as A where "
                    + "A.organization_id = ? ORDER BY created_at DESC";
            PreparedStatement query = connection.prepareStatement(queryString);
            query.setString(1, organizationId);

            ResultSet result = query.executeQuery();

            while (result.next()) {
                Integer userId;
                Float limit, total;
                GeneralData attributes;

                userId = result.getInt("user_id");
                total = result.getFloat("total");
                limit = result.getFloat("limit_amount");

                attributes = new GeneralData(
                        result.getInt("id"),
                        result.getDate("created_at"),
                        result.getDate("updated_at"));

                accounts.add(new Account(
                        userId,
                        total,
                        limit,
                        PaymentInterval.ONEMONTH,
                        attributes,
                        null,
                        true));
            }

        } catch (SQLException e) {
            Logger.getLogger("Error trying to get organization by id");
        }

        return accounts;
    }

    public ArrayList<FullAccount> getFullAccountsByUserId(String userIdReceived) {
        ArrayList<FullAccount> accounts = new ArrayList();

        try {
            String queryString = "select O.name, O.description, A.* from organizations as O, accounts as A where A.user_id = ? and A.organization_id = O.id";
            PreparedStatement query = connection.prepareStatement(queryString);
            query.setString(1, userIdReceived);

            ResultSet result = query.executeQuery();

            while (result.next()) {
                String organizationName = result.getString("name");
                String organizationDescription = result.getString("description");

                Integer accountId = result.getInt("id");
                Integer userId = result.getInt("user_id");

                Float total = result.getFloat("total");
                Float limit = result.getFloat("limit_amount");

                Boolean verified = result.getBoolean("verified");
                Boolean active = result.getBoolean("is_active");

                GeneralData attributes = new GeneralData(
                        accountId,
                        result.getDate("created_at"),
                        result.getDate("updated_at"));

                accounts.add(new FullAccount(
                        organizationName,
                        organizationDescription,
                        accountId,
                        verified,
                        userId,
                        total,
                        limit,
                        PaymentInterval.ONEMONTH,
                        attributes,
                        null,
                        active));
            }

        } catch (SQLException e) {
            Logger.getLogger("Error trying to get organization by id");
        }

        return accounts;
    }

    public Account getAccountById(String id) {
        Account account = null;

        try {
            String queryString = "select * from accounts where id = ?";
            PreparedStatement query = connection.prepareStatement(queryString);
            query.setString(1, id);

            ResultSet result = query.executeQuery();

            Integer userId = null;
            PaymentInterval paymentInterval = PaymentInterval.ONEWEEK;
            Float limit = 0f, total = 0f;
            GeneralData generalData = new GeneralData(0, null, null);
            String password = "";

            while (result.next()) {
                //paymentInterval = result.getString("payment_interval");
                userId = result.getInt("user_id");
                total = result.getFloat("total");
                limit = result.getFloat("limit_amount");
                password = result.getString("password");

                generalData = new GeneralData(
                        result.getInt("id"),
                        result.getDate("created_at"),
                        result.getDate("updated_at")
                );
            }

            if (generalData.getId() != 0) {
                account = new Account(
                        userId,
                        total,
                        limit,
                        paymentInterval,
                        generalData,
                        password,
                        false
                );

            }
        } catch (SQLException e) {
            Logger.getLogger("Error trying to get account by id");
        }

        return account;
    }

    public ArrayList<Account> getAllAccounts() {

        ArrayList result = new ArrayList();

        try {

            String queryString = "SELECT * FROM accounts";
            PreparedStatement query = connection.prepareStatement(queryString);
            ResultSet queryResult = query.executeQuery();

            /*
            id integer AUTO_INCREMENT primary key,
            total float not null,
            limit_amount float not null,
            user_id integer not null,
            organization_id integer not null,
            # w for weekly, m for monthly, t for 3-m
            payment_interval varchar(20) default "m",
            created_at timestamp default CURRENT_TIMESTAMP,
            updated_at timestamp default CURRENT_TIMESTAMP,
            foreign key(user_id) references users(id),
            foreign key(organization_id) references organizations(id)
             */
            while (queryResult.next()) {
                /*
                String total = queryResult.getFloat("Total");
                String limit = queryResult.getString("Limit");
                String interval = queryResult.getString("Interval");
                String active = queryResult.getString("Active");
                GeneralData attributes = new GeneralData();
                Password password = new Password();
                float floatTotal = Float.parseFloat(total);
                float floatLimit = Float.parseFloat(limit);
                
                if (interval.equals("ONEWEEK")) {
                    //crear nuevo objeto con ese valor
                }
                //mas comparaciones con interval
                
                if (active.equals("TRUE"))){
                    
                }
                 */
                //result.add(new Account(floatTotal,floatLimit,interval,attributes,password,active));//conflicto por constructor
            }

            //(float total, float limit, PaymentInterval paymentInterval, GeneralData attributes, Password password, boolean active)
        } catch (SQLException ex) {
            Logger.getLogger("Error getting al accounts");
        }

        return result;

    }

    public void createAccount(int organizationId, int userId, String limit_amount, String password) {
        try {
            String queryString = "INSERT INTO accounts (limit_amount, password, user_id, organization_id) VALUES (?,?,?,?)";
            PreparedStatement query = connection.prepareStatement(queryString);

            query.setString(1, limit_amount);
            query.setString(2, password);
            query.setInt(3, userId);
            query.setInt(4, organizationId);
            query.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger("Error creating Account");
        }
    }

    public void setAccountNewTotalAmount(String accountId, Float totalUpdatedDebt) {

        try {
            String queryString = "UPDATE accounts SET total = ? WHERE id = ?";
            PreparedStatement query = connection.prepareStatement(queryString);

            query.setFloat(1, totalUpdatedDebt);
            query.setString(2, accountId);
            query.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger("Error updating account total");
        }

    }

    public Float getAccountTotalAmount(String accountId) {
        Float total;
        total = Float.valueOf(0);
        try {
            String consultaSQL = "SELECT total FROM accounts WHERE id = ?;";
            try (PreparedStatement query = this.connection.prepareStatement(consultaSQL)) {
                query.setString(1, accountId);
                try (ResultSet result = query.executeQuery()) {
                    if (result.next()) {
                        // Obtiene el valor Float de la columna "columna_float"
                        total = result.getFloat("total");
                        return total;
                    } else {
                        // Si no se encontraron resultados
                        return 0.0f; // o cualquier otro valor por defecto
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger("Error getting account total amount");
        }

        return total;
    }
}
