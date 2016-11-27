package com.yfairy.login.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.google.code.kaptcha.Constants;
import com.yfairy.common.annotation.NotNeedSession;
import com.yfairy.common.beans.Result;
import com.yfairy.common.session.SessionKey;
import com.yfairy.common.utils.NullUtil;
import com.yfairy.user.bean.User;
import com.yfairy.user.service.ILoginService;

@RequestMapping("/login")
@Controller
public class LoginController {

	@Reference
	private ILoginService loginService;

	@NotNeedSession
	@RequestMapping("/toLoginPage")
	public String toLoginPage() {
		return "jsp/login/login";
	}

	@NotNeedSession
	@RequestMapping("/doLogin")
	@ResponseBody
	public Result login(User user, String kaptchaCode, HttpServletRequest request) {
		if (NullUtil.isEmpty(kaptchaCode)) {
			return Result.resultFalse("验证码不能为空!");
		}
		// session中的验证码
		String captchaId = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if (!captchaId.equals(kaptchaCode)) {
			return Result.resultFalse("验证码错误!");
		}

		Result result = loginService.login(user);
		if (NullUtil.isNotEmpty(result) && NullUtil.isNotEmpty(result.getFlag()) && result.getFlag()) {
			// 登录成功，保存session
			HttpSession httpSession = request.getSession();
			User successUser = (User) result.getObject();
			httpSession.setAttribute(SessionKey.USER_SESSION_KEY, successUser);
			User resUser = new User();
			BeanUtils.copyProperties(successUser, resUser);
			resUser.setId(null);
			resUser.setPassword(null);
			result.setObject(resUser);
		}
		return result;
	}

	@NotNeedSession
	@RequestMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession httpSession = request.getSession();
		httpSession.removeAttribute(SessionKey.USER_SESSION_KEY);
		// 重定向到index页面
		String BasePath = request.getServletContext().getContextPath();
		try {
			response.sendRedirect(BasePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
