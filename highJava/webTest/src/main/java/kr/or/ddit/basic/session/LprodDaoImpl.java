package kr.or.ddit.basic.session;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MyBatisSqlSessionFactory;
import kr.or.ddit.vo.LprodVO;

public class LprodDaoImpl {
	public static LprodDaoImpl dao;
	
	private LprodDaoImpl() {
		
	}
	
	public static LprodDaoImpl getInstance() {
		if(dao == null) dao = new LprodDaoImpl();
		return dao;
	}
	
	public List<LprodVO> getAllLprod() {
		List<LprodVO> lList = null;
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			lList = session.selectList("lprod.getAllLprod");
		} finally {
			if(session!=null) session.close();
		}
		return lList;
		
	}
}
