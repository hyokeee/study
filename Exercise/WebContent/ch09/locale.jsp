<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1>현재 로케일</h1>
<%
	String lan = request.getLocale().getLanguage();
	String nation = request.getLocale().getCountry();
	out.print("<p>언어  : "+lan+"</p>");
	out.print("<p>국가  : "+nation+"</p>");
%>
</body>
</html>