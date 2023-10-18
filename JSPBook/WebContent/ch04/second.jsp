<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Action Tag</title>
</head>
<body>
	<!-- 요청URI : second.jsp?date=오늘날짜 -->
	<h3>이 파일은 second.jsp입니다.</h3>
	Today is : <%= request.getParameter("date") %>
</body>
</html>