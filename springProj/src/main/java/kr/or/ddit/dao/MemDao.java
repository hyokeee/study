package kr.or.ddit.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.AddrVO;
import kr.or.ddit.vo.MemVO;

@Repository
public class MemDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int addMem(MemVO memVO) {
		return this.sqlSessionTemplate.insert("mem.addMem",memVO);
	}
	
	public int addAddr(AddrVO addrVO) {
		return this.sqlSessionTemplate.insert("mem.addAddr",addrVO);
	}
}
