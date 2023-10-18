<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>principal이 뭐에 대응하는지만 알면 Good</h1>
<h1>principal은 CustomUser에 대응함!</h1>
<sec:authorize access="isAuthenticated()">
<p><sec:authentication property="principal"/></p>
<p><sec:authentication property="principal.member"/></p>
<p><sec:authentication property="principal.member.username"/></p>
<p><sec:authentication property="principal.username"   var="merong"/></p>
<p><sec:authentication property="principal.member.authList"  var="myAuths"/></p>
</sec:authorize>
<h1>${merong }</h1>
<h1>${myAuths}</h1>
</body>
</html>