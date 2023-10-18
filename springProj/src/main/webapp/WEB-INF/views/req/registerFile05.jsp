<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="/resources/js/jquery-3.6.0.js"></script>
<script>
$(function(){
   $('#inputFile').on("change",function(event){
      console.log("개똥이");
      let userId = $('input[name="userId"]').val();		//gaeddongi
      let password = $('input[name="password"]').val();	//java
      //event.target : <input type="file" id="inputFile" name="pictures" />
      let files = event.target.files;
      
      //첫번쨰 파일만 선택해서 파일 object에 할당
      let file = files[0];
      
      let formData = new FormData();
      //formData : (formData를 ajax로 보내려면 
      //			processData, contentType을 false로 지정해주어야 한다)
      //<form>
      //   <input type="file" name="file" />
      //   <input type="text" name="userId" value="gaeddongi"/>
      //   <input type="text" name="password" value="java"/>
      //</form>
      formData.append("file",file)
      formData.append("userId",userId);
      formData.append("password",password);
      
      $.ajax({
    	  url:"/req/registerFile05Post",
    	  processData:false,
    	  contentType:false,
    	  data:formData,
    	  type:"post",
    	  dataType:"text",
    	  success:function(result){
    	   	  console.log("result : " + result);
    	  }
      })
   });
});
</script>
<!-- 
요청URI : /req/registerFile05Post
요청파라미터 : {userId=gaeddongi&password=java&pictures=파일객체들}
요청방식 : post
-->
<form action="/req/registerFile05Post" method="post" 
   enctype="multipart/form-data">
   <!-- 텍스트 필드 요소 -->
   <p><input type="text" name="userId"  value="gaeddongi"/></p>
   <p><input type="text" name="password"  value="java"/></p>
   <!-- 파일업로드 폼 파일 요소 -->
   <p><input type="file" id="inputFile" name="pictures" /></p>
   <p><input type="submit" value="파일업로드"/></p>
</form>