package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZiptbVO;

public class MemberServiceImpl implements IMemberService{
	private static IMemberService service;
	private IMemberDao dao;
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	public static IMemberService getInstance() {
		if(service==null) service = new MemberServiceImpl();
		return service;
	}
	@Override
	public String checkMemberId(String memId) {
		
		return dao.checkMemberId(memId);
	}

	@Override
	public int insertMember(MemberVO memVo) {
		
		return dao.insertMember(memVo);
	}
	@Override
	public List<ZiptbVO> getZipCode(String dong) {
		
		return dao.getZipCode(dong);
	}

}
