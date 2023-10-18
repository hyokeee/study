package com.minu.sec.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.minu.sec.vo.MemberVO;

import lombok.Getter;

@Getter
public class CustomUser extends User {
	private static final long serialVersionUID = 1L;
	private MemberVO member;
	
	public CustomUser(String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	// 시큐리티가 주는 정보는 3개밖에 안돼서, 우리가 필요한걸 더 붙임(멤버필드/속성으로)
	// 필요할 때 마다 id를 select하는 것 보다 자주쓰는 걸 그냥 붙여놓고 씀
	//MemberVO(userid=jinsu1, userpw=$2a$10$nDtzHwFB3cSkioV8h3710.puuymt9xys/M35c/Fo6mkxcDjBJ1w6K, username=niceJinsu1, 
	//enabled=1, regdate=Thu Aug 31 09:26:03 KST 2023, authList=[AuthVO(userid=jinsu1, auth=ROLE_SUKIL)])
	public CustomUser(MemberVO vo) {
		super(vo.getUserid(), vo.getUserpw(), 
			vo.getAuthList().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
		this.member = vo;		
	}
}