<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Exception</title>
</head>
<body>
	<p>잘못된 데이터가 입력되었습니다.</p>
	<p>숫자 1 : <%=request.getParameter("num1") %></p>
	<p>숫자 2 : <%=request.getParameter("num2") %></p>
</body>
</html>