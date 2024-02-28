package logic.classes;

// User + Account 

public class AccountUser {
    private User user;
    private Account account;
    
    public AccountUser(User user, Account account) {
        this.user = user;
        this.account = account;
    }
    
    public User getUser() {
        return this.user;
    }
    
    public Account getAccount() {
        return this.account;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public void setAccount(Account account) {
        this.account = account;
    }
}