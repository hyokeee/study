package com.minu.sec.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
@Slf4j
//@Controller
@RequestMapping(value="/angma",produces="text/plain;charset=UTF-8")
public class SecController {

	@GetMapping("/minu")
	public String minu(Authentication auth) {
		// 시큐리티 뽀이토 !
		SecurityContext secCont = SecurityContextHolder.getContext();
		
		log.debug("check:" + secCont);
		log.debug("auth : " + auth);
//		log.debug("getName : " + auth.getName());
//		log.debug("getAuthorities : " + auth.getAuthorities());
//		log.debug("getPrincipal : " + auth.getPrincipal());
//		log.debug("getPassword : " + ((User)auth.getPrincipal()).getPassword());
//		log.debug("getUsername : " + ((User)auth.getPrincipal()).getUsername());
		return "minu";
	}
	
	@GetMapping("/hyunhak")
	public String hyunhak() {
		return "hyunhak";
	}
	
	@PostMapping("/seoju")
	@ResponseBody
	public String seoju(@RequestBody String mName) {
		return mName + " 거기 서주세요!";
	}
	
	
}
