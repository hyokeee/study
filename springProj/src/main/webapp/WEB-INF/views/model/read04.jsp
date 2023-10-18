<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Result</h1>
<p>carList : ${carList.get(0) }</p>
<p>carArray : ${carArray[0] }</p>
<h4>carArray</h4>
<c:forEach var="car" items="${carArray }" varStatus="stat">
	<p>${car}</p>
</c:forEach>

<h4>carList</h4>
<c:forEach var="car" items="${carList }" varStatus="stat">
	<p>${car}</p>
</c:forEach>
