package com.bit2020.mysite.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //advice -> aop
public class GlobalExceptionHandler {
	private static final Log LOG = LogFactory.getLog(GlobalExceptionHandler.class);

	
	@ExceptionHandler(Exception.class)
	public void handlerException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Exception e) throws Exception {
		
				
		//1. 로깅 작업
		System.out.println("error:" + e);
		StringWriter errors = new StringWriter(); //버퍼
		e.printStackTrace(new PrintWriter(errors));
		LOG.error("error:" + e);
		//2. 사과페이wl
		httpServletRequest.setAttribute("exception", e.toString());
		
		httpServletRequest.getRequestDispatcher("/WEB-INF/views/error/exception.jsp").forward(httpServletRequest, httpServletResponse);
	
	}
	
	
}
