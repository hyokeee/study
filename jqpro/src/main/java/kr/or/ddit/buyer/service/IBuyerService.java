package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.buyer.vo.BuyerVO;

public interface IBuyerService {
	
	//public 리턴결과형 메서드이름(타입 파라미터변수)
	/**
	 * 전체 항목에 대한 buyer_id와 buyer_name를 출력하는 메서드
	 * @return BuyerVO 객체에 데이터를 담아 List형식으로 출력한다
	 */
	public List<BuyerVO> getAllBuyer();
	
	
	/**
	 * 검색한 buyer_id를 가지고 있는 데이터를 출력하는 메서드
	 * @param buyerId 검색할 String타입 buyer_id
	 * @return 검색한 데이터를 BuyerVO객체에 담아 출력한다
	 */
	public BuyerVO selectBuyer(String buyerId);
}
