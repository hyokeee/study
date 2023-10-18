package kr.or.ddit.basic.singleton;

public class SingletonTest {
	public static void main(String[] args) {
		//MySingleton test1 = new MySingleton();
		
		//객체 생성은 getInstance() 메서드를 호출해서 생성한다.
		MySingleton test2 = MySingleton.getInstance();
		MySingleton test3 = MySingleton.getInstance();
		
		System.out.println("test2 => " + test2.toString());
		System.out.println("test3 => " + test3);
		System.out.println();
		System.out.println(test2==test3);
		test2.displayTest();
	}
}
