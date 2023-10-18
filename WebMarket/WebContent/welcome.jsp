<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<body>
<!-- ///////////////////////////////header 시작(menu.jsp)////////////////////////////// -->
<%@ include file="./menu.jsp"%>
<!-- ///////////////////////////////header 끝////////////////////////////// -->
<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">
				도서 웹 쇼핑몰
			</h1>
		</div>
	</div>
	<div class="container">
		<div class="text=center">
			<h3>
			
			</h3>
		</div>
	</div>

<!-- /////////////////////////footer시작(footer.jsp)/////////////////////// -->
<%@ include file="footer.jsp" %>
<!-- /////////////////////////footer 끝/////////////////////// -->
<script type="text/javascript">
//현재시간 처리
function gogo(){
	//JSTL 변수를 J/S 변수에 할당
	let tagline = "${tagline}";
	console.log("tagline : " + tagline);
	
	//<h3> 태그 select
	let h3 = document.getElementsByTagName("h3")[0];
	
	let today = new Date();
	console.log("today : " + today);
	
	let year = today.getFullYear();
	let month = ('0' + (today.getMonth()+1)).slice(-2);
	let day = ('0' + today.getDate()).slice(-2);
	
	let dateString = year +"-"+month+"-"+day;
	
	console.log("dateString : " + dateString);
	
	let hours = ('0' + today.getHours()).slice(-2);
	let minutes = ('0' + today.getMinutes()).slice(-2);
	let seconds = ('0' + today.getSeconds()).slice(-2);
	
	let timeString = hours + ":" + minutes +":"+seconds;
	
	console.log("result : " + dateString + " " + timeString);
	//select
	h3.innerHTML = tagline + "<br/>" + "현재 접속 시각 : " + dateString + " " + timeString;
	 
}
setInterval(gogo,1000); //1초마다 gogo함수를 요청
</script>	
</body>
</html>