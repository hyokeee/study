package com.minu.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GridController {
	@GetMapping("/grid")
	public String getGrid() {
		return "grid";
	}
}
