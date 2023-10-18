package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory;

public class BoardDaoImpl implements IBoardDao{
	private static IBoardDao dao;
	private BoardDaoImpl() {}
	public static IBoardDao getInstance() {
		if(dao == null) dao = new BoardDaoImpl();
		return dao;
	}
	@Override
	public List<BoardVO> listPerPage(Map<String, Object> map) {
		// 1. 리턴 변수 선언
		List<BoardVO> bList = null;
		
		// 2. list mapper 실행
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisSqlSessionFactory.getSqlSession();
			bList = sqlSession.selectList("board.listPerPage",map);
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		// 3. 결과 리턴
		return bList;
	}

	@Override
	public int totalCount(Map<String, Object> map) {
		int cnt = 0;
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisSqlSessionFactory.getSqlSession();
			cnt = sqlSession.selectOne("board.totalCount",map);
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return cnt;
	}
	@Override
	public int insertBoard(BoardVO bvo) {
		int cnt = 0;
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisSqlSessionFactory.getSqlSession();
			cnt = sqlSession.insert("board.insertBoard",bvo);
		} finally {
			sqlSession.commit();
			if(sqlSession != null) sqlSession.close();
		}
		return cnt;
	}
	@Override
	public int updateBoard(BoardVO bvo) {
		int cnt = 0;
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisSqlSessionFactory.getSqlSession();
			cnt = sqlSession.update("board.updateBoard",bvo);
		} finally {
			sqlSession.commit();
			if(sqlSession !=null)sqlSession.close();
		}
		return cnt;
	}
	@Override
	public int deleteBoard(int num) {
		int cnt = 0;
		SqlSession sqlSession =null;
		try {
			sqlSession = MyBatisSqlSessionFactory.getSqlSession();
			cnt = sqlSession.delete("board.deleteBoard",num);
		} finally {
			sqlSession.commit();
			if(sqlSession !=null)sqlSession.close();
		}
		return cnt;
	}
	@Override
	public int updateHit(int hit) {
		int cnt = 0;
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisSqlSessionFactory.getSqlSession();
			cnt = sqlSession.update("board.updateHit",hit);				
		} finally {
			sqlSession.commit();
			if(sqlSession !=null)sqlSession.close();
		}
		return cnt;
	}
	@Override
	public int insertReply(ReplyVO rvo) {
		int cnt = 0;
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisSqlSessionFactory.getSqlSession();
			cnt = sqlSession.insert("reply.insertReply",rvo);
		} finally {
			sqlSession.commit();
			if(sqlSession !=null)sqlSession.close();
		}
		return cnt;
	}
	@Override
	public int updateReply(ReplyVO rvo) {
		int cnt = 0;
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisSqlSessionFactory.getSqlSession();
			cnt = sqlSession.update("reply.updateReply",rvo);
		} finally {
			sqlSession.commit();
			if(sqlSession !=null)sqlSession.close();
		}
		return cnt;
	}
	@Override
	public int deleteReply(int renum) {
		int cnt = 0;
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisSqlSessionFactory.getSqlSession();
			cnt = sqlSession.delete("reply.deleteReply",renum);
		} finally {
			sqlSession.commit();
			if(sqlSession !=null)sqlSession.close();
		}
		return cnt;
	}
	@Override
	public List<ReplyVO> listReply(int bonum) {
		List<ReplyVO> rList = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisSqlSessionFactory.getSqlSession();
			rList = sqlSession.selectList("reply.listReply",bonum);
		} finally {
			if(sqlSession !=null)sqlSession.close();
		}
		return rList;
	}

}
