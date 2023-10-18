package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.vo.MyMemberVO;
import kr.or.ddit.util.MyBatisSqlSessionFactory;

public class MyMemberDaoImpl implements IMyMemberDao{
	private static IMyMemberDao dao;
	private MyMemberDaoImpl() { }
	public static IMyMemberDao getInstance() {
		if(dao==null) dao = new MyMemberDaoImpl();
		return dao;
	}
	@Override
	public List<MyMemberVO> getMyMemberList() {
		List<MyMemberVO> mList = null;
		SqlSession session= null;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			mList = session.selectList("mymember.getMyMemberList");
		} finally {
			if(session!=null) session.close();
		}
		return mList;
	}

	@Override
	public int insertMyMember(MyMemberVO myMemVo) {
		int cnt = 0;
		SqlSession session= null;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			cnt = session.insert("mymember.insertMyMember",myMemVo);
		} finally {
			session.commit();
			if(session!=null) session.close();
		}
		return cnt;
	}

	@Override
	public int isExistID(String mem_id) {
		int cnt = 0;
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			cnt = session.selectOne("mymember.isExistID",mem_id);
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
	}

	@Override
	public MyMemberVO getMyMember(String mem_id) {
		MyMemberVO mVo = null;
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			mVo = session.selectOne("mymember.getMyMember",mem_id);
		} finally {
			if(session!=null) session.close();
		}
		return mVo;
	}

	@Override
	public int updateMyMember(MyMemberVO myMemVo) {
		int cnt = 0;
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			cnt = session.update("mymember.updateMyMember",myMemVo);
		} finally {
			session.commit();
			if(session!=null) session.close();
		}
		return cnt;
	}

	@Override
	public int deleteMyMember(String mem_id) {
		int cnt = 0;
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			cnt = session.delete("mymember.deleteMyMember",mem_id);
		} finally {
			session.commit();
			if(session!=null) session.close();
		}
		return cnt;
	}

}
