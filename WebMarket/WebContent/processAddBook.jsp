<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="org.apache.commons.fileupload.DiskFileUpload"%>
<%@ page import="java.util.List"%>
<%@ page import="ch04.com.dao.BookRepository"%>
<%@ page import="ch04.com.dao.BookVO"%>
<%
	request.setCharacterEncoding("UTF-8");
	String path = "C:\\eclipse202006\\workspace\\WebMarket\\WebContent\\images";
	DiskFileUpload upload = new DiskFileUpload();
	upload.setSizeMax(1000000);	//최대 1M
	upload.setSizeThreshold(4096);	// 1 * 1024 * 1024 => 1M
	upload.setRepositoryPath(path); // 임시 저장(생략가능)
	List items = upload.parseRequest(request);
	Iterator params = items.iterator(); //열거형
	String bookId       = "";
	String name         = "";
	String unitPrice    = "";
	String author       = "";
	String description  = "";
	String publisher    = "";
	String category     = "";
	String unitsInStock = "";
	String totalPages   = "";
	String releaseDate  = "";
	String condition    = "";
	int uPrice = 0;
	Long uInStock = 0L;
	Long tPage = 0L;
	String fileFieldName = "";
	String fileName = "";
	String contentType = "";
	long fileSize = 0L;
	while(params.hasNext()){ // 다음 항목이 있나
		FileItem item = (FileItem) params.next();	//있으면 가져와
		if(item.isFormField()){	// 일반 항목
			//item : {productId=P1234}
			String iname = item.getFieldName();	//productId
			if(iname.equals("bookId")){
				bookId = item.getString("UTF-8");	//P1234
			} else if(iname.equals("name")){
				name = item.getString("UTF-8");	
			} else if(iname.equals("unitPrice")){
				unitPrice = item.getString("UTF-8");	
				uPrice = Integer.parseInt(unitPrice);
			} else if(iname.equals("description")){
				description = item.getString("UTF-8");	
			} else if(iname.equals("publisher")){
				publisher = item.getString("UTF-8");	
			} else if(iname.equals("category")){
				category = item.getString("UTF-8");	
			} else if(iname.equals("unitsInStock")){
				unitsInStock = item.getString("UTF-8");	
				uInStock = Long.parseLong(unitsInStock);
			} else if(iname.equals("totalPages")){
				totalPages = item.getString("UTF-8");	
				tPage = Long.parseLong(totalPages);
			} else if(iname.equals("releaseDate")){
				releaseDate = item.getString("UTF-8");	
			} else if(iname.equals("condition")){
				condition = item.getString("UTF-8");	
			}
		} else {	// 파일 객체
			fileFieldName = item.getFieldName();	//productImage
			fileName = item.getName();			//파일 업로드 했을 때 이미지의 경로
			contentType = item.getContentType();	//MIME 타입: images/jpeg
			fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
			fileSize = item.getSize();				//파일 크기
			File file = new File(path + "/" + fileName);
			// 설계대로 복사 시작
			item.write(file);
		}
	} //end while
	BookVO bVo = new BookVO();
	bVo.setBookId(bookId);
	bVo.setName(name);
	bVo.setUnitPrice(uPrice);
	bVo.setAuthor(author);
	bVo.setDescription(description);
	bVo.setPublisher(publisher);
	bVo.setCategory(category);
	bVo.setUnitsInStock(uInStock);
	bVo.setTotalPages(tPage);
	bVo.setReleaseDate(releaseDate);
	bVo.setCondition(condition);
	bVo.setFileName(fileName);
	
	BookRepository dao = BookRepository.getInstance();
	
	dao.addBook(bVo);
	
	List<BookVO> listOfBooks = dao.getAllBooks();
	
	for(BookVO vo : listOfBooks){
		out.print("<p>"+vo+"</p>");
	}
	
	response.sendRedirect("books.jsp");
	
	


%>