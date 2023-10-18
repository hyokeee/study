<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

</head>
<body>
<%  //스크립틀릿
	//1초마다 새로고ㄹ침
	//response.setIntHeader("Refresh",1);

%>
<!-- new Date() => Web Jun 29 12:11:35 KST 2023 -->
<p id="p1"></p>
<script type="text/javascript">
function gogo(){
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
	
	document.getElementById("p1").innerHTML = dateString + " " + timeString;
}
setInterval(gogo,1000); //1초마다 gogo함수를 요청
</script>
</body>
</html>