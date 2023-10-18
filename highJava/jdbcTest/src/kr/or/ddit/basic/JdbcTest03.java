package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//문제) lprod_id 값을 2개 입력 받아서 두 값중 작은 값부터 큰 값사이의 자료들을 출력하시오
//		(작은값과 큰값은 포함된다.)
public class JdbcTest03 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("lprod_id값 1 입력>>");
		int first = scan.nextInt();
		System.out.print("lprod_id값 2 입력>>");
		int second = scan.nextInt();
		
		/* if절로 두 입력값 정렬
		if(first>second) { 
		int temp = first; 
		first = second; 
		second = temp; 
		}
		 */
		
		//배열로 값 2개 정렬
		ArrayList<Integer> inputs = new ArrayList<>();
		inputs.add(first);
		inputs.add(second);
		Collections.sort(inputs);
		first = inputs.get(0);
		second = inputs.get(1);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","pc15","java");
			String sql = "Select * From lprod where lprod_id >= " + first + " and lprod_id <= " + second;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println("lprod_id : " + rs.getInt("lprod_id"));
				System.out.println("lprod_gu : " + rs.getString("lprod_gu"));
				System.out.println("lprod_nm : " + rs.getString("lprod_nm"));
				System.out.println();
			}
		} catch (SQLException e) {
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();}catch(SQLException e) {};
			if(stmt!=null) try {stmt.close();}catch(SQLException e) {};
			if(conn!=null) try {conn.close();}catch(SQLException e) {};
			scan.close();
		}
		
	}
}
