package logic.classes;

public class Debt extends Transaction {

    private float initialPayment; // =0 ?
    private String detail;
    private Boolean confirmed;

    public Debt() {
    }

    public Debt(
            float initialPayment,
            GeneralData attributes,
            float totalAmount,
            String detail,
            Boolean confirmed,
            String accountId
            ) {
        super(attributes, totalAmount, accountId);
        this.detail = detail;
        this.confirmed = confirmed;
        this.initialPayment = initialPayment;
    }

    public String getDetail() {
        return this.detail;
    }

    public float getInitialPayment() {
        return initialPayment;
    }

    public void setInitialPayment(float initialPayment) {
        this.initialPayment = initialPayment;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public float getinitialPayment() {
        return initialPayment;
    }

    public void setinitialPayment(float initialPayment) {
        this.initialPayment = initialPayment;
    }

}
