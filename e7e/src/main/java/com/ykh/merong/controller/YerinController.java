package com.ykh.merong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.ykh.merong.mapper.YerinMapper;
import com.ykh.merong.service.Yerin;
import com.ykh.merong.vo.YerinVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/rest")
public class YerinController {

//	@Autowired
	private YerinMapper yerinSVC;
	
	
	@GetMapping("/index")
	public String getView() {
		return "yerin";
	}
	
	@GetMapping("/test")
	public String getTest() {
		return "548";
	}
	//RESTFUL방식을 적용하면 기본 5가지(get(리스트,1개),post,put,delete)
	//리스트 조회
	@ResponseBody
	@GetMapping(value="/yerins",produces = "application/json;charset=utf-8")
	public List<YerinVO> getYerins() {
		log.info("체킁" + yerinSVC);
		return yerinSVC.listData();
	}
	
	//1개 조회
	@ResponseBody
	@GetMapping(value="/yerin/{title}",produces = "application/json;charset=utf-8")
	public YerinVO getYerin(@PathVariable String title) {
		YerinVO yerinVO = new YerinVO();
		yerinVO.setTitle(title);
		
		return yerinSVC.oneData(yerinVO);
	}
	
	//1개 insert
	@ResponseBody
	@PostMapping(value="/yerin",produces = "application/json;charset=utf-8")
	public String postYerin(@RequestBody YerinVO yerinVO) {
		return Integer.toString(yerinSVC.insertData(yerinVO));
	}
	
	//1개 update
	@ResponseBody
	@PutMapping(value="/yerin",produces = "application/json;charset=utf-8")
	public String putYerin(@RequestBody YerinVO yerinVO) {
		return Integer.toString(yerinSVC.updateData(yerinVO));
	}
	
	//1개 delete
	@ResponseBody
	@DeleteMapping(value="/yerin/{title}",produces = "application/json;charset=utf-8")
	public String deleteYerin(@PathVariable String title) {
		YerinVO yerinVO = new YerinVO();
		yerinVO.setTitle(title);
		
		return Integer.toString(yerinSVC.deleteData(yerinVO));
	}
	
   // 컨트롤러마다 일일이 별도 예외처리를 하면 넘 힘들다!
   // NullPointerException 핸들링
   @ExceptionHandler(NullPointerException.class)
   @ResponseBody
   public String nullHandle(NullPointerException e) {
	  log.info("에렁" + e.getMessage());
      return "are you null " + e.getMessage();
   }
   
   // NullPointerException 핸들링
   @ExceptionHandler(NoHandlerFoundException.class)
   @ResponseBody
   public String notFoundHandle(NoHandlerFoundException e) {
      return e.getMessage();
   }
}

