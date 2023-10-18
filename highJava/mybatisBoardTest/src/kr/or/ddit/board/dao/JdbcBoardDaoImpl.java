package kr.or.ddit.board.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.vo.JdbcBoardVO;
import kr.or.ddit.util.MyBatisSqlSessionFactory;

public class JdbcBoardDaoImpl implements IJdbcBoardDao{
	private static JdbcBoardDaoImpl dao;
	
	private JdbcBoardDaoImpl() {}
	
	public static JdbcBoardDaoImpl getInstance() {
		if(dao==null) dao = new JdbcBoardDaoImpl();
		return dao;
	}
	//사용할 session객체
	public SqlSession session = null;
	
	@Override
	public int insertBoard(JdbcBoardVO boardVo) {
		int cnt = 0;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			cnt = session.insert("board.insertBoard",boardVo);
			if(cnt>0) session.commit();
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
	}

	@Override
	public int deleteBoard(int boardNo) {
		int cnt = 0;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			cnt = session.delete("board.deleteBoard",boardNo);
			if(cnt>0) session.commit();
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
	}

	@Override
	public int updateBoard(JdbcBoardVO boardVo) {
		int cnt = 0;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			cnt = session.update("board.updateBoard",boardVo);
			if(cnt>0) session.commit();
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
	}

	@Override
	public JdbcBoardVO getBoard(int boardNo) {
		JdbcBoardVO boardVo = null;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			boardVo = session.selectOne("board.getBoard",boardNo);
		} finally {
			if(session!=null) session.close();
		}
		
		return boardVo;
	}

	@Override
	public List<JdbcBoardVO> getAllBoard() {
		List<JdbcBoardVO> boardList = null;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			boardList = session.selectList("board.getAllBoard");
		} finally {
			if(session!=null) session.close();
		}
		
		return boardList;
		
	}

	@Override
	public List<JdbcBoardVO> getSearchBoard(String title) {
		List<JdbcBoardVO> boardList = null;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			boardList = session.selectList("board.getSearchBoard",title);
		} finally {
			if(session!=null) session.close();
		}
		
		return boardList;
	}

	@Override
	public int setCountIncrement(int boardNo) {
		int cnt = 0;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			cnt = session.update("board.setCountIncrement", boardNo);
			if(cnt>0) session.commit();
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
	}
}
