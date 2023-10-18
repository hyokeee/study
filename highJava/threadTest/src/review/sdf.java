package review;

public class sdf {
	
	public static void main(String[] args) {
		sdfdsf a = new sdfdsf();
		a.setAge(10);
		a.setName("홍길동");
		a.setNo(1);
		System.out.println(a.toString());
	}
	
}


class sdfdsf{
	private int no;
	private String name;
	private int age;
	
	public sdfdsf() {
		// TODO Auto-generated constructor stub
	}
	int getNo() {
		return no;
	}
	void setNo(int no) {
		this.no = no;
	}
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	int getAge() {
		return age;
	}
	void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
//		return String.format("이름 : %s 나이 : %d", name, age);
		return "이름 : " + name + " 나이 : " + age;
	}
	
}
