<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Session</title>
</head>
<body>
<%	//스크립틀릿
/*
요청 URL : session01_process.jsp
요청파라미터 : {id=admin&passwd=java}
*/
	// 한글 인코딩 처리
	request.setCharacterEncoding("utf-8");

	String user_id = request.getParameter("id");	 //admin
	String user_pw = request.getParameter("passwd"); //java
	
	out.print("session고유아이디(웹브라우저별 1개) : " + session.getId() + "<br/>");
	if(user_id.equals("admin") && user_pw.equals("java")){
		session.setAttribute("userId", user_id);
		session.setAttribute("userPw", user_pw);
		out.print("<p>세션 설정 성공</p>");
		out.print("<p>" + user_id + "님 환영합니다. </p>");
	} else{
		out.print("<p>세션 설정 실패</p>");
		out.print("<a href='session01.jsp'>되돌아가기</a>");
	}

%>
</body>
</html>