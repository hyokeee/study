package kr.or.ddit.basic;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.vo.LprodVO;

public class LprodMybatisTest {
	// myBatis를 이용하여 DB자료를 처리하는 순서 및 방법
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 1. myBatis의 환경설정파일(mybatis-config.xml)을 읽어와서 실행한다.
		InputStream in = null;
		SqlSessionFactory sqlSessionFactory = null;
		try {
			// 1-1. 환경설정파일을 읽어 올 스트림 객체 생성
			in = Resources.getResourceAsStream("kr/or/ddit/mybatis/config/mybatis-config.xml");
			
			// 1-2. 환경 설정 파일을 읽어와 환경 설정을 완성한 후 SQL문을 호출해서 실행할 수 있는 갳체를
			//		생성할 수 있는 SqlSessionFactory 객체를 생성한다.
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
			
		} catch (Exception e) {
			System.out.println("myBatis 초기화 실패");
			e.printStackTrace();
		} finally {
			if(in!=null) try {in.close();}catch(Exception e) {};
		}
		//------------------------------------환경설정끝-----------------------------------
		
		// 2. mapper에 등록된 SQL문들 중 실행할 SQL문을 호출해서 원하는 작업을 수행한다.
		/*
		// 2-1. insert 연습
		System.out.println("insert 작업 시작...");
		
		System.out.print("Lprod_id 입력 >>");
		int lprodId = scan.nextInt();
		
		System.out.print("Lprod_gu 입력 >>");
		String lprodGu = scan.next();
		
		System.out.print("Lprod_nm 입력 >>");
		String lprodNm = scan.next();
		
		// 입력한 데이터를 VO객체에 저장한다.
		LprodVO lvo1 = new LprodVO();
		lvo1.setLprod_id(lprodId);
		lvo1.setLprod_gu(lprodGu);
		lvo1.setLprod_nm(lprodNm);
		
		SqlSession session = null;		//sqlSession객체변수 선언
		try {
			// SqlSessionFactory 객체를 이용하여 SlqSession객체를 구한다.
			// ==> openSession()메서드를 이용한다.
			// 형식) SqlSessionFactory객체.openSession(논리값)
			//		'논리값'이 true이면 AutoCommit이 활성화된 상태이고
			//		'논리값'이 생략되거나 false이면 AutoCommit이 비활성화된 상태다.
			session = sqlSessionFactory.openSession();
			
			// SqlSession객체를 이용하여 처리할 SQL문을 호출하여 실행한다.
			// 형식) SqlSession객체.insert("namespace속성값.id속성값", 파라미터클래스)
			//		반환값 : 작업에 성공한 레코드 수
			int insertCnt = session.insert("lprod.insertLprod1",lvo1);
			
			if(insertCnt>0) {
				System.out.println("insert 작업성공");
				//SqlSession객체를 생성할 때 AutoCommit이 비활성화된 상태일 때에는
				//commit을 직접 실행해야 한다.
				session.commit();
			} else {
				System.out.println("insert 작업실패");
			}
		} finally {
			if(session!=null) session.close();
		}
		*/
		/*
		// 2-2 update 연습
		System.out.println("update 작업 시작...");
		
		System.out.print("수정할 Lprod_gu 입력 >>");
		String lprodGu = scan.next();
		
		System.out.print("새로운 Lprod_id >>");
		int lprodId = scan.nextInt();
		
		System.out.print("새로운 Lprod_nm >>");
		String lprodNm = scan.next();
		
		//VO객체 생성
		LprodVO lvo2 = new LprodVO();
		lvo2.setLprod_gu(lprodGu);
		lvo2.setLprod_id(lprodId);
		lvo2.setLprod_nm(lprodNm);
		
		//SqlSession 객체 변수 선언
		SqlSession session = null;
		try {
			//SqlSession객체 생성
			session = sqlSessionFactory.openSession();
			
			//SqlSession객체의 update()메서드를 이용해서 수정작업을 수행한다.
			//형식) SqlSession객체.update("namespace속성값.id속성값",파라미터클래스)
			//		반환값 : 작업에 성공한 레코드 수
			int updateCnt = session.update("lprod.updateLprod",lvo2);
			if(updateCnt>0) {
				System.out.println("update 작업 성공");
				session.commit();
			} else {
				System.out.println("update 작업 실패");
			}
		} finally {
			if(session!=null) session.close();
		}
		*/
		//---------------------------------------------------------------------
		/*
		//2-3 delete 작업
		System.out.println("delete 작업 시작");
		System.out.print("삭제할 Lprod_gu 입력 >>");
		String lprodGu3 = scan.next();
		
		//SqlSession 객체 변수 선언
		SqlSession session = null;
		try {
			//SqlSession객체 생성
			session = sqlSessionFactory.openSession();
			//SqlSession객체의 delete()메서드를 이용해서 수정작업을 수행한다.
			//형식) SqlSession객체.delete("namespace속성값.id속성값",파라미터클래스)
			//		반환값 : 작업에 성공한 레코드 수
			int deleteCnt = session.delete("lprod.deleteLprod",lprodGu3);
			if(deleteCnt>0) {
				System.out.println("delete 작업 성공");
				session.commit();
			} else {
				System.out.println("delete 작업 실패");
			}
		} finally {
			if(session!=null) session.close();
		}
		*/
		
