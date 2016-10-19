package com.yfairy.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class WelcomeInterpector extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		if ("/".equals(uri)) {
			response.sendRedirect("/index.jsp");
		}
		return super.preHandle(request, response, handler);
	}
}
