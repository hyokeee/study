package kr.or.ddit.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/*
 Aspect(에스팩트) : AOP의 단위가 되는 횡단 관심사
  - 횡단 관심사(Cross-Cutting Concern) : 핵심(core) 비즈니스 로직(삼겹살구워먹기)과
  				다소 거리가 있지만 , 여러 보듈에서 공통적이고 반복적인 처리를 요구하는 내용
  				(불판닦기, 불판교체)
  - 횡단  관심사 분리(Separation of Cross-Cutting Concern) : 횡단 관심사에 해당하는 부분
  				(불판닦기, 불판교체..)을 분리해서 한 곳으로 모은다.
  - Component : 골뱅이Aspect와 짝꿍. component-scan 시 "여기 봐주세요" 라는 의미 
  - JoinPoint : 어드바이스(특정 조인 포인트(불판이 탔을때)에서 실행되는 코드. 횡단 관심사를 실제로 구현)
  - Advice : 어떤 부가기능(불판닦기)을 언제(삼겹살을 굽기 전(Before)에) 사용할지 정의
  			* 언제 ?
  			- Before : 조인포인트 전에 실행(삼겹살을 굽기 직전)
  			- After  : 조인포인트에서 처리가 완료된 후 실행(삼겹살을 굽고 먹은 직후 실행)
  			- Around : 조인포인트 전후에 실행(삼겹살을 굽기 직전과 먹은 후 실행)
  			- After Returning : 조인 포인트가 정상적으로 종료 후 실행
  			- After Throwing  : 조인 포인트에서 예외 발생 시 실행. 예외가 발생안되면 실행 x
 */
@Slf4j
@Component
@Aspect
public class ServiceLoggerAdvice {
	//로보트에 : AOP 대상 ( 로그, 보안, 트랜잭션, 에러 )
	//포인트컷 표현식. 별쩜쩜별괄호쩜쩜괄호
	//execution : 포인트컷(대상(메서드)을 선별하는 것) 지정자
	//*  : 임의의 1개의 리턴타입
	//.. : 임의의 0개 이상 
	//kr.or.ddit.*..*(..)
	//		패키지 밑의 각각의 패키지가 있고
	//				그 하위에 모든 파일/패키지
	//					각각의 메서드가 있고
	//				(..) : 메서드의 모든 파라미터
	@Before("execution(* kr.or.ddit.*..*(..))")
	public void startLog(JoinPoint jp) {
		log.info("startLog");
		
		//.getSignature() : 어떤 클래스의 어떤 메서드가 실행되었는지 보여짐.
		//					파라미터 타입은 무엇이든 보여줌
		//kr.or.ddit.service.BoardService.register(BoardVO)
		log.info("startLog : " + jp.getSignature());
		// .getArgs() : 전달 된 파라미터 정보를 보여줌
		// [BoardaVO [boardNo=127, title=개똥이]]
		log.info("startLog : " + Arrays.toString(jp.getArgs()));
	}
	
	//AfterReturning 어드바이스
	// 조인포인트가 정상적으로 종료한 후에 실행됨. 예외 발생 시 실행 안됨
	@AfterReturning("execution(* kr.or.ddit.*..*(..))")
	public void logReturning(JoinPoint jp) {
		log.info("logReturning");
		//.getSignature() : 어떤 클래스의 어떤 메서드가 실행되었는지 보여짐.
		//					파라미터 타입은 무엇이든 보여줌
		log.info("logReturning : " + jp.getSignature());
	}
	
	//After Throwing 어드바이스
	// 조인 포인트에서 예외 발생 시 실행. 예외가 발생 안되면 실행 안됨
	@AfterThrowing(pointcut="execution(* kr.or.ddit.*..*(..))",throwing = "e")
	public void logException(JoinPoint jp, Exception e) {
		log.info("logException");
		//.getSignature() : 어떤 클래스의 어떤 메서드가 실행되었는지 보여짐.
		//					파라미터 타입은 무엇이든 보여줌
		log.info("logException : " + jp.getSignature());
		//예외 메시지를 보여줌
		log.info("logException : " + e);
	}
	
	//After 어드바이스
	// 조인포인트 완료 후 실행
	// 예외 발생이 되더라도 항상 실행됨
	@After("execution(* kr.or.ddit.*..*(..))")
	public void endLog(JoinPoint jp) {
		log.info("endLog");
		log.info("endLog : " + jp.getSignature());
		log.info("endLog : " + Arrays.toString(jp.getArgs()));
	}
	
	// ProceedingJoinPoint : around 어드바이스에서 사용
	// 횡단괌심사 - 부수적, 포인트컷 대상
	// 스프링프레임워크가 컨트롤하고 있는 비즈니스로직 호출을 가로챔. 책임이 around 어드바이스로 전가됨
	// 그래서 비즈니스 메서드에 대한 정보를 around 어드바이스 메서드가 가지고 있어야 하고
	// 그 정보를 스프링 컨테이너가 around 어드바이스 메서드로 넘겨주면
	// ProceedingJoinPoint 객체로 받아서 around 어드바이스가 컨트롤 시 활용함
	@Around("execution(* kr.or.ddit.*..*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable{
		//메서드 실행 직전 시간 체킹
		long startTime = System.currentTimeMillis();
		log.info("pjpStart : " + Arrays.toString(pjp.getArgs()));
		
		//메서드 실행
		Object result = pjp.proceed();
		
		//메서드 실행 직후 시간 체킹
		long endTime = System.currentTimeMillis();
		log.info("pjpEnd : " + Arrays.toString(pjp.getArgs()));
		
		//직후 시간 - 직전 시간 => 메서드 실행 시간
		log.info(pjp.getSignature().getName() + " : " + (endTime-startTime));
		
		return result;
	}
}
