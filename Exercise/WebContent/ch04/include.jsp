<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h4>구구단 출력하기</h4>
<jsp:include page="include_data.jsp">
	<jsp:param value="5" name="dan"/>
</jsp:include>
</body>
</html>