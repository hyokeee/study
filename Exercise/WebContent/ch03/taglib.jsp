<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Directives Tag</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="i" begin="0" end="10" step="1">
	<c:if test="${i%2==0}">
		<c:out value="${i}"/>
	</c:if>
</c:forEach>
</body>
</html>