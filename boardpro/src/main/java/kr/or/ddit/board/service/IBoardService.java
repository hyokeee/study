package kr.or.ddit.board.service;


import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardService {
	// 페이지별 리스트 가져오기
	/**
	 * 
	 * @param map 'key값들' => stype(선택) : subject/writer/content 중 택
	 *                        sword(선택) : 검색 내용
	 *                        end(필수) : 끝 rows
	 *                        start(필수) : 시작 rows
	 * @return
	 */
	public List<BoardVO> listPerPage(Map<String, Object> map);
	
	
	// 전체 글 갯수 가져오기
	public int totalCount(Map<String, Object> map);
	
	// 조회수 증가하기
	public int updateHit(int hit);
	// 글쓰기 - 저장하기
	public int insertBoard(BoardVO bvo);
	// 글 수정하기
	public int updateBoard(BoardVO bvo);
	// 페이지 정보 얻기 - 시작번호 , 끝번호, 시작페이지번호, 끝페이지번호, 총 페이지 갯수
	public PageVO pageInfo(int page, String stype, String sword);
	
	// 글 삭제하기
	public int deleteBoard(int num);
	
	//----------------------------------------------------------
	
	// 댓글 쓰기 - 저장
	public int insertReply(ReplyVO rvo);
	// 댓글 수정
	public int updateReply(ReplyVO rvo);
	// 댓글 삭제
	public int deleteReply(int renum);
	// 댓글 리스트
	public List<ReplyVO> listReply(int bonum);
}
