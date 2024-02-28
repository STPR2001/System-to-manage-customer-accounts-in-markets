package logic.controllers;

import logic.classes.User;
import logic.interfaces.IAuthController;
import logic.services.UserService;
import org.mindrot.jbcrypt.BCrypt;

public class AuthController implements IAuthController {
    private boolean isAuthenticated = false;
    private String authenticatedEmail = null;
    private int authenticatedId = 0;
    
    private static AuthController instance = null;
    private UserService userService;
    
    public AuthController() {
        this.userService = new UserService();
    }
    
    public static IAuthController getInstance() {
        if(instance == null) 
            instance = new AuthController(); 
        return instance;
    }    
    
    public String handleLogIn(String email, String password) {
        User user = userService.getUserByIdOrEmail(null, email);
        
        if(user == null) 
            return "El usuario no existe";
        
        if(!BCrypt.checkpw(password, user.getPassword())) 
            return "Credenciales incorrectas";
        
        this.isAuthenticated = true;
        this.authenticatedEmail = user.getEmail();
        this.authenticatedId = user.getAttributes().getId();
        
        return "ok";
    }
    
    
    public boolean getIsAuthenticated() {
        return this.isAuthenticated;
    }
    
     public int GetOwnerId(){
        if (isAuthenticated == true){
            return this.authenticatedId;
        }
        return 0;
    }
     
    public void logOut(){
        this.isAuthenticated = false;
        this.authenticatedEmail = null;
        this.authenticatedId = 0;
        return;
    }
    
}
