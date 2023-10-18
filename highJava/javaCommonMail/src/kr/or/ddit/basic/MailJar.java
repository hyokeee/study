package kr.or.ddit.basic;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailJar {
	public static void main(String[] args) throws MessagingException {
		
		String senderId = "rkdgur1977@naver.com";
		String senderPw = "bz3897ed!!";
		String receiverId = "yoonksjsjsj@gmail.com";
		
		
		Properties props = new Properties();
	    props.put("mail.smtp.host", "smtp.naver.com");
	    props.put("mail.smtp.auth", "true");
		//props.put("mail.smtp.ssl.enable","true");
	    //props.put("mail.smtp.port", "465");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.port", "587");
		
		
		Session session = Session.getDefaultInstance(props, new Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		       return new PasswordAuthentication(senderId, senderPw);
		      }
		     });
		
		MimeMessage message = new MimeMessage(session);
	      message.setFrom(new InternetAddress(senderId));
	      message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverId));
	      message.setSubject("메일 제목");
	      message.setText("메일 내용");
	      
	      Transport.send(message);
	
	}
	}
