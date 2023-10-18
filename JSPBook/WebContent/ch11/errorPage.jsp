<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page errorPage="errorPage_error.jsp" %>
<!-- 
JSP 페이지가 실행되는 도중 오류 발생 시 오류 페이지 호출
-->
<!DOCTYPE html>
<html>
<head>
<title>Exception</title>
</head>
<body>
	<!-- errorPage.jsp?name=smith => SMITH
		 errorPage.jsp => 오류발생(null을 대문자변환 불가)
		 toUpperCase() 메서드 : 파라미터 값을 대문자로 변환하여 출력
	 -->
	name 파라미터 : <%=request.getParameter("name").toUpperCase()%>
</body>
</html>