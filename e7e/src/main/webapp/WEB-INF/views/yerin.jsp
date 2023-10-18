<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예린 restful 클라이언틍</title>
</head>
<body>
<div id="disp"></div>
<hr>
<form>
    타이틀 <input type="text" name="title"> <br>
    이  름 <input type="text" name="sname"> <br>
    내  용 <textarea name ="scont"></textarea><br>
    <!-- button 태그는 form 태그 안에 있음 기본 type이 submit이 됨 -->
    <button type="button" onclick="fSearch()">조회</button>
    <button type="button" onclick="fModify()">수정</button>
    <button type="button" onclick="fDel()">삭제</button>
    <button type="button" onclick="fInsert()">입력</button>
</form>
<script>
const myList = document.querySelector("#disp");
const myTitle = document.querySelector("input[name=title]");
const myName = document.querySelector("input[name=sname]");
const myCont = document.querySelector("textarea[name=scont]");
//클릭 이벤트
function fmclick(pthis){
    myTitle.value = pthis.children[0].innerHTML;
    myName.value = pthis.children[1].innerHTML;
    myCont.value = pthis.children[2].innerHTML;
}
//등록
function fInsert(){
    let xhr = new XMLHttpRequest();
    let schURL = `/merong/rest/yerin`;
    let yerinVO = {
        title : myTitle.value,
        sname : myName.value,
        scont : myCont.value
    };
    xhr.open("post",schURL,true);
    xhr.setRequestHeader("Content-Type","application/json; charset=UTF-8");
    
    xhr.onreadystatechange = () => {
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);
            getList();
            myTitle.value = "";
            myName.value =  "";
            myCont.value =  "";
        }
    }
    xhr.send(JSON.stringify(yerinVO)); 
}

//타이틀로 조회
function fSearch(){
    let xhr = new XMLHttpRequest();
    let schURL = `/merong/rest/yerin/\${myTitle.value}`;
    xhr.open("get",schURL,true);
    
    xhr.onreadystatechange = () => {
        if(xhr.readyState == 4 && xhr.status == 200){
            let yerinVO = xhr.responseText;
            if(yerinVO){
                yerinVO = JSON.parse(yerinVO);  // json 문자열을 json 객체로
                myName.value = yerinVO.sname;
                myCont.value = yerinVO.scont;
            } else{
                alert('찾는 타이틀은 없습니다.')
            }
            
        }
    }
    xhr.send(); 
}

//삭제 이벤트
function fDel(){
    let xhr = new XMLHttpRequest();
    let delURL = `/merong/rest/yerin/\${myTitle.value}`;
    xhr.open("delete",delURL,true);
    
    xhr.onreadystatechange = () => {
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log("체킁",xhr.responseText);
            getList();
            myTitle.value = "";
            myName.value =  "";
            myCont.value =  "";
        }
    }
    xhr.send(); 
}


//수정 이벤트
function fModify(){
    // 넘겨야 할 data
    let yerinVO = {
        title : myTitle.value,
        sname : myName.value,
        scont : myCont.value
    }

    let xhr = new XMLHttpRequest();
    xhr.open("put","/merong/rest/yerin",true);
    xhr.setRequestHeader("Content-Type","application/json; charset=UTF-8");
    xhr.onreadystatechange = () => {
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log("체킁",xhr.responseText);
            getList();
        }
    }
    xhr.send(JSON.stringify(yerinVO)); //문자열(json형식의 문자열)
}

// TR 마우스 오버
function fmover(pthis){
    pthis.style.backgroundColor="black";
    pthis.style.color="yellow";
}

// TR 마우스 아웃
function fmout(pthis){
    pthis.style.backgroundColor="white";
    pthis.style.color="black";
}
// 리스트 가져다 뿌리깅
const getList = () =>{
    let xhr = new XMLHttpRequest();
    xhr.open("get","/merong/rest/yerins",true);
    xhr.onreadystatechange = () =>{
        if(xhr.readyState == 4 && xhr.status == 200){
            //json문자열을 json객체로 바꿔야 편하게 쓸 수 있음 !
            let rslt = JSON.parse(xhr.responseText);

            let tblStr = "<table border=1>";
            tblStr += "<tr><th>타이틀</th><th>이름</th><th>내용</th></tr>";
            for(let i=0; i<rslt.length; i++){
                tblStr += "<tr onmouseover=fmover(this) onmouseout=fmout(this) onclick=fmclick(this)>";
                tblStr += `<td>\${rslt[i].title}</td>`;
                tblStr += `<td>\${rslt[i].sname}</td>`;
                tblStr += `<td>\${rslt[i].scont}</td>`;
                tblStr += "</tr>";
            }
            tblStr += "</table>";
            myList.innerHTML = tblStr;
        }
    }
    xhr.send();
}
getList();
</script>
</body>
</html>