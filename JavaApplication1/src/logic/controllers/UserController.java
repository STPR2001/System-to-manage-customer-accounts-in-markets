package logic.controllers;

import java.util.ArrayList;
import logic.classes.User;
import logic.interfaces.IUserController;
import logic.services.UserService;

public class UserController implements IUserController {
    private static UserController instance;
    private UserService userService;
    
    public UserController() {
        this.userService = new UserService();
    }
    
    public static IUserController getInstance() {
        if(instance == null) {
            instance = new UserController();
        } 
        return instance;
    }
    
    public ArrayList<User> getUsersByOrganizationId(String organizationId) {
        return this.userService.getUsersByOrganizationId(organizationId);
    }
    
    public int getUserIdByEmail(String email){
       return this.userService.getUserIdByEmail(email);
    }
    public void createUser(String name, String address, String email, String password){
       this.userService.createUser(name, address, email, password);
    }
    public User getUserByIdOrEmail(String idArg, String emailArg) {
        return this.userService.getUserByIdOrEmail(idArg, emailArg);
    };
}
