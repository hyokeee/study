<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="/resources/js/jquery-3.6.0.js"></script>
<script>
$(function(){
	$.ajax({
		url : "/resp/goHome030101",
		type : "get",
		dataType : "json",
		success: function(result){
			console.log("result : " + JSON.stringify(result));
		}
	
	});
	$('#btnDetail').on('click',function(){
		let data = {"bookId" : $('input[name="bookId"]').val()};
		
		console.log(JSON.stringify(data));
		/* $.ajax({
			url : "/resp/goHome030102?bookId="+data,
			type : "get",
			contentType : "application/json;charset=utf-8",
			dataType : "json",
			success : function(result){
				console.log("result : "  + JSON.stringify(result));
				console.log(result.bookId);
			}
		}) */
		$.ajax({
			url : "/resp/goHome030103",
			type : "post",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(data),
			dataType : "json",
			success : function(result){
				console.log("result : "  + JSON.stringify(result));
				//result : BookVO
				//result.content : bookVO의 getContent()
				$('textarea[name="content"]').val(result.content);
			}
		})
	});
});
</script>
<p><input type="text" name="bookId" value="1"/></p>
<p><button type="button" id="btnDetail">도서정보 확인</button></p>
<p>
	<textarea name="content" rows="5" cols="30"></textarea>
</p>