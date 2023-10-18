package mailProject;

public class CommonsMailJarSet {
	//필드
	private String senderId;
	private	String senderPw;
	private	String recieverId;
	private	String mailSubject; 
	private	String mailText;
	private	String filePath;
	private String fileName;
	
	
	public CommonsMailJarSet() {
		
	}
	
	//getter-setter
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

	String getFilePath() {
		return filePath;
	}

	void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	String getFileName() {
		return fileName;
	}

	void setFileName(String fileName) {
		this.fileName = fileName;
	}
	

	
	
	
}
