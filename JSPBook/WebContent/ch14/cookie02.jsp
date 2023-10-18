<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Cookie</title>
</head>
<body>
<%	// 스크립틀릿
	// 요청시 함께 툭툭 던져지는 request객체 안에 있는 쿠키들을 확인해보자
	// Cookie cookie_id = new Cookie("userId",user_id);
	// Cookie cookie_pw = new Cookie("userPw",user_pw);
	// + JSESSIONID
	Cookie[] cookies = request.getCookies();
	
	// 현재 쿠키저장소에 들어있는 쿠키의 개수는 ?
	out.print("현재 설정된 쿠키의 개수 : " + cookies.length + "<br/>");
	out.print("<hr/>");
	for(int i = 0; i<cookies.length; i++){
		out.print("쿠키[" + i + "] : " + cookies[i] + "<br/>");
		// 쿠키 속성 명
		out.print("쿠키 속성 명["+ i +"] : " + cookies[i].getName() + "<br/>");
		// 쿠키 속성 값
		out.print("쿠키 속성 값["+ i +"] : " + cookies[i].getValue() + "<br/>");
		out.print("-------------------------------------------------<br/>");
	}
	out.print("세션 ID : " + session.getId() + "<br/>");
%>
	<a href="cookie03.jsp">모든 쿠키 삭제</a>
	
</body>
</html>