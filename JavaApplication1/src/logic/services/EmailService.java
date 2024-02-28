package logic.services;

import db.DBConnection;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import logic.classes.Debt;

public class EmailService {

    public EmailService() {};
    
    
    //cuando se crea una cuenta se manda un correo de notificcion
     public void sendNewAccountNotificationMessage(
            String destinationEmail,
            String limit,
            String organizationName,
            String userName
    ) {
        String htmlBody = ""
                + "<!DOCTYPE html>"
                + "<html lang='es'>"
                + "<body style='box-sizing:border-box'>"
                + "<div style='box-sizing:border-box;padding:12px;"
                + "color:white;width:100%;background-color:#1a1a1a"
                + ";border-radius:10px'>"
                + "<span style='background:white;border-radius:10px;"
                + "color:#1a1a1a;padding:2px 10px'>"
                + organizationName
                + "</span>"
                + "<p style='color:white'>Has creado una cuenta con el usuario:</p>"
                + "<p style='color:white'>" + userName + "</p>"
                + "<h1 style='color:white'>Saldo limite establecdo: " + limit + "</h1>"
                + "</div>"
                + "</body"
                + "</html>";
        String subject = "Notificación de creación de cuenta";
        this.sendEmail(destinationEmail, subject, htmlBody);
    }
    
    //cuando se realiza una transaccion de pago se envia un correo de notificacion
     public void sendTransactionPayNotificationMessage(
            String destinationEmail,
            String status,
            String total,
            String organizationName
    ) {
        String htmlBody = ""
                + "<!DOCTYPE html>"
                + "<html lang='es'>"
                + "<body style='box-sizing:border-box'>"
                + "<div style='box-sizing:border-box;padding:12px;"
                + "color:white;width:100%;background-color:#1a1a1a"
                + ";border-radius:10px'>"
                + "<span style='background:white;border-radius:10px;"
                + "color:#1a1a1a;padding:2px 10px'>"
                + organizationName
                + "</span>"
                + "<p style='color:white'>Estado del pago:</p>"
                + "<p style='color:white'>" + status + "</p>"
                + "<h1 style='color:white'>Total: $" + total + "</h1>"
                + "</div>"
                + "</body"
                + "</html>";
        String subject = "Notificación de transacción";
        this.sendEmail(destinationEmail, subject, htmlBody);
    }
    
   
    // Cuando un correo es asignado a una cuenta, el dueño deberá 
    // confirmarlo a travez del correo que esta función envía
    public void sendEmailAsignationVerification(
            String destinationEmail,
            String newAssignedEmail
    ) {
        String htmlBody = ""
                + "<!DOCTYPE html>"
                + "<html lang='es'>"
                + "<body style='box-sizing:border-box'>"
                + "<div style='box-sizing:border-box;padding:12px;"
                + "color:white;width:100%;background-color:#1a1a1a"
                + ";border-radius:10px'>"
                + "<span style='background:white;border-radius:10px;"
                + "color:#1a1a1a;padding:2px 10px'>"
                + "Business1"
                + "</span>"
                + "<p style='color:white'>Un nuevo correo solicitó se asignado a esta cuenta:</p>"
                + "<h2>" + newAssignedEmail + "</h2>"
                + "<p style='color:white'>Confirma la solicitud clickeando el botón de abajo.</p>"
                + "<button style='border-radius:10px;background"
                + "-color:#60A5FA;padding:10px;width:100%;border:none'>"
                + "Confirmar"
                + "</button>"
                + "</div>"
                + "</body"
                + "</html>";
        String subject = "Verificación de transacción";
        this.sendEmail(destinationEmail, subject, htmlBody);
    }

    // Cuando se asigna una nueva transacción a una cuenta, el dueño
    // de la cuenta debe confirmarla a travez del correo que esta función
    // envía.
    public void sendTransactionVerificationMessage(
            String destinationEmail,
            String detail,
            String initialPayment,
            String totalAmount,
            String organizationName,
            String transactionId
    ) {
        String htmlBody = ""
                + "<!DOCTYPE html>"
                + "<html lang='es'>"
                + "<body style='box-sizing:border-box'>"
                + "<div style='box-sizing:border-box;padding:12px;"
                + "color:white;width:100%;background-color:#1a1a1a"
                + ";border-radius:10px'>"
                + "<span style='background:white;border-radius:10px;"
                + "color:#1a1a1a;padding:2px 10px'>"
                + organizationName
                + "</span>"
                + "<p style='color:white'>Detalles de la transacción:</p>"
                + "<p style='color:white'>" + detail + "</p>"
                + "<h1 style='color:white'>Total: $" + totalAmount + "</h1>"
                + "<a href='http://localhost:8080/Home/transaction?transaction_id="
                + transactionId 
                + "' style='border-radius:10px;background"
                + "-color:#60A5FA;padding:10px;width:100%;border:none'>"
                + "Confirmar"
                + "</a>"
                + "</div>"
                + "</body"
                + "</html>";
        String subject = "Verificación de transacción";
        this.sendEmail(destinationEmail, subject, htmlBody);
    }

    // 3 argumentos: email de destino, asunto del correo, y cuerpo html.
    // Un html simple: <html lang="es"><body><p>Mensaje</p></body></html>
    public void sendEmail(
            String destinationEmail,
            String subject,
            String htmlBody
    ) {
        String originEmail;
        String originEmailPassword;

        Properties properties = System.getProperties();
        try (InputStream input = new FileInputStream("src/config.properties")) {
            properties.load(input);
            originEmail = properties.getProperty("emailservice.senderEmail");
            originEmailPassword = properties.getProperty("emailservice.senderPassword");

            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com"); // Servidor SMTP de Gmail
            properties.put("mail.smtp.port", "587"); // Puerto SMTP de Gmail

            Session session = Session.getInstance(properties, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(originEmail, originEmailPassword);
                }
            });

            try {
                MimeMessage message = new MimeMessage(session);

                message.setFrom(new InternetAddress(originEmail));
                message.addRecipient(Message.RecipientType.TO,
                        new InternetAddress(destinationEmail));
                message.setSubject(subject);
                message.setContent(htmlBody, "text/html");

                Transport.send(message);
                System.out.println("Successful email");
            } catch (MessagingException mex) {
                System.out.println("Email service error: " + mex);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
