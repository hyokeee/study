package com.ykh.merong.service;

import java.util.List;

import com.ykh.merong.vo.YerinVO;

//@Service, 인터페이스는 new로 생성할 수 없음
//요기에 붙이면 여러사람 목줄 날아감!
public interface Yerin {
	//읽기 리스트(여러줄)
	public List<YerinVO> listData();
	//읽기 한줄
	public YerinVO oneData(YerinVO yerinVO);
	//입력
	public int insertData(YerinVO yerinVO);
	//수정
	public int updateData(YerinVO yerinVO);
	//삭제
	public int deleteData(YerinVO yerinVO);
}

