package com.ykh.merong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ykh.merong.vo.YerinVO;

@Mapper		// 명시적 표현 DAO에 해당
public interface YerinMapper {
	// 읽기 리스트(여러 줄)
	public List<YerinVO> listData();
	// 읽기 한 줄
	public YerinVO oneData(YerinVO yerinVO);
	// 입력
	public int insertData(YerinVO yerinVO);
	// 수정
	public int updateData(YerinVO yerinVO);
	// 삭제
	public int deleteData(YerinVO yerinVO);
}
