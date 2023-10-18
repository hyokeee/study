package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
	문제) 5명의 별명을 입력 받아 ArrayList에 저장하고 저장된 별명들 중에 
	별명의 길이가 제일 긴 별명을 출력하시오.
	단, 각 별명의 길이는 모드 다르게 입력한다.
 */

public class ArrayListTest03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> id = new ArrayList<>();

		for (int i = 1; i <= 5; i++) {
			System.out.print(i + "번째 별명입력: ");
			String insertId = scanner.nextLine();
			id.add(insertId);
		}

		String longId = id.get(0);

		System.out.println("긴 별명은????");
//		for(int i=1; i<id.size(); i++) {
//			for(int j = 0; j<i; j++) {
//				if(id.get(i).length()>id.get(j).length()) {
//					longId = id.get(i);
//				}
//			}
//		}
		for (int i = 1; i < id.size(); i++) {
			if (longId.length() < id.get(i).length()) {
				longId = id.get(i);
			}
		}
		System.out.println(longId);

	}
}
