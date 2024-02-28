package logic.services;

import java.sql.*;
import db.DBConnection;
import java.util.ArrayList;
import logic.classes.Employee;
import java.util.logging.Logger;

public class EmployeeService {
   
    private Connection connection = new DBConnection().getConnection();
    
    public EmployeeService(){}
    
    public ArrayList<Employee> getAllEmployees(){
        
        ArrayList result = new ArrayList();
        
        try{
            String queryString = "SELECT * FROM empleados";
            PreparedStatement query = connection.prepareStatement(queryString);
            ResultSet queryResult = query.executeQuery();
            
            while(queryResult.next()){
                
                String nombre = queryResult.getString("Nombre");
                String apellido = queryResult.getString("Apellido");
                String edad = queryResult.getString("Edad");
                String email = queryResult.getString("Email");
                
                result.add(new Employee(nombre,apellido,edad,email));
                
            }
        }catch(SQLException ex){
            Logger.getLogger("Error getting all employees");
        }
        return result;
    }
    
    public void createEmployee(String nombre, String apellido, String edad, String email){
        
        try{
            String queryString = "INSERT INTO empleados (Nombre, Apellido, Edad, Email) VALUES (?,?,?,?)";
            PreparedStatement query = connection.prepareStatement(queryString);
            query.setString(1,nombre);
            query.setString(2,apellido);
            query.setString(3,edad);
            query.setString(4,email);
            query.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger("Error creating employee");
        }
    }
    
    public void deleteEmployee(String nombre){
         try{
            String queryString = "DELETE FROM empleados WHERE empleados.Nombre = ?";
            PreparedStatement query = connection.prepareStatement(queryString);
            query.setString(1,nombre);
           
            query.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger("Error deleting employee");
        }
    }
    
    public void updateEmployee(String nombreOriginal, String nombre, String apellido, String edad, String email){
        
        try{
            
            String queryString = "UPDATE empleados SET Nombre=?,Apellido=?,Edad=?,Email=? WHERE empleados.Nombre = ?";
            PreparedStatement query = connection.prepareStatement(queryString);
            query.setString(5,nombreOriginal);
            query.setString(1,nombre);
            query.setString(2,apellido);
            query.setString(3,edad);
            query.setString(4,email);
            query.executeUpdate();    
        }catch(SQLException ex){
            Logger.getLogger("Error updating employee");
        }
    }
}
