package logic.controllers;

import java.util.ArrayList;
import logic.interfaces.IEmployeeController;
import logic.classes.Employee;
import logic.services.EmployeeService;

public class EmployeeController implements IEmployeeController {

    private static EmployeeController instance;
    private EmployeeService employeeService;
    
    public EmployeeController() {
        this.employeeService = new EmployeeService();
    }

    public static EmployeeController getInstance() {
        if (instance == null) {
            instance = new EmployeeController();
        }
        return instance;
    }

    public ArrayList<Employee> listEmployees() {

        ArrayList<Employee> todosLosEmpleados = this.employeeService.getAllEmployees();
        
        //manipular informacion
        return todosLosEmpleados;
    }
    
    public void createEmployee(String nombre, String apellido, String edad, String email){
        this.employeeService.createEmployee(nombre, apellido, edad, email);    
    }

    public void deleteEmployee(String nombre){
        this.employeeService.deleteEmployee(nombre);
    }
    
    public void updateEmployee(String nombreOriginal, String nombre, String apellido, String edad, String email){
        this.employeeService.updateEmployee(nombreOriginal,nombre,apellido,edad,email);
    }
}
