import jakarta.jms.Message;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServlet;

import java.util.Properties;

public class MailServlet extends HttpServlet {

    public void sendEmail(String emailReceiver) {
        String host = "smtp.gmail.com";
        String username = "nelsonntabana@gmail.com";
        String password = "12345";

        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message;
            message = new MimeMessage(session);
            ((MimeMessage) message).setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailReceiver));
            message.setObjectProperty("Login Message");
            message.setObjectProperty("Thank you!!.\n\n\n" + "You have been admitted");

            Transport.send((jakarta.mail.Message) message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}