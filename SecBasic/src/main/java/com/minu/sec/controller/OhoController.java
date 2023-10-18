package com.minu.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oho")
public class OhoController {
	
	@GetMapping("/sukil")
	public String getSukll() {
		return "home";
	}
	
	@GetMapping("/suji")
	public String getSuji() {
		return "sectag";
	}
	

	

}
