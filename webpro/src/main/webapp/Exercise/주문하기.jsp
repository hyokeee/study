<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>JSP : Java Server Page</h1>

<%
	request.setCharacterEncoding("UTF-8");
	String userName = request.getParameter("name");
	String userTel = request.getParameter("tel");
	String userMail = request.getParameter("mail");
	String pizza = request.getParameter("pizza");
	String pSize = request.getParameter("size");
	String[] pTopping = request.getParameterValues("topping");
	String time = request.getParameter("time");
	String userArea = request.getParameter("area");	
	String str = "";
	for(String pz : pTopping){
		str += pz + "&nbsp;&nbsp;";
	}
	
	String area = userArea.replaceAll("\n" , "<br>");
%>

<table border="1">
	<tr>
		<td>고객명</td>
		<td> <%=userName %> </td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td> <%=userTel %> </td>
	</tr>
	<tr>
		<td>E-mail</td>
		<td> <%=userMail %> </td>
	</tr>
	<tr>
		<td>피자선택</td>
		<td> <%=pizza %> </td>
	</tr>
	<tr>
		<td>피자사이즈</td>
		<td> <%=pSize %> </td>
	</tr>
	<tr>
		<td>토핑</td>
		<td> <%=str %> </td>
	</tr>
	<tr>
		<td>희망주문시간</td>
		<td> <%=time %> </td>
	</tr>
	<tr>
		<td>요청사항</td>
		<td> <%=area %> </td>
	</tr>


</table>
</body>
</html>