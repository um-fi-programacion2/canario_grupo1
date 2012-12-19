package um.canario.grupo1.utils;

import java.util.Properties;
 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer {
    
        final String username = "um.proyecto.canario@gmail.com";
        final String password = "Grupo01.UM";
    
        
public void enviar(String destinatario, String subject, String cuerpo) {
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("um.proyecto.canario@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(destinatario));
			message.setSubject(subject);
                        message.setContent(cuerpo, "text/html; charset=utf-8");
                        //message.setText(cuerpo);
			Transport.send(message);
 
			System.out.println("Mail enviado OK");
 
		} catch (MessagingException e) {
                    	System.out.println("Mail enviado mal :(");
                        System.out.println("ERROR:_ " + e);

			throw new RuntimeException(e);
		}
	}
}