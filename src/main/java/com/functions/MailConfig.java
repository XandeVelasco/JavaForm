package main.java.com.functions;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailConfig {

	public static void main(String to, String sub, 
            String msg) throws AddressException, MessagingException {
            	
            	Properties props = new Properties();
            	props.put("mail.smtp.auth", "true");
            	props.put("mail.smtp.starttls.enable", "true");
            	props.put("mail.smtp.host", "smtp.gmail.com");
            	props.put("mail.smtp.port", "587");

            	Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            		protected PasswordAuthentication getPasswordAuthentication() {
            			return new PasswordAuthentication("chatbotmailsend@gmail.com", "xandeletro10");
            		}
            	});

            	Message message = new MimeMessage(session);
            	message.setFrom(new InternetAddress("chatbotmailsend@gmail.com"));
                message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            	message.setSubject(sub);
            	message.setText(msg);

            	Transport.send(message);
            }
}