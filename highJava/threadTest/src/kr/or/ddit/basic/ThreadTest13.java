package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/*
	10마리의 말들이 경주하는 경마 프로그램 작성하기
	
	말은 Horse라는 이름의 클래스로 구성하고,
	이 클래스는 말이름(String), 현재위치(int), 등수(int)를 멤버변수로 갖는다.
	그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는
	기능이 있다.( Comparable 인터페이스 구현)
	
	경기 구간은 1~50구간으로 되어 있다.
	
	경기 중 중간 중간에 각 말들의 위치를 나타내시오.
	예)
	1번말 --->------------------------------------
	2번말 ----->----------------------------------
	...
	
	경기가 끝나면 등수 순으로 출력한다.
*/
public class ThreadTest13 {
	public static int rank = 1;
	public static void main(String[] args) {
		// horse 객체 10개 생성
		int arraySize = 3;
		ArrayList<Horse> hList = new ArrayList<>();

		for (int i = 0; i < arraySize; i++) {
			String name = i + 1 + "번 말";
			hList.add(new Horse(name));
		}

		// horse 객체 10개 쓰레드 시작
		for (Horse th : hList) {
			th.start();
		}

		// join
		for (Horse th : hList) {
			try {
				th.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		Collections.sort(hList);
		System.out.println("----우승한 말은----");
		System.out.println("축하합니다!!!");
		System.out.println(hList.get(0)+"입니다!!");

	}
}

class Horse extends Thread implements Comparable<Horse> {
	private String horsename;
	private int position;
	private int grade;

	// 생성자
	public Horse(String horsename) {
		this.horsename = horsename;
	}

	public Horse() {

	}

	public String getHorsename() {
		return horsename;
	}

	public void setHorsename(String horsename) {
		this.horsename = horsename;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return grade + "등 " + horsename;
	}

	// 내부정렬기준
	@Override
	public int compareTo(Horse o) {
		if(this.grade>o.getGrade()) {
			return 1;
		} else {
			return -1;
		}
	}

	// 쓰레드 run override
	@Override
	public void run() {
		for (int i = 1; i <= 50; i++) {
			Random rnd = new Random();
			setPosition(i);
			System.out.print(horsename);
			for (int j = 1; j <= i; j++) {
				System.out.print("-");
				if(i==j) {
					System.out.print(">");					
				}
			}
			for (int j = 1; j < 50 - i; j++) {
				System.out.print("-");
			}
			System.out.println(" (위치 "+getPosition()+"지점)");
		
			try {
				Thread.sleep(rnd.nextInt(400));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		} // for문 끝..
		System.out.println(horsename + "완주");
		setGrade(ThreadTest13.rank);
		ThreadTest13.rank++;
	}

}
