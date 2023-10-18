package com.ykh.merong.mapper;
/*
 * 테스트는 spring 버전 또는 boot냐 아니냐 여부에 따라 어노테이션이 달라짐
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ykh.merong.vo.YerinVO;

//Junit5 사용
@ExtendWith(SpringExtension.class)

//Context설정파일 지정 classpath를 사용해도 됨
@ContextConfiguration("classpath:config/spring/database-context.xml")
public class YerinTest {
	
	@Autowired
	private YerinMapper yerin;
	@Test
	@DisplayName("giduk merong")
	public void insertTest() {
		
		YerinVO yerinVO = new YerinVO();
		for(int i=1; i<=100; i++) {
			yerinVO.setTitle("merong"+i);
			yerinVO.setScont("content"+i);
			yerinVO.setSname("gidukOta"+i);
			assertEquals(1, yerin.insertData(yerinVO));
		}
		//기댓값이 1! int cnt
		
	}

}
