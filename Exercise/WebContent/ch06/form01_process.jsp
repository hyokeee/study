<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Form Processing</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("name");
	String addr = request.getParameter("addr");
	String email = request.getParameter("email");
%>
<p>아이디 : <%=id %></p>
<p>주소 : <%=addr %></p>
<p>이메일 : <%=email %></p>
</body>
</html>