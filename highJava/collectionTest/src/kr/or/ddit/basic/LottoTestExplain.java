package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class LottoTestExplain {
	private Scanner scanner = new Scanner(System.in);
	
	//메인메소드
	public static void main(String[] args) {
		LottoTestExplain lotto = new LottoTestExplain();
		lotto.lottoStart();
	}

	//시작메소드
	public void lottoStart() {
		while(true) {
			int choice = displayMenu();
			switch(choice) {
				case 1:					//로또 구입
					buyLotto();
					break;
				case 2:					//종료
					System.out.println("감사합니다");
					return;
				default :				//1,2이외의 값
					System.out.println("번호를 잘못 선택했습니다. 다시 선택하세요.");
			}
		}
	}
	
	
	//로또 구입을 처리하는 메서드
	private void buyLotto() {
		System.out.println("\nLotto 구입 시작");
		System.out.println();
		System.out.println("(1000원에 로또번호 하나입니다.)");
		System.out.print("금액 입력 : ");
		int money = scanner.nextInt();
		
		if(money<1000) {
			System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!");
			return;
		} else if(money>=101000) {
			System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!");
			return;
		}
		
		//----------------------------------------------------------------
		HashSet<Integer> lottoSet = new HashSet<>();
		Random random = new Random();
		int count = money/1000;			//금액을 1000으로 나눈 몫 구하기(로또 구매 수)
		System.out.println();
		
		for(int i=1; i<=count; i++) {
			while(lottoSet.size()<6) {
				lottoSet.add(random.nextInt(45)+1);		//1 ~ 45사이의 난수를 만들어서 Set에 추가한다.
			}
			
			//Set의 데이터를 List에 넣어서 List객체 생성하기
			ArrayList<Integer> lottoList = new ArrayList<>(lottoSet);
			//List를 오름차순으로 정렬하기
			Collections.sort(lottoList);
			//정렬된 List를 출력
			System.out.println("로또번호 " + i + ": " + lottoList);		
			lottoSet.clear();      //한번의 작업이 끝나면 Set의 데이터를 비워준다.
		}
		System.out.println("받은 금액은 " + money + "원이고 거스름돈은 " + (money%1000) + "원 입니다.");
	}
	
	//메뉴를 출력하고 사용자가 선택한 메뉴 번호를 반환하는 메서드
	private int displayMenu() {
		System.out.println("\n==========================");
	    System.out.println("       Lotto 프로그램");
	    System.out.println("--------------------------");
	    System.out.println("	1. Lotto 구입");
	    System.out.println("	2. 프로그램 종료");
	    System.out.println("==========================");
	    System.out.print("메뉴선택 : ");
	    return scanner.nextInt();
	}
	
}