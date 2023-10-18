package com.ykh.merong.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ykh.merong.vo.TestVO;

import lombok.extern.slf4j.Slf4j;

//@Controller + @ResponseBody ==> @RestController 자동으로 ResponseBody가 붙여진 상태가 된다.
//@RestController
@Slf4j
@Controller
@RequestMapping(value="/silver")
public class SilverRainController {
/*
	//@RequestMapping(value="/rain/,method=Requestmethod.GET)
	@GetMapping("/rain")
	//@ResponseBody
	//ResponseBody 를 해주면 return "SilverRain" 하면 바로 화면에 출력해주지만,
	//어노테이션을 사용하지 않으면 response 객체를 이용해 write 메서드를 이용해야한다.
	public void getRain(HttpServletResponse resp) throws Exception{
		resp.getWriter().write("SilverRain");
		//return "SilverRain";
	}
*/
	@GetMapping("/test")
	public String getTest() {
		return "test";
	}
	
	
	@GetMapping("/rain/{name}")
	@ResponseBody
	public String getRain(@PathVariable String name){
		System.out.println("체크 : " + name);
		return name;
	}
	
	@PostMapping(value="/rain",produces = "application/json;charset=utf-8")
	@ResponseBody
	public List<String> postRain(@RequestBody List<String> myList) {
		//return "{\"name\":\"KGB\"}";	//{"name" : "KGB"}
		/*
		List<String> myList = new ArrayList<String>();
		for(int i=0; i<10; i++) {
			myList.add("Hello" + i);
		}
		
		return myList;
		*/
		log.debug(myList.toString());
		
		return myList;
	}
	
	@PutMapping(value="/rain",produces = "application/json;charset=utf-8")
	@ResponseBody
	public Map<String, String> putRain() {
		Map<String, String> myMap = new HashMap<String, String>();
		myMap.put("name", "메롱");
		myMap.put("age", "19");
		return myMap;
	}
	
	@DeleteMapping("/rain")
	@ResponseBody
	public TestVO deleteRain(@RequestBody TestVO testVO) {
		//System.out.println(myMap.get("name"));
		//System.out.println(myMap.get("age"));
		//System.out.println(myMap.get("alias"));
		//return myMap;
		log.debug(testVO+"");
		
		return testVO;
	}
}
