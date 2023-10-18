package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthenFilter implements Filter{
	
	// 필터 시작. 초기화
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Filter01 초기화 완료...");
		
	}

	// 필터 기능 수행
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		System.out.println("Filter01 수행");
		//	/ch12/filetr01_process.jsp?name=개똥이
		String name = request.getParameter("name");	//개똥이
		// 응답 메시지를 담아서 서버에서 클라이언트로 전달해줌(response 객체 활용)
		if(name== null || name.contentEquals("")) {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");	//MIME 타입
			PrintWriter writer = response.getWriter();
			String message = "입력된 name 값은 null입니다.";
			writer.println(message);
			return;
		}
		// 필터가 여러개 있을 때 전달해줌
		filterChain.doFilter(request, response);
	}
	
	// 필터 종료하기 전에 호출
	@Override
	public void destroy() {
		System.out.println("Filter01 해제...");
		
	}
	
}
