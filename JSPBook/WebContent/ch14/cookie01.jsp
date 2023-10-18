<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Cookie</title>
</head>
<body>
<%	//스크립틀릿
	//request.getCookies() 메서드 : 쿠키 정보를 얻어옴
	Cookie[] cookies = request.getCookies();
	out.print("cookies.length : " + cookies.length);
	for(int i=0;i<cookies.length;i++){
		out.print("<p>"+cookies[i].getName() + " : " +
						cookies[i].getValue() + "</p>");
		
	}
	//---------최초 실행 시 NullPointer가 뜨는 이유 : Cookie값이 request객체에 없어서!-------------
	out.print("<p> session.getId() : " + session.getId()+ "</p>");

%>
	<!-- 
	요청URL : cookie01_process.jsp
	요청파라미터 : {id=master,passwd=java}
	-->
	<form action="cookie01_process.jsp" method="post">
		<p>아이디 : <input type="text" name="id"/></p>
		<p>비밀번호 : : <input type="text" name="passwd"/></p>
		<p><input type="submit" value="전송"/> </p>
	</form>
</body>
</html>