function CheckAddBook(){
	let form = document.newBook;
	// 1) 도서 아이디 체크
	// 첫 글자는 ISBN. 숫자를 조합해서 5~12자까지 입력 가능
	// ISBN1
	let regExpId = /^ISBN([0-9]){1,8}$/;
	if(!regExpId.test(form.bookId.value)){
		alert("[도서 코드]\nISBN와 숫자를 조합하여 5~12자까지 입력하세요.\n첫 글자는 P로 시작하세요.");
		form.bookId.select();
		form.bookId.focus();
		return false;
	}
	// 2) 도서명 체크
	// 4~12자까지 입력 가능
	// ex) 백과사전1
	if(form.name.value.length<4||form.name.value.length>11){
		alert("[상품명]\n최소 4자에서 최대 12자까지 입력하세요.");
		form.name.select();
		form.name.focus();
		return false;	//함수 멈춰
	}
	
	// 3) 상품 가격 체크
	// 숫자만 입력 가능. 음수는 막자
	if(form.unitPrice.value.length ==0 || isNaN(form.unitPrice.value)){
		alert("[가격]\n숫자만 입력하세요.");
		form.unitPrice.select();
		form.unitPrice.focus();
		return false;
	}
	if(form.unitPrice.value < 0){
		alert("[가격]\n음수는 입력할 수 없습니다.");
		form.unitPrice.select();
		form.unitPrice.focus();
		return false;
	}
	
	// 소수점 둘째자리까지 허용 [0-9] == \d
	//let regExpUnitPrice = /^\d+((\.)?([0-9]{1,2})?)?$/;
	let regExpUnitPrice = /^\d+$/;
	if(!regExpUnitPrice.test(form.unitPrice.value)){
		alert("[가격]\n가격은 정수만 허용됩니다.");
		form.unitPrice.select();
		form.unitPrice.focus();
		return false;
	}
	// 4) 재고 수 체크
	// 숫자만 입력 가능
	if(form.unitsInStock.value.length ==0 || isNaN(form.unitsInStock.value)){
		alert("[재고수]\n숫자만 입력해주세요.")
		form.unitsInStock.select();
		form.unitsInStock.focus();
		return false;
	}
	
	if(form.unitsInStock.value < 0){
		alert("[가격]\n음수는 입력할 수 없습니다.");
		form.unitsInStock.select();
		form.unitsInStock.focus();
		return false;
	}
	// 유효성검사를 모두 통과했다면
	form.submit();
}


