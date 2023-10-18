package kr.or.ddit.basic;

import java.util.Random;

import javax.swing.JOptionPane;

public class ThreadTest07Explain {
	public static boolean inputCheck;
	public static void main(String[] args) {
		GameCount counter = new GameCount();
		
		// 난수를 이용해서 컴퓨터의 가위 바위 보 정하기
		String[] data = {"가위","바위","보"};
		Random rnd = new Random();
		int index = rnd.nextInt(3); //0~2사이의 난수 만들기
		String com =  data[index];	// 컴퓨터의 가위 바위 보 정하기
		
		//사용자의 가위 바위 보 입력 받기
		counter.start();
		
		String man = null;
		do {
			man = JOptionPane.showInputDialog("가위 바위 보를 입력하세요..");
		} while( !("가위".equals(man)||"바위".equals(man)||"보".equals(man)));
		
		inputCheck = true;
		
		//결과 판정하기
		String result = "";		//판정 결과가 저장될 변수
		
//		if문으로 처리하기
//		if(com.equals(man)) {
//			result = "비겼습니다...";
//		} else if(com.equals("가위") && man.equals("바위")
//				|| com.equals("바위") && man.equals("보")
//				|| com.equals("보") && man.equals("가위")) {
//			result = "사용자가 이겼습니다...";
//		} else {
//			result = "사용자가 졌습니다...";
//		}
	
//		switch문으로 처리하기
		switch(man + com) {
		case "가위가위":
		case "바위바위":
		case "보보":		result = "비겼습니다..."; break;
		
		case "가위보":
		case "바위가위":
		case "보바위":	result = "사용자가 이겼습니다..."; break;
		
		default:		result = "사용자가 졌습니다..."; break;
		}
		
		//결과 출력하기
		System.out.println("--------- 결과 ---------");
		System.out.println("컴퓨터 : " + com);
		System.out.println("사용자 : " + man);
		System.out.println("결 과 : " + result);
	}
}

class GameCount extends Thread{
	@Override
	public void run() {
		System.out.println("카운트 다운 시작..");
		
		for(int i = 5; i>=1; i--) {
			
			if(ThreadTest07Explain.inputCheck==true) {
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		System.out.println("- - - - - 결과 - - - - -");
		System.out.println("시간 초과로 당신이 졌습니다.");
		System.exit(0);
	}
	
}
