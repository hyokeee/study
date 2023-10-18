package com.minu.sec.security;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res,
			Authentication auth) throws IOException, ServletException {
		log.info("auth success");
		
		/* 권한(Authorities 가져오기)
		 Iterator<? extends GrantedAuthority> authIter= auth.getAuthorities().iterator();
		 
		 while(authIter.hasNext()) {
			 System.out.println(authIter.next());
		 }
		 */
		
		//특정 URL로 보내기
		 res.sendRedirect("/sec/oho/suji");
	}

}