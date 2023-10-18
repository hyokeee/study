<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<title>Exception</title>
</head>
<body>
<img src="/images/error03.jpg"/>
<p>예외 : <%=exception%></p>
<p>toString() : <%=exception.toString()%></p>
<p>getClass().getName() : <%=exception.getClass().getName()%></p>
<p>getMessage() : <%=exception.getMessage()%></p>
</body>
</html>