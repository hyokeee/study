package kr.or.ddit.basic;

import java.util.Random;

import javax.swing.JOptionPane;

/*
 	컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
 	
 	컴퓨터의 가위 바위 보는 난수를 이용해서 구하고
 	사용자의 입력은  showInputDialog()매서드를 이용해서 입력받는다.
 	
 	입력시간은 5초로 제한하고 카운트다운을 진행한다.
 	5초 안에 입력이 없으면 게임에 진 것으로 처리한다.
 	
 	5초 안에 입력이 완료되면 승패를 구해서 결과를 출력한다.
  	
  	결과 예시 1) ==> 5초 안에 입력을 못했을 경우
  		-- 결  과 --
  	시간 초과로 당신이 졌습니다.
  	
  	결과 예시 2) ==> 5초 안에 입력이 완료되었을 경우
  	 	-- 결  과 --
  	 	컴퓨터 : 가위
  	 	사용자 : 바위
  	 	결 과 : 당신이 이겼습니다.
 */
public class ThreadTest07 {
	public static void main(String[] args) {
		Thread th1 = new ChoiceInput();
		Thread th2 = new CountDown2();
		//입력, 카운트다운 메서드 시작
		th1.start();
		th2.start();
		//메서드 종료 기다리기
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//난수 생성(3개)
		Random rd = new Random();
		int com = rd.nextInt(3);
		String computer = null;
		// 컴퓨터 0 : 가위 , 1 : 바위, 2 : 보 로 가정한다
		if (com == 0) {
			computer = "가위";
		} else if (com == 1) {
			computer = "바위";
		} else if (com == 2) {
			computer = "보";
		}
		// 내가 입력한 값을 받는 me 변수
		String me = ChoiceInput.str;
		// 결과 비교if절
		// 비길 시
		if (computer.equals(me)) {
			System.out.println("--------- 결과 ---------");
			System.out.println("컴퓨터 : " + computer);
			System.out.println("사용자 : " + me);
			System.out.println("결 과 : 비겼습니다.");
			try {
				th1.join();
				th2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		// 컴퓨터 승리시
		} else if (computer.equals("가위") && me.equals("보")
				|| computer.equals("바위") && me.equals("가위")
				|| computer.equals("보") && me.equals("바위")) {
			System.out.println("--------- 결과 ---------");
			System.out.println("컴퓨터 : " + computer);
			System.out.println("사용자 : " + me);
			System.out.println("결 과 : 당신이 졌습니다..");
		// 사용자 승리 시
		} else if (computer.equals("가위") && me.equals("바위")
				|| computer.equals("바위") && me.equals("보")
				|| computer.equals("보") && me.equals("가위")) {
			System.out.println("--------- 결과 ---------");
			System.out.println("컴퓨터 : " + computer);
			System.out.println("사용자 : " + me);
			System.out.println("결 과 : 당신이 이겼습니다..");
		} else {
			System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
		}
	}
}

//입력 쓰레드
class ChoiceInput extends Thread {
	public static boolean checkInput = false;
	public static String str = null;

	@Override
	public void run() {
		str = JOptionPane.showInputDialog("입력하세요");

		checkInput = true;

	}
}

//카운트다운 쓰레드
class CountDown2 extends Thread {

	@Override
	public void run() {
		for (int i = 5; i >= 1; i--) {
			if (ChoiceInput.checkInput) {
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		System.out.println("--------- 결과 ---------");
		System.out.println("시간 초과로 당신이 졌습니다..");
		System.exit(0);
	}
}
