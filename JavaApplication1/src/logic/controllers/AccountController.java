package logic.controllers;

import java.util.ArrayList;
import logic.interfaces.IAccountController;
import logic.classes.Account;
import logic.classes.Debt;
import logic.classes.FullAccount;
import logic.classes.Payment;
import logic.services.AccountService;

public class AccountController implements IAccountController {
    
    private static AccountController instance;
    private AccountService accountService;
    
    public AccountController(){
        this.accountService = new AccountService();
    }
    
    public static AccountController getInstance(){
        if(instance == null){
            instance = new AccountController();
        }
        return instance;
    }
    
    public void desactiveAccount(String accountId){
         this.accountService.desactiveAccount(accountId);
    }
    
    public void setVerificationAccount(String accountId){
        this.accountService.setVerificationAccount(accountId);
    }
    
    public ArrayList<Account> listAccounts(){
        ArrayList<Account> everyAccount = this.accountService.getAllAccounts();
        
        return everyAccount;
    }
    
    public void createAccount(int organizationId, int userId, String limit_amount, String password) {
        this.accountService.createAccount(organizationId, userId, limit_amount, password);
    }
    
    public ArrayList<Account> getAccountsByOrganizationId(String organization_id) {
        return this.accountService.getAccountsByOrganizationId(organization_id);
    }
    
    public ArrayList<FullAccount> getFullAccountsByUserId(String userId) {
        return this.accountService.getFullAccountsByUserId(userId);
    }
    
    public Account getAccountById(String id) {
       return this.accountService.getAccountById(id); 
    }
    
    public ArrayList<Debt> getAccountDebtTransactions(String id) {
        return this.accountService.getAccountDebtTransactions(id);
    }
    
    public ArrayList<Debt> getAllDebtTransactionsByOrgId(String orgId){
        return this.accountService.getAllDebtTransactionsByOrgId(orgId);
    }
    
    public ArrayList<Payment> getAllPaymentTransactionsByOrgId(String orgId){
        return this.accountService.getAllPaymentTransactionsByOrgId(orgId);
    }
    
    public void setAccountNewTotalAmount(String accountId, Float totalSumarDeuda){
        this.accountService.setAccountNewTotalAmount(accountId, totalSumarDeuda);
    }
    public Float getAccountTotalAmount(String accountId){
        return this.accountService.getAccountTotalAmount(accountId);
    }
    
}
