package kr.or.ddit.board.vo;
// 실제로 테이블이 만들어 지지 않고, 단순히 보조역할을 하는 VO 객체임
// ==> mybatis-config.xml 에 typealias나 mapper 경로를 따로 만들어 줄 필요가 없다
// ==> DB에 접근하는 객체가 아니므로 (mapper에 접근하는 객체가 아니므로) 
//      Dao로 갈 필요 없이 Service 에서만 실행한다.
public class PageVO {
	// 페이지 정보 얻기 - 시작번호 , 끝번호, 시작페이지번호, 끝페이지번호, 총 페이지 갯수
	private int start;
	private int end;
	
	private int startPage;
	private int endPage;
	private int totalPage;
	private int count;
	
	private static int perList = 3;	//한 화면에 출력될 게시글의 수
	private static int perPage = 2;	//한 화면에 출력될 페이지 갯수 
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public static int getPerList() {
		return perList;
	}
	public static void setPerList(int perList) {
		PageVO.perList = perList;
	}
	public static int getPerPage() {
		return perPage;
	}
	public static void setPerPage(int perPage) {
		PageVO.perPage = perPage;
	}
	
	
	
	
}
