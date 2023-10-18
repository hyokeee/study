package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdDaoImpl implements IProdDao{
	private static IProdDao dao;
	
	public static IProdDao getInstance() {
		if(dao ==null) dao = new ProdDaoImpl();
		return dao;
	}
	@Override
	public List<ProdVO> getProdsByLprodGu(String lprod_gu) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		List<ProdVO> pList = null;
		try {
			pList = sqlSession.selectList("prod.getProdsByLprodGu",lprod_gu);
		} finally {
			if(sqlSession!=null) sqlSession.close();
		}
		return pList;
	}

	@Override
	public ProdVO getProdByProdId(String prod_id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		ProdVO prodVo = null;
		try {
			prodVo = sqlSession.selectOne("prod.getProdByProdId",prod_id);
		} finally {
			if(sqlSession!=null) sqlSession.close();
		}
		return prodVo;
	}

}
