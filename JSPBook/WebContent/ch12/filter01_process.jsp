<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>filter</title>
</head>
<body>
<!-- 요청URL : /ch12/filter01_process.jsp
	  요청파라미터 : {name=개똥이}
-->
<%	//스크립틀릿

	String name = request.getParameter("name");	//개똥이

%>
<!-- 
1) /ch12/filter01_process.jsp?name=개똥이
	-> 입력된 name 값 : 개똥이
2) /ch12/filter01_process.jsp?name=
	-> 입력된 name 값은 null입니다. (AuthenFilter.java)
-->
<p>입력된 name 값 : <%=name %></p>
</body>
</html>