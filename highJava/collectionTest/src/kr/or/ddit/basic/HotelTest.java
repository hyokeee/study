package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class HotelTest {
	private HashMap<Integer, Room> hotelMap;
	private Scanner scan;
	public HotelTest() {
		scan = new Scanner(System.in);
		hotelMap = new HashMap<Integer,Room>();
		for(int i=201; i<=209; i++) {
			hotelMap.put(i, new Room(i));
		}
		for(int i=301; i<=309; i++) {
			hotelMap.put(i, new Room(i));
		}
		for(int i=401; i<=409; i++) {
			hotelMap.put(i, new Room(i));
		}
		
	}
	
	public static void main(String[] args) {
		new HotelTest().hotelStart();
	}
	
	
	//display 메뉴
	private int displayMenu() {
		System.out.println("--------------------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인      2.체크아웃      3.객실상태      4.업무종료");
		System.out.println("--------------------------------------------------");
		System.out.print("선택>> ");
		return scan.nextInt();
	}
	
	
	//시작화면 메서드
	private void hotelStart() {
		
		System.out.println("*******************************");
		System.out.println("    호텔문을 열었습니다. 어서오십시요.");
		System.out.println("*******************************");
		
		while(true) {
			int choice = displayMenu();
			switch(choice) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				roomStatus();
				break;
			case 4:
				System.out.println("*******************************");
				System.out.println("    호텔문을 닫았습니다. 안녕히가세요.");
				System.out.println("*******************************");
				return;		
			default:
				System.out.println();
				System.out.println("올바르지 않은 메뉴선택입니다.");
				System.out.println("다시 입력해주세요.");
			}
		}
	}
	
	//체크 아웃 메서드
	private void checkOut() {
		System.out.println("----------------------------------------------");
		System.out.println("   체크아웃 작업");
		System.out.println("----------------------------------------------");
		System.out.println("체크아웃 할 방 번호를 입력하세요.");
		System.out.print("방번호 입력>>");
		int selectRoom = scan.nextInt();
		if(hotelMap.containsKey(selectRoom)) {
			if(!hotelMap.get(selectRoom).getGuestName().equals("-")) {
				System.out.println(selectRoom + "호 객실의 " + hotelMap.get(selectRoom).getGuestName()+"님 체크아웃을 완료하였습니다.");
				hotelMap.get(selectRoom).setGuestName("-");
			} else {
				System.out.println(selectRoom + "호 객실에는 체크인 한 사람이 없습니다.");
			}
		} else {
			System.out.println(selectRoom + "호 객실은 존재하지 않습니다.");
		}
	}
	
	
	
	//객실 상태 메서드
	private void roomStatus() {
		System.out.println();
		Set<Integer> hotelKeySet = hotelMap.keySet();
		System.out.println("----------------------------------------------");
		System.out.println("		       현재 객실 상태");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호    방 종류   투숙객 이름");
		System.out.println("----------------------------------------------");
		
		//Set으로 만든 후 list에 넣고 정렬
		List<Integer> keyList = new ArrayList<>(hotelKeySet);
		Collections.sort(keyList);
		Iterator<Integer> sortedHotelKeyIt = keyList.iterator();

		//정렬 후 Iterator로 만들어 출력
		while(sortedHotelKeyIt.hasNext()) {
			int roomNo = sortedHotelKeyIt.next();
			Room r = hotelMap.get(roomNo);
			System.out.println(roomNo + "      " + r.getRoomType() + "\t" + r.getGuestName());
		}
		System.out.println("----------------------------------------------");
	}
	   
	
	
	
	//체크인 메서드
	private void checkIn() {
		System.out.println("----------------------------------------------");
		System.out.println("체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println("* 201~209 : 싱글룸");
		System.out.println("* 301~309 : 더블룸");
		System.out.println("* 401~409 : 스위트룸");
		System.out.print("방 번호 입력>>");
		int selectRoom = scan.nextInt();
		if(hotelMap.containsKey(selectRoom)) {
			if(hotelMap.get(selectRoom).getGuestName()!="-") {
				System.out.println(selectRoom + "호 객실은 이미 손님이 있습니다.");
			}else {
				System.out.println("누구를 체크인 하시겠습니까?");
				System.out.print("이름 입력>>");
				String name = scan.next();
				hotelMap.get(selectRoom).setGuestName(name);
				System.out.println("체크인이 완료되었습니다.");
			}
		} else {
			System.out.println(selectRoom + "호 객실은 존재하지 않습니다.");
		}
	}
}






class Room{
	private int roomNo;
	private String roomType ;
	private String guestName = "-";
	
	//생성자
	public Room(int roomNo, String guestName) {
		super();
		this.roomNo = roomNo;
		if(roomNo>=201&&roomNo<=209) {
			this.roomType = "싱글룸";
		} else if(roomNo>=301&&roomNo<=309) {
			this.roomType = "더블룸";
		} else if(roomNo>=401&&roomNo<=409) {
			this.roomType = "스위트룸";
		}
		this.guestName = guestName;
	}
	
	//객실상태용 생성자
	public Room(int roomNo) {
		super();
		this.roomNo = roomNo;
		if(roomNo>=201&&roomNo<=209) {
			this.roomType = "싱글룸";
		} else if(roomNo>=301&&roomNo<=309) {
			this.roomType = "더블룸";
		} else if(roomNo>=401&&roomNo<=409) {
			this.roomType = "스위트룸";
		}
		
	}
	

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	@Override
	public String toString() {
		return "Room [roomNo=" + roomNo + ", roomType=" + roomType + ", guestName=" + guestName + "]";
	}
	
	
}