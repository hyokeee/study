<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%

String userId = request.getParameter("id");
String userPass = request.getParameter("pw");
String userAge = request.getParameter("age");
String userName = request.getParameter("name");

%>

<%=userId %><br>
<%=userPass %><br>
<%=userAge %><br>
<%=userName %><br>

</body>
</html>