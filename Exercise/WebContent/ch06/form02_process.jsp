<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<title>Form Processing</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	Enumeration paramNames = request.getParameterNames();
	while(paramNames.hasMoreElements()){
		String name = (String) paramNames.nextElement();
		String value = request.getParameter(name);
		out.print("<p>"+name+ " : "+value+"</p>");
	}
%>

</body>
</html>