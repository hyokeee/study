<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
	border : 3px solid blue;
	margin : 50px auto;
}

th{
	border : 3px solid blue;
	height : 40px;
}

td{
	width : 200px;
	height : 40px;
	
}

div{
	text-align: center;
	border : 1px solid black;
	margin : 45px;
}

h1}
</style>

</head>
<body>
<div>
<h1>주문내역 출력!!</h1>

<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String eMail = request.getParameter("mail");
	String hPage = request.getParameter("home");
	String loc = request.getParameter("loc");
	String pname = request.getParameter("pname");
	String qty = request.getParameter("qty");
	String grade = request.getParameter("grade");
	String etc = request.getParameter("etc");
	String area = etc.replaceAll("\n" , "<br>");

%>

<table border="1">
	<tr>
		<th>납품자명</th>
		<th>이메일</th>
		<th>홈페이지</th>
		<th>지역</th>
	</tr>
	<tr>
		<td><%=name %></td>
		<td><%=eMail %></td>
		<td><%=hPage %></td>
		<td><%=loc %></td>
	</tr>
</table>

<table border="1">
	<tr>
		<th>상품명</th>
		<th>납품수량</th>
		<th>납품등급</th>
		<th>기타사항</th>
	</tr>
	<tr>
		<td><%=pname %></td>
		<td><%=qty %></td>
		<td><%=grade %></td>
		<td><%=area %></td>
	</tr>
</table>
</div>
</body>
</html>