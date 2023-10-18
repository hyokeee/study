<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
	//request 내장 객체가 {name=개똥이} 요청 파라미터를 가지고 있음
	String name = request.getParameter("name");


%>
<p>이름 : <%=name %></p>
<c:set var="name" value="<%=name %>"/>
<p>이름(JSTL) : ${name}</p>
<script type="text/javascript">
//J/S 변수 name
let name = "${name}";
console.log("name : " +name);
</script>
