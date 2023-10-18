package kr.or.ddit.prod.Service;

import java.util.List;

import kr.or.ddit.prod.vo.ProdVO;

public interface IProdService {
	
	public List<ProdVO> getProdsByLprodGu(String lprod_gu);
	
	public ProdVO getProdByProdId(String prod_id);
}
