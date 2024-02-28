package logic.services;

import java.sql.*;
import db.DBConnection;
import java.util.ArrayList;
import logic.classes.User;
import java.util.logging.Logger;
import logic.classes.GeneralData;
import logic.classes.Organization;

public class UserService {
    private Connection connection = new DBConnection().getConnection();
    
    public UserService() {}
    
    public void createUser(String name, String address, String email, String password){
        try{
            String queryString = "INSERT INTO users (name,address,email,password) VALUES (?,?,?,?)";
            PreparedStatement query = connection.prepareStatement(queryString);

            query.setString(1, name);
            query.setString(2,address);
            query.setString(3,email);
            query.setString(4,password);
            query.executeUpdate();
        }


        catch(SQLException ex){
            Logger.getLogger("Error creating Account");
        }
    }
    
    public int getUserIdByEmail(String email){
         try {
            String queryString = "SELECT id FROM users WHERE email = ?";
            PreparedStatement query = connection.prepareStatement(queryString);
            query.setString(1, email);
            ResultSet result = query.executeQuery();

            if(result.next()){
            int userId = result.getInt("id");
            return userId;
            }else{
                return 0;
            }

        } catch (SQLException e) {
            return 0;
        }
    }
    
    // Given an organization id, it returns the info of those users
    // that have accounts on that organization
    public ArrayList<User> getUsersByOrganizationId(String organizationId) {
        ArrayList<User> users = new ArrayList();

        try {
            String queryString = "select U.* from users as U, accounts as A where "
                    + "A.organization_id = ? and U.id = A.user_id ORDER BY created_at DESC;";
            PreparedStatement query = connection.prepareStatement(queryString);
            query.setString(1, organizationId);

            ResultSet result = query.executeQuery();

            while (result.next()) {
                String name, email, address, password;
                Boolean verified;
                GeneralData attributes;
                
                name = result.getString("name");
                email = result.getString("email");
                address = result.getString("address");
                password = result.getString("password");
                
                attributes = new GeneralData(
                        result.getInt("id"), 
                        result.getDate("created_at"), 
                        result.getDate("updated_at"));
                
                users.add(new User(name, email, address, attributes, password));
            }

        } catch (SQLException e) {
            Logger.getLogger("Error trying to get organization by id");
        }

        return users;
    }
    
    public User getUserByIdOrEmail(String idArg, String emailArg) {
        String id;
        User user = null;

        try {
            String queryString = "select * from users where ";

            if(idArg == null) {
                queryString += "email = ?";
                id = emailArg;
            } else {
                queryString += "id = ?";
                id = idArg;
            }
            
            PreparedStatement query = connection.prepareStatement(queryString);
            query.setString(1, id);
            
            ResultSet result = query.executeQuery();
            
            String name, address, email, password;
            GeneralData attributes;
            int userId;
            
            while(result.next()) {
                userId = result.getInt("id");
                name = result.getString("name");
                address = result.getString("address");
                email = result.getString("email");
                password = result.getString("password");
                attributes = new GeneralData(
                        userId,
                        result.getDate("created_at"), 
                        result.getDate("updated_at"));
                user = new User(name, email, address, attributes, password);
            }
        } catch (SQLException e) {  
            Logger.getLogger("Error trying to get user by id");
        }
        
        return user;
    }
    
    
}
