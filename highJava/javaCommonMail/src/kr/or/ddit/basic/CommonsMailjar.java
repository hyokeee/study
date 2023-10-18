package kr.or.ddit.basic;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class CommonsMailjar {
	public static void main(String[] args) throws EmailException {
		String senderId = "rkdgur1977@naver.com";
		String senderPw = "비밀번호";
		String receiverId = "yoonksjsjsj@gmail.com";
		// Ex1> SimpleEmail

		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.naver.com"); // ex) nate.com 일 경우!! ->> mail.nate.com
		email.setSmtpPort(587); // TLS를 사용하는 경우 587 포트를 사용합니다.
		email.setStartTLSEnabled(true); // STARTTLS 사용을 지정합니다.
		
		email.setAuthenticator(new DefaultAuthenticator(senderId, senderPw)); // 사용자 인증 정보를 설정합니다.
		email.setFrom(senderId,"Sender");
		email.addTo(receiverId, "Receiver"); // ex) onamt@nate.com
		email.setSubject("Ex1>SimpleEmail");
		email.setMsg("SimpleEmail");
//		email.send();
		System.out.println(email.getFromAddress());
		System.out.println(email.getToAddresses());
		System.out.println(email.getSubject());
		System.out.println(email.getSmtpPort());
		System.out.println(email.getSmtpPort());
		


	}
}
