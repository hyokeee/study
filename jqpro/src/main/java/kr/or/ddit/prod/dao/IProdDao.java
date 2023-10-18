package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.prod.vo.ProdVO;

public interface IProdDao {
	
	public List<ProdVO> getProdsByLprodGu(String lprod_gu);
	
	public ProdVO getProdByProdId(String prod_id);
}
