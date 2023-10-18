package kr.or.ddit.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

//경마 프로그램
public class ThreadTest13Explain {
	public static void main(String[] args) {
//10마리 말 저장
		Horse1[] horsesArr = new Horse1[] {
				new Horse1("01번말"),
				new Horse1("02번말"),
				new Horse1("03번말"),
				new Horse1("04번말"),
				new Horse1("05번말"),
				new Horse1("06번말"),
				new Horse1("07번말"),
				new Horse1("08번말"),
				new Horse1("09번말"),
				new Horse1("10번말")
		};
		
		GameStatePrint gsp = new GameStatePrint(horsesArr);
		
		//말들의 경주 시작
		for(Horse1 h : horsesArr) {
			h.start();
		}
		//말들의 경주 상태 출력하는 쓰레드 시작
		gsp.start();
		
		//경주 쓰레드 종료
		for(Horse1 h : horsesArr) {
			try {
				h.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		//경주 상태 출력 쓰레드 종료
		try {
			gsp.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		System.out.println();
		System.out.println("경기 끝...");
		System.out.println("경기 결과");
		
		//등수의 오름차순으로 정렬
		Arrays.sort(horsesArr);
		
		for(Horse1 h : horsesArr) {
			System.out.println(h);
		}
	}
}

class Horse1 extends Thread implements Comparable<Horse1>{
	public static int currentRank = 0;		//말들의 등수를 정할 변수
	
	private String horseName;	//말 이름
	private int location;		//현재 위치
	private int rank;			//등수
	
	//생성자 (말 이름만 초기화)
	public Horse1(String horseName) {
		super();
		this.horseName = horseName;
	}

	String getHorseName() {
		return horseName;
	}

	void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	int getLocation() {
		return location;
	}

	void setLocation(int location) {
		this.location = location;
	}

	int getRank() {
		return rank;
	}

	void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "경주마" + horseName + "의 등수는 " + rank + "등 입니다.";
	}
	
	//등수의 오름차순으로 처리할 내부 정렬 기준
	@Override
	public int compareTo(Horse1 horse) {
		return Integer.compare(rank, horse.rank);
	}
	
	
	//말이 달리는 것을 쓰레드로 처리한다.
	@Override
	public void run() {
		Random rnd = new Random();
		for(int i=1; i<=50; i++) {
			this.location = i;	//말의 현재 위치를 구한다.
			
			try {
				Thread.sleep(rnd.nextInt(500));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
		}//for문이 끝나면
		
		//한 마리의 말이 경주가 끝나면 등수를 구해서 저장한다.
		currentRank++;
		this.rank = currentRank;
	}
}

//경기 중간 각 말들의 현재 위치를 나타내는 쓰레드
class GameStatePrint extends Thread{
	private Horse1[] horseArr;
	
	//생성자
	public GameStatePrint(Horse1[] horseArr) {
		this.horseArr = horseArr;
	}
	 
	@Override
	public void run() {
		while(true) {
			//모든 말들의 경기가 종료되었는지 여부 검사하기
			if(Horse1.currentRank == horseArr.length) {
				break;
			}
			
			//빈 줄 출력하기
			for(int i=1; i<=10; i++) {
				System.out.println();
			}
			for(int i = 0; i<horseArr.length; i++) {
				System.out.print(horseArr[i].getHorseName()+ " : ");
				
				for(int j=1; j<=50; j++) {
					//말의 현재 위치를 찾아서 ">"문자로 나타낸다.
					if(horseArr[i].getLocation()==j) {
						System.out.print(">");
					} else {
						System.out.print("-");
					}
				}
				System.out.println();	//줄바꿈
			}
			//딜레이를 줌
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}



