<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Form Processing</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String[] val = request.getParameterValues("fruits");
	out.print("<h1>선택한 과일</h1><p>");
	String txt = "";
	for(String f : val){
		txt += f+" ";
	}
	out.print(txt);
	out.print("</p>");

%>

</body>
</html>