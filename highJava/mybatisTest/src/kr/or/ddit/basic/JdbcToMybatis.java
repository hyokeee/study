package kr.or.ddit.basic;

import java.io.InputStream;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.vo.LprodVO;

public class JdbcToMybatis {
	public static void main(String[] args) {
		//insert할 LprodVO 객체 선언
		LprodVO lVo = new LprodVO();
		
		
		//Jdbc예제 중 JdbcTest05.java를 Mybatis용으로 변환하시오.
		Scanner scan = new Scanner(System.in);
		
		//1. myBatis의 환경설정파일(mybatis-config.xml)을 읽어와서 실행한다.
		InputStream in =null;
		SqlSessionFactory sqlSessionFactory = null;
		try {
			//1-1. 환경설정파일을 읽어 올 스트림 객체 생성
			in = Resources.getResourceAsStream("kr/or/ddit/mybatis/config/mybatis-config.xml");
			
			//1-2. 환경 설정 파일을 읽어와 환경 설정을 완성한 후 SQL문을 호출해
			//		실행할 수 있는 객체를 생성할 수 있는 SqlSessionFactory객체를 생성한다.
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		} catch (Exception e) {
			System.out.println("myBatis 초기화 실패");
			e.printStackTrace();
		} finally {
			if(in!=null) try {in.close();}catch(Exception e) { };
		}
		//-------------------------------환경 설정 끝-------------------------------
		
		//작업 1)Lprod_id는 현재의 Lprod_id중에서 제일 큰 값보다 1 크게 한다.
		//값이 없을 때를 대비해 nvl사용 !
		System.out.println("lprod_id 값 중 제일 큰 값 출력작업 시작...");
		
		//Session 객체 변수 선언
		SqlSession session = null;
		try {
			//Session 객체 생성
			session = sqlSessionFactory.openSession();
			
			//반환 값이 max(*) 이므로 int로 받는다
			//반환 값이 한개이므로 selectOne, 파라미터클래스는 없음
			int maxValue = session.selectOne("jdbc.getMaxLprodId");
			System.out.println("현재 가장 큰 id값 : " + maxValue);
			System.out.println("입력될 id값 : " + (maxValue+1));
			maxValue++;
			
			
			//받은 maxValue 값에 1을 더해 VO 객체의 lprod_id값에 넣어준다.
			lVo.setLprod_id(maxValue);
		} finally {
			if(session!=null) session.close();
		}
		
		
		//작업2)입력 받은 lprod_gu가 이미 등록되어 있으면 다시 입력 받아서 처리한다.
		String inputGu = null; 	//scanner를 통해 입력할 lprod_gu 값이 저장될 변수
		int count = 0; 			//입력한 lprod_gu가 db에 저장된 개수
		
		do {
			System.out.print("lprod_gu 입력>>");
			inputGu = scan.nextLine();
			
			//select sql 문 실행
			try {
				//Session 객체 생성
				session = sqlSessionFactory.openSession();
				
				//반환 값이 count(*)이므로 int count로 받아준다.
				//반환 값이 한개이므로 selectOne() 사용
				//파라미터클래스 => String
				count = session.selectOne("jdbc.getCountLprodGu",inputGu);
				if(count>0) {
					System.out.println("입력한 상품 분류 코드 " + inputGu + "는 이미 등록된 코드입니다.");
					System.out.println("다시 입력하세요.");
				}
			} finally {
				if(session!=null) session.close();
			}
			
		} while(count>0);
		//do-while문을 빠져 나오면 lprod_gu값이 중복되지 않은 것이므로 VO 객체에 저장한다.
		lVo.setLprod_gu(inputGu);
		
		//작업3)상품 분류명(LPROD_NM) 입력 받아 DB에 INSERT하기
		System.out.print("lprod_nm 입력 >>");
		String inputNm = scan.nextLine();
		
		//입력 받은 inputNm을 VO객체에 저장한다.
		lVo.setLprod_nm(inputNm);
		
		//insert sql문 실행
		try {
			//Session 객체 생성
			session = sqlSessionFactory.openSession();
			
			// 형식) SqlSession객체.insert("namespace속성값.id속성값", 파라미터클래스)
			//		파라미터 클래스 ==> VO객체 lVo
			//		반환값 : 작업에 성공한 레코드 수
			int insertCnt = session.insert("jdbc.insertLprodVO",lVo);
			
			if(insertCnt>0) {
				System.out.println("insert 작업성공");
				//commit을 직접 실행해야 한다.
				session.commit();
			} else {
				System.out.println("insert 작업실패");
			}
			
		} finally {
			if(session!=null) session.close();
		}
		
	}
}
