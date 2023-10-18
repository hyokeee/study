package mailProject;


import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFileChooser;
import javax.swing.JFrame;


import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;


public class SendMail {
	private MailJarSet mj;	//mail.jar이용한 메일 보내기 위한 변수(MimeMessage)
	private CommonsMailJarSet cmj1;	//commons-mail.jar 이용해서 메일보내기(SimpleEmail)
	
	private Scanner scan;		//scanner
	JFrame frame;		//JFrame
	
	//생성자
	public SendMail() {
		scan = new Scanner(System.in);
		mj = new MailJarSet();
		cmj1 = new CommonsMailJarSet();
		frame = new JFrame();
	}
	
	public static void main(String[] args) throws AddressException, MessagingException {
		new SendMail().start();
//		new SendMail().getFileAbsolutePath();
		
	}
	
	//시작 메서드
	public void start() {
		System.out.println();
		System.out.println("+++++++++++++++++++++++++++++++++");
		System.out.println("메   일   보   내   기");
		System.out.println("+++++++++++++++++++++++++++++++++");
		System.out.println();
		while(true) {
			int choice = display();
			switch(choice) {
			case 1: //메일보내기
				sendMailSwitch();
				break;
			case 0: //종료
				System.out.println();
				System.out.println("프로그램을 종료합니다.");
				return;
			default : 
				System.out.println();
				System.out.println("작업 번호를 잘못 선택했습니다. 다시 선택하세요...");	
			}
		}
	}
	
	//메뉴 출력 화면
	private int display() {
		int a;
		System.out.println();
		System.out.println("==== 메   뉴 ====");
		System.out.println("1. 메일보내기");
	    System.out.println("0. 프로그램 종료");
	    System.out.println("=================");
	    System.out.print("번호 입력 >>");
	    try {
	    	a = scan.nextInt();	
	    } catch(InputMismatchException e) {
	    	a = -1;
	    	scan.nextLine();
	    }
	    return a;
	}
	
	//메일 보내기 선택 후 switch
	public void sendMailSwitch() {
		
		while(true) {
			int c = sendDisplay();
			switch(c) {
			case 1:
				SendMailJar();
				break;
			case 2:
				SendCommonsMailJar1();
				break;
				
			case 3:
				SendCommonsMailJar2();
				break;
				
			case 0 :
				System.out.println();
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
				
			default :
				System.out.println();
				System.out.println("작업 번호를 잘못 선택했습니다. 다시 선택하세요...");	
			}
		}
	}
	
	
	//메일 보내기 선택 후 화면
	private int sendDisplay() {
		int a;
		System.out.println();
		System.out.println("==== 메일보내기 ====");
		System.out.println("1. Mail.jar를 통해 보내기");
	    System.out.println("2. CommonsMail.jar  SimpleMail을 통해 보내기");
	    System.out.println("3. CommonsMail.jar MultipartMail을 통해 파일 첨부하기");
	    System.out.println("0. 메인메뉴로 돌아가기");
	    System.out.println("=================");
	    System.out.print("번호 입력 >>");
	    try {
	    	a = scan.nextInt();	
	    } catch(InputMismatchException e) {
	    	a = -1;
	    	scan.nextLine();
	    }
	    return a;
	}
	
	//1-1 mail.jar이용한 메일 보내기(MimeMessage), mj
	private void SendMailJar()  {
		System.out.println("보내는 분의 id를 입력하세요(예.abc@naver.com)");
		System.out.print(">>");
		mj.setSenderId(scan.next());
		System.out.println("보내는 분의 pw를 입력하세요");
		System.out.print(">> ");
		mj.setSenderPw(scan.next());
		System.out.println("받는 분의 id를 입력하세요(예.abc@naver.com)");
		System.out.print(">> ");
		mj.setRecieverId(scan.next());
		System.out.println("메일 제목을 입력하세요");
		System.out.print(">> ");
		mj.setMailSubject(scan.next());
		System.out.println("메일 내용을 입력하세요");
		System.out.print(">> ");
		mj.setMailText(scan.next());
		try {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.naver.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getDefaultInstance(props, new Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		       return new PasswordAuthentication(mj.getSenderId(), mj.getSenderPw());
		      }
		     });
		
		MimeMessage message = new MimeMessage(session);
	      message.setFrom(new InternetAddress(mj.getSenderId()));
	      message.addRecipient(Message.RecipientType.TO, new InternetAddress(mj.getRecieverId()));
	      message.setSubject(mj.getMailSubject());
	      message.setText(mj.getMailText());
	      
