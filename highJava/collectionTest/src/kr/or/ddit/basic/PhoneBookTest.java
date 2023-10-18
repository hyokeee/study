package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookTest {
  private static Scanner scanner;
  private static HashMap<String,Phone> phoneBook = new HashMap<>();
   
   
   public static void main(String[] args) {
      PhoneBookTest phoneBookTest = new PhoneBookTest();
      phoneBookTest.start();
   }
   
   //시작메소드
   public void start() {
      while(true) {
         int choiceMenu = menu();
         switch(choiceMenu) {
         case 1:
            register();
            break;         
         case 2:
        	modifyPhoneNumber();
            break;
         case 3:
        	removePhoneNumber();
            break;
         case 4:
        	 searchPhoneNumber();
            break;
         case 5:
            printPhoneNumber();
            break;
         case 0:
            System.out.println("프로그램을 종료합니다.");
            return;
         default:
            System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
            break;
         }      
      }
   }
   
   //메뉴 출력 화면
   public int menu() {
      scanner = new Scanner(System.in);
      System.out.println();
      System.out.println("    메뉴");
      System.out.println("1. 전화번호 등록");
      System.out.println("2. 전화번호 수정");
      System.out.println("3. 전화번호 삭제");
      System.out.println("4. 전화번호 검색");
      System.out.println("5. 전화번호 전체 출력");
      System.out.println("0. 프로그램 종료");
      System.out.println("--------------");
      System.out.print("번호 입력 >>");
      return scanner.nextInt();
   }
   
   //전화번호 등록
   public void register() {
      scanner.nextLine();
      Phone p1 = new Phone();
      System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
      System.out.print("이름 >> ");
      String name = scanner.nextLine();
      p1.setName(name);
      if(!phoneBook.containsKey(name)) {
         phoneBook.put(p1.getName(), p1);   
         System.out.print("전화번호 >>");
         p1.setTel(scanner.nextLine());
         System.out.print("주소 >> ");
         p1.setAddr(scanner.nextLine());
         phoneBook.put(p1.getName(),p1);
         System.out.println();
         System.out.println("'"+p1.getName()+"'"+"전화번호 등록 완료!!");
         System.out.println(phoneBook);
      } else {
         System.out.println(p1.getName() + "은 이미 등록된 사람입니다.");
      }
   }
   
   //전화번호 전체 출력 매서드
   public void printPhoneNumber(){
      Set<String> keySet = phoneBook.keySet();
      System.out.println("----------------------------------------");
      System.out.println("번호\t이름\t전화번호\t주소");
      System.out.println("----------------------------------------");
      Iterator<String> it = keySet.iterator();
      int num = 1;
      while(it.hasNext()) {
         String key = it.next();      // 'key값' 구하기
         Phone value = phoneBook.get(key);      
         System.out.println(num + "      " + value.getName()+ "      " + value.getTel()+ "      " + value.getAddr());
         num++;
      }
      System.out.println("----------------------------------------");
      System.out.println("출력끝..");
   }
   
   //전화번호 수정 메서드
   public void modifyPhoneNumber() {
	   scanner = new Scanner(System.in);
	   System.out.println("전화번호를 수정할 사람의 이름을 입력하세요.");
	      System.out.print("이름 >> ");
	      String name = scanner.nextLine();
	      if(phoneBook.get(name)!=null) {
	    	  System.out.println("현재 전화번호 : " + phoneBook.get(name).getTel());
	    	  System.out.println("수정할 전화번호를 입력하세요>>.");
	    	  phoneBook.get(name).setTel(scanner.nextLine());
	    	  System.out.println("수정이 완료되었습니다.");
	      } else {
	    	  System.out.println("해당하는 정보가 없습니다.");
	      }
   }
   
   //전화번호 삭제 메서드
   public void removePhoneNumber() {
	   scanner = new Scanner(System.in);
	   System.out.println("전화번호를 삭제할 사람의 이름을 입력하세요.");
	   System.out.print("이름 >> ");
	   String name = scanner.nextLine();
	   if(phoneBook.get(name)!=null) {
		   Phone removeTel = phoneBook.remove(name);
		   System.out.println(removeTel.getName() + "의 정보가 삭제되었습니다.");
	   }else {
	    	  System.out.println("해당하는 정보가 없습니다.");
	      }
	   
   }
   
   //전화번호 검색 메서드
   public void searchPhoneNumber() {
	   scanner.nextLine();
	   System.out.println("전화번호를 검색할 사람의 이름을 입력하세요.");
	   System.out.print("이름 >> ");
	   String name = scanner.nextLine();
	   if(phoneBook.get(name)!=null) {
		   System.out.println(phoneBook.get(name).getName()+"님의 전화번호는 "+phoneBook.get(name).getTel()+"입니다.");
	   } else {
		   System.out.println("해당하는 정보가 없습니다.");
	   }
   }
}
//Phone 클래스
class Phone{
   private String name;
   private String tel;
   private String addr;
   
   
   
   //기본생성자
   public Phone() {
      
   }
   //key입력용 생성자
   public Phone(String name) {
      this.name = name;
   }
   
   //전체 값 생성자
   public Phone(String name, String tel, String addr) {
      this.name = name;
      this.addr = addr;
      this.tel = tel;
   }
   
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getAddr() {
      return addr;
   }
   public void setAddr(String addr) {
      this.addr = addr;
   }
   public String getTel() {
      return tel;
   }
   public void setTel(String tel) {
      this.tel = tel;
   }
   
   @Override
   public String toString() {
      return "Phone [name=" + name + ", addr=" + addr + ", tel=" + tel + "]";
   }
   
   
}