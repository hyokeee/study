package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
 	회원을 관리하는 프로그램을 작성하시오...(MYMEMBER 테이블 이용)
 	
 	아래 메뉴의 기능을 모두 구현하시오. (CREATE READ UPDATE DELETE)
 	
 	메뉴예시)
 	----------------
 	1. 자료 추가		----> insert (C)
 	2. 자료 삭제		----> delete (D)
 	3. 자료 수정		----> update (U)
 	4. 전체 자료 출력	----> select (R)
 	0. 작업 끝
 	----------------
 	
 	조건)
 	1) '자료 추가' 메뉴에서 '회원ID'는 중복되지 않는다. (중복되면 다시 입력)
 	2) '자료 삭제'는 '회원ID'를 입력받아서 처리한다.
 	3) '자료 수정'에서 '회원ID'는 변경되지 않는다.
 */
public class JdbcTest06 {
	Scanner scan = new Scanner(System.in);
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Statement stmt = null;
	
	//mymember 테이블에 CRUD과정에 필요한 변수들
	String id = null;
	String pw = null;
	String name = null;
	String tel = null;
	String addr = null;
	
	//생성자
	public JdbcTest06() {
		conn = DBUtil.getConnection();
	}
	
	public static void main(String[] args) throws Exception {
		new JdbcTest06().start();
	}
	
	//시작 메서드
	public void start() throws Exception {
		int choice = display();
		switch(choice) {
		case 1:			//자료 추가
			insert();
			break;
		case 2:			//자료 삭제
			delete();
			break;
		case 3:			//자료 수정
			update();
			break;
		case 4:			//전체 자료 출력
			selectAll();
			break;
		case 0:			//작업 끝
			close();
			System.out.println("작업이 종료되었습니다.");
			return;
		default:
			System.out.println();
			System.out.println("올바르지 않은 메뉴선택입니다.");
			System.out.println("다시 입력해주세요.");
			start();
		}
	}
	
	//화면 구성
	public int display(){
		System.out.println();
		System.out.println("----------------");
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 삭제");
		System.out.println("3. 자료 수정");
		System.out.println("4. 전체 자료 출력");
		System.out.println("0. 작업 끝");
		System.out.println("----------------");
		System.out.print("선택>> ");
		int sss;
		try {
			sss = scan.nextInt();
		}catch(InputMismatchException e) {
			sss = -1;
			scan.nextLine(); // 버퍼 비우기
		}
		return sss;
	}
		
	//
	
	
	//작업 종료시 메서드
	public void close() throws Exception{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
	}
	
	//전체 자료 출력 메서드
	public void selectAll() throws Exception{
		String sql = "select * from mymember";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		System.out.println("MEM_ID        MEM_PASS        MEM_NAME        MEM_TEL        MEM_ADDR");
		System.out.println("=====================================================================");
		
		if(!rs.next()) {
			System.out.println("없습니다.");
		} else {
			System.out.print(rs.getString(1)+"        ");
			System.out.print(rs.getString(2)+"        ");
			System.out.print(rs.getString(3)+"        ");
			System.out.print(rs.getString(4)+"        ");
			System.out.print(rs.getString(5)+"        ");
			System.out.println();
		}
		
		while(rs.next()) {
			System.out.print(rs.getString(1)+"        ");
			System.out.print(rs.getString(2)+"        ");
			System.out.print(rs.getString(3)+"        ");
			System.out.print(rs.getString(4)+"        ");
			System.out.print(rs.getString(5)+"        ");
			System.out.println();
		}
		start();
		
		
	}
	
	//자료 수정 메서드
	public void update() throws Exception{
		int cnt = 0;	//수정 완료되었는지 확인하기 위한 변수
		System.out.println();
		System.out.println("=====자료 수정=====");
		System.out.print("수정할 회원의 ID를 입력하세요>> ");
		id = scan.next();
		System.out.print("선택한 회원 ID [" +id+"] 회원 비밀번호 변경 >>");
		pw = scan.next();
		System.out.print("선택한 회원 ID [" +id+"] 회원 이름 변경 >>");
		name = scan.next();
		System.out.print("선택한 회원 ID [" +id+"] 회원 전화번호 변경 >>");
		tel = scan.next();
		System.out.print("선택한 회원 ID [" +id+"] 회원 주소 변경 >>");
		addr = scan.next();
		String sql = "update mymember set mem_pass = ?, mem_name = ?, mem_tel = ?, mem_addr = ? where mem_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, pw);
		pstmt.setString(2, name);
		pstmt.setString(3, tel);
		pstmt.setString(4, addr);
		pstmt.setString(5, id);
		cnt = pstmt.executeUpdate();
		if(cnt>0) {
			System.out.println();
			System.out.println("수정 완료!");
			start();
		} else {
			System.out.println();
			System.out.println("수정 실패! 메뉴로 이동합니다.");
			start();
		}
	}
	
	
	//자료 삭제 메서드
	public void delete() throws Exception{
		int cnt = 0;		//삭제 완료되었는지 확인하기 위한 변수
		System.out.println();
		System.out.println("=====자료 삭제=====");
		
		System.out.print("삭제할 회원 ID를 입력하세요>> ");
		id = scan.next();
		String sql = "delete from mymember where mem_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		cnt = pstmt.executeUpdate();
		if(cnt>0) {
			System.out.println("삭제 완료");
			start();
		}else {
			System.out.println("삭제 실패! 메뉴로 이동합니다.");
			start();
		}
		
	}

	//자료 추가 메서드
	public void insert() throws Exception {
		
		int count = 0;
		System.out.println();
		System.out.println("=====자료추가=====");
		do {
			System.out.print("회원 ID를 입력하세요>>");
			id = scan.next();
			String sql = "select count(*) from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}
			if(count>0) {
				System.out.println("입력한 ID " + id + "는 이미 존재합니다.");
				System.out.println("다시 입력하세요.");
			}	
		}while(count>0);
		System.out.print("회원 비밀번호를 입력하세요>>");
		pw = scan.next();
		System.out.print("회원 이름을 입력하세요>>");
		name = scan.next();
		System.out.print("회원 전화번호를 입력하세요>>");
		tel = scan.next();
		scan.nextLine();
		System.out.print("회원 주소를 입력하세요>>");
		addr = scan.nextLine();
		
		String sql2 = "insert into mymember(mem_id, mem_pass, mem_name, mem_tel, mem_addr) values(?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql2);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		pstmt.setString(3, name);
		pstmt.setString(4, tel);
		pstmt.setString(5, addr);
		int cnt = pstmt.executeUpdate();	//추가 완료되었는지 확인하기 위한 변수
		if(cnt>0) {
			System.out.println();
			System.out.println("등록 완료");
			System.out.println();
			start();
		} else {
			System.out.println();
			System.out.println("등록 실패");
			System.out.println();
			start();
		}
		
	}
}
