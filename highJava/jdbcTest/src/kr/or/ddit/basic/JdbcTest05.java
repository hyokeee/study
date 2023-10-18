package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
   LPROD 테이블에 새로운 데이터 추가하기
   
   lprod_gu와 lprod_nm값은 직접 입력 받아 처리하고,
   lprod_id  는 현재의 lprod_id값 중에서 제일 큰 값보다 1 크게 한다.
   sql = "select max(lprod_id) from lprod";
   입력 받은 lprod_gu가 이미 등록되어 있으면, 다시 입력 받아서 처리한다.(pk)
   sql = "select count(*) from lprod where lprod_gu ='입력값'"; ==> 0 : 중복 안됨
 
 */
public class JdbcTest05 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PreparedStatement pstmt = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs= null;
		
		//insert할 id값(최대값+1)
		int maxId = 0;
		
		//insert할 gu값
		String insertGu = null;
		
		
		try {
			//연결
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","pc15","java");
			//sql1 => 현재 저장된 lprod_id 의 max값 구하기
			String sql1 = "select max(lprod_id) from lprod";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			while(rs.next()) {
				maxId = rs.getInt("max(lprod_id)")+1;
			}
			System.out.println("새로운 데이터 추가하기");
			while(true) {
			System.out.print("추가할 lprod_gu 값을 입력하세요 >>");
			String newGu = scan.next();
			String sql2 = "select count(*) from lprod where lprod_gu = '"+ newGu+"'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql2);
			//newGu값이 중복되는지 확인할 변수( 0이어야 중복 아님)
			int isExist=1;
			while(rs.next()) {
				
				isExist = rs.getInt("count(*)");
			}
			if(isExist==0) {
				insertGu = newGu;
				break;
			} else {
				System.out.println("이미 존재하는 lprod_gu입니다.");
			}
			}
			System.out.print("추가할 lprod_nm값을 입력하세요 >>");
			String newNm = scan.next();
			
			//데이터 insert
			String sql3 = "insert into lprod (lprod_id,lprod_gu,lprod_nm) values (?,?,?)";
			pstmt = conn.prepareStatement(sql3);
			pstmt.setInt(1, maxId);
			pstmt.setString(2, insertGu);
			pstmt.setString(3, newNm);
			
			int cnt = pstmt.executeUpdate();
			if(cnt !=0) {
				System.out.println();
				System.out.println("반환값 : " + cnt);
				System.out.println("입력한 값 저장 성공!");
			} else {
				System.out.println("입력한 값 저장 실패!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block		
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {};
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {};
			if(stmt!=null) try {stmt.close();} catch(SQLException e) {};
			if(conn!=null) try {conn.close();} catch(SQLException e) {};
			scan.close();
		}
	}
}
