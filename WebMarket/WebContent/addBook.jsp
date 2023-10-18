<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/bootstrap.min.css" />
<title>도서 등록</title>
<script type="text/javascript" src="/js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="./js/validation.js"></script>
<script>
//document 내 모든 요소 로딩 후 처리
$(function(){
	// 이미지 미리보기 시작
	$('#productImage').on('change',handleImg);
	// e : change event
	function handleImg(e){
		// 첨부 파일들
		let files = e.target.files;
		// 파일 배열 Object
		let fileArr = Array.prototype.slice.call(files);
		// 파일 반복 -> 파일(f)
		fileArr.forEach(function(f){
			if(!f.type.match("image.*")){
				alert("이미지 확장자만 가능합니다.");
				// 함수 종료
				return;
			}
			let reader = new FileReader();
			// e : 파일 읽을 때 이벤트
			reader.onload = function(e){
				let img_html = "<img src='"+ e.target.result +"' style='width:100%;'/>";
				$('.divImg').html(img_html);
			}
			// 리더로 파일을 읽음 
			reader.readAsDataURL(f);
		});
	}
});
</script>
</head>
<body>
	<fmt:setLocale value="${param.language }"/>
	<fmt:bundle basename="bundle.message">
	<jsp:include page="menu.jsp"/>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3"><fmt:message key="title"/></h1>
		</div>
	</div>
	<div class="container">
		<div class="text-right">
			<a href="?language=ko">Korean</a>|<a href="/WebMarket/addBook.jsp?language=en">English</a>
		</div>
		<form name="newBook" action="processAddBook.jsp"
			class="form-horizontal" method="post" enctype="multipart/form-data">
			<div class="form-group row">
				<label class="col-sm-2"><fmt:message key="bookId"/></label>
				<div class="col-sm-3">
					<input type="text" name="bookId" class="form-control" required/>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2"><fmt:message key="name"/></label>
				<div class="col-sm-3">
					<input type="text" name="name" class="form-control" required/>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2"><fmt:message key="unitPrice"/></label>
				<div class="col-sm-3">
					<input type="text" name="unitPrice" class="form-control" required/>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2"><fmt:message key="author"/></label>
				<div class="col-sm-3">
					<input type="text" name="author" class="form-control" required/>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2"><fmt:message key="publisher"/></label>
				<div class="col-sm-3">
					<input type="text" name="publisher" class="form-control" required/>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2"><fmt:message key="releaseDate"/></label>
				<div class="col-sm-3">
					<input type="text" name="releaseDate" class="form-control" required/>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2"><fmt:message key="totalPages"/></label>
				<div class="col-sm-3">
					<input type="text" name="totalPages" class="form-control" required/>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2"><fmt:message key="description"/></label>
				<div class="col-sm-3">
					<textarea rows="3" cols="50" name="description" 
					class="form-control"  required></textarea>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2"><fmt:message key="category"/></label>
				<div class="col-sm-3">
					<input type="text" name="category" class="form-control" required/>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2"><fmt:message key="unitsInStock"/></label>
				<div class="col-sm-3">
					<input type="text" name="unitsInStock" class="form-control" required/>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2"><fmt:message key="condition"/></label>
				<div class="col-sm-3">
					<input type="text" name="condition" class="form-control" required/>
				</div>
			</div>
						<!-- 상품 이미지 -->
			<div class="form-group row">
				<label class="col-sm-2"><fmt:message key="bookImage"/></label>
				<div class="col-sm-5">
					<input type="file" id="bookImage" name="bookImage" class = "form-control"/>
				</div>
			</div>
			<!-- 상품 이미지 미리보기 -->
			<div class="form-group row">
				<label class="col-sm-2">이미지 미리보기</label>
				<div class="col-sm-5 divImg"></div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="button" onclick="CheckAddBook()" class="btn btn-primary" value="<fmt:message key="button"/>"/>
				</div>	
			</div>
			
		</form>
	</div>
	<jsp:include page="footer.jsp"/>
	</fmt:bundle>
</body>
</html>