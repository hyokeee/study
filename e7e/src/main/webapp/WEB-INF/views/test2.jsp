<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
function fPostAjax(){
    let testVO = {
    	"name":"강혁",
    	"age":"20",
    	"alias":"흥"
    };
	let xhr = new XMLHttpRequest();
    xhr.open("delete","/merong/silver/rain",true);
    // 보내는 데이터가 json 형태의 문자열임을 알려줘야 함
    xhr.setRequestHeader("Content-Type","application/json; charset=UTF-8");	//이거 안쓰면 400 에러!
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);	//controller에서 return testVO 한 값이 xhr.responseText로 넘어옴 (문자열)
            console.log(JSON.parse(xhr.responseText));	//그 문자열을 다시 Json으로 Parse 해줌
        }
    }
    // get방식 이외에는 보낼 데이터를 send() 안에 매개변수로 보내야 한다.
    xhr.send(JSON.stringify(testVO));   //꼭 문자열로 보내야함	stringify 안하면 400 에러!(잘못된 요청)
}
fPostAjax();
function fPostAjax1(){
    let myList = [
    	"채현",
    	"21",
    	"강남스타일"
    ];
	let xhr = new XMLHttpRequest();
    xhr.open("post","/merong/silver/rain",true);
    // 보내는 데이터가 json 형태의 문자열임을 알려줘야 함
    xhr.setRequestHeader("Content-Type","application/json; charset=UTF-8");	//이거 안쓰면 400 에러!
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);	//controller에서 return testVO 한 값이 xhr.responseText로 넘어옴 (문자열)
            console.log(JSON.parse(xhr.responseText));	//그 문자열을 다시 Json으로 Parse 해줌
        }
    }
    // get방식 이외에는 보낼 데이터를 send() 안에 매개변수로 보내야 한다.
    xhr.send(JSON.stringify(myList));   //꼭 문자열로 보내야함	stringify 안하면 400 에러!(잘못된 요청)
}
fPostAjax1();
</script>
</body>
</html>