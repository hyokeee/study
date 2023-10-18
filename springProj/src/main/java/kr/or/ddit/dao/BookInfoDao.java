package kr.or.ddit.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.BookInfoVO;


//매퍼xml(bookInfo_SQL.xml)을 실행시키는
//DAO(Data Access Object) 클래스
//Repository : 데이터에 접근하는 클래스임을 명시
//스프링이 데이터를 관리하는 클래스라고 인지하여 자바빈으로 등록하여 관리
@Repository
public class BookInfoDao {
	//쿼리실행객체를 주입
	//DI / IoC
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	//1-1) <insert id="addBookPost" parameterType="bookInfoVO">
	public int addBookPost(BookInfoVO bookInfoVO) {
		// .insert("namespace.id",파라미터)
		int cnt = this.sqlSessionTemplate.insert("bookInfo.addBookPost",bookInfoVO);
		return cnt;
	}
	
	//1-2) <insert id="addAttach" parameterType="attachVO">
	public int addAttach(AttachVO attachVO) {
		int cnt = this.sqlSessionTemplate.insert("bookInfo.addAttach",attachVO);
		return cnt;
	}
	
	//도서코드 자동생성
	//<select id="getBookId" resultType="String">
	public String getBookId() {
		String bookId = this.sqlSessionTemplate.selectOne("bookInfo.getBookId");
		return bookId;
	}
	
	//도서목록
	//<select id="listBook" resultMap="bookInfoMap">
	public List<BookInfoVO> listBook(Map<String,Object> map){
		return this.sqlSessionTemplate.selectList("bookInfo.listBook",map);
	}
	
	// BOOK_INFO 테이블의 전체 행 수
	// <select id="getBookInfoTotal" resultType="int">
	public int getBookInfoTotal(Map<String,Object> map) {
		return this.sqlSessionTemplate.selectOne("bookInfo.getBookInfoTotal",map);
	}
	
	// 도서 상세
	// <select id="detailBook" parameterType="String" resultType="bookInfoVO">
	public BookInfoVO detailBook(String bookId) {
		return this.sqlSessionTemplate.selectOne("bookInfo.detailBook",bookId);
	}
	
	// 1)도서 수정
	// <update id="updateBookPost" parameterType="bookInfoVO">
	public int updateBookPost(BookInfoVO bookInfoVO) {
		return this.sqlSessionTemplate.update("bookInfo.updateBookPost",bookInfoVO);
	}
	
	// 2) BOOK_INFO 테이블을 update 한 후 ATTACH 테이블도 update 할 수 있음 
	//한 권의 책에 첨부파일이 여러개일 경우 첫번째 첨부파일만 변경
	public int updateAttach(AttachVO attachVO) {
		return this.sqlSessionTemplate.update("bookInfo.updateAttach",attachVO);
	}
	
	// 도서 삭제
	public int deleteBookPost(String bookId) {
		return this.sqlSessionTemplate.delete("bookInfo.deleteBookPost",bookId);
	}
	
	// ATTACH 삭제
	public int deleteAttach(String bookId) {
		return this.sqlSessionTemplate.delete("bookInfo.deleteAttach",bookId);
	}
}