	      Transport.send(message);
	      System.out.println();
	      System.out.println("메일 전송이 완료되었습니다.");
		} catch(AddressException e) {
			System.out.println("메일 전송 실패!");
			return;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			System.out.println("메일 전송 실패!");
			return;
		}
	}
	
	//2-1 commons-mail.jar 이용해서 메일보내기(SimpleEmail) cmj1
	private void SendCommonsMailJar1() {
		System.out.println("보내는 분의 id를 입력하세요(예.abc@naver.com)");
		System.out.print(">>");
		cmj1.setSenderId(scan.next());
		System.out.println("보내는 분의 pw를 입력하세요");
		System.out.print(">>");
		cmj1.setSenderPw(scan.next());
		System.out.println("받는 분의 id를 입력하세요(예.abc@naver.com)");
		System.out.print(">> ");
		cmj1.setRecieverId(scan.next());
		System.out.println("메일 제목을 입력하세요");
		System.out.print(">> ");
		cmj1.setMailSubject(scan.next());
		System.out.println("메일 내용을 입력하세요");
		System.out.print(">> ");
		cmj1.setMailText(scan.next());
		try {
			SimpleEmail email = new SimpleEmail();
			email.setHostName("smtp.naver.com");
			email.setSmtpPort(587); 
			email.setStartTLSEnabled(true);
			email.setAuthenticator(new DefaultAuthenticator(cmj1.getSenderId(), cmj1.getSenderPw())); // 사용자 인증 정보를 설정합니다.
			email.setFrom(cmj1.getSenderId(),"보낸사람");
			email.addTo(cmj1.getRecieverId(), "받는사람"); // ex) onamt@nate.com
			email.setSubject(cmj1.getMailSubject());
			email.setMsg(cmj1.getMailText());
			email.send();
			
			System.out.println();
			System.out.println("메일 전송 성공!");
			
		}catch(EmailException e) {
			System.out.println("메일 전송 실패.");
			
		}
	}
	
	//2-2 commons-mail.jar 이용해서 메일보내기(MultiPartEmail) cmj1
	private void SendCommonsMailJar2() {
		System.out.println("보내는 분의 id를 입력하세요(예.abc@naver.com)");
		System.out.print(">>");
		cmj1.setSenderId(scan.next());
		
		System.out.println("보내는 분의 pw를 입력하세요");
		System.out.print(">>");
		cmj1.setSenderPw(scan.next());
		System.out.println("받는 분의 id를 입력하세요(예.abc@naver.com)");
		System.out.print(">> ");
		cmj1.setRecieverId(scan.next());
		System.out.println("메일 제목을 입력하세요");
		System.out.print(">> ");
		cmj1.setMailSubject(scan.next());
		System.out.println("메일 내용을 입력하세요");
		System.out.print(">> ");
		cmj1.setMailText(scan.next());
		System.out.println("파일을 선택해주세요");
		cmj1.setFilePath(getFileAbsolutePath(frame));
	    

		
		try {
			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath(cmj1.getFilePath()); 
			attachment.setDisposition(EmailAttachment.ATTACHMENT); 
			attachment.setName(cmj1.getFileName()); 
			
			MultiPartEmail email2 = new MultiPartEmail();
			email2.setHostName("smtp.naver.com");
			email2.setSmtpPort(465); 
			email2.setSSLOnConnect(true); 
			email2.setAuthenticator(new DefaultAuthenticator(cmj1.getSenderId(), cmj1.getSenderPw()));
			email2.setFrom(cmj1.getSenderId(), "보내는사람");
			email2.addTo(cmj1.getRecieverId(), "받는사람");
			email2.setSubject(cmj1.getMailSubject());
			email2.setMsg(cmj1.getMailText());
			email2.attach(attachment);		
			email2.send();
			System.out.println();
			System.out.println("메일 전송 완료");
		} catch (EmailException e) {
			System.out.println("메일 전송에 실패하였습니다.");
			
		}
		
	}
	
	//JFileChooser chooser를 통해 File의 절대경로 정보 가져오는 메서드
	private String getFileAbsolutePath(JFrame parentFrame) {
		JFileChooser chooser = new JFileChooser(); 
		int ret = chooser.showOpenDialog(parentFrame);	
		if(ret != JFileChooser.APPROVE_OPTION) {
			System.out.println("경로를 선택하지 않았습니다.");
		}
		
		return chooser.getSelectedFile().getAbsolutePath();
	}
	
	
}
