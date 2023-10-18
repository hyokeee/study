package kr.or.ddit.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemVO {
	private String userId     ;
	private String password   ;
	private int    coin       ;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date   dateOfBirth;
	private String gender     ;
	private String nationality;
	private String developer  ;
	private boolean foreigner  ;
	//주소
	//중첩된 자바빈
	//MemVO : AddrVO = 1 : 1
	private AddrVO addrVO;
}
