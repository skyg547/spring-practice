package com.bit2020.mysite.exception;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //advice -> aop
public class GlobalExceptionHandler {

	
	@ExceptionHandler(Exception.class)
	public void handlerException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Exception e) throws Exception {
		
				
		//1. 로깅 작업
		System.out.println("error:" + e);
		
		//2. 사과페이wl
		httpServletRequest.setAttribute("exception", e.toString());
		httpServletRequest.getRequestDispatcher("/WEB-INF/views/error/exception.jsp").forward(httpServletRequest, httpServletResponse);
		
	}
	
	
}
