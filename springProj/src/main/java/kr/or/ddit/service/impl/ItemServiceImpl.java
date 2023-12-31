package kr.or.ddit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.mapper.ItemMapper;
import kr.or.ddit.service.ItemService;
import kr.or.ddit.util.FileUploadUtils;
import kr.or.ddit.vo.Item3VO;
import kr.or.ddit.vo.ItemAttachVO;
import kr.or.ddit.vo.ItemVO;
@Service
public class ItemServiceImpl implements ItemService{
	//DI,IoC
	@Autowired
	ItemMapper itemMapper;
	
	//아이템 등록
	@Override
	public int itemRegist(ItemVO itemVO) {
		/*
		 itemVO : ItemVO(itemId=0, itemName=태블릿, price=12000, description=<p>내용글</p>,
		 			pictureUrl=null, pictures = org.springframework...)
		*/
		MultipartFile picture = itemVO.getPictures();
		//파일업로드
		String pictureUrl = FileUploadUtils.singleUpload(picture);
		
		itemVO.setPictureUrl(pictureUrl);
		
		//아이템 insert
		/*
		 itemVO : ItemVO(itemId=0, itemName=태블릿, price=12000, description=<p>내용글</p>,
		 			pictureUrl=/2023/08/10/asdf_개똥이.jpg, pictures = org.springframework...)
		*/
		int result = this.itemMapper.itemRegist(itemVO);
		return result;
	}
	
	//아이템 등록 + 다중파일 등록
	//Transactional : 클래스나 매서드에 대해 스프링의 트랜잭션 처리를 적용
	@Transactional
	@Override
	public int registMultiPost(Item3VO item3VO) {
		//1) item3VO -> ITEM3 테이블에 insert
		int result = this.itemMapper.registMultiPost(item3VO);
		MultipartFile[] pictures = item3VO.getPictures();
		//파일 업로드
		/*
		 itemAttachVOList[
		  itemAttachVO[fullname=/2023/08/10/asdf_개똥이.jpg,itemId=0,regdate=null],
		  itemAttachVO[fullname=/2023/08/10/sfsf_박명수.jpg,itemId=0,regdate=null],
		  itemAttachVO[fullname=/2023/08/10/qdthf_개똥이.jpg,itemId=0,regdate=null]
		 ]
		 */
		List<ItemAttachVO> itemAttachVOList 
			= FileUploadUtils.multiUpload(pictures);
		for(ItemAttachVO vo : itemAttachVOList) {
			vo.setItemId(item3VO.getItemId());
		}
		item3VO.setItemAttachVOList(itemAttachVOList);
		//2) ItemAttach(fullname, itemId, regdate) -> ITEM_ATTACH 테이블에 insert
		result += this.itemMapper.registMultiAttach(itemAttachVOList);
		return result;
	}
}    
