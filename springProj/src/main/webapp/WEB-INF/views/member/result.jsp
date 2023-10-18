<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<p>아이디 : ${memberVO.userId }</p>
<p>이   름 : ${memberVO.userName }</p>
<p>비밀번호 : ${memberVO.password }</p>
<p>이 메 일 : ${memberVO.email }</p>
<p>생   일 : ${memberVO.dateOfBirth }</p>
<pre>소   개 : ${memberVO.introduction }</pre>
<p>취미 : 
	<!-- String each-->
	<c:forEach var="hobby" items="${memberVO.hobbys }">
		${hobby}
	</c:forEach>
</p>
<p>성   별 : ${memberVO.gender }</p>
<p>국   적 : ${memberVO.nationality }</p>
<p>자동차 : 
	<!-- String[] cars -->
	<c:forEach var="car" items="${memberVO.cars}">
		${car}
	</c:forEach>
</p>

