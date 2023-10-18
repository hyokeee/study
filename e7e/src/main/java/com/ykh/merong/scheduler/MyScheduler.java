package com.ykh.merong.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MyScheduler {
	
	
//	@Scheduled(fixedDelay = 3000)	//3초마다 미움!
//	public void gangHate() {
//		log.debug("밉다!");
//	}
//	//cron =       초 분 시간 일 월 요일 
//	@Scheduled(cron = "10 36 * * * *")	//매 분 10초마다 출력
//	public void gangHate2() {
//		log.debug("밉다2!");
//	}
}
