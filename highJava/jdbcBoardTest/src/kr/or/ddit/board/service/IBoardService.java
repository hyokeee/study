package kr.or.ddit.board.service;


import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

/**
 * 
 * @author PC-15
 *
 */
public interface IBoardService {
	
	/**
	 * BoardVO객체에 담겨진 자료를 DB에 insert하는 메서드
	 * @param borVo DB에 insert할 자료가 저장된 BoardVO객체
	 * @return 작업 성공 : 1 , 작업 실패 : 0
	 */
	public int insertBoard(BoardVO borVo);
	
	/**
	 * DB전체 게시판 정보를 가져와서 List에 담아서 반환하는 메서드
	 * @return BoardVO객체가 저장된 List객체
	 */
	public List<BoardVO> getAllBoard();
	
	/**
	 * 수정할 제목, text를 DB에 update하는 메서드
	 * @param boardNo 수정할 데이터의 boardNo
	 * @param title 수정할 제목
	 * @param content 내용
	 * @return 작업 성공 : 1, 작업 실패 : 0 
	 */
	public int updateBoard(int boardNo, String title, String content);
	
	
	/**
	 * 해당 boardNo에 일치하는 게시글 조회하는 메서드
	 * @param boardNo 조회할 board_no
	 * @return boardNo에 해당하는 BoardVO객체
	 */
	public BoardVO getBoard(int boardNo);
	
	/**
	 * BoardNo를 매개변수로 받아서 해당 게시글을 삭제하는 메서드
	 * @param boardNo 삭제할 BoardNo
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int deleteBoard(int boardNo);
	
	/**
	 * 제목을 검색하여 검색한 내용을 포함하는 게시글들을 조회하는 메서드
	 * @param searchTitle 검색할 제목
	 * @return BoardVo가 저장된 객체
	 */
	public List<BoardVO> searchBoard(String searchTitle);
	
	
	
	/**
	 * BoardNo를 매개변수로 받아서 해당 게시글의 조회수를 +1 하는 메서드
	 * @param boardNo update할  boardNo
	 * @param cnt 조회수
	 * @return
	 */
	public int updateViewCount(int boardNo,int cnt);
}
