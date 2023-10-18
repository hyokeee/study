/**
 * 
 */

 function proc1(){
	 let today = new Date();
 
 let day1 = today.toLocaleString();
 let day2 = today.toLocaleDateString();
 let day3 = today.toLocaleTimeString();
 
 //출력내용
  let str = "오늘은" +today + "<br>";
  str += "우리는 " +day1+"<br>"+"우리의 날짜 "+day2 + "<br>"+"우리의 시간 "+day3 + "<br>";
 /*  str += "우리의 날짜 "+day2 + "<br>";
  str += "우리의 시간 "+day3 + "<br>"; */
  
  //id가 res인 요소 검색  -출력
  //document.querySelector("#res").innerText = str;
  document.querySelector("#res").innerHTML = str;
 }