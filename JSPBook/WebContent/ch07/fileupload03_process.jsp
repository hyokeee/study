<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.commons.fileupload.DiskFileUpload"%>
<%@ page import="org.apache.commons.fileupload.FileItem"%>
<%@ page import="java.io.File"%>
<%	//스크립틀릿

	//폼 페이지에서 전송된 파일을 저장할 서버의 경로를 작성
	// 윈도우 경로는 역슬래시('\') 두개, 웹 경로는 슬래시('/') 1개
	String fileUploadPath = "C:\\upload";
	// commons-fileupload-1.2.1.jar 라이브러리 패키지에 포함되어 있는 DiskFileUpload의
	// 인스턴스를 생성
	DiskFileUpload upload = new DiskFileUpload();
	// 웹 브라우저(크롬)가 전송한 multipart/form 유형의 요청 파라미터들을 가져옴
	// parse(파싱) : 구문분석, 의미분석
	List items = upload.parseRequest(request);
	// 폼 페이지에서 전송된 요청 파라미터를 Iterator 클래스로 변환
	Iterator params = items.iterator();
	// 폼 페이지에서 전송된 요청 파라미터가 더 이상 없을 때 까지 반복(while)
	while(params.hasNext()){
		// params.next()의 리턴 타입은 Object이므로 FileItem 타입으로 형변환
		FileItem fileItem = (FileItem) params.next();
		// FileItem 클래스의 메서들르 사용하여 요청 파라미터가
		// 일반 데이터인지 파일인지 분석 및 처리하여
		// 파일을 업로드함
		// FormFiled : <input type="text" / "radio", <select... 
		if(!fileItem.isFormField()){	//input type="file" 일 때~ 라서 ! 붙임
			// 파일명 가져옴
			String fileName = fileItem.getName();
			// 업로드 대상(고객쪽)
			// D:\\A_study\\jquery\\jqpro\\src\\main\\webapp\\images\\cloud03.jpg
			fileName.substring(fileName.lastIndexOf("\\")+1);
			// 이 곳으로 업로드 ==> c:\\upload + / + cloud03.jpg
			File file = new File(fileUploadPath+"/"+fileName);
			// 설계대로 복사 실행
			fileItem.write(file);
			
		}
	}



%>