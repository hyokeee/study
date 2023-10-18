package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest02 {
	public static void main(String[] args) {
		/*
	    문제) 5명의 사람 이름을 입력 받아 ArrayList에 저장한 후에 
	        이 ArrayList에 저장된 이름들 중에서 '김'씨 성의 이름을 모두 출력하시오.
	        (입력은 Scanner객체를 이용한다.
	 */ 
		
		 Scanner scanner = new Scanner(System.in);
		 ArrayList<String> name = new ArrayList<>();
		 for(int i = 1; i<=5; i++) {
			 System.out.print(i+"번째 이름: ");
			 String insertName = scanner.nextLine();
			 name.add(insertName);
		 }
		 
		 System.out.println();
		 System.out.println("김씨 성을 가진 사람들은");
			for (int i = 0; i < name.size(); i++) {
				if (name.get(i).substring(0, 1).equals("김")) {
					System.out.println(name.get(i));
				}
//				if (name.get(i).indexOf("김") == 0) {
//					System.out.println(name.get(i));
//				}
//				if (name.get(i).charAt(0) == '김') {
//					System.out.println(name.get(i));
//				}
//				if (name.get(i).startsWith("김") == true) {
//					System.out.println(name.get(i));
//				}
//				if (name.get(i).contains("김") == true) {
//					System.out.println(name.get(i));
//				}
			}

		}
	}
