package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcTest02 {
	// 문제1) 사용자로부터 Lprod_id값을 입력 받아 입력한 값보다 Lprod_id가 큰 자료들을 출력하시오.
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		System.out.print("Lprod_id 값을 입력하세요>>");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc15", "java");
			String sql = "select lprod_id, lprod_gu, lprod_nm as NM from lprod where lprod_id > ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, scan.nextInt());
			rs = stmt.executeQuery();

			System.out.println("== 쿼리문 처리 결과 ==");

			while (rs.next()) {
				System.out.println("LPROD_ID : " + rs.getInt("LPROD_ID")); // 컬럼명
				System.out.println("LPROD_GU : " + rs.getString(2)); // 컬럼번호
				System.out.println("LPROD_NM : " + rs.getString("NM")); // 컬럼의 alias 명으로
				System.out.println("----------------------------------------------");
			}
		} catch (SQLException e) {
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} finally {
			// 5. 자원 반납
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
			scan.close();
		}
	}
}
