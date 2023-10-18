package kr.or.ddit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.service.Bookservice;
import kr.or.ddit.vo.BookInfoVO;
import kr.or.ddit.vo.BookVO;
import lombok.extern.slf4j.Slf4j;

//스프링이 이 클래스를 자바빈으로 등록하여 관리함
@RequestMapping("/board")
@Slf4j
@Controller
public class BoardController {
	/*
	 1. 요청 경로 매핑
	 - 요청 경로는 필수
	 - 속성이 하나일 때 속성명 생략 가능
	 - 클래스레벨 요청경로는 기본 경로로 취급
	 - 클래스레벨 요청경로(/board) + 메서드레벨 요청경로(/register) => 최종요청경로(/board/register)
	 */
	/*
	 method 생략 : get방식
	 리턴 타입이 void : return "board/register";
	 				board폴더에 register.jsp를 forwarding
	 */
	//value속성에 요청 경로를 설정
	@RequestMapping(value="/register")
	public void registerForm() {
		log.info("registerForm");
	}
	
	@RequestMapping(value="/modify")
	public void modifyForm() {
		log.info("modifyForm");
		
		//board 폴더의 modify.jsp가 forwarding
	}
	/* 2. 경로 패턴 매핑
	 	- 요청 경로를 동적으로 표현 가능
	 	- 경로 변수(path variable)에 해당하는 값을 파라미터 변수에 설정
	 */
	// 요청 URI : /board/read/12 요청을 처리해보자
	// board테이블의 12번 글
	// boardNo : 경로(path) 변수 (variable)
	// 1) /board/read?boardNo=12
	//		==> 골뱅이RequestParam("boardNo") int boardNo
	// 2) /board/read/12
	//		==> 골뱅이PathVariable("boardNo") int boardNo
	@RequestMapping(value="/read/{boardNo}")
	public String readForm(@PathVariable("boardNo") int boardNo) {
		//readForm->boardNo : 12
		log.info("readForm->boardNo : " + boardNo);
		
		//board폴더의 read.jsp를 forwarding
		return "board/read";
	}
	
	// 요청URI : /board/update/27
	// 경로변수명 : boardNo
	// board폴더의 update.jsp를 forwarding 해보자
	@RequestMapping(value="/update/{boardNo}")
	public String updateForm(@PathVariable("boardNo") int boardNo) {
		log.info("updateForm->boardNo : " + boardNo);
		return "board/update";
	}
	/*
	 4. Params 매핑
	   - 요청 파라미터를 매핑 조건으로 지정하는 경우 params 속성을 사용
	   - <button>, <a href..에 따라 호출할 메서드를 바꿔야 할 때 사용함
	 */
	// 요청URI : /board/get?register
	// 요청방식 : get
	// 요청파라미터 : register
	@RequestMapping(value="/get",method=RequestMethod.GET,params = "register")
	public String register() {
		log.info("register");

		//forwarding
		return "board/register";
	}
	
	/*
	 	요청URI : /board/post
		요청방식 : post
		요청파마리터 : register
	 */
	@RequestMapping(value="/post",method=RequestMethod.POST,params="register")
	public String registerPost(String bookId) {
		log.info("registerPost");
		log.info("bookId : " + bookId);
		//forwarding
		return "board/register";
	}
	
	/*
	 	요청URI : /board/post
		요청방식 : post
		요청파마리터 : {"update", "bookId" : "ISBN1234"}
	 */
	@RequestMapping(value="/post",method=RequestMethod.POST,params="update")
	public String updatePost(String bookId) {
		log.info("updatePost");
		log.info("bookId : " + bookId);
		//forwarding
		return "board/register";
	}
	
	/*
	 	요청URI : /board/post
		요청방식 : post
		요청파마리터 : {"delete", "bookId" : "ISBN1234"}
	 */
	@RequestMapping(value="/post",method=RequestMethod.POST,params="delete")
	public String deletePost(String bookId) {
		log.info("deletePost");
		log.info("bookId : " + bookId);
		//forwarding
		return "board/register";
	}
	
