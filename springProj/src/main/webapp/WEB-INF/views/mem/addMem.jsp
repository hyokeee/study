<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/resources/js/jquery-3.6.0.js"></script>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>

<form action="/mem/addMem01" method="post">
   <p>userId : <input type="text"name="userId" value="gaeddongi"/></p>
   <p>password : <input type="text"name="password" value="java"/></p>
   <p>coin : <input type="text"name="coin" value="100"/></p>
   <p>dateOfBirth : <input type="date" name="dateOfBirth" value="2023-08-07"/></p>
   <p>
   	  gender : <br/>
   	  <p>
	   	  <input type="radio" id="gender1" name="gender" value="male" checked />
	   	  <label for="gender1">Male</label>
   	  </p>
   	  <p>
	   	  <input type="radio" id="gender2" name="gender" value="female"/>
	   	  <label for="gender2">Female</label>
   	  </p>
   	  <p>
	   	  <input type="radio" id="gender3" name="gender" value="other"/>
	   	  <label for="gender3">Other</label>
   	  </p>
   </p>
   <p>
   	  국적 : <select name="nationality">
   	  		<option value="Korea" selected>대한민국</option>
   	  		<option value="Germany">독일</option>
   	  		<option value="Australia">호주</option>
   	  		<option value="Canada">캐나다</option>
   	      </select>
   </p>
   <p>
   <!-- Y : String 타입 => Y(체크) 또는 null(비체크)-->
         개발자 여부 :
      <input type="checkbox" name="developer" value="Y"/>
   </p>
   <p>
   <!-- false : Boolean 타입 => value 속성을 작성하지 말자=> true(체크) 또는 false(비체크) -->
         외국인 여부 : 
      <input type="checkbox" name="foreigner"/>
   </p>
   <p>
          우편번호 :
      <input type="text" name="addrVO.zonecode" placeholder="우편번호" readonly/>
      <button type="button" id="btnPostNum">우편번호검색</button>
      <input type="text" name="addrVO.address" placeholder="주소"/><br/>
      <input type="text" name="addrVO.buildingName" placeholder="상세주소"/>
   </p>
   <p>
      <input type="submit" value="addMem01"/>
   </p>
   <script>
   $(function(){
	  $('#btnPostNum').on('click',function(){
		  new daum.Postcode({
			//다음 창에서 검색이 완료되면 콜백함수에 의해 결과 데이터가 data 객체로 들어옴
			oncomplete:function(data){
				$('input[name="addrVO.zonecode"]').val(data.zonecode);
				$('input[name="addrVO.address"]').val(data.address);
				$('input[name="addrVO.buildingName"]').val(data.buildingName);
			}
		  }).open();
	  });
   });
   </script>
</form>