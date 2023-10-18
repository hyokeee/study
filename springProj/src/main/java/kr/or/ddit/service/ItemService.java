package kr.or.ddit.service;

import kr.or.ddit.vo.Item3VO;
import kr.or.ddit.vo.ItemVO;

public interface ItemService {
	//메서드 시그니쳐
	//아이템 등록
	public int itemRegist(ItemVO itemVO);
	
	//아이템 등록 + 다중파일 등록
	public int registMultiPost(Item3VO item3VO);
	
}
