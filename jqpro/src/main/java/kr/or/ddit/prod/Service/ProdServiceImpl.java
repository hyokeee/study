package kr.or.ddit.prod.Service;

import java.util.List;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdServiceImpl implements IProdService{
	private static IProdService service;
	private IProdDao dao;
	private ProdServiceImpl() {
		dao = ProdDaoImpl.getInstance();
	}
	
	public static IProdService getInstance() {
		if(service == null) service = new ProdServiceImpl();
		
		return service;
	}
	
	@Override
	public List<ProdVO> getProdsByLprodGu(String lprod_gu) {
		return dao.getProdsByLprodGu(lprod_gu);
	}

	@Override
	public ProdVO getProdByProdId(String prod_id) {
		return dao.getProdByProdId(prod_id);
	}

}
