package logic.services;

import java.sql.*;
import db.DBConnection;
import logic.classes.Transaction;
import java.util.logging.Logger;
import logic.classes.Debt;
import logic.classes.GeneralData;
import logic.classes.Payment;

public class TransactionService {

    private Connection connection = new DBConnection().getConnection();

    public TransactionService() {
    }

    public Boolean confirmDebtTransaction(String transactionId) {
        try {
            String queryString = "update sale_transactions set confirmed = 1 where id = ?";
            PreparedStatement query = connection.prepareStatement(queryString);

            query.setString(1, transactionId);
            query.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger("Error creating Transaction");
            return false;
        }
    }

    // Returns transaction id
    public Integer createDebtTransaction(String accountId, String detail, String initialPrice, String totalAmount) {
        Integer transactionId = null;

        try {
            String queryString = "INSERT INTO sale_transactions (account_id, detail, initial_price, total_amount) VALUES (?,?,?,?)";
            PreparedStatement query = connection.prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);

            query.setString(1, accountId);
            query.setString(2, detail);
            query.setString(3, initialPrice);
            query.setString(4, totalAmount);
            query.executeUpdate();

            ResultSet generatedKeys = query.getGeneratedKeys();
            
            if (generatedKeys.next()) {
                transactionId = generatedKeys.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger("Error creating Transaction");
        }
    
        return transactionId;
    }

    public void createPaymentTransaction(String status, String accountId, String amount, String userId) {
        try {

            String queryString = "INSERT INTO payment_transactions (status, account_id, total_amount, user_id) VALUES (?,?,?,?)";
            PreparedStatement query = connection.prepareStatement(queryString);

            query.setString(1, status);
            query.setString(2, accountId);
            query.setString(3, amount);
            query.setString(4, userId);
            query.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger("Error creating Transaction");
        }

    }

    public Debt getDebtById(int transactionIdInt) {
        Debt debt = new Debt();
        try {
            String transactionId = String.valueOf(transactionIdInt);
            String queryString = "SELECT * FROM sale_transactions WHERE id = ?";
            PreparedStatement query = connection.prepareStatement(queryString);

            query.setString(1, transactionId);

            ResultSet result = query.executeQuery();
            while (result.next()) {
                GeneralData attributes;
                attributes = new GeneralData(
                        result.getInt("id"),
                        result.getDate("created_at"),
                        result.getDate("updated_at")
                );
                Float initialPrice = result.getFloat("initial_price");
                debt = new Debt(
                        initialPrice,
                        attributes,
                        result.getFloat("total_amount"),
                        result.getString("detail"),
                        result.getBoolean("confirmed"),
                        result.getString("account_id")
                );
            }

        } catch (SQLException ex) {
            Logger.getLogger("Error trying to get debt transaction");
        }

        return debt;

    }

    public Payment getPaymentById(int transactionIdInt) {
        Payment payment = new Payment();
        try {
            String transactionId = String.valueOf(transactionIdInt);
            String queryString = "SELECT * FROM payment_transactions WHERE id = ?";
            PreparedStatement query = connection.prepareStatement(queryString);

            query.setString(1, transactionId);

            ResultSet result = query.executeQuery();
            while (result.next()) {
                GeneralData attributes;
                attributes = new GeneralData(
                        result.getInt("id"),
                        result.getDate("created_at"),
                        result.getDate("updated_at")
                );

                Float totalAmount = result.getFloat("total_amount");
                String status = result.getString("status");

                payment = new Payment(
                        status, //cambié el constructor a String por ahora, luego si quieren lo ponemos en enum pero me parecio medio innecesario ahora mismo, mucha comparacion con los ifs y despues igual tenes que enviar un string
                        attributes,
                        totalAmount,
                        result.getString("account_id")
                );
            }

        } catch (SQLException ex) {
            Logger.getLogger("Error trying to get debt transaction");
        }

        return payment;

    }
}
