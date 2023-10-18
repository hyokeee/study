package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class LottoTest {
   public static void main(String[] args) {
      //Scanner, Random 생성
      Scanner scanner = new Scanner(System.in);
      Random random = new Random();
      HashSet<Integer> lottoSet = new HashSet<>();
      boolean loop = true;
      //프로그램 화면
      while(loop) {
      System.out.println("\n==========================");
      System.out.println("       Lotto 프로그램");
      System.out.println("--------------------------");
      System.out.println("1. Lotto 구입");
      System.out.println("2. 프로그램 종료");
      System.out.println("==========================");
      System.out.print("메뉴선택 : ");
      int selectNum = scanner.nextInt();
      
      //메뉴선택 switch문 생성
      switch(selectNum) {
      case 1:
         System.out.println("Lotto 구입 시작");
         System.out.println();
         System.out.println("(1000원에 로또번호 하나입니다.)");
         System.out.print("금액 입력 : ");
         int price = scanner.nextInt();
         if(price<1000) {
            System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!");
         } else if(price>101000) {
            System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!");
         } else {
            System.out.println("행운의 로또번호는 아래와 같습니다.");
            for(int i = 1; i<= price/1000; i++) {
               //로또 번호 출력
               while(lottoSet.size()<6) {
               lottoSet.add(random.nextInt(45)+1);
               }
               ArrayList<Integer> lottoList = new ArrayList<>(lottoSet);
               Collections.sort(lottoList);
               System.out.println("로또번호" + i + " : " + lottoList);
               lottoSet.clear();
            }
            System.out.println("받은 금액은 "+price+"원이고 거스름돈은"+price%1000+"원입니다.");   
         }
         loop = true;
         break;
      case 2:
         System.out.println("감사합니다.");
         loop = false;
         break;
      default:
    	 System.out.println("번호를 잘못 입력하셨습니다.");
      }
   }
}
}