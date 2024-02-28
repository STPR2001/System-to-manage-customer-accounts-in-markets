package logic.services;

import java.sql.*;
import db.DBConnection;
import java.util.ArrayList;
import logic.classes.Organization;
import java.util.logging.Logger;
import logic.classes.Account;
import logic.classes.AccountUser;
import logic.classes.Employee;
import logic.classes.GeneralData;
import logic.classes.PaymentInterval;
import logic.classes.User;
import logic.interfaces.IAuthController;
import logic.factories.Factory;

public class OrganizationService {

    private Connection connection = new DBConnection().getConnection();

    private IAuthController IAuth = Factory.getInstance().getAuthController();

    private UserService userService = new UserService();
    private AccountService accountService = new AccountService();

    public OrganizationService() {
    }

    ;
    
    public Organization getOrganizationByAccountId(String accountId) {
        Organization organization = null;

        try {
            String queryString = "select * from organizations as O, accounts as A "
                    + "where A.organization_id = O.id and A.id = ?";
            PreparedStatement query = connection.prepareStatement(queryString);
            query.setString(1, accountId);

            ResultSet result = query.executeQuery();

            Integer id = null;
            String name = null, description = null;
            Boolean isPublic = null;
            
            while (result.next()) {
                name = result.getString("name");
                id = result.getInt("id");
                description = result.getString("description");
                isPublic = result.getBoolean("public");
            }

            if (name != null) {
                organization = new Organization(
                        id,
                        name,
                        description,
                        isPublic,
                        false,
                        null,
                        null,
                        null
                );
            }
        } catch (SQLException e) {
            Logger.getLogger("Error trying to get organization by account id");
        }

        return organization;
    }
    
    public Organization getOrganizationByDebtTransactionId(String transactionId) {
        Organization organization = null;

        try {
            String queryString = "select * from organizations as O, accounts as A, sale_transactions as ST "
                    + "where ST.id = ? and ST.account_id = A.id and A.organization_id = O.id";
            PreparedStatement query = connection.prepareStatement(queryString);
            query.setString(1, transactionId);

            ResultSet result = query.executeQuery();

            Integer id = null;
            String name = null;

            while (result.next()) {
                name = result.getString("name");
                id = result.getInt("id");
            }

            if (name != null) {
                organization = new Organization(
                        id,
                        name,
                        null,
                        false,
                        false,
                        null,
                        null,
                        null
                );
            }
        } catch (SQLException e) {
            Logger.getLogger("Error trying to get organization by id");
        }

        return organization;
    }

// Get all user and asociated accounts information combined
    public ArrayList<AccountUser> getAccountAndUserDetails(
            String organizationId
    ) {
        ArrayList<AccountUser> clients = new ArrayList();

        ArrayList<User> usersInfo = this.userService.getUsersByOrganizationId(organizationId);
        ArrayList<Account> accountsInfo = this.accountService.getAccountsByOrganizationId(organizationId);

        for (Account account : accountsInfo) {
            AccountUser clientInfo = new AccountUser(null, null);
            for (User user : usersInfo) {
                if (user.getAttributes().getId() == account.getUserId()) {
                    clientInfo.setAccount(account);
                    clientInfo.setUser(user);
                }
            }
            if (clientInfo.getAccount() != null) {
                clients.add(clientInfo);
            }
        }
        return clients;
    }

    public Organization getOrganizationById(String organizationId) {
        ArrayList<Organization> organizations = new ArrayList();
        Organization organization = null;

        try {
            String queryString = "select * from organizations where id = ?";
            PreparedStatement query = connection.prepareStatement(queryString);
            query.setString(1, organizationId);

            ResultSet result = query.executeQuery();

            Integer id = null;
            String name = null;
            String description = null;
            String city = null;
            String address = null;

            while (result.next()) {
                name = result.getString("name");
                id = result.getInt("id");
                description = result.getString("description");
                city = result.getString("city");
                address = result.getString("address");
                
            }

            if (name != null) {
                organization = new Organization(
                        id,
                        name,
                        description,
                        false,
                        false,
                        null,
                        city,
                        address
                );
            }
        } catch (SQLException e) {
            Logger.getLogger("Error trying to get organization by id");
        }

        return organization;
    }

