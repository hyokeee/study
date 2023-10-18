<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page errorPage="page_errorPage_error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>Directive Tag</title>
</head>
<body>
	<%	//스크립틀릿
		//지역변수 선언
		String str = null;
		//오류 발생(null을 toString()할 수 없음
		out.print(str.toString());
	%>
</body>
</html>