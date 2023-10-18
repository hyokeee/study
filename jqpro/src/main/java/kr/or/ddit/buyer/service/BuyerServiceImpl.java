package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.buyer.dao.IBuyerDao;
import kr.or.ddit.buyer.dao.BuyerDaoImpl;
import kr.or.ddit.buyer.vo.BuyerVO;

public class BuyerServiceImpl implements IBuyerService{
	
	private static IBuyerService service;
	private IBuyerDao dao;
	//dao 객체를 얻어온다.
	private BuyerServiceImpl() {
		dao = BuyerDaoImpl.getInstance();
	}
	
	//자기자신의 객체를 생성하고 리턴 메서드
	public static IBuyerService getInstance() {
		if(service == null) service = new BuyerServiceImpl();
		
		return service;
	}

	@Override
	public List<BuyerVO> getAllBuyer() {
		//1. 리턴 결과형의 변수 선언
		List<BuyerVO> list = null;

		//2. dao의 메서드를 실행 -결과값
		list = dao.getAllBuyer();
		
		//3. 결과 값을 리턴
		return list;
	}

	@Override
	public BuyerVO selectBuyer(String buyerId) {
		return dao.selectBuyer(buyerId);
	}

}
