<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>
<script>
$(function(){
	// 문자열 처리
	$('#strBtn').on('click',function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/JSONDataTest.do",
			type : "post",
			data : "choice=string",    //"이름=값&이름=값", {"이름1" : 값, "이름2" : 값},
			success : function(res){
				//res = "안녕하세요";
				$('#result').html(res);
			},
			error : function(xhr){
				alert("오류");
			},
			dataType : "json"		 	// 응답 데이터의 데이터 타입 지정
		});
	});
	//-------------------------------------------------------------------------------
	//배열 처리
	$('#arrayBtn').on('click',function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/JSONDataTest.do",
			type : "post",
			data : "choice=array",    //"이름=값&이름=값", {"이름1" : 값, "이름2" : 값},
			success : function(res){
				//res = {10,20,30,40,50,60}
				let htmlCode = "";
				$.each(res,function(i,v){
					htmlCode +=(i+1) + "번째 자료 :" + v + "<br>";
				});
				$('#result').html(htmlCode);
			},
			error : function(xhr){
				alert("오류");
			},
			dataType : "json"		 	// 응답 데이터의 데이터 타입 지정
		});
	});
	
	//--------------------------------------------------------------------------------
	 <%-- var count = 0;
	$('#arrayBtn').on('click',function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/JSONDataTest.do",
			type : "post",
			data : "choice=array",    //"이름=값&이름=값", {"이름1" : 값, "이름2" : 값},
			success : function(res){
				//res = {10,20,30,40,50,60}
				let htmlCode = "";
				
				htmlCode += count + "번째 자료 :" + res[count] + "<br>";
				
				$('#result').append(htmlCode);
			},
			error : function(xhr){
				alert("오류");
			},
			dataType : "json"		 	// 응답 데이터의 데이터 타입 지정
		});
		if(count<5){
		count++;
		} else{
		count = 0;
		}
	});  --%>
	//-----------------------------------------------------------------
	$('#objBtn').on('click',function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/JSONDataTest.do",
			type : "post",
			data : "choice=obj",
			success : function(res){
				// res = {"num":1,"name":"홍길동"}
				let htmlCode = "";
				htmlCode += "번호 : " + res.num + "<br>";
				htmlCode += "이름 : " + res.name + "<br>";
				$('#result').html(htmlCode);
			},
			error : function(xhr){
				alert("오류");
			},
			dataType : "json"		 
		});
	});
	//------------------------------------------------------------------
	$('#listBtn').on('click',function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/JSONDataTest.do",
			type : "post",
			data : "choice=list",
			success : function(res){
				//res = [
				//	      {"num":100,"name":"이순신"},
				//        {"num":200,"name":"강감찬"},
				//        {"num":300,"name":"이몽룡"}
				//      ];
				let htmlCode = "";
				$.each(res,function(i,v){
					htmlCode += i + "번째 자료<br>"; 
					htmlCode += "번 호 : " + v.num + "<br>";
					htmlCode += "이 름 : " + v.name + "<hr>";
				});
				$('#result').html(htmlCode);
			},
			error : function(xhr){
				alert("오류");
			},
			dataType : "json"		 
		});
	});
	//-------------------------------------------------------------------
	$('#mapBtn').on('click',function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/JSONDataTest.do",
			type : "post",
			data : "choice=map",
			success : function(res){
				//res = {"name":"성춘향","tel":"010-1234-5678","addr":"대전시 중구 오류동"};
				// 객체에 $.each를 하면 i 는 'key값'을 v는 해당 'value값'을 자동으로 출력한다.
			/* 
				let htmlCode = "이 름 : " + res.name + "<br>";
				htmlCode += "전 화 : " + res.tel + "<br>";
				htmlCode += "주 소 : " + res.addr + "<br>";
				$('#result').html(htmlCode);
			*/
				let htmlCode = "";
				$.each(res,function(i,v){
					htmlCode += i + " : " + v + "<br>";
				});
				$('#result').html(htmlCode);
			},
			error : function(xhr){
				alert("오류");
			},
			dataType : "json"	
		});
	});
});
</script>
</head>
<body>
<h2>Ajax를 이용한 예제</h2>
<form action="">
	<input type="button" id="strBtn" value="문자열">
	<input type="button" id="arrayBtn" value="배 열">
	<input type="button" id="objBtn" value="객 체">
	<input type="button" id="listBtn" value="리스트">
	<input type="button" id="mapBtn" value="Map객체">
</form> <hr>
<h3>응답 결과 출력</h3>
<div id="result"></div>
</body>
</html>