		//-------------------------------------------------------------------
		
		//2-4 select 작업
		
		/*
		//1) 응답 결과가 여러개인 경우
		System.out.println("select 작업 시작");
		//SqlSession 객체 변수 선언
		SqlSession session = null;
		
		
		try {
			//SqlSession객체 생성
			session = sqlSessionFactory.openSession();
			//응답 결과가 여러개일 경우 selectList()메서드를 사용하는데,
			//이 메서드는 여러개의 레코드 각각을 VO객체에 담은 후 이 VO데이터를 List에 추가해주는
			//작업을 자동으로 수행한다.
			//형식) SqlSession객체.selectList("namespace속성값.id속성값",파라미터클래스)
			// 여기선 파라미터 클래스 값이 없다.
			// 데이터가 하나도 없으면 list.size() == 0 으로 출력된다.
			List<LprodVO> lprodList = session.selectList("lprod.getAlllprod");
			
			for(LprodVO lvo3 : lprodList) {
				System.out.println("ID : " + lvo3.getLprod_id());
				System.out.println("GU : " + lvo3.getLprod_gu());
				System.out.println("NM : " + lvo3.getLprod_nm());
				System.out.println("---------------------------");
			}
			System.out.println("출력 끝...");
		} finally {
			if(session!=null) session.close();
		}
		*/
		
		//2) 응답 결과값이 한개인 경우
		System.out.println("select 작업 시작 == 응답 결과가 1개인 경우");
		System.out.print("조회할 lprod_gu를 입력하세요 >> ");
		String lprodGu4 = scan.next();
		
		//Session 객체 변수 선언
		SqlSession session = null;
		try {
			//Session 객체 생성
			session = sqlSessionFactory.openSession();
			
			//응답 결과가 1개일 경우에는 selectOne()메서드를 사용한다.
			//형식) SqlSession객체.selectOne("namespace속성값.id속성값",파라미터클래스)
			//		반환값 : resultType속성에 지정한 데이터가 반환된다.
			//		검색한 데이터가 하나도 없으면 null을 반환한다.
			LprodVO lvo4 = session.selectOne("lprod.getLprod", lprodGu4);
			//출력
			if(lvo4==null) {
				System.out.println("검색한 데이터가 없습니다");
			} else {
				System.out.println("ID : " + lvo4.getLprod_id());
				System.out.println("GU : " + lvo4.getLprod_gu());
				System.out.println("NM : " + lvo4.getLprod_nm());
				System.out.println("---------------------------");
				System.out.println("출력 끝...");
			}
			
		} finally {
			if(session!=null) session.close();
		}
	}
}
