package kr.or.ddit.basic;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class CommonsMailFilejar {
	public static void main(String[] args) throws EmailException{
		String senderId = "rkdgur1977@naver.com";
		String senderPw = "bz3897ed!!";
		String receiverId = "yoonksjsjsj@gmail.com";
		String filePath = "d:/d_other/uploadFiles/펭귄.jpg";
		String fileDes = "펭귄사진입니다";
		String fileName = "펭귄이름임";
		
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath(filePath); // 파일의 경로
		attachment.setDisposition(EmailAttachment.ATTACHMENT); // 파일의 형태/ 파일의 성명


		// 그 후 MultiPartEmail 을 통해 SimpleEmail 처럼 기본 메일정보를 설정합니다
		MultiPartEmail email2 = new MultiPartEmail();
		email2.setHostName("smtp.naver.com");
		email2.setSmtpPort(465); // TLS를 사용하는 경우 587 포트를 사용합니다.
		email2.setSSLOnConnect(true); // STARTTLS 사용을 지정합니다.
		email2.setAuthenticator(new DefaultAuthenticator(senderId, senderPw));
		email2.setFrom(senderId, "보내는사람");
		email2.addTo(receiverId, "받는사람"); // ex) onamt@nate.com
		email2.setSubject("Ex2>MultiPartEmail");
		email2.setMsg("MultiPartEmail");
		email2.attach(attachment);		//파일 첨부
		email2.send();
		System.out.println("메일 전송 완료");
	 
	}
}
