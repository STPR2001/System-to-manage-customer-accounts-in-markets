package logic.factories;

import logic.controllers.AccountController;
import logic.controllers.EmployeeController;
import logic.interfaces.IAccountController;
import logic.interfaces.IEmployeeController;
import logic.controllers.OrganizationController;
import logic.controllers.UserController;
import logic.interfaces.IOrganizationController;
import logic.interfaces.IUserController;
import logic.controllers.TransactionController;
import logic.interfaces.IAuthController;
import logic.interfaces.ITransactionController;
import logic.controllers.AuthController;
import logic.interfaces.IEmailController;
import logic.controllers.EmailController;

public class Factory {

    private static Factory instance;

    public Factory() {}

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }
    
    public IEmailController getEmailController() {
        IEmailController controller = EmailController.getInstance();
        return controller;
    }
    
    public IAuthController getAuthController() {
        IAuthController controller = AuthController.getInstance();
        return controller;
    }

    public IAccountController getAccountController(){
        IAccountController controller = AccountController.getInstance();
        return controller;
    }
    
    public IUserController getUserController() {
        IUserController controller = UserController.getInstance();
        return controller;
    }
    
    public IEmployeeController getEmployeeController() {

        IEmployeeController controller = EmployeeController.getInstance();
        return controller;
    }
    
    public IOrganizationController getOrganizationController(){
        
        IOrganizationController controller = OrganizationController.getInstance();
        return controller;
    }
    
    public ITransactionController getTransactionController(){
        ITransactionController controller = TransactionController.getInstance();
        return controller;
    }
    
}
/*
crear cuenta de cliente
confirmar cuenta de cliente
desactivar cuenta de cliente
asignar correo a una cuenta
crear transacción de venta
crear transacción de pago
asignar transacción
crear organización
listar cuentas - IN PROGRESS
listar organizaciones
listar transacciones
iniciar sesión como organización
cerrar sesión como organización
modificar contraseña de organización
*/