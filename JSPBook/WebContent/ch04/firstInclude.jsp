<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<title>Action Tag</title>
</head>
<body>
	<h3>이 파일은 first.jsp입니다.</h3>
	<!-- forwqrd 액션 태그 : 다른 페이지로 이동(페이지 흐름 제어)
	요청URI : second.jsp?date=오늘날짜
	요청파라미터(Http파라미터=QueryString) : date = 오늘날짜
	 -->
	<hr/>
	<%@ include file="second.jsp" %>
	<hr/>
	
	<jsp:include page="second.jsp">
		<jsp:param name="date" value="<%=new Date() %>" />
	</jsp:include>
	<!--  forward 할 때는 태그들<!DOCTYPE html>
	<html> <head>...이 필요한데, include 할때는 들어갈 코드만 작성해주면 된다. 
	-->
	<p>===first.jsp의 페이지</p>
</body>
</html>