package kr.or.ddit.board.controller;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;



import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;
import oracle.sql.CLOB;


public class BoardController {
	private IBoardService service;	//service 객체 변수 선언
	private Scanner scan;
	private int board_no;		//게시물 보기에서 선택한 게시물 번호가 저장-> update / delete 메서드에서 사용ㄴ
	
	//생성자
	public BoardController() {
		scan = new Scanner(System.in);
		service = BoardServiceImpl.getInstance();
	}
	public static void main(String[] args) {
		new BoardController().boardStart();
	}
	
	//시작 메서드
	public void boardStart() {
		while(true) {
			int choice = displayMenu();
			switch(choice) {
			case 1:		//새 글 작성
				insertBoard();
				break;
			case 2:		//게시글 보기
				boardMenu();
				break;
			case 3:		//검색
				searchBoard();
				break;
			case 0:		//종료
				System.out.println();
				System.out.println("작업을 마칩니다..");
				return;
			default:
				System.out.println();
				System.out.println("잘못 입력하셨습니다.");
				System.out.println("다시 입력하세요.");
			}
		}
	}
	
	//전체 게시글을 출력하고 작업번호를 입력받아 반환하는 메서드
	private int displayMenu() {
		int choice = 0;
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println(" No	        제 목            작성자 	     조회수       ");
		System.out.println("-------------------------------------------------------------");
		List<BoardVO> boardList = service.getAllBoard();
		if(boardList==null||boardList.size()==0) {
			System.out.println("게시글이 하나도 없습니다.");
		}
		for(BoardVO boardVo : boardList) {
			System.out.println(boardVo.getBoard_no()+"    "+boardVo.getBoard_title()
			+"     "+boardVo.getBoard_writer()+"     "+boardVo.getBoard_cnt());
		}
		System.out.println("-------------------------------------------------------------");
		System.out.println("메뉴    :  1. 새글작성     2. 게시글보기    3. 검색    0. 작업끝");
		System.out.print("작업선택>> ");
		try {
			choice = scan.nextInt();
		} catch (InputMismatchException e) {
			choice = -1;
			scan.nextLine();	//스캐너 비우기
		}
		return choice;
	}
	
	//새 글 작성하기 메서드
	private void insertBoard() {
		scan.nextLine();
		System.out.println();
		System.out.println("새글 작성하기");
		System.out.println("-------------------------------------------------------------");
		System.out.print("- 제  목 : ");
		String title = scan.nextLine();
		System.out.print("- 작성자 : ");
		String writer = scan.nextLine();
		System.out.print("- 내  용 : ");
		String content = scan.nextLine();
		
		
		//입력 받은 자료를 VO객체에 저장
		BoardVO boardVo = new BoardVO();
		boardVo.setBoard_title(title);
		boardVo.setBoard_writer(writer);
		boardVo.setBoard_content(content);
		
		
		int cnt = service.insertBoard(boardVo);
		
		if(cnt>0) {
			System.out.println("insert 성공!!!");
		} else {
			System.out.println("insert 실패!!!");
		}
	}
	
	//게시물 번호 입력 후 해당 게시글 보기
	private int getBoard() {
		System.out.print("보기를 원하는 게시물 번호 입력>> ");
		board_no = scan.nextInt();		//게시물 보기에서 선택한 게시물 번호가 저장-> update / delete 메서드에서 사용
		BoardVO boardVo = null;
		boardVo = service.getBoard(board_no);
		service.updateViewCount(board_no, boardVo.getBoard_cnt()+1);	//1 증가 시킨 후 다시 boardVo객체에 저장
		System.out.println(board_no+"번글 내용");
		System.out.println("-------------------------------------------------------------");
		System.out.println("- 제  목 : " + boardVo.getBoard_title());
		System.out.println("- 작성자 : " + boardVo.getBoard_writer());
		System.out.println("- 내  용 : " + boardVo.getBoard_content());
		System.out.println("- 작성일 : " + boardVo.getBoard_date());
		System.out.println("- 조회수 : " + boardVo.getBoard_cnt());
		System.out.println("-------------------------------------------------------------");
		System.out.println("메뉴 : 1. 수정    2. 삭제    3. 리스트로 가기");
		System.out.print("작업선택 >>");
		int num = 0;
		try {
			num = scan.nextInt();
		} catch (InputMismatchException e) {
			num = -1;
			scan.nextLine();	//스캐너 비우기
		}
		
		return num;
	}
	
	//게시물 보기 후 메뉴 선택 메서드
	private void boardMenu() {
		while(true) {
			int choice = getBoard();
			switch(choice) {
			case 1:		//수정
				updateBoard(board_no);
				return;
			case 2:		//삭제
				deleteBoard(board_no);
				return;
			case 3:		//리스트로 가기
				return;
			default :
				System.out.println();
				System.out.println("잘못 입력하셨습니다");
				System.out.println("다시 입력해주세요");
			}
		}
	}
	
	//게시물 수정 작업 메서드
	private void updateBoard(int choice) {
		scan.nextLine();		//버퍼 비우기
		System.out.println();
		System.out.println("수정 작업하기");
		System.out.println("-------------------------------------------------------------");
		System.out.print("- 제  목 : ");
		String title = scan.nextLine();
		System.out.print("- 내  용 : ");
		String content = scan.nextLine();
		
		
		int cnt = service.updateBoard(choice, title, content);
		
		if (cnt > 0) {
	         System.out.println("update 성공!!!");
	    } else {
	         System.out.println("update 실패!!!");
	    }
	}
	
	//게시물 삭제 작업 메서드
	private void deleteBoard(int choice) {
		int cnt = service.deleteBoard(choice);
		
		if (cnt > 0) {
	         System.out.println(choice+"번 글 delete 성공!!!");
	    } else {
	         System.out.println(choice+"번 글 delete 실패!!!");
	    }
	}
	
	//게시물 제목으로 검색(입력값이 없으면 전체 자료 출력)
	private void searchBoard() {
		scan.nextLine();
		System.out.println();
		System.out.println("검색 작업");
		System.out.println("-------------------------------------------------------------");
		System.out.print("검색할 제목 입력 : ");
		String title = scan.nextLine();		
		List<BoardVO> boardList = service.searchBoard(title);
		
		if(boardList==null||boardList.size()==0) {
			System.out.println("조회된 내역이 하나도 없습니다.");
		}
		
		for(BoardVO boardVo : boardList) {
			System.out.println(boardVo.getBoard_no()+"    "+boardVo.getBoard_title()
			+"     "+boardVo.getBoard_writer()+"     "+boardVo.getBoard_cnt());
		}
		return;
	}
}
