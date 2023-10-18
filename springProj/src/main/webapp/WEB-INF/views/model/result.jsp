<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 
registerForm.jsp => ModelController.java => result.jsp
{userId=gaeddongi,password=java}		 전달 안됨!!
 -->

<h3>result</h3>
<p>userId : ${userId }</p>
<p>password : ${password }</p>
<p>userId : ${memberVO.userId }</p>
<p>password : ${memberVO.password }</p>