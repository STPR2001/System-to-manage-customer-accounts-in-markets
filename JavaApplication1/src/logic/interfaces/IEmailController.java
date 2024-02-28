package logic.interfaces;

public interface IEmailController {

    public abstract void sendEmailAsignationVerification(
            String destinationEmail,
            String newAssignedEmail
    );
    
    public abstract void sendTransactionVerificationMessage(
            String destinationEmail,
            String detail,
            String initialPayment,
            String totalAmount,
            String organizationName,
            String transactionId
    );
    
    public abstract void sendEmail(
            String destinationEmail, 
            String subject, 
            String htmlBody
    );
    
    public abstract void sendTransactionPayNotificationMessage(
            String destinationEmail,
            String status,
            String total,
            String organizationName
    );
    
     public abstract void sendNewAccountNotificationMessage(
            String destinationEmail,
            String limit,
            String organizationName,
            String userName
    );
}