	/*
	 	요청URI : /board/post
		요청방식 : post
		요청파마리터 : {"list","bookId" : "ISBN1234"}
	 */
	@RequestMapping(value="/post",method=RequestMethod.POST,params="list")
	public String listPost(String bookId) {
		log.info("listPost");
		log.info("bookId : " + bookId);
		//forwarding
		return "board/register";
	}
	
	/*
	 요청URI : /board/get?remove
	 요청방식 : get
	 요청파라미터 : {"remove"}
	 forwarding : board/register
	 */
	@RequestMapping(value="/get",method=RequestMethod.GET,params = "remove")
	public String getRemove(String bookId) {
		log.info("getRemove");

		//forwarding
		return "board/register";
	}
	
	/*
	 요청URI : /board/post?remove
	 요청방식 : post
	 요청파라미터 : {"remove"}
	 forwarding : board/register
	 */
	
	@RequestMapping(value="/post",method=RequestMethod.POST,params = "remove")
	public String postRemove(String bookId) {
		log.info("postRemove");

		//forwarding
		return "board/register";
	}
	/*
	 요청URI : /board/get?read
	 요청방식 : get
	 요청파라미터 : {"read"}
	 forwarding : board/register
	 */
	@RequestMapping(value="/get",method=RequestMethod.GET,params = "read")
	public String getRead(String bookId) {
		log.info("getRead");

		//forwarding
		return "board/register";
	}
	
	 /*
    5. Headers 매핑
    HttpEntity클래스를 상속받아 구현한 클래스 : RequdstEntity, ResponseEntity.
    
    
    요청URI : /board/10
   PathVariable : boardNo
   요청방식 : post
   
   2)
   도서 상세 정보(/detail?bookId=1)
   요청URI : /board/9
   PathVariable : boardNo -> bookId로 처리 예정
   요청방식 : get
   dataType(응답타입) : JSON
   
     consumes : JSON string으로 들어올 때(client -> server)(생략가능)
    produces : JSON string으로 나갈때(server -> client)(생략가능)

    */
	
	@Autowired
	Bookservice bookservice;
	
   @RequestMapping(value="/{bookId}",method=RequestMethod.GET,produces="application/json")
   public ResponseEntity<BookVO> modifyPost(@PathVariable("bookId") int bookId,
         BookVO bookVO){
      log.info("modifyPost");
      
      //bookVO{bookId=1,...}
      bookVO.setBookId(bookId);
      
      bookVO = this.bookservice.detail(bookVO);
      //bookVO{bookId-1, title=검은태양...}
      log.info("bookVO : "+bookVO);
      ResponseEntity<BookVO> entity 
         = new ResponseEntity<BookVO>(bookVO,HttpStatus.OK);
      
      return entity;
      
   }
	
	//요청 URI : /board/detail/ISBN1234
	//pathVariable : bookId
	//data : bookId, name, unitPrice, author, totalPages
	//JSON 데이터를 받으며녀 골뱅이 RuquestBody
	//요청방식 : post
	//응답데이터 : SUCCESS
	@RequestMapping(value="/detail/{bookId}",method=RequestMethod.POST,consumes="application/json")
	public ResponseEntity<String> detailJSONPost(@PathVariable("bookId") String bookId, @RequestBody BookInfoVO bookInfoVO){
		log.info("detailJSONPost");
		log.info("bookId : "+ bookId);
		log.info("bookInfoVO : "+ bookInfoVO);
		ResponseEntity<String> entity 
			= new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		
		return entity;
	}
	@Autowired
	Bookservice service;
	
	@RequestMapping(value="/book",method=RequestMethod.POST,consumes="application/json")
	public ResponseEntity<String> insertBookPost(@RequestBody BookVO bookVO){
		log.info("insertBookPost");
		log.info("bookVO : " + bookVO );
		int result = service.insert(bookVO);
		log.info("bookInsert->result:"+result);
		
		ResponseEntity<String> entity
			= new ResponseEntity<String>(bookVO.getBookId()+"",HttpStatus.OK);
		return entity;
	}
}
