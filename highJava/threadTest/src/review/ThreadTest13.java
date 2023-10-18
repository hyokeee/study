package review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ThreadTest13 {
	public static int rank = 1;

	public static void main(String[] args) {
		// horse 객체 10개 생성
		int arraySize = 10;
		ArrayList<Horse> hList = new ArrayList<>();

		for (int i = 0; i < arraySize; i++) {
			String name = i + 1 + "번 말";
			hList.add(new Horse(name));
		}
		// 쓰레드 시작
		for (Horse th : hList) {
			th.start();
		}

		// 출력화면
		boolean finish = true;
		while (finish) {
			System.out.println("**********************************************************");
			for (int i = 0; i < hList.size(); i++) {
				System.out.print(hList.get(i).getHorsename() + " :  ");
				for (int j = 1; j <= 50; j++) {
					if (hList.get(i).getPosition() == j) {
						System.out.print(">");
						continue;
					}
					System.out.print("-");
				}
			
				System.out.println();
				if(hList.get(i).getPosition()==50&&hList.get(i).getGrade()==10){
					finish = false;
				}
				if (!finish) {
					break;
				}
				
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			System.out.println("**********************************************************");
		}
		//쓰레드 종료
		for (Horse th : hList) {
			try {
				th.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Collections.sort(hList);
		System.out.println("--------결과창----------");
		for(int i=0; i<10; i++) {
			System.out.println("***" +(i+1) + "등***");
			System.out.println(hList.get(i).getHorsename());
		}
		
		

	}
}

class Horse extends Thread implements Comparable<Horse> {
	private String horsename;
	private int position;
	private int grade;

	public Horse(String horsename) {
		super();
		this.horsename = horsename;
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
	public int compareTo(Horse o) {
		if (this.grade > o.getGrade()) {
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public String toString() {
		return getGrade() + "등 " + horsename;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 50; i++) {
			Random rnd = new Random();
			setPosition(i);
			try {
				Thread.sleep(rnd.nextInt(300));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
		}
//		System.out.println(horsename+"도착");
		setGrade(ThreadTest13.rank);
		ThreadTest13.rank++;
//		System.out.println(getGrade());
	}

}