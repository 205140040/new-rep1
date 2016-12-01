package com.yfairy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yfairy.common.annotation.NotNeedSession;
import com.yfairy.common.session.SessionKey;
import com.yfairy.common.utils.NullUtil;
import com.yfairy.session.UserSession;
import com.yfairy.user.bean.User;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HandlerMethod method = (HandlerMethod) handler;
		NotNeedSession notNeedSession = method.getMethodAnnotation(NotNeedSession.class);
		if (NullUtil.isEmpty(notNeedSession)) {
			// 需要登录
			User user = (User) request.getSession().getAttribute(SessionKey.USER_SESSION_KEY);
			if (NullUtil.isEmpty(user)) {
				// 重定向到登录页面
				String BasePath = request.getServletContext().getContextPath();
				response.sendRedirect(BasePath + "/login/toLoginPage");
				return false;
			} else {
				UserSession.setUser(user);
			}
		}
		return super.preHandle(request, response, handler);
	}
}
