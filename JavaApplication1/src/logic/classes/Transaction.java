package logic.classes;
public class Transaction {
    private GeneralData attributes;
    private float totalAmount;
    private String accountId;

    public Transaction(GeneralData attributes, float totalAmount, String accountId) {
        this.attributes = attributes;
        this.totalAmount = totalAmount;
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Transaction() {
    }

    public GeneralData getAttributes() {
        return attributes;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setAttributes(GeneralData attributes) {
        this.attributes = attributes;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    
}
