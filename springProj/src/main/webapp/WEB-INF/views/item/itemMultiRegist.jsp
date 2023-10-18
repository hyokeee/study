<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="/resources/ckeditor/ckeditor.js"></script>
<div class="card card-primary">
	<div class="card-header">
		<h3 class="card-title">Item 등록</h3>
	</div>
	<!-- 
	요청URI : /item/registPost
	요청파라미터 : {itemName=태블릿&price=12000&description=설명&pictures=파일객체들}
	요청방식 : post
	-->
	<form id="frm" action="/item/registMultiPost" method="post"
			enctype="multipart/form-data">
		<div class="card-body">
			<div class="form-group">
				<label for="itemName">아이템 명</label>
				<input type="text" class="form-control" id="itemName"
						name="itemName" placeholder="아이템 명"/>
			</div>
			<div class="form-group">
				<label for="price">가격</label>
				<input type="number" class="form-control" id="price"
					name="price" placeholder="가격을 입력하세요."/>
			</div>
			<div class="form-group">
				<label for="description">설명</label>
				<textarea rows="3" cols="10" id="description" name="description"></textarea>
			</div>
			<div class="form-group">
				<label for="pictures">아이템 이미지</label>
				<div class="input-group">
					<div class="custom-file">
						<input type="file" class="custom-file-input" 
							name="pictures" id="pictures" multiple/>
						<label class="custom-file-label" for="pictures">Choose
							file</label>
					</div>
				</div>
			</div>
		</div>
		<div class="card-footer">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>
</div>
<script type="text/javascript">
	CKEDITOR.replace("description");
</script>