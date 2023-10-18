package kr.or.ddit.lprod.dao;

import java.util.List;

import kr.or.ddit.lprod.vo.LprodVO;

public interface ILprodDao {

	
	/**
	 * 전체 LprodList 출력
	 * @return
	 */
	public List<LprodVO> getAllLprod(); 
}
