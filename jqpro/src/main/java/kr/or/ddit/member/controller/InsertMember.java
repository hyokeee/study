package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;


@WebServlet("/insertMember.do")
public class InsertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
/*		
		//전송시 데이터 받기
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String bir = request.getParameter("bir");
		String pw = request.getParameter("pw");
		String hp = request.getParameter("hp");
		String mail = request.getParameter("mail");
		String zip = request.getParameter("zip");
		String add1 = request.getParameter("add1");
		String add2 = request.getParameter("add2");
		
		//MemberVO객체에 저장
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(id);
		memVo.setMem_name(name);
		memVo.setMem_bir(bir);
		memVo.setMem_pass(pw);
		memVo.setMem_hp(hp);
		memVo.setMem_mail(mail);
		memVo.setMem_zip(zip);
		memVo.setMem_add1(add1);
		memVo.setMem_add2(add2);
*/
		
		//전송 시 데이터 받아서 vo에 저장하기 - 
		
		MemberVO memVo = new MemberVO();
		try {
			BeanUtils.populate(memVo, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e1) {
			e1.printStackTrace();
		}
		
		
		
		//service 생성
		IMemberService service = MemberServiceImpl.getInstance();
		
		// insert 결과값이 출력될 변수
		int cnt = 0;
		
		// insertMember메서드 실행(파라미터 - 앞에서 만든 MemberVo객체)
		try {
			cnt = service.insertMember(memVo);
		} catch (Exception e) { //오류 발생 시 cnt를 0으로 준다
			cnt = 0;
		}
		
		// cnt 1 : 작업 성공 0 : 작업 실패
		if(cnt>0) {
			request.setAttribute("checkInsert", "회원가입 성공");
		} else {
			request.setAttribute("checkInsert", "회원가입 실패");
		}
		// 성공여부 view로 전송
		request.getRequestDispatcher("/0601/insertMember.jsp").forward(request, response);
	}

}
