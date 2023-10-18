package kr.or.ddit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.Item3VO;
import kr.or.ddit.vo.ItemAttachVO;
import kr.or.ddit.vo.ItemVO;
@Mapper
public interface ItemMapper {
	//아이템 등록
	public int itemRegist(ItemVO itemVO);
	
	//다중 등록
	public int registMultiPost(Item3VO item3VO);
	
	//파일 다중 입력
	public int registMultiAttach(List<ItemAttachVO> itemAttachVOList);
}
