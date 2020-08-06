package com.bit2020.mysite.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.bit2020.mysite.controller.AuthUser;
import com.bit2020.mysite.vo.UserVo;

public class AuthUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
	
	

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
	
		AuthUser authUser = parameter.getParameterAnnotation(AuthUser.class);
		
		//@AuthUser가 안 붙어 있으면
		if(authUser == null) {
			return false;
			
		}
		
		// 파라미토 터압아 UserVo가 아니면
		if(parameter.getParameterType().equals(UserVo.class) == false) {
			return false;
			
		}
		
		return true;
	}

	@Override
	public Object resolveArgument(
		MethodParameter parameter,
		ModelAndViewContainer mavContainer,
		NativeWebRequest webRequest,
		WebDataBinderFactory binderFactory) throws Exception {
		
		if(supportsParameter(parameter)== false) {
			
			return WebArgumentResolver.UNRESOLVED;
		}
		
		HttpServletRequest request = (HttpServletRequest)webRequest.getNativeRequest();
		
		HttpSession session=  request.getSession();
		
		if(session == null) {
			
			return null;
		}
		return session.getAttribute("authUser");
	}

}
