package logic.interfaces;

import logic.classes.Debt;
import logic.classes.Payment;
import logic.classes.Transaction;

public interface ITransactionController {
    
    public abstract Boolean confirmDebtTransaction(String transactionId);
    public abstract Integer createDebtTransaction(String accountId, String detail, String initialPrice, String totalAmount);
    public abstract void createPaymentTransaction(String status, String accountId, String amount, String userId);
    public abstract Debt getDebtById(int transactionIdInt);
    public abstract Payment getPaymentById(int transactionIdInt);
    
}
