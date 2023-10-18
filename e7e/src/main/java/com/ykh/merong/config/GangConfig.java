package com.ykh.merong.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/* 
 	EnableScheduling을 사용하면 스케줄러를 편하게 사용할 수 있다 .
 */
@Configuration		// root-context에서 annotation-config
@EnableScheduling	// 기본제공 스케줄러 사용하겠다, xml로 (task~~) 하면 복잡함. 
public class GangConfig {

}
