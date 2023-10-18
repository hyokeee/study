<%@page import="kr.or.ddit.member.vo.MyMemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
img{
	width : 200px;
	height : 200px;
}
</style>
<% MyMemberVO memVo = (MyMemberVO) request.getAttribute("memVo"); %>
<body>
<table border="1">
<tr>
	<td colspan="2"><img src="<%=request.getContextPath()%>/imageView.do?photo=<%=memVo.getMem_photo()%>" alt="<%=memVo.getMem_photo() %>"></td>
</tr>
<tr>
	<td>회원ID</td>
	<td><%=memVo.getMem_id() %></td>
</tr>
<tr>
	<td>비밀번호</td>
	<td><%=memVo.getMem_pass() %></td>
</tr>
<tr>
	<td>회원이름</td>
	<td><%=memVo.getMem_name() %></td>
</tr>
<tr>
	<td>전화번호</td>
	<td><%=memVo.getMem_tel() %></td>
</tr>
<tr>
	<td>회원주소</td>
	<td><%=memVo.getMem_addr() %></td>
</tr>
<tr>
	<td colspan="2">
		<input type="button" id="update" value="수정" onclick="location.href='<%=request.getContextPath() %>/mymember/update.jsp?id=<%=memVo.getMem_id()%>&photo=<%= memVo.getMem_photo()%>'">
		<input type="button" id="delete" value="삭제" onclick="location.href='<%=request.getContextPath() %>/delete.do?id=<%=memVo.getMem_id() %>'">
		<input type="button" id="memlist" value="회원목록" onclick="location.href='<%=request.getContextPath() %>/memberList.do'">
	</td>
</tr>

</table>

</body>
</html>