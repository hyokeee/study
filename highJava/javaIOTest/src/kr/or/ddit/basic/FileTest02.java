package kr.or.ddit.basic;

import java.io.File;

public class FileTest02 {

	public static void main(String[] args) {
		File f1 = new File("d:/d_other/test.txt");
		
		//length() ==> File의 용량(bytes)가 나온다.
		System.out.println(f1.getName()+ "파일의 크기 : " + f1.length()+ "bytes");
		
		//getPath() ==> File객체를 생성할 때 생성자에 대입한 경로가 그대로 나온다.
		System.out.println("path : " + f1.getPath());
		System.out.println("absolutePath : " + f1.getAbsolutePath());
		System.out.println();
		
		//현재 위치 ? ==> 이클립스에서 java프로그램을 실행하면 프로젝트 폴더의 위치가 현재 위치가 된다.
		//실제로는 src 안에 있잖아 + 컴파일 하는건 bin에 있고 근데 
		//사실상 그게 이루어지는 폴더는 javaIOTest 폴더인거임 그래서 위치가 javaIOTest폴더가 됨
		//경로가 나ㅣ오는게 아니고 이클립스에서 실행하는 프로젝트 폴더의 위치가 현재 위치가 됨 
		//현재위치 .   .. 부모위치 ㅇㅇ 그 상위 폴더 javaIoTest가 현재 위치가 되는것.
		//글고 javaIOTest => 파일이 아니고 디렉토리임. 
		File f2 = new File(".");
		System.out.println("path : "+ f2.getPath());
		System.out.println("absolutePath : " + f2.getAbsolutePath());
		System.out.println();
		
		if(f1.isFile()) {
			System.out.println(f1.getName()+"은 파일입니다.");
		}else if(f1.isDirectory()){
			System.out.println(f1.getName()+"은 디렉토리(폴더)입니다.");
		} else {
			System.out.println(f1.getName()+"은 뭘까?");
		}
		System.out.println();
		
		if(f2.isFile()) {
			System.out.println(f2.getName()+"은 파일입니다.");
		}else if(f2.isDirectory()){
			System.out.println(f2.getName()+"은 디렉토리(폴더)입니다.");
		} else {
			System.out.println(f2.getName()+"은 뭘까?");
		}
		
		//sample.exe는 현재 존재하지 않는다.
		File f3 = new File("d:/d_other/sample.exe");
		if(f3.isFile()) {
			System.out.println(f3.getName()+"은 파일입니다.");
		}else if(f3.isDirectory()){
			System.out.println(f3.getName()+"은 디렉토리(폴더)입니다.");
		} else {
			System.out.println(f3.getName()+"은 뭘까?");
		}
		System.out.println();
	}
}
