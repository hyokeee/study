package kr.or.ddit.basic;

// 데몬스레드: 백그라운드에서 실행되는 스레드, 메인 스레드가 종료될 때 자동으로 종료


// 데몬스레드 연습 => 자동저장하는 스레드
public class ThreadTest08 {
   public static void main(String[] args) {
      AutoSaveThread autoSave = new AutoSaveThread();
      
      System.out.println("데몬스레드 여부: " + autoSave.isDaemon()); // true or false 리턴
      
      autoSave.setDaemon(true); // 데몬스레드로 설정하는 메소드 -> start() 메소드 전에 있어야 함
      autoSave.start();
      
      try {
         for(int i=1; i<=20; i++) {
            System.out.println(i);
            Thread.sleep(1000);
         }
      } catch (InterruptedException e) {
            // TODO: handle exception
      }
         
      System.out.println("main스레드 종료");
   }
}


// 자동저장하는 스레드 => 
class AutoSaveThread extends Thread {
   private void save() { // 저장하는 일을 처리하는 메소드
      System.out.println("작업 내용을 저장합니다");
   }
   
   @Override
   public void run() {
      while(true) {
      try {
         Thread.sleep(3000);            
      } catch (InterruptedException e) {
         // TODO: handle exception
      }
      
      save(); // 저장하는 메소드 호출
      }
   
   }
}