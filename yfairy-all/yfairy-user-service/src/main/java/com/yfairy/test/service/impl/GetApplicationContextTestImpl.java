package com.yfairy.test.service.impl;

import org.springframework.context.ApplicationContext;

import com.alibaba.dubbo.config.spring.ServiceBean;
import com.yfairy.user.service.ILoginService;

public class GetApplicationContextTestImpl {
	public void test() {
		ApplicationContext context=ServiceBean.getSpringContext();
		ILoginService loginService=(ILoginService)context.getBean("loginService");
		System.out.println(loginService);
	}
	
	public static void main(String[] args) {
		ApplicationContext context=ServiceBean.getSpringContext();
		ILoginService loginService=(ILoginService)context.getBean("loginService");
		System.out.println(loginService);
	}
	
}
