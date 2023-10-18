package kr.or.ddit.buyer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory;

public class BuyerDaoImpl implements IBuyerDao{
	private static IBuyerDao dao;
	
	//자기 자신의 객체를 생성하고 리턴
	public static IBuyerDao getInstance() {
		if(dao==null) dao = new BuyerDaoImpl();
		
		return dao;
	}
	
	private BuyerDaoImpl() { }
	//SqlSession 이 필요
	
	@Override
	public List<BuyerVO> getAllBuyer() {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		List<BuyerVO> bList = null;
		try {
			bList = sqlSession.selectList("buyer.getAllBuyer");
		} finally {
			if(sqlSession!=null) sqlSession.close();
		}
		return bList;
	}

	@Override
	public BuyerVO selectBuyer(String buyerId) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		BuyerVO buyerVo = null;
		try {
			buyerVo = sqlSession.selectOne("buyer.selectBuyer",buyerId);
		} finally {
			if(sqlSession!=null) sqlSession.close();
		}
		return buyerVo;
	}
}
