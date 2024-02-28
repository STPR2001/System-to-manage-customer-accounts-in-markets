package logic.interfaces;

import java.util.ArrayList;
import logic.classes.Employee;

public interface IEmployeeController {
    
    public abstract ArrayList<Employee> listEmployees();
    public abstract void createEmployee(String nombre, String apellido, String edad, String email);
    public abstract void deleteEmployee(String nombre);
    public abstract void updateEmployee(String nombreOriginal, String nombre, String apellido, String edad, String email);
}
