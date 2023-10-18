<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.io.File"%>
<%@ page import="org.apache.commons.fileupload.FileItem"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="org.apache.commons.fileupload.DiskFileUpload"%>
<%@ page import="java.util.List"%>
<%@ page import="dao.ProductRepository"%>
<%@ page import="vo.ProductVO"%>
<!-- 폼 필드
	요청URL : processAddProduct.jsp
	요청방식 : post
	요청파라미터(HTTP 파라미터,QueryString) :
		{productId=P1237,pname=에어팟3,unitPrice=200000,description=굿음질,
			manufacturer=Apple,category=Tablet,unitInStock=1000,condition=Old,}
-->
<%	//스크립틀릿
	//폼 페이지에서 입력된 데이터를 서버로 전송 시 한글이 깨지지 않도록 문자 인코딩 유형을 UTF-8로 하여
	//request 내장 객체의 모든 파라미터의 인코딩을 UTF-8로 처리
	request.setCharacterEncoding("UTF-8");
	// 이미지 파일 위치
	String path = "C:\\eclipse202006\\workspace\\JSPBook\\WebContent\\images";
	// 파일 업로드 처리용 클래스
	DiskFileUpload upload = new DiskFileUpload();
	// 환경설정
	upload.setSizeMax(1000000);	//최대 1M
	upload.setSizeThreshold(4096);	// 1 * 1024 * 1024 => 1M
	upload.setRepositoryPath(path); // 임시 저장(생략가능)
	// form 데이터들을 items로 파싱(의미분석, 구문분석)
	List items = upload.parseRequest(request);
	Iterator params = items.iterator(); //열거형
	
	//폼 페이지에서 입력된 값들을 얻어오기 위해 request 내장 객체의 getParameter()메서드를 작성
	String productId    = "";
	String pname        = "";
	String unitPrice    = "";
	String description  = "";
	String manufacturer = "";
	String category     = "";
	String unitsInStock = "";
	String condition    = "";
	int price = 0;
	int stock = 0;
	    
	String fileFieldName = "";
	String fileName = "";
	String contentType = "";
	long fileSize = 0L;
	
	while(params.hasNext()){ // 다음 항목이 있나
		FileItem item = (FileItem) params.next();	//있으면 가져와
		if(item.isFormField()){	// 일반 항목
			//item : {productId=P1234}
			String name = item.getFieldName();	//productId
			if(name.equals("productId")){
				productId = item.getString("UTF-8");	//P1234
			} else if(name.equals("pname")){
				pname = item.getString("UTF-8");	
			} else if(name.equals("unitPrice")){
				unitPrice = item.getString("UTF-8");	
				price = Integer.parseInt(unitPrice);
			} else if(name.equals("description")){
				description = item.getString("UTF-8");	
			} else if(name.equals("manufacturer")){
				manufacturer = item.getString("UTF-8");	
			} else if(name.equals("category")){
				category = item.getString("UTF-8");	
			} else if(name.equals("unitsInStock")){
				unitsInStock = item.getString("UTF-8");	
				stock = Integer.parseInt(unitsInStock);
			} else if(name.equals("condition")){
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
	//넘어온 파라미터값들을 -> ProductVO productVO 객체에 setting해보자
	ProductVO productVO = new ProductVO();
	productVO.setProductId(productId);
	productVO.setPname(pname);
	productVO.setUnitPrice(price);
	productVO.setDescription(description);
	productVO.setManufacturer(manufacturer);
	productVO.setCategory(category);
	productVO.setUnitsInStock(stock);
	productVO.setCondition(condition);
	productVO.setFilename(fileName);
	
	out.print("productVO : " + productVO);
	
	ProductRepository dao = ProductRepository.getInstance();
	//폼 페이지에서 입력된 데이터를 저장하도록 ProductRepository 클래스의
	// addProduct()메서들르 호출
	dao.addProduct(productVO);
	//모든 상품 목록을 리턴
	List<ProductVO> listOfProducts = dao.getAllProducts();
	
	//향상된 for문
	for(ProductVO vo : listOfProducts){
		out.print("<p>"+vo+"</p>");
	}
	
	// 목록으로 강제 이동
	response.sendRedirect("products.jsp");
%>