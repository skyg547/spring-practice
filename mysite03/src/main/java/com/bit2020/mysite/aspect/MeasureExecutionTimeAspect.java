package com.bit2020.mysite.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MeasureExecutionTimeAspect {

	
	@Around("execution(* *..*.repository.*.*(..))||execution(* *..*.controller.*.*(..))||execution(* *..*.service.*.*(..))")
	public Object aroundAspect(ProceedingJoinPoint pjp) {
		
		Object result = pjp.proceed();
		
	
		String className = 
				Stirng method Name 
		
		return result;
	}
}
