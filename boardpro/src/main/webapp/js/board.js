/**
 * 
 */

replyUpdateServer = function(){
	$.ajax({
		url : `${mypath}/updateReply.do`,
		data : reply,
		type : 'post',
		success : function(res){
			if(res.flag=="성공"){
				//입력한 댓글을 출력
				 p3.html(cont);
			}
		},
		error : function(xhr){
			alrert(xhr.status);
		},
		dataType : 'json'
	})
}

replyDeleteServer = function(){
	$.ajax({
		url :  `${mypath}/deleteReply.do`,
		data : {"renum" : vidx},
		type : 'get',
		success : function(res){
			//화면삭제
			vdelete.parents('.reply-body').remove();
			
		},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : 'json'
	})
}
replyListServer = function(){
	$.ajax({
		url : `${mypath}/replyList.do`,
		data : {"bonum" : vidx},
		type : 'get',
		success : function(res){
			//결과 res를 출력
			
			rcode = "";
			$.each(res, function(i,v){
				cont = v.cont;
				cont = cont.replace(/\n/g,"<br>");
				rcode += 
				`<div class="reply-body">
                   <div class="p12">
                      <p class="p1">
                      작성자 : <span class="wr">${v.name}</span>&nbsp;&nbsp;&nbsp;&nbsp;  
                      날짜  : <span class="da">${v.redate}</span>

                      </p>
                      <p class="p2">
                         <input type="button" idx="${v.renum}" value="댓글수정" name="r_modify" class="action">
                         <input type="button" idx="${v.renum}" value="댓글삭제" name="r_delete" class="action">
                      </p>
                   </div>
                   <p class="p3">
                    ${cont}       
            	   </p> 
                 </div>`;
			})
			// remove 방법 2가지
			//vreply.parent().next().remove();
			vreply.parents('.card').find('.reply-body').remove();
			
			
			// 등록버튼(this=vreply)을 기준으로 card-body를 찾아서 reply-body를
			// 추가한다
			vreply.parents('.card').find('.card-body').append(rcode);
			
		},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : 'json'
		
	})
}

replyInsertServer = function(){
	$.ajax({
		url : `${mypath}/insertReply.do`,
		data : rdata,
		type : 'post',
		success : function(res){
			//alert(res.flag);
			if(res.flag=="성공"){
				//입력한 댓글을 출력
				replyListServer();
			}
		},
		error : function(xhr){
			alrert(xhr.status);
		},
		dataType : 'json'
		
	})	
	
	
}
updateHit = function(){
	$.ajax({
		url : `${mypath}/updateHit.do`,
		data : {"num" : vidx},
		type : 'post',
		success : function(res){
			//alert(res.flag);
			vhit = parseInt(vhit)+1;
			vparents.find('.hit').text(vhit);
			
		},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : 'json'
	})
}


boardDeleteServer = function(){
	$.ajax({
		url : `${mypath}/boardDelete.do`,
		data : {"num" : vidx},
		type : 'post',
		success : function(res){
			alert(res.flag);
			listPageServer(1);
		},
		error : function(xhr){
			alert(xhr.status)
		},
		dataType : 'json'
	})
	
}

boardUpdateServer = function(){
	//서버로 전송
	$.ajax({
		url : `${mypath}/boardUpdate.do`,
		data : udata,
		type : 'post',
		success : function(res){
			//성공했으면 udata로 본문의 내용을 바꾼다.
			alert(res.flag);
			
			//본문의 내용을 변경한다
			vparent.find('a').text(udata.subject)// 제목
			vparent.find('.wr').text(udata.writer)
			vparent.find('.ma').text(udata.mail)
			
			cont = udata.content;
			cont = cont.replace(/\n/g,"<br>");
			
			vparent.find('.p3').html(cont);
			listPageServer(1);
		},
		error : function(xhr){
			alert(xhr.status)
		},
		dataType : 'json'
	})
}



boardWriteServer = function(){
   //서버로 전송
   $.ajax({
	 url : `${mypath}/boardWrite.do`,
	 data : fdata,
	 type : 'post',
	 success : function(res){
		 alert(res.flag);
		 listPageServer(1);
	 },
	 error : function(xhr){
		 alert(xhr.status);
	 },
	 dataType : 'json'
   })
	
}



listPageServer = function(cpage){
   
   vtype = $('#stype option:selected').val().trim();
   vword = $('#sword').val().trim();
   $.ajax({
//       url:"/boardpro",
      url:`${mypath}/boardList.do`,
      data:{
         "page" : cpage,
         "stype" :vtype ,
         "sword" : vword
      },
      type:"post",
      success : function(res){
         
         code="";
         
         code+=`<div class="container mt-3">
           <h2>Accordion Example</h2>
           
           <div id="accordion">`
         $.each(res.datas, function(i,v){
			content = v.content;
			content = content.replace(/\n/g, "<br>");
            code +=`
            <div class="card">
                 <div class="card-header">
                 <a idx="${v.num}" class="btn" data-bs-toggle="collapse" href="#collapse${v.num}">
                    ${v.subject}
                 </a>
               </div>
               <div id="collapse${v.num}" class="collapse" data-bs-parent="#accordion">
                 <div class="card-body">
                   <div class="p12">
                      <p class="p1">
                      작성자 : <span class="wr">${v.writer}</span>&nbsp;&nbsp;&nbsp;&nbsp;  
                      이메일 : <span class="ma">${v.mail}</span> &nbsp;&nbsp;&nbsp;&nbsp; 
                      조회수 : <span class="hit"> ${v.hit}</span>&nbsp;&nbsp;&nbsp;&nbsp; 
                      날짜  : <span class="da">${v.wdate}</span>

                      </p>
                      <p class="p2">
                         <input type="button" idx="${v.num}" value="수정" name="modify" class="action">
                         <input type="button" idx="${v.num}" value="삭제" name="delete" class="action">
                      </p>
                   </div>
                   <p class="p3">
                    ${content}       
                   </p>
                   <p class="p4">
                      <textarea rows="" cols="50"></textarea>
                         <input type="button" idx="${v.num}" value="등록" name="reply" class="action">
                   </p>
                 </div>
               </div>
             </div>
            `;
         })//$.each
         code += `</div></div>`;
         
         $('#result').html(code);
         
         //페이지 처리
         pager ="";
         
         //이전
         pager+=`<ul class="pagination">`;
         if(res.sp >1){
            pager +=`<li class="page-item"><a id="prev" class="page-link" href="#">Previous</a></li>`;
         }
         //페이지번호
         for(i=res.sp; i<=res.ep;i++){
            if(i==currentPage){
               pager+=`<li class="page-item active"><a class="page-link pageno" href="#">${i}</a></li>`;
            }else{
               pager+=`<li class="page-item"><a class="page-link pageno" href="#">${i}</a></li>`;
               
            }
         }
         //다음
         if(res.ep<res.tp){
            pager+=`  <li class="page-item"><a id="next" class="page-link" href="#">Next</a></li>`;
         }
         pager+= `</ul>`;
         
         $('#pageList').html(pager);
         
      },//success
      error: function(xhr){
         alert("상태 : "+xhr.status);
      },
      dataType : 'json'
      
         
   })
   
}