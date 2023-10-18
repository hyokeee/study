<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.7.0.min.js"></script>
<style>
td[colspan="3"]{
	text-align: center;
}
</style>
<script>
$(function(){
	
	//id 중복 확인
	$('#checkid').on('click',function(){
		id = $('#id').val();
		$.ajax({
			url : '/webMemberTest/checkMemberId.do',
			type : 'get',
			data : {"checkid" : id},
			success : function(res){
				$('#spid').html(res.check);
			},
			error : function(xhr){
				alert(xhr.status);	
			},
			dataType : 'json'
		})
		
	})
	
	
	//비밀번호 확인
	$('#pw2').on('change',function(){
		pw1 = $('#pw').val();
		pw2 = $('#pw2').val();
		if(pw1 != null && pw2 != null){
			if(pw1==pw2){
				$('#check').html("비밀번호가 일치합니다.");
				$('#check').css({"color":"blue"});
				
			}else{
				$('#check').html("비밀번호가 일치하지 않습니다.");
				$('#check').css({"color":"red"});
				
			}
		}
	})
	
	$('#insert').on('submit',function(){
		cid = $('#spid').html();
		
		if(cid=="이미 존재하는 아이디입니다."){
			alert("아이디 중복");
			return false;
		}
		if($('#pw').val() != $('#pw2').val()){
			alert("비밀번호 다시 입력하세요");
			return false;
		}
		
		return true;
	})
	
	
})


</script>
</head>
<body>
<form id="insert" action="<%=request.getContextPath()%>/insertMember.do" method="post" enctype="multipart/form-data">
<table border="1">
<tr>
	<td>회원ID</td>
	<td><input id="id" name="id">
	<input type="button" id="checkid" value="중복확인"><span id="spid"></span></td>
</tr>
<tr>
	<td>비밀번호</td>
	<td><input type="password" class="checkpw" id="pw" name="pw"></td>
</tr>
<tr>
	<td>비밀번호 확인</td>
	<td><input type="password" class="checkpw" id="pw2"><span id="check"></span></td>
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
	<td>프로필 사진</td>
	<td><input type="file" id="photo" name="photo"></td>
</tr>
<tr>
	<td colspan="3">
		<input type="submit" id="save" value="저장">
		<input type="button" id="cancel" value="취소" onClick="location.href='<%=request.getContextPath() %>/index.jsp'">
		<input type="button" id="memlist" value="회원목록" onClick="location.href='<%=request.getContextPath() %>/memberList.do'">
	</td>
</tr>


</table>

</form>
</body>
</html>