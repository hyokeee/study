package kr.or.ddit.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;
@Data
public class Member2VO {
	private int    userNo   ;
	private String userId   ;
	private String userName ;
	private int    coin     ;
	private Date   regDate  ;
	private Date   updDate  ;
	private String enabled  ;
	private String userPw   ;
	
	//중첩된 자바빈즈
	//Member2VO : MemberAuthVO = 1 : N
	private List<MemberAuthVO> memberAuthVOList;
}
