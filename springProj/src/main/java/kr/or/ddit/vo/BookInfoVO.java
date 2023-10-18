package kr.or.ddit.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BookInfoVO {
	private int    rnum			;
	private String bookId       ;
	private String name         ;
	private int    unitPrice    ;
	private String author       ;
	private String description  ;
	private String publisher    ;
	private String category     ;
	private int    unitsInStock ;
	private int    totalPages   ;
	private String releaseDate  ;
	private String condition    ;
	//<input type="file" name="bookImage"..
	private MultipartFile bookImage;
	
	//BookInfoVO : AttachVO = 1 : N
	private List<AttachVO> attachVOList;
}
