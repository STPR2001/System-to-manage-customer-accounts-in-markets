package db;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.sql.Connection;
import java.util.Properties;

public class DBConnection {
    
    private Connection connection=null;

    public DBConnection() {}
    
    public Connection getConnection() {
        
       if(connection == null) {
           
          
            try {
                String dbURI, username, password;
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                dbURI = "jdbc:mysql://aws.connect.psdb.cloud/pa-db?sslMode=VERIFY_IDENTITY";
                username = "gzcsjw96rian36v2l4ja";
                password = "pscale_pw_u18VlpbzF62PNQSYEp2jua743VoTqSAjsuBfguMxmC";
                connection = (Connection)DriverManager.getConnection(dbURI, username, password);
                
               } catch (SQLException e) {
                    e.printStackTrace();
                }
                
                
                
            
       }
        return connection;
    }
}