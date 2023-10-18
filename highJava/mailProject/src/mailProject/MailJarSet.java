package mailProject;

public class MailJarSet {
	//필드
	private String senderId;
	private String senderPw;
	private String recieverId;
	private String mailSubject;
	private String mailText;
	
	
	public MailJarSet() {
		
	}
	

	//getter setter
	
	String getSenderId() {
		return senderId;
	}
	
	void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	String getSenderPw() {
		return senderPw;
	}
	void setSenderPw(String senderPw) {
		this.senderPw = senderPw;
	}
	String getRecieverId() {
		return recieverId;
	}
	void setRecieverId(String recieverId) {
		this.recieverId = recieverId;
	}
	String getMailSubject() {
		return mailSubject;
	}
	void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}
	String getMailText() {
		return mailText;
	}
	void setMailText(String mailText) {
		this.mailText = mailText;
	}
	
	
}
