<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Validation</title>
<script>
	function checkForm(){
		//"1admin".substr(0,1) => 1
		//33개똥이
		// It is Not a Number : 그것은 숫자가 아니다(isNaN) 가 아니다(!) => 숫자다
		let form = document.frm;
		if(!isNaN(form.name.value.substr(0,1))){
			// 숫자라면
			alert("이름은 숫자로 시작할 수 없습니다.");
			form.name.select();
			return;
		}
		// 통과했다면
		form.submit();	//form에 action 없음 => 현재 URL을 요청, method없음 => 기본 get방식
	}
</script>
</head>
<body>
<!-- body와 /body 사이를 document라고 한다 -->
	<form name="frm">
		<p>이름 : <input type="text" name="name"/></p>
		<!-- checkForm() : 핸들러함수 -->
		<p><input type="button" value="전송" onclick="checkForm()"/></p>
	</form>
</body>
</html>