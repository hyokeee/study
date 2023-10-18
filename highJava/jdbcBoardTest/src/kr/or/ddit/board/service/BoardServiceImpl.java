package kr.or.ddit.board.service;


import java.util.List;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {
	private IBoardDao dao;		//dao 객체가 저장될 변수 선언
	private static BoardServiceImpl service;
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}
	public static BoardServiceImpl getInstance() {
		if(service==null) service = new BoardServiceImpl();
		return service;
	}
	@Override
	public int insertBoard(BoardVO borVo) {
		
		return dao.insertBoard(borVo);
	}

	@Override
	public List<BoardVO> getAllBoard() {
		
		return dao.getAllBoard();
	}

	@Override
	public int updateBoard(int boardNo, String title, String content) {
		
		return dao.updateBoard(boardNo,title,content);
	}

	@Override
	public BoardVO getBoard(int boardNo) {
		
		return dao.getBoard(boardNo);
	}

	@Override
	public int deleteBoard(int boardNo) {

		return dao.deleteBoard(boardNo);
	}

	@Override
	public List<BoardVO> searchBoard(String searchTitle) {
		
		return dao.searchBoard(searchTitle);
	}
	
	@Override
	public int updateViewCount(int boardNo, int cnt) {
		
		return dao.updateViewCount(boardNo,cnt);
	}

}
