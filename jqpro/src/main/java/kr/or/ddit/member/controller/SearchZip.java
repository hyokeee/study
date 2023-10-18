package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.vo.ZiptbVO;
import kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory;

/**
 * Servlet implementation class SearchZip
 */
@WebServlet("/searchZip.do")
public class SearchZip extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String dong = request.getParameter("dong");
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		List<ZiptbVO> zList = sqlSession.selectList("member.getZipCode",dong);
		
		request.setAttribute("list", zList);
		request.getRequestDispatcher("/0601/zipcodes.jsp").forward(request, response);
	}

}
