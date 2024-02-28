package logic.classes;
public class Payment extends Transaction{
    //private TransactionStatus transactionstatus;
    private String transactionStatus;
    
    public Payment(){
        
    }
    
    public Payment(String transactionStatus, GeneralData attributes, float totalAmount, String accountId) {
        super(attributes, totalAmount, accountId);
        this.transactionStatus = transactionStatus;
    }

    public String getTransactionstatus() {
        return transactionStatus;
    }

    public void setTransactionstatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
    
}
