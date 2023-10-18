package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZiptbVO;
import kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory;

public class MemberDaoImpl implements IMemberDao{
	private static IMemberDao dao;
	
	public static IMemberDao getInstance() {
		if(dao==null) dao = new MemberDaoImpl();
		return dao;
	}
	
	@Override
	public String checkMemberId(String memId) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		String checkId = null;
		try {
			checkId = sqlSession.selectOne("member.checkMemberId",memId);
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return checkId;
	}

	@Override
	public int insertMember(MemberVO memVo) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		int cnt;
		try {
			cnt = sqlSession.insert("member.insertMember",memVo);
			if(cnt>0) sqlSession.commit();
	
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return cnt;
	}

	@Override
	public List<ZiptbVO> getZipCode(String dong) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		List<ZiptbVO> zipList = null;
		try {
			zipList = sqlSession.selectList("member.getZipCode",dong);
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return zipList;
	}

}
