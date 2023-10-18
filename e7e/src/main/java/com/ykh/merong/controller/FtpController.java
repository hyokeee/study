package com.ykh.merong.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ykh.merong.utils.FtpUtils;

@Controller
@RequestMapping("/ftp")
public class FtpController {
	
	@Autowired
	private FtpUtils ftpUtils;
	
	@GetMapping("/main")
	public String main() {
		return "ftpmain";
	}
	
	@GetMapping("/download/{fname}")
	public void down(@PathVariable String fname,  HttpServletResponse resp) throws IOException {
		ftpUtils.downlod("ㅋㅋ.jpg",resp);
	}
	
	@PostMapping("/upTest")
	@ResponseBody  // 그냥 jsp 안 만들라고
	public String upTest(MultipartFile myFile) throws IOException {
		ftpUtils.upload(myFile);
		return "OK";
	}
}
