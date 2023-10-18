package kr.or.ddit.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.Member2VO;

@Mapper
public interface MemberMapper {
	//<select id="detail" parameterType="String" resultMap="memberDetailMap">
	public Member2VO detail(String userNo);
}



