package kr.or.ddit.basic.fileupload.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MyBatisSqlSessionFactory;
import kr.or.ddit.vo.FileInfoVO;

public class FileInfoDaoImpl implements IFileInfoDao{
	private static FileInfoDaoImpl dao;
	private FileInfoDaoImpl() {}
	public static FileInfoDaoImpl getinstance() {
		if(dao==null) dao = new FileInfoDaoImpl();
		return dao;
	}
	
	@Override
	public int insertFileinfo(FileInfoVO fileVo) {
		int cnt= 0;
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			cnt = session.insert("fileinfo.insertFileinfo",fileVo);
			if(cnt>0) {
				session.commit();
			}
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
		
	}

	@Override
	public List<FileInfoVO> getAllFileinfo() {
		List<FileInfoVO> fList = null;
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			fList = session.selectList("fileinfo.getAllFileinfo");
		} finally {
			if(session!=null) session.close();
		}
		return fList;
	}

	@Override
	public FileInfoVO getFileinfo(int fileNo) {
		FileInfoVO fVo = null;
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			fVo = session.selectOne("fileinfo.getFileinfo",fileNo);
		} finally {
			if(session!=null) session.close();
		}
		return fVo;
		
	}

}
