package kr.or.ddit.board.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.util.DBUtil3;

public class BoardDaoImpl implements IBoardDao{
	private static BoardDaoImpl dao;
	private BoardDaoImpl() { }
	public static BoardDaoImpl getInstance() {
		if(dao==null) dao = new BoardDaoImpl();
		return dao;
	}
	@Override
	public int insertBoard(BoardVO borVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0; // 반환값이 저장될 변수
		try {
			conn = DBUtil3.getConnection();
			String sql = "insert into jdbc_board (board_no, board_title, board_writer,board_date,board_content)"
					+ " values(board_seq.nextVal,?,?,sysdate,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, borVo.getBoard_title());
			pstmt.setString(2, borVo.getBoard_writer());
			pstmt.setString(3, borVo.getBoard_content());
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try {pstmt.close();}catch(SQLException e) {};
			if(conn!=null) try {conn.close();}catch(SQLException e) {};
		}
		return cnt;
	}
	@Override
	public List<BoardVO> getAllBoard() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> boardList = null;
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from jdbc_board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			boardList = new ArrayList<>();
			while(rs.next()) {
				//한 레코드의 내용을 VO객체에 저장
				BoardVO boardVo = new BoardVO();
				boardVo.setBoard_no(rs.getInt("board_no"));
				boardVo.setBoard_title(rs.getString("board_title"));
				boardVo.setBoard_writer(rs.getString("board_writer"));
				boardVo.setBoard_date(rs.getDate("board_date"));
				boardVo.setBoard_cnt(rs.getInt("board_cnt"));
				boardVo.setBoard_content(rs.getString("board_content"));
				
				//데이터가 저장된 VO객체를 List에 추가한다.
				boardList.add(boardVo);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			if(rs!=null) try {pstmt.close();} catch(SQLException e) { }
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) { }
			if(conn!=null) try {conn.close();} catch(SQLException e) { }
		}
		return boardList;
	}
	@Override
	public int updateBoard(int boardNo, String title, String content) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0; // 반환값이 저장될 변수
		try {
			conn = DBUtil3.getConnection();
			String sql = "update jdbc_board set board_title = ?, board_content = ? board_date = sysdate where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,title);
			pstmt.setString(2,content);
			pstmt.setInt(3,boardNo);
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			if(pstmt!=null) try {pstmt.close();}catch(SQLException e) {};
	    	if(conn!=null) try {conn.close();}catch(SQLException e) {};	
		}
		return cnt;
	}
	@Override
	public BoardVO getBoard(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO boardVo = new BoardVO();
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from jdbc_board where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				boardVo.setBoard_no(rs.getInt("board_no"));
				boardVo.setBoard_title(rs.getString("board_title"));
				boardVo.setBoard_writer(rs.getString("board_writer"));
				boardVo.setBoard_date(rs.getDate("board_date"));
				boardVo.setBoard_cnt(rs.getInt("board_cnt"));
				boardVo.setBoard_content(rs.getString("board_content"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			if(rs!=null) try {pstmt.close();} catch(SQLException e) { }
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) { }
			if(conn!=null) try {conn.close();} catch(SQLException e) { }
		}
		return boardVo;
	}
	@Override
	public int deleteBoard(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0; // 반환값이 저장될 변수
		try {
			conn = DBUtil3.getConnection();
			String sql = "delete from jdbc_board where board_no=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			if(pstmt!=null) try {pstmt.close();}catch(SQLException e) {};
	    	if(conn!=null) try {conn.close();}catch(SQLException e) {};
		}
		return cnt;
	}
	@Override
	public List<BoardVO> searchBoard(String searchTitle) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> boardList = null;
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from jdbc_board where board_title like "+"'"+searchTitle+"%'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			boardList = new ArrayList<>();
			while(rs.next()) {
				//한 레코드의 내용을 VO객체에 저장
				BoardVO boardVo = new BoardVO();
				boardVo.setBoard_no(rs.getInt("board_no"));
				boardVo.setBoard_title(rs.getString("board_title"));
				boardVo.setBoard_writer(rs.getString("board_writer"));
				boardVo.setBoard_date(rs.getDate("board_date"));
				boardVo.setBoard_cnt(rs.getInt("board_cnt"));
				boardVo.setBoard_content(rs.getString("board_content"));
				
				//데이터가 저장된 VO객체를 List에 추가한다.
				boardList.add(boardVo);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			if(rs!=null) try {pstmt.close();} catch(SQLException e) { }
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) { }
			if(conn!=null) try {conn.close();} catch(SQLException e) { }
		}
		return boardList;
	}
	
	@Override
	public int updateViewCount(int boardNo, int cnt) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt2 = 0; // 반환값이 저장될 변수
		try {
			conn = DBUtil3.getConnection();
			String sql = "update jdbc_board set board_cnt = ? where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,cnt);
			pstmt.setInt(2,boardNo);
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			if(pstmt!=null) try {pstmt.close();}catch(SQLException e) {};
	    	if(conn!=null) try {conn.close();}catch(SQLException e) {};	
		}
		return cnt2;
		
	}
	
	
}
