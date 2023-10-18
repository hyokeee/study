package kr.or.ddit.member.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.member.service.IMyMemberService;
import kr.or.ddit.member.service.MyMemberServiceImpl;
import kr.or.ddit.member.vo.FileInfoVO;
import kr.or.ddit.member.vo.MyMemberVO;


@WebServlet("/update.do")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 30,
		maxRequestSize = 1024 * 1024 * 100 
	)
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		String oldphoto = request.getParameter("oldphoto");
		
		
		MyMemberVO memVo = new MyMemberVO();
	    memVo.setMem_id(id);
	    memVo.setMem_pass(pw);
	    memVo.setMem_name(name);
	    memVo.setMem_tel(tel);
	    memVo.setMem_addr(addr);
	    memVo.setMem_photo(oldphoto);
		// 업로드된 파일이 저장될 폴더 설정
		String uploadPath = "d:/d_other/web/files";
				
		// 저장될 폴더가 없으면 새로 만든다.
		File f = new File(uploadPath);
				
		if(!f.exists()) {
			f.mkdirs();
		}
		
			//파일명이 저장될 변수 선언
	    FileInfoVO fvo = new FileInfoVO();
		// 전체 Part객체 개수만큼 반복 처리
	    Part part = request.getPart("photo");
	    
	   
	    if(part!=null) {
	    	String fileName = extractFileName(part);
	    	 if(!"".equals(fileName)) {
	             fvo.setFile_writer(id);
	             fvo.setOrigin_file_name(fileName);
	             
	             String saveFilename = UUID.randomUUID().toString()+ "_" + fileName;
	             fvo.setSave_file_name(saveFilename);
	             
	             fvo.setFile_size((long) Math.ceil(part.getSize() / 1024.0));
	             memVo.setMem_photo(saveFilename);
	             try {
	                part.write(uploadPath + File.separator + saveFilename);
	             } catch(Exception e) {
	                e.printStackTrace();
	             }
	    	 }
	    }
	   
	    
	    IMyMemberService service = MyMemberServiceImpl.getInstance();
	    int cnt = service.updateMyMember(memVo);
	    
	    response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		if(cnt>0) {
			out.println("<html><head><meta charset='utf-8'></head>");
			out.println("<body><h1>회원 정보 수정이 완료되었습니다.</h1><a href='"+request.getContextPath()+"/memberList.do'>회원 목록 보기</a></body></html>");
		}else {
			out.println("<html><head><meta charset='utf-8'></head>");
			out.println("<body><h1>회원 정보 수정을 실패했습니다.</h1><a href='"+request.getContextPath()+"/memberList.do'>회원 목록 보기</a></body></html>");
		}

	    
	}
	
		
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/mymember/update.jsp").forward(request, response);
	}
	
	
	//Part 영역 안에서 fileName을 추출하는 메서드
	private String extractFileName(Part part) {
		String fileName ="";  //추출할 fileName이 저장될 변수 선언
		// Part에서 'content-disposition'의 헤더 값을 구해온다.
		String headerValue = part.getHeader("content-disposition");
			
		String[] items = headerValue.split(";");
		for(String item : items) {
			if(item.trim().startsWith("filename")) {//파일인지 여부인지 검사
				fileName = item.substring(item.indexOf("=")+2,item.length()-1); //  파일 이름 추가
					
			}
		}
		return fileName;
	} 
}
