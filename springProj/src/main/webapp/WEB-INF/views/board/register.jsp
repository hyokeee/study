<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/resources/js/jquery-3.6.0.js"></script>
<script>
$(function(){
	$('#btnHeaders').on('click',function(){
		let boardNo = "10";
		let title = "개똥이의 여행";
		let content= "개똥이 여행을 떠나다";
		let writer ="개똥이";
		
		let data = {"boardNo" : boardNo, "title" : title,"condent" : content,"writer":writer};
		
		//JSON은 object. -> string으로 변환
		//JSON : JavaScript Object Notation
		//		클라이언트(브라우저)와 서버 간에 데이터를 교환할 때 활용. 텍스트.
		//		모든 자바스크림트 객체를 JSON으로 변환하고 JSON을 서버로 보낼 수 있음
		//		서버에서 받은 JSON을 자바스크립트 객체로 변환할 수 있음
		console.log("data : " + JSON.stringify(data));
		
		// contentType : 보내는 타입
		// dataType : 받는 타입
		/*
			요청URI : /board/10
			PathVariable : boardNo
			요청방식 : post
		*/
		$.ajax({
			url : "/board/"+boardNo,
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(data),
			type : "post",
			success : function(result){
				console.log("result : " + result);
			}
		});
	});
	
	   //도서 상세 정보(/detail?bookId=1)
	   //요청URI : /board/9
	   //PathVariable : boardNo -> bookId로 처리 예정
	   //요청방식 : get
	   //dataType(응답타입) : JSON
	   $("#btnBookDetail").on("click",function(){
		      let bookId = "8";
		      
		      $.get("/board/" + bookId,function(result){
		         console.log("result : " + JSON.stringify(result));
		      })
		});
});
</script>
<h3>register</h3>
<p>
   <!-- 
   요청URI : /board/post?register
   요청방식 : post
   요청파라미터 : register
    -->
   <form action="/board/post" method="post">
      <input type="text" name="bookId" value="ISBN1234"/>
      <!-- 요청URI : /board/post?register -->
      <button type="submit" name="register">Register</button>
      <!-- 요청URI : /board/post?update -->
      <button type="submit" name="update">Update</button>
      <!-- 요청URI : /board/post?delete -->
      <button type="submit" name="delete">Delete</button>
      <!-- 요청URI : /board/post?list -->
      <button type="submit" name="list">List</button>
   </form>
   <form action="/board/post" method="post">
      <a href="/board/get?read" class="btn btn-primary">read</a>
      <!-- 요청URI : /board/post?remove -->
      <button type="button" id="btnHeaders">Header매핑</button>
      <button type="submit" name="remove">remove</button>
      <button type="button" id="btnBookDetail">bookDetail</button>
   </form>
</p>