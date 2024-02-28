package logic.controllers;

import logic.interfaces.IEmailController;
import logic.services.EmailService;

public class EmailController implements IEmailController {

    private static EmailController instance = null;
    private EmailService emailService;

    private EmailController() {
        this.emailService = new EmailService();
    };
    
    public static EmailController getInstance() {
        if (instance == null) {
            instance = new EmailController();
        }
        return instance;
    }

    public void sendEmailAsignationVerification(
            String destinationEmail,
            String newAssignedEmail
    ) {
        this.emailService.sendEmailAsignationVerification(
                destinationEmail, 
                newAssignedEmail
        );
    };
    
    public void sendTransactionVerificationMessage(
            String destinationEmail,
            String detail,
            String initialPayment,
            String totalAmount,
            String organizationName,
            String transactionId
    ) {
        this.emailService.sendTransactionVerificationMessage(
                destinationEmail,
                detail,
                initialPayment,
                totalAmount,
                organizationName,
                transactionId);
    }
    
    public void sendEmail(
            String destinationEmail,
            String subject,
            String htmlBody
    ) {
        this.emailService.sendEmail(
                destinationEmail, 
                subject, 
                htmlBody
        );
    }
    
    public void sendTransactionPayNotificationMessage(
            String destinationEmail,
            String status,
            String total,
            String organizationName
    ) {
        this.emailService.sendTransactionPayNotificationMessage(
            destinationEmail,
            status,
            total,
            organizationName 
        );               
    }
    
     public void sendNewAccountNotificationMessage(
            String destinationEmail,
            String limit,
            String organizationName,
            String userName
    ) {
         this.emailService.sendNewAccountNotificationMessage(
           destinationEmail,
           limit,
           organizationName,
           userName
         );
     }
  
}
