<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.7.0.min.js"></script>
<script>
<%
	String id = request.getParameter("id");
	String photo = request.getParameter("photo");
%>


})
</script>
</head>
<body>
<form  action="<%=request.getContextPath()%>/update.do" method="post" enctype="multipart/form-data">
<input type="hidden" name="oldphoto" value="<%=photo%>">
<table border="1">
<tr>
	<td colspan="2"></td>
</tr>
<tr>
	<td>회원ID</td>
	<td><input type="text" id="id" name="id" value="<%=id %>" readonly></td>
</tr>
<tr>
	<td>비밀번호</td>
	<td><input type="password" class="checkpw" id="pw" name="pw" autocomplete="off"></td>
</tr>
<tr>
	<td>회원이름</td>
	<td><input id="name" name="name"></td>
</tr>
<tr>
	<td>전화번호</td>
	<td><input id="tel" name="tel"></td>
</tr>
<tr>
	<td>회원주소</td>
	<td><input id="addr" name="addr"></td>
</tr>
<tr>
	<td>프로필사진</td>
	<td><input type="file" id="photo" name="photo"></td>
</tr>
<tr>
	<td colspan="2">
		<input type="submit" id="save" value="저장">
		<input type="button" id="cancel" value="취소" onClick="location.href='<%=request.getContextPath() %>/index.jsp'">
		<input type="button" id="memlist" value="회원목록" onClick="location.href='<%=request.getContextPath() %>/memberList.do'">
	</td>
</tr>

</table>
</form>
</body>
</html>