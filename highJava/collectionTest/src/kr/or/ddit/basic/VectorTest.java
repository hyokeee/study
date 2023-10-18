package kr.or.ddit.basic;

import java.util.Vector;

public class VectorTest {
	public static void main(String[] args) {
		// 객체 생성
		Vector v1 = new Vector();		
		
		System.out.println("처음 크기: " + v1.size());
		
		// 데이터 추가하기(1): add(추가할 데이터) 메소드 사용
		// 반환값: 데이터 추가 성공 -> true, 추가 실패 -> false
		v1.add("aaaaa");
		v1.add(new Integer(100)); // 100은 객체가 아니기 때문에 Integer 객체를 새로 생성한 것
		v1.add(123); // new Integer로 생성 안해줘도 객체로 auto boxing 됨 (auto unboxing도 있음)
		v1.add('a'); // char형식, 객체가 아니기 때문에 auto boxing 됨
		v1.add(true); // auto boxing
		boolean r = v1.add(3.14); // 데이터 추가 성공 시 true 반환
		
		System.out.println("현재 크기: " + v1.size());
		System.out.println("반환값: " + r);
		System.out.println("v1 => " + v1.toString()); // 출력 시 toString 메소드는 생략 가능(없어도 똑같이 출력)
		
		// 데이터 추가하기(2): addElement(추가할 데이터)
		// add랑 똑같음. auto boxing 기능이 생기기 전에 있던 것
		// 이전 프로그램과의 호환성을 위해 남아 있는 메소드
		v1.addElement("ccc");
		
		System.out.println("v1 => " + v1);
		
		// 데이터 추가하기(3): add(index, 데이터)
		// 'index'번째에 '데이터'를 끼워넣는다.
		// 반환값: 없음
		v1.add(1, "kkk");
		System.out.println("v1 => " + v1);
		
		// 데이터 꺼내오기: get(index)
		// 'index'번째 데이터를 꺼내서 반환
		System.out.println("0번째 데이터: " + v1.get(0));
		int iTemp = (int) v1.get(2); // v1에 저장된 각 객체들은 object 타입으로 변환되어 있음
		// ㄴ> 여기서 auto unboxing이 일어나면서 객체가 자료형으로 변환
		System.out.println("2번째 데이터: " + iTemp);
		
		// 데이터 수정하기: set(index, 새로운 데이터)
		// 'index'번째 데이터를 '새로운 데이터'로 변경
		// 반환값: 기존 데이터
		String sTemp = (String) v1.set(0, "zzz");
		System.out.println("v1 => " + v1);
		System.out.println("set 메소드의 반환값(기존 데이터): " + sTemp);
		
		// 데이터 삭제하기(1): remove(index)
		// 'index'번째 데이터를 삭제
		// 반환값: 삭제된 데이터
		sTemp = (String) v1.remove(0);
		System.out.println("삭제 후 v1 => " + v1);
		System.out.println("remove 메소드의 반환값(삭제된 데이터): " + sTemp);
		
		// 데이터 삭제하기 2: remove(삭제할 데이터)
		// '삭제할 데이터'를 찾아서 삭제
		// '삭제할 데이터'가 여러 개이면 그 중 첫번째 자료를 삭제
		// 반환값: 삭제 성공 -> true, 삭제 실패 -> false
		// 삭제할 데이터가 정수형이거나 char형일 경우에는 반드시 객체로 변환 후 사용해야 함
		r = v1.remove("ccc");
		System.out.println("삭제 후 v1 => " + v1);
		System.out.println("remove 메소드의 반환값(삭제 성공 했는지): " + r);
		
//		v1.remove(123); // (1)에 있는 remove 방법(인덱스가 123번째인 값을 삭제)으로 해석됨
						// -> 123을 객체화해서 데이터로 주어야 함
		v1.remove(new Integer(123)); // 객체화 방법 1
//		v1.remove(Integer.valueOf(123)); // 객체화 방법 2
		System.out.println("123 삭제 후 v1 => " + v1);
		
//		v1.remove('a'); // char는 숫자로 받아들임 -> 객체화 시켜야 함
		v1.remove(new Character('a')); // 객체화 방법
		System.out.println("a 삭제 후 v1 => " + v1);
		
		v1.remove(true);
		System.out.println("true 삭제 후 v1 =>" + v1);
		
		v1.remove(3.14);
		System.out.println("3.14 삭제 후 v1 => " + v1);
		
		// 전체 데이터 삭제하기: clear();
		v1.clear();
		System.out.println("clear 삭제 후 v1 => " + v1);
		
		/*
		 * Generic Type
		 * : 클래스 내부에서 사용할 데이터의 타입을 객체를 생성할 때 외부에서 지정해주는 기법으로
		 * 객체를 선언할 때 <> 괄호 안에 그 객체의 내부에서 사용할 데이터의 타입을 정해주는 것
		 * 
		 * - 이런 식으로 선언하게 되면 그 지정된 데이터 타입 이외의 다른 종류의 데이터를 저장할 수 없다
		 * - 이때 제네릭으로 선언될 수 있는 데이터 타입은 클래스형이어야 한다
		 *   그래서 int형은 Integer, boolean은 Boolean, char은 Character 등으로 대체해서 사용해야 한다.
		 * - 제네릭 타입으로 선언하게 되면 데이터를 꺼내올 때도 별도의 형 변환이 필요 없다.
		 */
		
		Vector<Integer> v2 = new Vector<>(); // int형 자료만 저장할 수 있는 벡터
		Vector<String> v3 = new Vector<>(); // String만 저장할 수 있는 벡터
		v3.add("안녕하세요");
//		v3.add(100); // 오류: 다른 타입의 데이터를 저장할 수 없음
//		v2.add("ABCD"); // 오류: 다른 타입의 데이터를 저장할 수 없음
		
		String sTemp2 = v3.get(0); // 형 변환 없이 데이터를 꺼내와 사용할 수 있음
		Vector<Vector> vv = new Vector<>();
		Vector<Vector<Vector>> vvv = new Vector<>(); // 2차원 배열 느낌
		
		v3.clear();
		System.out.println("v3의 사이즈: " + v3.size());

		v3.add("AAA");
		v3.add("BBB");
		v3.add("CCC");
		v3.add("DDD");
		v3.add("EEE");
		
		Vector<String> v4 = new Vector<>();
		v4.add("BBB");
		v4.add("EEE");
		
		System.out.println("v3 => " + v3);
		System.out.println("v4 => " + v4);
		
		// 데이터 삭제하기(3)
		// 벡터의 데이터 중에서 'Collection 객체'가 가지고 있는 모든 데이터를 삭제
		// 반환값: 삭제 성공 -> true, 삭제 실패 -> false
		v3.removeAll(v4); // v3의 데이터들 중에서 v4가 가지고 있는 데이터와 같은 데이터들을 모두 삭제
		System.out.println("v4에 있는 값들을 삭제한 v3 => " + v3);
		
		v3.clear();
		
		v3.add("AAA");
		v3.add("BBB");
		v3.add("CCC");
		v3.add("DDD");
		v3.add("EEE");
		
		// 벡터의 데이터들을 순서대로 모두 가져와 사용(반복문 사용)
		for(int i=0; i<v3.size(); i++) {
			System.out.println(i + "번째 자료: " + v3.get(i));
		}
		System.out.println("----------------");
		
		// 향상된 for문
		for(String temp : v3) {
			System.out.println(temp);
		}

	}

}
