<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>스프링 폼 태그 라이브러리</h1>
<pre>
스프링 폼은 HTML 폼을 표시하기 위한 태그 라이브러리.
스프링 폼을 이용하면 HTML(Vies, jsp) 폼과 자바 객체(Controller)를 쉽게 바인딩(연결)할 수 있음
</pre>
<form:form modelAttribute="user" method="post" action="/member/register">
	<p>
		<!-- path : VO의 멤버변수 -->
		<!-- 
		<input id="userId" name="userId" type="text" value="gaeddongi">
		-->
		유저 ID : <form:input path="userId"/>
	</p>
	<p>
		<!-- 
		<input id="userName" name="userName" type="text" value="개똥이">
	 	-->
		이름 : <form:input path="userName"/>
	</p>
	<p>
		코인 : <input type="text" id="coin" name="coin" value="${memberVO.coin}"/>
	</p>
	<p>
		<form:button name="register">등록</form:button>
	</p>
	
</form:form>