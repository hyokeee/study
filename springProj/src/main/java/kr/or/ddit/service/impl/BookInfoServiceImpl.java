package kr.or.ddit.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.dao.BookInfoDao;
import kr.or.ddit.service.BookInfoService;
import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.BookInfoVO;
import lombok.extern.slf4j.Slf4j;
// 서비스 클래스 : 비즈니스 로직
// 스프링 MVC 구조에서 Controller와 DAO를 연결하는 역할
@Slf4j
@Service
public class BookInfoServiceImpl implements BookInfoService{
	//데이터베이스 접근을 위해 BookInfoDao 인스턴스를 주입받자
	//DI / IoC
	@Autowired
	BookInfoDao bookInfoDao;
	
	
	//1. 도서 정보 등록
	/*
	 
	 */
	@Override
	public int addBookPost(BookInfoVO bookInfoVO) {
		//1-1) 도서 정보 등록
		int result = this.bookInfoDao.addBookPost(bookInfoVO);//부모
		
		//1-2) 첨부 파일등록. bookId, filename이 필요함
		AttachVO attachVO = new AttachVO();
		attachVO.setBookId(bookInfoVO.getBookId());//참조무결성(참조 관계에서 결험이 없다)
		
		///////////////////// 첨부 파일 처리 시작//////////////////////
		String uploadFolder = 
				"C:\\Users\\PC-15\\Desktop\\springProj\\springProj\\src\\main\\webapp\\resources\\images";
		
		//연/월/일 폴더 생성
		//2023-07-28 형식(format) 지정
		//간단한 날짜 형식
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//날짜 객체 생성(java.util 패키지)
		Date date = new Date();
		//2023-07-28 => ..s\\images\\2023\\07\\28
		String str = sdf.format(date);
		File uploadPath = new File(uploadFolder,str.replace("-",File.separator));
		log.info("uploadPath : "  + uploadPath);
		
		//만약 연/월/일 해당 폴더가 없으면 생성
		if(uploadPath.exists()==false) {
			uploadPath.mkdirs();
		}
		
		//파일객체(업로드 대상)
		MultipartFile multipartFile = bookInfoVO.getBookImage();
		
		log.info("파일명 :  "  + multipartFile.getOriginalFilename());
		log.info("파일크기 :  "  + multipartFile.getSize());
		log.info("파일타입 :  "  + multipartFile.getContentType());
		
		//원래 파일명. 개똥이.jpg
		String uploadFileName = multipartFile.getOriginalFilename();
		
		//같은 날 같은 이미지를 업로드 시 파일 중복되는 것을 방지해보자
		//java.util.UUID => 랜덤값 생성
		UUID uuid = UUID.randomUUID();
		//원래의 파일 이름과 구분하기 위해 _를 붙임(ASDFASD_개똥이.jpg)
		uploadFileName = uuid.toString() + "_" + uploadFileName;
		
		//File 객체 복사 설계(복사할 대상 경로, 파일명)
		File saveFile = new File(uploadPath,uploadFileName);
		
		//설계대로 파일 복사 실행
		try {
			multipartFile.transferTo(saveFile);
			//str : ...images\\2023-07-28
			// /
			attachVO.setFilename("/" + str.replace("-", File.separator).replace("\\", "/") + "/" + uploadFileName);
			
			result +=  this.bookInfoDao.addAttach(attachVO); //자식
			
			log.info("최종result : " + result);
			
			return result;
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		///////////////////// 첨부 파일 처리    끝//////////////////////
		
	}
	
	@Override
	public String getBookId() {
		return this.bookInfoDao.getBookId();
	}
	@Override
	public List<BookInfoVO> listBook(Map<String,Object> map) {
		return this.bookInfoDao.listBook(map);
	}
	@Override
	public int getBookInfoTotal(Map<String,Object> map) {
		return this.bookInfoDao.getBookInfoTotal(map);
	}
	
	@Override
	public BookInfoVO detailBook(String bookId) {
		return this.bookInfoDao.detailBook(bookId);
	}
	
	//도서 정보 및 첨부파일이 함께 수정
	@Override
	public int updateBookPost(BookInfoVO bookInfoVO) {
		//1) 도서 정보 수정
		int result =  this.bookInfoDao.updateBookPost(bookInfoVO);
		
		//2) 첨부파일 정보 수정
		//2-1) 파일객체가 있음 (파일도 수정하겠음) bookInfoVO{...bookImage=org.springfra...
		if(bookInfoVO.getBookImage().getSize()>0) {
			log.info("파일객체가 있음");
			//업로드 폴더 설정
			String uploadFolder = 
					"C:\\Users\\PC-15\\Desktop\\springProj\\springProj\\src\\main\\webapp\\resources\\images";
			
			//연월일 폴더 설정
			File uploadPath = new File(uploadFolder,getFolder());
			log.info("uploadPath : "  + uploadPath);
			
			//만약 연/월/일 해당 폴더가 없으면 생성
			if(uploadPath.exists()==false) {
				uploadPath.mkdirs();
			}
			
			
			//원래 파일명을 할당할 변수
			String uploadFileName = "";
			
			//파일정보를 확인해보자
			MultipartFile multipartFile = bookInfoVO.getBookImage();
			log.info("파일명 : " + multipartFile.getOriginalFilename());
			log.info("파일크기 : " + multipartFile.getSize());
			log.info("파일MIME타입 : " + multipartFile.getContentType());
			
			//같은 날 같은 이미지를 업로드 시 파일명 중복 방지
			//java.util.UUID => 랜덤값 생성
			UUID uuid = UUID.randomUUID();
			//File객체 설계(복사할 대상 경로, uuid_파일명)
			//uploadPath : ...\\images\\2023\\08\\02 \\(,)
			//uploadFileName : asdfadsf_개똥이.jpg
			uploadFileName = uuid.toString() + "_" + multipartFile.getOriginalFilename();
			//파일 복사 실행
			File saveFile = new File(uploadPath,uploadFileName);
			try {
				multipartFile.transferTo(saveFile);
				AttachVO attachVO = new AttachVO();
				//SEQ(자동생성), BOOK_ID, FILENAME
				attachVO.setBookId(bookInfoVO.getBookId());
				// web경로를 setting
				// /2023/08/02/asdf_개똥이.jpg
				attachVO.setFilename("/" + getFolder().replace("\\", "/")+"/"+uploadFileName);
				
				//ATTACH 테이블에 update 처리
				result += this.bookInfoDao.updateAttach(attachVO);
				
				
				return result;
			} catch (IllegalStateException | IOException e) {
				log.error(e.getMessage());
				return 0;
			}
		}else {
			log.info("파일객체가 없음");
			//2-2) 파일객체가 없음 (파일은 수정안함) bookInfoVO{...bookImage=null
			return result;
		}//end if
	}
	
	public int deleteBookPost(String bookId) {
		//먼저 ATTACH 테이블 데이터부터 삭제해주어야 한다.
		int result = this.bookInfoDao.deleteAttach(bookId);
		result += this.bookInfoDao.deleteBookPost(bookId); 
		return result;
	}
	
	//연월일 폴더 생성
	public String getFolder() {
		//2023-08-02 형식(format)지정
		//간단한 날짜 형식
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//날짜 객체 생성(java.util.Date)
		Date date = new Date();
		//2023-08-02
		String str = sdf.format(date);
		//File.separator : 윈도우 폴더 구분자(\\)
		return str.replace("-", File.separator);
		
	}
	
	
	
}
