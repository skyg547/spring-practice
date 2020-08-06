package com.bit2020.mysite.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub

		// 1. Handler 종류확인

		if (handler instanceof HandlerMethod == false) {

			// DefaultServletHandler (보통 , assets의 정적 자원 접근)
			return true;
		}

		// .2 casting

		HandlerMethod handlerMethod = (HandlerMethod) handler;

		// 3. HandlerMethㅐd의 @Auth받아오기

		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);

		// 4. @Auth 가 안붙어있는 경우

		if (auth == null) {

			return true;
		}

		// 5. @Auth가 붙어 있기 때문에 인증(Authentificatinon) 여부 확인
		HttpSession session = request.getSession();

		if (session == null) {

			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;

		}

		Object authUser = session.getAttribute("authUser");

		if (authUser == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}

		// 6.@Auth 가 붙어 있고 인증도 돠어있음
		return true;
	}

}
