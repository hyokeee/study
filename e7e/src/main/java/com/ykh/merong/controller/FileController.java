package com.ykh.merong.controller;

import java.io.File;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ykh.merong.vo.Chahyun;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FileController {

	
	
	@PostMapping(value="/mFile",produces="application/json;charset=utf-8")
	@ResponseBody	// AJAX 요청에 응답
	public String getFile(Chahyun chahyun) throws Exception {
		log.debug(chahyun.getSujiFile().getOriginalFilename());
		log.debug(""+chahyun.getSujiFile().getSize());
		log.debug(chahyun.getGoodWords());
		log.debug(chahyun.getBadWords());
		
		String destPath = "d:/uploads/"+chahyun.getSujiFile().getOriginalFilename();
		chahyun.getSujiFile().transferTo(new File(destPath));
		
		return "/merong/myfiles/"+chahyun.getSujiFile().getOriginalFilename();
	}
	
	/*
	@PostMapping(value="/mFile",produces="application/json;charset=utf-8")
	@ResponseBody	// AJAX 요청에 응답
	public String getFile(MultipartFile sujiFile, MultipartHttpServletRequest msr) throws Exception {
		log.debug(sujiFile.getOriginalFilename());
		log.debug(""+sujiFile.getSize());
		log.debug(msr.getParameter("goodWords"));
		log.debug(msr.getParameter("badWords"));
		log.debug(msr.getParameter("sujiFile"));
		
		String chahyun = "d:/uploads/"+sujiFile.getOriginalFilename();
		sujiFile.transferTo(new File(chahyun));
		
		return "/merong/myfiles/"+sujiFile.getOriginalFilename();
	}
	*/
}