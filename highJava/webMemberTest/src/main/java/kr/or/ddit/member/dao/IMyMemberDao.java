package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.member.vo.MyMemberVO;

public interface IMyMemberDao {
	/**
	 * 전체 회원 목록을 출력하는 메서드
	 * @return 회원 목록을 MyMemberVO객체에 담아 List로 반환한다
	 */
	public List<MyMemberVO> getMyMemberList();
	
	/**
	 * 회원 목록을 추가하는 메서드
	 * @param myMemVo 추가할 회원의 정보를 MyMemberVO 객체에 담아 파라미터로 사용
	 * @return 추가 성공 : 1, 추가 실패 : 0
	 */
	public int insertMyMember(MyMemberVO myMemVo);
	
	
	/**
	 * 회원 id 중복 여부를 확인하는 메서드
	 * @param mem_id 중복 여부를 확인할 회원 ID
	 * @return 중복 : 1, 중복 아닐 경우 : 0 반환
	 */
	public int isExistID(String mem_id);
	
	
	/**
	 * 해당 회원의 상세 정보를 출력하는 메서드
	 * @param mem_id 상세 정보를 출력할 회원의 ID
	 * @return 회원의 정보가 담긴 MyMemberVO 객체
	 */
	public MyMemberVO getMyMember(String mem_id);
	
	/** 
	 * 회원의 정보를 수정하는 메서드
	 * @param  myMemVo : 수정할 회원의 정보를 담은 MyMemberVO 객체	
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int updateMyMember(MyMemberVO myMemVo);
	
	/**
	 * 회원의 정보를 삭제하는 메서드
	 * @param mem_id 삭제할 회원의 ID
	 * @return 작업 성공 :1, 작업 실패 : 0
	 */
	public int deleteMyMember(String mem_id);
}
