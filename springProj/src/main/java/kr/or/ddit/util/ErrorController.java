package kr.or.ddit.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/error")
@Controller
public class ErrorController {

	//요청 URI : error/error400
	@GetMapping("/error400")
	public String error400() {
		//fowarding
		return "error/error400";
	}
	
	//요청 URI : error/error404
	@GetMapping("/error404")
	public String error404() {
		//fowarding
		return "error/error404";
	}
	
	//요청 URI : error/error500
	@GetMapping("/error500")
	public String error500() {
		//fowarding
		return "error/error500";
	}
	
	//요청URI : /error/errorDefault
	@GetMapping("/errorDefault")
	public String errorDefault() {
		//fowarding
		return "error/errorDefault";
	}
	
	//요청URI : /error/errorException
	@GetMapping("/errorException")
	public String errorException() {
		//fowarding
		return "error/errorException";
	}
}
