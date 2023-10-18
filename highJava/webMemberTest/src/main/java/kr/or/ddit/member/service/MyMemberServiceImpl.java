package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMyMemberDao;
import kr.or.ddit.member.dao.MyMemberDaoImpl;
import kr.or.ddit.member.vo.MyMemberVO;

public class MyMemberServiceImpl implements IMyMemberService{
	private static IMyMemberService service;
	private IMyMemberDao dao;
	private MyMemberServiceImpl() {
		 dao = MyMemberDaoImpl.getInstance();
	}
	public static IMyMemberService getInstance() {
		if(service == null) service = new MyMemberServiceImpl();
		return service;
	}
	
	@Override
	public List<MyMemberVO> getMyMemberList() {	
		return dao.getMyMemberList();
	}

	@Override
	public int insertMyMember(MyMemberVO myMemVo) {
		return dao.insertMyMember(myMemVo);
	}

	@Override
	public int isExistID(String mem_id) {
		return dao.isExistID(mem_id);
	}

	@Override
	public MyMemberVO getMyMember(String mem_id) {
		return dao.getMyMember(mem_id);
	}

	@Override
	public int updateMyMember(MyMemberVO myMemVo) {
		return dao.updateMyMember(myMemVo);
	}

	@Override
	public int deleteMyMember(String mem_id) {
		return dao.deleteMyMember(mem_id);
	}

}
