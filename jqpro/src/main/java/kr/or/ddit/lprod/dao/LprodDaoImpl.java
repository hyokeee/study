package kr.or.ddit.lprod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.lprod.vo.LprodVO;
import kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory;

public class LprodDaoImpl implements ILprodDao{
	private static ILprodDao dao;
	public static ILprodDao getInstance() {
		if(dao==null) dao = new LprodDaoImpl();
		
		return dao;
	}
	@Override
	public List<LprodVO> getAllLprod() {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		List<LprodVO> lprodList = null;
		try {
			lprodList = sqlSession.selectList("lprod.getAllLprod");
		} finally {
			if(sqlSession!=null) sqlSession.close();
		}
		return lprodList;
	}

}
