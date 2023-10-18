package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
LPROD 테이블에 새로운 데이터 추가하기

lprod_gu와 lprod_nm값은 직접 입력 받아 처리하고,
lprod_id  는 현재의 lprod_id값 중에서 제일 큰 값보다 1 크게 한다.
sql = "select max(lprod_id) from lprod";
입력 받은 lprod_gu가 이미 등록되어 있으면, 다시 입력 받아서 처리한다.(pk)
sql = "select count(*) from lprod where lprod_gu ='입력값'"; ==> 0 : 중복 안됨

*/
public class JdbcTest05Explain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");		
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
//					"pc15","java");
			
			conn = DBUtil.getConnection();
			//작업 1)Lprod_id는 현재의 Lprod_id중에서 제일 큰 값보다 1 크게 한다.
			//값이 없을 때를 대비해 nvl사용 !
			String sql = "Select nvl(max(lprod_id),0) maxid from lprod";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int maxNum = 0;
			//rs 레코드가 하나만 나오는 것이 확실하다면 while(rs.next())문 사용 하지 않고 if문으로 값을 꺼내 올 수 있다.
			if(rs.next()) {
				// maxNum = rs.getInt(1);						//컬럼 번호
				// maxNum = rs.getInt("nvl(max(lprod_id),0)");	//식내용이 컬럼명 역할을 함(alias 없을때만)
				maxNum = rs.getInt("maxid");					// maxid로 alias 부여
			}
			
			maxNum ++;			//값 증가
			//작업1)끝----------------------------------------------------------------------
			
			//작업2)입력 받은 lprod_id가 이미 등록되어 있으면 다시 입력 받아서 처리한다.
			String gu;		//Lprod_gu(상품분류코드)가 저장될 변수 선언
			int count = 0;	//입력한 상품분류코드가 DB에 저장된 개수(count(*))를 저장할 변수 선언
			
			do {
				System.out.print("상품 분류 코드(LPROD_GU) 입력>>");
				gu = scan.next();
				
				String sql2 = "select count(*) from lprod where lprod_gu = ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, gu);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					count = rs.getInt("count(*)");
					System.out.println(count);
				}
				if(count>0) {
					System.out.println("입력한 상품 분류 코드 " + gu + "는 이미 등록된 코드입니다.");
					System.out.println("다시 입력하세요.");
				}
			}while(count>0);
			//작업2) 끝-----------------------------------------------------------------------
			//작업3) 상품 분류명(LPROD_NM) 입력 받아 DB에 INSERT하기
			System.out.print("상품 분류명(LPROD_NM) 입력 >> ");
			String nm = scan.next();
			
			String sql3 = "insert into lprod(lprod_id,lprod_gu,lprod_nm) values(?,?,?)";
			pstmt = conn.prepareStatement(sql3);
			pstmt.setInt(1, maxNum);
			pstmt.setString(2, gu);
			pstmt.setString(3, nm);
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println("등록 성공");
			} else {
				System.out.println("등록 실패");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {};
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {};
			if(conn!=null) try {conn.close();} catch(SQLException e) {};
		}
	}
}