    public String getOrganizationDescriptionById(int orgId) {
        String orgDescription = "";

        try {
            String queryString = "SELECT description FROM organizations WHERE id = ?";
            PreparedStatement query = connection.prepareStatement(queryString);

            String orgIdStr = String.valueOf(orgId);

            query.setString(1, orgIdStr);
            ResultSet queryResult = query.executeQuery();

            orgDescription = queryResult.getString("description");

        } catch (SQLException ex) {
            Logger.getLogger("Error getting all Organizations");
        }

        return orgDescription;
    }

    public ArrayList<Organization> getAllOrganizationsById(int ownerId) {

        //int OwnerId = 20;//esto es para probar
        //int OwnerId = this.IAuth.GetOwnerId(); 
        ArrayList result = new ArrayList();

        try {
            String queryString = "SELECT id, name, description FROM organizations WHERE owner_id = ? ORDER BY created_at DESC";
            PreparedStatement query = connection.prepareStatement(queryString);
            query.setInt(1, ownerId);
            ResultSet queryResult = query.executeQuery();

            while (queryResult.next()) {
                int id = queryResult.getInt("id");
                String name = queryResult.getString("name");
                String description = queryResult.getString("description");

                //ACA QUEDAMOS!
                //int i =0;
                //int id = i;
                boolean a = false;
                boolean b = false;

                result.add(new Organization(id, name, description, a, b, null, null, null)); //crear clase auxiliar??

            }
        } catch (SQLException ex) {
            Logger.getLogger("Error getting all Organizations");
        }
        return result;
    }

    public ArrayList<Organization> getAllOrganization() {

        int OwnerId = 20;//esto es para probar

        //int OwnerId = this.IAuth.GetOwnerId(); 
        ArrayList result = new ArrayList();

        try {
            String queryString = "SELECT id, name, description FROM organizations WHERE owner_id = ?";
            PreparedStatement query = connection.prepareStatement(queryString);
            query.setInt(1, OwnerId);
            ResultSet queryResult = query.executeQuery();

            while (queryResult.next()) {
                int id = queryResult.getInt("id");
                String name = queryResult.getString("name");
                String description = queryResult.getString("description");

                //ACA QUEDAMOS!
                //int i =0;
                //int id = i;
                boolean a = false;
                boolean b = false;

                result.add(new Organization(id, name, description, a, b, null, null, null)); //crear clase auxiliar??

            }
        } catch (SQLException ex) {
            Logger.getLogger("Error getting all Organizations");
        }
        return result;
    }
    
    public ArrayList<Organization> listAllOrganizations() {

        ArrayList result = new ArrayList();

        try {
            String queryString = "SELECT id, name, description, city, address FROM organizations";
            PreparedStatement query = connection.prepareStatement(queryString);
            ResultSet queryResult = query.executeQuery();

            while (queryResult.next()) {
                int id = queryResult.getInt("id");
                String name = queryResult.getString("name");
                String description = queryResult.getString("description");
                String city = queryResult.getString("city");
                String address = queryResult.getString("address");

                boolean a = false;
                boolean b = false;

                result.add(new Organization(id, name, description, a, b, null, city, address)); 

            }
        } catch (SQLException ex) {
            Logger.getLogger("Error getting all Organizations");
        }
        return result;
    }

    public void createOrganizations(String name, String description, boolean isPublic, String password, String city, String address) {

        int owner_id = this.IAuth.GetOwnerId();

        try {
            String queryString = "INSERT INTO organizations ( owner_id, name, description, public, password, city, address) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement query = connection.prepareStatement(queryString);

            query.setInt(1, owner_id);
            query.setString(2, name);
            query.setString(3, description);
            query.setBoolean(4, isPublic);
            query.setString(5, password);
            query.setString(6, city);
            query.setString(7, address);
            query.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger("Error creating organization");
        }
    }
}
