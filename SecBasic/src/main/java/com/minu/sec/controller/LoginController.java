package com.minu.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
@Controller
public class LoginController {
	@GetMapping("/angma/mLogin")
	public String myLogin() {
		return "mLogin";
	}
	
	@GetMapping("/mLogin")
	public String mLogin() {
		return "mLogin";
	}
	
	@GetMapping("/angel/youLogin")
	public String youLogin() {
		return "yLogin";
	}

}
