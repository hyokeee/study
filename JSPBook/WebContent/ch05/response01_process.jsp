<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- 
	요청 URL : response01_process.jsp
	요청 파라미터 : {id=a001&passwd=java}
-->

<%
	String id = request.getParameter("id"); //a001
	String passwd = request.getParameter("passwd");//java
	
	//분기
	if(id.equals("a001")&&passwd.equals("java")){
		//관리자맞음
		response.sendRedirect("response01_success.jsp");
	}else{
		//관리자아님
		response.sendRedirect("response01_failed.jsp");
	}
	
	%>