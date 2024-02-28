package logic.interfaces;

public interface IAuthController {
    public abstract String handleLogIn(String email, String password);
    public abstract int GetOwnerId();
    public abstract void logOut();
}
