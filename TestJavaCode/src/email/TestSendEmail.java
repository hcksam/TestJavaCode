package email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class TestSendEmail {
	public void sendEmail() {
		String to = "hcksam8310@gmail.com";
		String from = "hcksam8310@gmail.com";
		String pass = "sheep8310";
		String host = "smtp.gmail.com";
		String port = "587";
		Properties props = System.getProperties();
//		properties.setProperty("mail.smtp.host", host);

		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");

		// Get the default Session object.
		Session session = Session.getDefaultInstance(props);

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));
			message.setSubject("This is the Subject Line!");
			message.setText("This is actual message");

//			Transport.send(message);
			Transport transport = session.getTransport("smtp");
		    transport.connect(host, from, pass);
		    transport.sendMessage(message, message.getAllRecipients());
		    transport.close();
			
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
//		new TestSendEmail().sendEmail();
		SendMailUtil.sendMail("mail.pccw.com", "Sam.CK.Heung@pccw.com", "Sam.CK.Heung@pccw.com", "test", "testing");
	}
}
