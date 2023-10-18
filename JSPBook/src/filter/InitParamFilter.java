package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class InitParamFilter implements Filter{
	private FilterConfig filterConfig = null;
	
	/*
	<init-param>
    	<param-name>param1</param-name>
    	<param-value>admin</param-value>
    </init-param>
    <init-param>
    	<param-name>param2</param-name>
    	<param-value>1234</param-value>
    </init-param>
	 */
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter02 초기화");
		this.filterConfig = filterConfig;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Filter02 수행");
		//사용자가 입력한 요청 파라미터
		//filter02_process.jsp?id=admin&passwd=1234
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		//web.xml에서 넘어온 초기화 파라미터
		String param1 = this.filterConfig.getInitParameter("param1");	//admin
		String param2 = this.filterConfig.getInitParameter("param2");	//1234
		
		String message;
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		if(id.equals(param1)&& passwd.equals(param2)) {
			message = "로그인 성공!";
		}else {
			message = "로그인 실패!";
		}
		// response 객체에 message를 추가해줌
		writer.println(message);
		// 다음 필터로 제어를 넘김
		chain.doFilter(request, response); 
	}
	
	@Override
	public void destroy() {
		
	}

}
