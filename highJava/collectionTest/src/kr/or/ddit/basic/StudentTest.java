package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
  문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다.
  이 Student클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서 초기화 처리를 한다.
  
  이 Student객체는 List에 저장하여 관리한다.
  
  List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고 ,
  총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬되는 외부 정렬 기준 클래스를 작성하여
  정렬된 결과를 출력하시오.
  
  등수는 List에 전체 데이터가 추가된 후에 구해서 저장되도록 한다. (StudentTest 클래스에 처리)
 
 */
public class StudentTest {
	
	//등수를 구하는 메소드
	public void createRank(ArrayList<Student> rankStdList) {
		for(Student std1 : rankStdList) { // 기준 데이터를 구하기 위한 반복문
			int rank = 1;   //처음에는 등수를 1로 설정해 놓고 시작
			for(Student std2 : rankStdList) { // 비교 대상을 나타내는 반복문
				
				if(std1.getTotal()<std2.getTotal()) { //기준값보다 비교대상이 더 크면 등수 1 증가
					rank++;
				}
			}
			//구해진 등수를 기준 데이터의 rank변수에 저장한다.
			std1.setRank(rank);
		}
	}
	
	public static void main(String[] args) {
		StudentTest test = new StudentTest(); 
		ArrayList<Student> studentList = new ArrayList<>();
		studentList.add(new Student(1, "홍길동", 90, 95, 80));
		studentList.add(new Student(3, "성춘향", 90, 75, 70));
		studentList.add(new Student(7, "강감찬", 95, 95, 80));
		studentList.add(new Student(5, "변학도", 80, 95, 90));
		studentList.add(new Student(2, "일지매", 100, 85, 80));
		studentList.add(new Student(4, "이순신", 60, 65, 70));
		studentList.add(new Student(6, "이몽룡", 90, 100, 90));

		test.createRank(studentList);
		
		System.out.println("정렬전..");
		for (Student std : studentList) {
			System.out.println(std);
		}
		
		System.out.println("============================================");
		Collections.sort(studentList);
		System.out.println("학번 오름차순 정렬 후..");
		for (Student std : studentList) {
			System.out.println(std);
		}

		System.out.println("============================================");
		Collections.sort(studentList, new SortByTotal());
		System.out.println("총점 역순 정렬 후..");
		for (Student std : studentList) {
			System.out.println(std);
		}
		System.out.println("============================================");
		
		

	}
}
//문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다.
//이 Student클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서 초기화 처리를 한다.
//List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현
class Student implements Comparable<Student> {
	private int stuNum;
	private String name;
	private int korPoint;
	private int engPoint;
	private int mathPoint;
	private int total;
	private int rank;

	public Student(int stuNum, String name, int korPoint, int engPoint, int mathPoint) {
		super();
		this.stuNum = stuNum;
		this.name = name;
		this.korPoint = korPoint;
		this.engPoint = engPoint;
		this.mathPoint = mathPoint;
		this.total = korPoint + engPoint + mathPoint;
	}

	public int getStuNum() {
		return stuNum;
	}

	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorPoint() {
		return korPoint;
	}

	public void setKorPoint(int korPoint) {
		this.korPoint = korPoint;
	}

	public int getEngPoint() {
		return engPoint;
	}

	public void setEngPoint(int engPoint) {
		this.engPoint = engPoint;
	}

	public int getMathPoint() {
		return mathPoint;
	}

	public void setMathPoint(int mathPoint) {
		this.mathPoint = mathPoint;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Student [stuNum=" + stuNum + ", name=" + name + ", korPoint=" + korPoint + ", engPoint=" + engPoint
				+ ", mathPoint=" + mathPoint + ", total=" + total + ", rank=" + rank + "]";
	}

	//내부 정렬 기준은 현재 객체(this)와 매개변수에 저장된 객체와 비교해서 처리한다
	//현재 객체(this)가 앞쪽 데이터, 매개변수에 저장된 객체가 뒤쪽 데이터라고 하고 코딩한다.
	@Override
	public int compareTo(Student std) {
//		if (this.getStuNum() - std.getStuNum() > 0) {
//			return 1;
//		} else if (this.getStuNum() - std.getStuNum() < 0) {
//			return -1;
//		} else {
//			return 0;
//		}
		return Integer.compare(this.getStuNum(), std.getStuNum());
	}

}
//총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬되는 외부 정렬 기준 클래스를 작성
class SortByTotal implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
//		if (o1.getTotal() - o2.getTotal() > 0) {
//			return -1;
//		} else if (o1.getTotal() - o2.getTotal() > 0) {
//			return 1;
//		} else if (o1.getTotal() == o2.getTotal()) {
//			if (o1.getName().compareTo(o2.getName()) > 0) {
//				return 1;
//			} else if (o1.getName().compareTo(o2.getName()) < 0) {
//				return -1;
//			} else {
//				return 0;
//			}
//		} else {
//			return 0;
//		}
		if(o1.getTotal()==o2.getTotal()) {
			return o1.getName().compareTo(o2.getName());
		} else {
			return Integer.compare(o1.getTotal(), o2.getTotal())*-1;
		}
	}
}
