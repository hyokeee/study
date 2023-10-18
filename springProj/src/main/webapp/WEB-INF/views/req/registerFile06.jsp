<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="/resources/js/jquery-3.6.0.js"></script>
<script>
$(function(){
	$('#uploadBtn').on('click',function(event){
		//가상의 form 태그 생성<form></form>
		let formData = new FormData();
		//input type="file" name="pictures" multiple
		let pictures = $('input[name="pictures"]');
		//pictures[0] : input type="file"... 요소
		// .files : 그 요소 안에 들어온 파일객체들
		let files = pictures[0].files;
		//formData에다 파일객체를 추가해보자
		for(let i=0; i<files.length; i++){
			//파일확장자 체크(확장자가 exe, sh, zip, alz이니?)
			if(!checkExtension(files[i].name,files[i].size)){
				// 반복문 종료 및 함수 종료
				return false;
			}
			//파일확장자/크기 체킹 통과 시 폼 데이터에 추가
			/*
			<form>
				<input type="file" name="pictures" />
				<input type="file" name="pictures" />
				<input type="file" name="pictures" />
			</form
			*/
			formData.append("pictures",files[i]);
		}//end for
		formData.append("userId",$('input[name="userId"]').val());
		formData.append("password",$('input[name="password"]').val());
		
		//ajax
		$.ajax({
			url:"/req/registerFile06Post",
			processData:false,
			contentType:false,
			data:formData,
			type:"post",
			dataType:"text",
			success:function(result){
				console.log("result : " + result);
				$('#zzz').html(result);
			}
		});
	});
	//정규식
	let regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
	let maxSize = 5242880; //5MB
	//파일의 확장자, 크기 체킹 펑션
	function checkExtension(fileName, fileSize){
		if(fileSize >= maxSize){
			alert("파일 사이즈가 초과되었습니다.");
			//함수 종료
			return false;
		}
		if(regex.test(fileName)){//확장자가 정규식에 포함됨
			alert("해당 종류의 파일은 업로드할 수 없습니다.");
			//함수 종료
			return false;
		}
		//모든 if절을 통과했을 때
		return true;
	}
});
</script>
<!-- 
요청URI : /req/registerFile05Post
요청파라미터 : {userId=gaeddongi&password=java&pictures=파일객체들}
요청방식 : post
-->
<form action="/req/registerFile06Post" method="post" 
   enctype="multipart/form-data">
   <!-- 텍스트 필드 요소 -->
   <p><input type="text" name="userId"  value="gaeddongi"/></p>
   <p><input type="text" name="password"  value="java"/></p>
   <!-- 파일업로드 폼 파일 요소 -->
   <p><input type="file"  name="pictures" multiple/></p>
   <p><input type="button" id="uploadBtn" value="파일업로드"/></p>
</form>
<div id="zzz">
</div>