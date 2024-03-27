package assignment9;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email implements Notification {

	@Override
	public void notify1(String to, String messageToSend) {
//		System.out.println("Sending E-Mail...");
//		System.out.println("To: " + to);
//		System.out.println("Message: " + message);
		
//		String to = "enggnimu_ju@yahoo.com";
        String from = "ankgh2117@gmail.com";
        String host = "smtp.gmail.com";

        // Setup mail server
        Properties properties = System.getProperties();
        properties.put("mail.smtp.ssl.protocols","TLSv1.2");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication("ankgh2117@gmail.com", "fita ktja xlov zjzp");
            }
        });
        //session.setDebug(true);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Message sent using JAVA");
            message.setText(messageToSend);
            System.out.println("sending...");
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
	}

}
