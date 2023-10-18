package kr.or.ddit.basic.generic;

//제네릭을 적용하지 않은 class작성
class NonGeneric{
	private Object value;
	
	public Object getValue() {
		return value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}
}

/*
 제네릭을 적용한 클래스 만드는 방법
 형식) 
 	class 클래스명<제네릭타입글자>{
 		private 제네릭타입글자 변수명;		//변수 선언에 제네릭을 사용한 경우
 		...
 		
 		public 제네릭타입글자 메서드명(매개변수들...){	//반환값이 있는 메서드에서 제네릭을 사용한 경우
 			...
 			return 반환값;
 		}
 		
 		public void 메서드명(제네릭타입글자 변수명){	//메서드의 매개변수에 제네릭을 사용한 경우
 			...
 		}
 		
 	}	
 	
 	//제네릭타입글자 ==> 영문자 대문자 1글자로 표기한다.
 	 T ==> Type
 	 K ==> Key
 	 V ==> Value
 	 E ==> Element 
 	
 	
 	
 
 */


//제네릭을 적용한 class작성
class MyGeneric<T>{
	private T value;
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return this.value;
	}
}



public class GenericTest {

	public static void main(String[] args) {
		NonGeneric ng1 = new NonGeneric();
		ng1.setValue("가나다라");
		
		NonGeneric ng2 = new NonGeneric();
		ng2.setValue(123);
		
		String temp1 = (String)ng1.getValue(); //Object타입으로 들어가므로 형변환이 필수.
		System.out.println("temp1 = " + temp1);
		
		int temp2 = (int)ng2.getValue();
		System.out.println("temp2 = " + temp2);
		
		MyGeneric<String> mg1 = new MyGeneric<>();
		mg1.setValue("안녕하세요");
		//mg1.setValue(123);
		
		MyGeneric<Integer> mg2 = new MyGeneric<>();
		mg2.setValue(100);
		
		String temp3 = mg1.getValue(); //형변환없이 데이터를 꺼내올 수 있다.
		int intTemp = mg2.getValue();  
		System.out.println("temp3 : " + temp3);
		System.out.println("intTemp : " + intTemp);
		
		
		NonGeneric test = new NonGeneric();
		test.setValue("123");
		
		int a = Integer.parseInt((String) test.getValue());
		System.out.println(a);
		
		//오류는 나지 않지만 실행할 경우 에러 발생함.
		test.setValue("안녕하세요");
		int b = (int) test.getValue();
		System.out.println(b);
		
		
		
		//Generic을 사용할 경우 comfile 과정에서 오류를 발견해
		//미리 수정 가능함! 효율 up!!
		MyGeneric<String> test2 = new MyGeneric<>();
		test.setValue("XYZ");
//		int b = test2.getValue();
	}

}











