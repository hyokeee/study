<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%
	String dan = request.getParameter("dan");
	int gugudan = Integer.parseInt(dan);
	for(int i = 1; i<=9; i++){
		out.print(gugudan + " * " + i + " = " + gugudan*i+"<br/>");
	}
%>
</body>
</html>