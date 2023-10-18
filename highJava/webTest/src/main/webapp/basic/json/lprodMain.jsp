<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="lprodCss.css"/>
<script src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>
<script>
$(function(){
	// ajax 이용
	$('#lprodBtn').on('click',function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/lprodListServlet.do",
			type : "get",
			//data : 	// 서버로 가져갈 data가 없으면 생략 가능
			success : function(res){
				let htmlCode = '<table border="1" class="table-fill">';
				htmlCode += "<tr><th class='text-left'>LPROD_ID</th class='text-left'><th class='text-left'>LPROD_GU</th><th>LPROD_NM</th></tr>";
				$.each(res,function(i,v){
					htmlCode += "<tr><td class='text-left'>"+ v.lprod_id +"</td><td class='text-left'>"+ v.lprod_gu +"</td><td class='text-left'>"+ v.lprod_nm +"</td></tr>";
				});
				htmlCode += "</table>"
				$('#result').html(htmlCode);
			},
			error : function(xhr){
				alert("상태 : " + xhr.status);
			},
			dataType : "json"	
		});
		
	});
	
	// ajax 이용 x
	$('#lprodBtn2').on('click',function(){
		
		// 서블릿으로 요청을 하면 서블릿에서 DB의 자료를 가져오고
		// 가져온 자료를 view용 JSP문서로 forward 방식으로 보낸다
		// view용 JSP문서에서는 서블릿이 보낸 데이터를 받아서 화면에 출력한다.
		
		location.href = "<%=request.getContextPath()%>/lprodListServlet2.do"
	});
	
	
	
})

</script>
</head>
<body>
<form>
	<input type="button" id="lprodBtn" value="Lprod자료 가져오기">
	<input type="button" id="lprodBtn2" value="Lprod자료 가져오기(Ajax사용 안함)">
</form>
<h3>Lprod 자료 목록</h3>
<div id="result"></div>
</body>
</html>