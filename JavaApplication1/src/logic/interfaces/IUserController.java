package logic.interfaces;

import java.util.ArrayList;
import logic.classes.User;

public interface IUserController {
    public abstract ArrayList<User> getUsersByOrganizationId(String organizationId);
    public abstract User getUserByIdOrEmail(String idArg, String emailArg);
    public abstract int getUserIdByEmail(String email);
    public abstract void createUser(String name, String address, String email, String password);
}
