
<!-- <script src="https://cdn.jsdelivr.net/npm/jquery_cdn@3.0.0/index.min.js"></script> -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/gridstack.js/9.1.0/gridstack-all.min.js"></script>

<link href="https://cdnjs.cloudflare.com/ajax/libs/gridstack.js/9.1.0/gridstack.min.css" rel="stylesheet"/> 
<link href="./resources/css/demo.css" rel="stylesheet"/> 

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


    <div class="grid-stack"></div> 
<script type="text/javascript"> 
    var items = [ 
	{content: 'my first widget'}, 
	{w: 5, content: 'another longer widget!'},
	{w: 5, h:5, content: '<div id="suji">ㅎㅎ</div>'},
	{w: 5, content: 'another longer widget!'},
	{w: 5, content: 'another longer widget!'}];
    var grid = GridStack.init(); grid.load(items); grid.float(true);
</script>

<button id="abc" onclick="kkk()">클릭</button>
<script>
	var vDiv = document.querySelector('#suji');
	function kkk(){
		let txt = `
			<table border="1" style="width : 100%;height : 100%;background-color : hotpink;">
			<tr><th>이름</th><th>사번</th></tr>
			<tr><td>정은비</td><td>123</td></tr>
			<tr><td>정수지</td><td>456</td></tr>
			<tr><td>김예린</td><td>111</td></tr>
			<tr><td>윤강혁</td><td>244</td></tr>
			<tr><td>이경민</td><td>789</td></tr>
		</table>
		`;
		vDiv.innerHTML = txt;
	}
	

</script>
