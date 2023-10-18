package kr.or.ddit.member.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/imageView.do")
public class ImageView extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 파라미터로 넘어온 파일 번호를 구한다.(String)		
		String photo = request.getParameter("photo");
		
		// 업로드된 파일이 저장될 폴더 설정
		String uploadPath = "d:/d_other/web/files";
						
		// 저장될 폴더가 없으면 새로 만든다.
		File f = new File(uploadPath);
						
		if(!f.exists()) {
			f.mkdirs();
		}
		
		String imagePath = uploadPath + File.separator + photo;
		
		File imgFile = new File(imagePath);
		
		if(imgFile.exists()) {
			// 파일 입출력을 진행한다.
			BufferedInputStream bin = null;
			BufferedOutputStream bout = null;
			try {
				// 출력용 스트림 객체 생성(클라이언트로 전송할 스트림) ==> response객체 이용ㅓ
				bout = new BufferedOutputStream(response.getOutputStream());
				
				// 파일 입력용 스트림 객체 생성
				bin = new BufferedInputStream(new FileInputStream(imgFile));
							
				byte[] temp = new byte[1024];
				int len = 0;	//실제 읽어온 데이터 길이가 저장될 변수
				while((len=bin.read(temp))>0){
					bout.write(temp,0,len);
				}
				bout.flush();
							
			} catch (IOException e) {
				System.out.println("입출력 오류 : " + e.getMessage());
			} finally {
				if(bin != null) try {bin.close();} catch(IOException e) {}
				if(bout != null) try {bout.close();} catch(IOException e) {}
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
