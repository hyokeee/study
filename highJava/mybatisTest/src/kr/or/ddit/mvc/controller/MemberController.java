package kr.or.ddit.mvc.controller;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.mvc.service.IMemberService;
import kr.or.ddit.mvc.service.MemberServiceImpl;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemberController {
   private IMemberService service; // Service객체 변수 선언
   private Scanner scan;

   // 생성자
   public MemberController() {
      scan = new Scanner(System.in);
      service = MemberServiceImpl.getinstance();
   }

   public static void main(String[] args) {
      new MemberController().memberStart();

   }

   // 시작 메서드
   public void memberStart() {
      while (true) {
         int choice = displayMenu();
         switch (choice) {
         case 1: // 추가
            insertMember();
            break;

         case 2: // 삭제
            deleteMember();
            break;

         case 3: // 수정
            updateMember();
            break;

         case 4: // 전체 출력
            displayAll();
            break;

         case 5: // 자료 수정2 ==> 원하는 항목만 수정하기
            updateMember2();
            break;

         case 0: // 종료
            System.out.println();
            System.out.println("작업을 마칩니다...");
            return;
         default:
            System.out.println();
            System.out.println("잘못 입력하셨습니다.");
            System.out.println("다시 입력하세요.");
         }
      }
   }

   // 회원 정보를 추가하는 메서드
   private void insertMember() {
      System.out.println();
      System.out.println("추가할 회원 정보를 입력하세요...");

      String memId = null; // 회원 ID 가 저장될 변수
      int count = 0;
      do {
         System.out.print("ID입력>> ");
         memId = scan.next();
         count = service.getMemberCount(memId);
         if (count > 0) {
            System.out.println(memId + "은(는) 이미 등록된 회원ID입니다.");
            System.out.println("다른 회원ID를 입력하세요");
         }
      } while (count > 0);
      System.out.print("비밀번호 >> ");
      String memPass = scan.next();

      System.out.print("회원이름 >> ");
      String memName = scan.next();

      System.out.print("전화번호 >> ");
      String memTel = scan.next();

      scan.nextLine(); // nextLine() 쓰기 전에 다른걸 쓰면, 버퍼 비우기를 먼저 해줘야 한다.
      System.out.print("회원주소 >> ");
      String memAddr = scan.nextLine();

      // 입력 받은 자료를 VO객체에 저장한다.
      MemberVO memVo = new MemberVO();
      memVo.setMem_id(memId);
      memVo.setMem_pass(memPass);
      memVo.setMem_name(memName);
      memVo.setMem_tel(memTel);
      memVo.setMem_addr(memAddr);

      // Service에 일을 시켜서 자료를 DB에 insert한다.
      int cnt = service.insertMember(memVo);

      if (cnt > 0) {
         System.out.println("insert 성공!!!");
      } else {
         System.out.println("insert 실패!!!");
      }

   }

   // 삭제
   private void deleteMember() {
      System.out.println();
      System.out.println("삭제할 회원 정보를 입력하세요...");
      System.out.print("삭제할 ID입력>> ");
      String memId = scan.next();

      // Service에 일을 시켜서 자료를 DB에서 delete 한다.
      int cnt = service.deleteMember(memId);

      if (cnt > 0) {
         System.out.println("delete 성공!!!");
      } else {
         System.out.println("delete 실패!!!");
      }
   }

   // 수정
   private void updateMember() {
      System.out.println();
      System.out.println("수정할 회원 정보를 입력하세요...");
      System.out.print("수정할 ID입력>> ");
      String memId = scan.next();
      int count = service.getMemberCount(memId);
      if (count == 0) {
         System.out.println(memId + " 는 없는 회원입니다.");
         System.out.println("수정 작업을 종료합니다.");
         return;
      }
      System.out.print("새로운 회원 비밀번호 >> ");
      String newMemPass = scan.next();
      System.out.print("새로운 회원 이름 >> ");
      String newMemName = scan.next();
      System.out.print("새로운 회원 전화번호 >> ");
      String newMemTel = scan.next();
      scan.nextLine(); // 입력 법퍼 비우기
      System.out.print("새로운 회원 주소>> ");
      String newMemAddr = scan.nextLine();

      MemberVO memVo = new MemberVO();
      memVo.setMem_id(memId);
      memVo.setMem_pass(newMemPass);
      memVo.setMem_name(newMemName);
      memVo.setMem_tel(newMemTel);
      memVo.setMem_addr(newMemAddr);

      // Service에 일을 시켜서 자료를 DB에서 update 한다.
      int cnt = service.updateMember(memVo);

      if (cnt > 0) {
         System.out.println("update 성공!!!");
      } else {
         System.out.println("update 실패!!!");
      }
   }
   //수정2
   private void updateMember2() {
	   System.out.println();
		
		System.out.println("수정할 회원 정보를 입력하세요...");
		System.out.print("수정할 ID입력>> ");
		String memId = scan.next();
		int count = service.getMemberCount(memId);
		if(count==0) {
			System.out.println(memId + " 는 없는 회원입니다.");
			System.out.println("수정 작업을 종료합니다.");
			return;
		}
		
		int num;	//수정을 원하는 항목의 선택 번호가 저장될 변수
		String updateField = null;	//수정할 컬럼명이 저장될 변수
		String updateTitle = null;	//입력할 때 보여줄 제목
		
		do {
			System.out.println();
			System.out.println("수정할 항목을 선택하세요....");
			System.out.println("1.비밀번호   2.회원이름   3.전화번호   4.회원주소");
			System.out.println("-----------------------------------------");
			System.out.print("수정할 항목 선택 >> ");
			
			try {
				num = scan.nextInt();
			}catch(InputMismatchException e) {
				num = -1;
				scan.nextLine(); // 버퍼 비우기
			}
			
			switch(num) {
			case 1:
				updateField = "mem_pass";
				updateTitle = "비밀번호";
				break;
			case 2:
				updateField = "mem_name";
				updateTitle = "회원이름";
				break;
			case 3:
				updateField = "mem_tel";
				updateTitle = "전화번호";
				break;
			case 4:
				updateField = "mem_addr";
				updateTitle = "회원주소";
				break;
			default :
				System.out.println("다시 입력하세요.");
			
				
			
			}
		}while(num<1||num>4);
		scan.nextLine();		//스캐너 비우기
		System.out.println();
		System.out.print("수정할 " + updateTitle + ">> ");
		String updateData = scan.nextLine();
		
		//수정할 정보를 Map에 추가한다.
		//key값 정보 ==> 회원ID(memid), 수정할 컬럼명(field), 수정할 데이터(data)
		Map<String,String> memMap = new HashMap<>();	//Map객체 생성
		memMap.put("memid", memId);						//회원 ID셋팅
		memMap.put("field", updateField);				//수정할 컬럼명 셋팅
		memMap.put("data", updateData);	
		//수정할 데이터 셋팅
		int cnt = service.updateMember2(memMap);
		
		if (cnt > 0) {
	         System.out.println("update 성공!!!");
	      } else {
	         System.out.println("update 실패!!!");
	      }
   }
   // 전체 출력
   private void displayAll() {
      System.out.println();
      System.out.println("--------------------------------------");
      System.out.println("ID    비밀번호    이  름    전화번호    주소");
      System.out.println("--------------------------------------");
      
      // 전체 회원 목록을 가져온다.
      List<MemberVO> memList = service.getAllMember();
      
      if(memList==null||memList.size()==0) {
         System.out.println("회원 목록이 하나도 없습니다.");
      }
      //List의 데이터 개수만큼 반복해서 데이터를 출력한다.
//      for(int i =0; i<memList.size();i++) {
//         System.out.print(memList.get(i).getMem_id()+"    ");
//         System.out.print(memList.get(i).getMem_pass()+"    ");
//         System.out.print(memList.get(i).getMem_name()+"    ");
//         System.out.print(memList.get(i).getMem_tel()+"    ");
//         System.out.print(memList.get(i).getMem_addr()+"    ");
//         System.out.println();
//      }
      for(MemberVO memVo : memList) {
         System.out.println(memVo.getMem_id()+"     " + memVo.getMem_pass()
         +"     " +memVo.getMem_name()+"     " +memVo.getMem_tel()+"     " +memVo.getMem_addr());
      }
   }

   // 메뉴를 출력하고 작업번호를 입력받아 반환하는 메서드
   private int displayMenu() {
      System.out.println();
      System.out.println("------------------------");
      System.out.println("  1. 자료 추가");
      System.out.println("  2. 자료 삭제");
      System.out.println("  3. 자료 수정");
      System.out.println("  4. 전체 자료 출력");
      System.out.println("  5. 자료 수정2"); // 원하는 항목 1개만 수정하기
      System.out.println("  0. 프로그램 종료");
      System.out.println("------------------------");
      System.out.print(" 원하는 작업 선택 >> ");
      return scan.nextInt();
   }
}