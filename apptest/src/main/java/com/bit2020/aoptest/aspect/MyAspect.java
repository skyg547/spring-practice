package com.bit2020.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	
	
	@Before("execution(public com.bit2020.aoptest.vo.ProductVo com.bit2020.aoptest.service.ProductService.find(String))")
	public void beforeAdvice() {
		
		System.out.println("-----before Advice----");
	}
	
	@After("execution(* *..*.*.ProductVo *.*.*.*.ProductService.*(..))")
	public void afterAdvice() {
		
		System.out.println("-----after Advice----");
	}
	
	@AfterReturning("execution(* *..*.*.ProductVo *.*.*.*.ProductService.*(..))")
	public void afterReuturning() {
		
		System.out.println("-----afterreun----");
	}
	
	@AfterThrowing(value = "execution(* *..*.*.ProductVo *.*.*.*.ProductService.*(..))",throwing="ex")
	public void afterThrowingAdvice(Throwable ex) {
		
		System.out.println("-----afterThrowing advicdaftethrowingadvice----"+ex);
	}
	
	@Around("execution(* *..*.*.ProductVo *.*.*.*.ProductService.*(..))")
	public void aroundAdvie(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("-----@Aorund(before)after aroung advicdaftethrowingadvice----");
		
		pjp.proceed();
		

		System.out.println("-----@Aorund(after) AdVice after aroung advicdaftethrowingadvice----");
		
		return ;
	}
}
