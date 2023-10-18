<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 
요청URI : /model/register01
요청파라미터 : {userId=gaeddongi,password=java}
요청방식 : post
-->
<form action="/model/register01" method="post">
	<p>userId : <input type="text" name="userId" value="gaeddongi"/></p>
	<p>password : <input type="text" name="password" value="java"/></p>
	<p><input type="submit" value="register01"/></p>
</form>

<form action="/model/register02" method="post">
	<p>userId : <input type="text" name="userId" value="gaeddongi"/></p>
	<p>password : <input type="text" name="password" value="java"/></p>
	<p><input type="submit" value="register02"/></p>
</form>

<!-- 
요청URI : /model/register04
요청파라미터 : {userId=gaeddongi,password=java}
요청방식 : post
-->
<form action="/model/register04" method="post">
	<p>userId : <input type="text" name="userId" value="gaeddongi"/></p>
	<p>password : <input type="text" name="password" value="java"/></p>
	<p><input type="submit" value="register04"/></p>
</form>