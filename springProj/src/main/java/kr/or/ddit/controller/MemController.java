package kr.or.ddit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.service.MemService;
import kr.or.ddit.vo.MemVO;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/mem")
@Slf4j
@Controller
public class MemController {
	@Autowired
	MemService memService;
	
	@GetMapping("/addMem")
	public String addMem() {
		return "mem/addMem";
	}
	
	@ResponseBody
	@PostMapping("/addMem01")
	public String addMem01(MemVO memVO) {
		log.info("memVO : " + memVO);
		int cnt = this.memService.addMem(memVO);
		if(cnt>0) {
			return "SUCCESS";
		}else {
			return "FAIL";
		}
	}
}
