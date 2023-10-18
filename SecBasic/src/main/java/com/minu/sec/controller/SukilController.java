package com.minu.sec.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class SukilController {
	@GetMapping("/slogin")
//	@PreAuthorize("hasRole('ROLE_SUKIL')")
	public String sukilLogn() {
		return "slogin"; // id, 암호 입력 페이지
	}
}
