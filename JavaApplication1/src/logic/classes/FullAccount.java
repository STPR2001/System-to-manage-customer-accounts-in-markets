package logic.classes;

public class FullAccount {

    private String organizationName;
    private String organizationDescription;
    private Integer id;
    private Boolean verified;
    private Integer userId;
    private Float total, limit;
    private PaymentInterval paymentInterval;
    private GeneralData attributes;
    private String password;
    private Boolean active;

    public FullAccount() {
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationDescription() {
        return organizationDescription;
    }

    public void setOrganizationDescription(String organizationDescription) {
        this.organizationDescription = organizationDescription;
    }

    public FullAccount(String organizationName, String organizationDescription, Integer id, Boolean verified, Integer userId, Float total, Float limit, PaymentInterval paymentInterval, GeneralData attributes, String password, Boolean active) {
        this.organizationName = organizationName;
        this.organizationDescription = organizationDescription;
        this.id = id;
        this.verified = verified;
        this.userId = userId;
        this.total = total;
        this.limit = limit;
        this.paymentInterval = paymentInterval;
        this.attributes = attributes;
        this.password = password;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getVerified() {
        return verified;
    }

    public Integer getUserId() {
        return userId;
    }

    public float getTotal() {
        return total;
    }

    public float getLimit() {
        return limit;
    }

    public PaymentInterval getPaymentInterval() {
        return paymentInterval;
    }

    public GeneralData getAttributes() {
        return attributes;
    }

    public String getPassword() {
        return password;
    }

    public boolean getActive() {
        return active;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setLimit(float limit) {
        this.limit = limit;
    }

    public void setPaymentInterval(PaymentInterval paymentInterval) {
        this.paymentInterval = paymentInterval;
    }

    public void setAttributes(GeneralData attributes) {
        this.attributes = attributes;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
