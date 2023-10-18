package kr.or.ddit.basic;

public class ThreadTest15 {
	public static void main(String[] args) {
		
		//공통으로 접근해서 사용하기때문에 메소드 실행 중 권한이 넘어가 20부터 출력되는 등
		//결과값이 이상하게 출력됨 ==> lock을 걸어 주어 한 메소드 진행동안
		//하나의 쓰레드만 접근가능하게 해주어야 한다. (synchronized)
		//th1 th2 순서가 바뀔 순 있어도 최종 결과는 잘 나온다. 
		ShareObject sObj = new ShareObject();
		TestThread th1 = new TestThread("Test1", sObj);
		TestThread th2 = new TestThread("Test2", sObj);
		
		th1.start();
		th2.start();
		
	}
}



// 공통으로 사용할 클래스
class ShareObject {
	private int sum = 0;
	
	//동기화 설정하기
	
//	public synchronized void add() { 	//방법 1 ==> 메서드 자체에 동기화 설정을 한다.
		public void add() { 
			
			synchronized (this) {	//방법2 ==> 동기화 블럭으로 동기화 설정을 한다.
				
				int n = sum;	
				
				n += 10;	
				
				sum= n;		
				
				System.out.println(Thread.currentThread().getName() + "합계 : " + sum);
			}
	}
}


// Test용 쓰레드
class TestThread extends Thread{
	private ShareObject sObj;
	
	//생성자
	public TestThread(String name, ShareObject sObj) {
		super(name);
		this.sObj = sObj;
	}
	
	@Override
	public void run() {
		for(int i = 0; i<=10; i++) {
			sObj.add();
		}
	}
}

