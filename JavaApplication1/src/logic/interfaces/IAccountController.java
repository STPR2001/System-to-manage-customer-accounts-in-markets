package logic.interfaces;

import java.util.ArrayList;
import logic.classes.Account;
import logic.classes.Debt;
import logic.classes.FullAccount;
import logic.classes.GeneralData;
import logic.classes.Password;
import logic.classes.Payment;
import logic.classes.PaymentInterval;

public interface IAccountController {
    public abstract void desactiveAccount(String accountId);
    public abstract void setVerificationAccount(String accountId);
    public abstract ArrayList<Account> getAccountsByOrganizationId(String organizationId);
    public abstract ArrayList<FullAccount> getFullAccountsByUserId(String userId);
    public abstract ArrayList<Debt> getAccountDebtTransactions(String id);
    public abstract Account getAccountById(String id);
    public abstract ArrayList<Account> listAccounts();
    public abstract void createAccount(int organizationId, int userId, String limit_amount, String password);
    public abstract ArrayList<Debt> getAllDebtTransactionsByOrgId(String orgId);
    public abstract ArrayList<Payment> getAllPaymentTransactionsByOrgId(String orgId);
    public abstract void setAccountNewTotalAmount(String accountId, Float totalSumarDeuda);
    public abstract Float getAccountTotalAmount(String accountId);
    //public abstract void deactivateAccount(GeneralData attributes);//aca está el id, pero tal vez si va a tener un vector con objetos ahi es otro el parametro
    //public abstract void activateAccount(GeneralData attributes);
    //public abstract void updateAccount(float total, float limit, PaymentInterval paymentInterval, GeneralData attributes, Password password, boolean active);
}
