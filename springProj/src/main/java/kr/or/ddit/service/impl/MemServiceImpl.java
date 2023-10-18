package kr.or.ddit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.dao.MemDao;
import kr.or.ddit.service.MemService;
import kr.or.ddit.vo.AddrVO;
import kr.or.ddit.vo.MemVO;

@Service
public class MemServiceImpl implements MemService{
	@Autowired
	MemDao memDao;
	
	@Override
	public int addMem(MemVO memVO) {
		AddrVO addrVO = memVO.getAddrVO();
		addrVO.setUserId(memVO.getUserId());
		if(memVO.getDeveloper()==null) {
			memVO.setDeveloper("N");
		}
		int cnt = this.memDao.addMem(memVO);
		cnt += this.memDao.addAddr(addrVO);
		return cnt;
	}
}
