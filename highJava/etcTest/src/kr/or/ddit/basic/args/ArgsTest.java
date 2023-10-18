package kr.or.ddit.basic.args;

public class ArgsTest {
	
	/*
	  가변형인수==> 메서드의 인수의 개수가 메서드를 호출할 때마다 다를 수 있을 때 사용한다.
	  
	  - 가변형 인수는 메서드 안에서는 배열로 처리된다.
	  - 가변형 인수는 한가지 자료형만 사용할 수 있다.
	  
	 */
	
	
	
	
	//매개변수로 받은 정수들의 합계를 구하는 매서드 만들기
	// ( 이 정수들의 갯수는 상황에 따라 다르다.)
	
	//배열을 이용한 메서드
	public int sumArr(int[] data) {
		int sum=0;
		for(int i=0; i<data.length; i++) {
			sum += data[i];
		}
		return sum;
	}

	
	//가변형 인수를 이용한 메서드
	public int sumArg(int...data) {
		int sum=0;
		for(int i=0; i<data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
	
	
	
	//가변형 인수와 일반적인 인수를 같이 사용할 경우에는 가변형 인수를 제일 뒤쪽에 배치해야 한다.
	public String sumArg2(String name, int...data) {
		int sum=0;
		for(int i=0; i<data.length; i++) {
			sum += data[i];
		}
		return name+ "씨의 합계 : " + sum;
	}
	
	public static void main(String[] args) {
		ArgsTest at = new ArgsTest();
		//2,"일지매" / 3,"이순신" 즉, 매개 변수에 들어가는 값을 인수라 한다.
//		at.test01(2, "일지매");
//		System.out.println("----------------");
//		at.test01(3,"이순신");
		
		//1,2,3,4,5 를 sumArr() 메서드에 전달해서 결과를 출력하시오.
		//배열초기화 방법 두가지
//		int[] a;
//		a= {1,2,3,4,5};
		int[] a2;
		a2 = new int[] {1,2,3,4,5};
		//둘의 차이점 : 바로 변수를 만들고 초기화 할 때에는 차이가 없다.
		//첫번쨰 방법은 배열을 선언함과 동시에 초기화하고 싶을 때만 사용가능
		//두번째 방법은 선언 해놓고 이후에 초기화 할 수 있다.
		int result = at.sumArr(a2);
		System.out.println(result);
		
		//100 ,200 ,300 ,400
//		System.out.println(at.sumArr({100,200,300,400,500})); //x
		System.out.println(at.sumArr(new int[]{100,200,300,400,500})); //o
		System.out.println("---------------------------------");
		
		//가변형 인수 데이터 출력
		System.out.println(at.sumArg(1,2,3,4,5));
		System.out.println(at.sumArg(100,200,300,400));
		System.out.println("---------------------------------");
		
		System.out.println(at.sumArg2("홍길동", 30,60,90));
		
		
	}
	//int a , String str = 매개변수
	public void test01(int a, String str) {
		System.out.println("a = " + a);
		System.out.println("str = " + str);
	}
	
	public int test02(int a, int b,int c) {
		return a+b+c;
	}
}
