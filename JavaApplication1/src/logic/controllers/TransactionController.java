package logic.controllers;

import logic.classes.Debt;
import logic.classes.Payment;
import logic.interfaces.ITransactionController;
import logic.classes.Transaction;
import logic.services.TransactionService;

public class TransactionController implements ITransactionController{
    
    private static TransactionController instance;
    private TransactionService transactionService;
    
    public TransactionController(){
        this.transactionService = new TransactionService();
    }
    
    public static TransactionController getInstance(){
        if(instance == null){
            instance = new TransactionController();
        }
        return instance;
    }
    
    public Boolean confirmDebtTransaction(String transactionId) {
        return this.transactionService.confirmDebtTransaction(transactionId);
    }
    
    public Integer createDebtTransaction(String accountId, String detail, String initialPrice, String totalAmount){
        return this.transactionService.createDebtTransaction(accountId, detail, initialPrice, totalAmount);
    }
    
     public void createPaymentTransaction(String status, String accountId, String amount, String userId){
         this.transactionService.createPaymentTransaction(status, accountId, amount, userId);
     }
    
     public Debt getDebtById(int transactionIdInt){
        return this.transactionService.getDebtById(transactionIdInt);
     }
     
     public Payment getPaymentById(int transactionIdInt){
         return this.transactionService.getPaymentById(transactionIdInt);
     }
    
}
