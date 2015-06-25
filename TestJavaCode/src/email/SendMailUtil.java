package email;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendMailUtil {

	public static String[] getRecipientList(String strMasterEmail, String email, String[] recipient) {
		String [] masterEmail = strMasterEmail.split(";");
		for (int i=0;i<masterEmail.length;i++) { 
			if (email!=null&&email.toUpperCase().equals(masterEmail[i].toUpperCase())) {
				String[] tempEmail = {masterEmail[i]};
				recipient = tempEmail;
			} 
		} 
		return recipient;
	}

	
	public static void sendMail(String mailHostName, String from, String to, String subject, String content) throws Exception {
		String charset = "utf-8";

		try {
			/*
			 * You can create HTML mail by HtmlEmail
			 */ 
			SimpleEmail email = new SimpleEmail();
			email.setHostName(mailHostName);   
  
			email.setFrom(from);    
			email.addTo(to);
			email.setCharset(charset);
			
			email.setSubject(subject);
			
			email.setSentDate(new Date());
			
			email.setMsg(new String(content.getBytes(charset), charset));
			
			System.out.println("Send Mail");
			email.send();
			
			System.out.println("from: " + from);
			System.out.println("to: " + to);
			System.out.println("subject: " + subject);
			System.out.println("content: " + content);
			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new Exception();
		} catch (EmailException e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	public static String getMailBody(String ref_no, String content, String lang) {
		String mailBody = "";
		if (lang.equalsIgnoreCase("zh_HK")) {
			mailBody = "謝謝閣下與我們聯絡。\n\n"
						+ "我們特為閣下提供一個參考編號："+ref_no+"，以助閣下跟進此一個案，並供日後聯絡之用。\n\n"
						+ "閣下在所遞交的表格內提供以下資料：\n\n"
						+ "================================================================\n\n"
						+ content + "\n\n"
						+ "================================================================\n"
						+ "我們的電郵小組將儘快作出跟進。\n\n"
						+ "註：此乃系統自動回覆，無須覆函。\n\n";	
		} else {
			 mailBody = "Thank you for contacting us.\n\n"
						+ "To help track your case, we have generated a reference number for you: " + ref_no +". "
						+ "Please quote this number in any future correspondence regarding your case.\n\n"
						+ "Here's a summary of the details you have entered in the form:\n\n"
						+ "================================================================\n\n"
						+ content + "\n\n"
						+ "================================================================\n"
						+ "Our email team will follow up on the above shortly.\n\n"
						+ "Note: This is a computer-generated message. No reply is required.";
		}
		return mailBody;
	}

}