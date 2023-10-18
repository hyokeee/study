package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZiptbVO;

public interface IMemberService {
	public String checkMemberId(String memId);
	
	public int insertMember(MemberVO memVo);
	
	public List<ZiptbVO> getZipCode(String dong);
}
