package com.yfairy.test.service.impl;

import org.springframework.context.ApplicationContext;

import com.alibaba.dubbo.config.spring.ServiceBean;
import com.yfairy.user.service.ILoginService;

public class GetApplicationContextTestImpl {
	public void test() {
		/**
		 * 
		 */
		/**
		 * dubbo中可在service中使用dubbo的ServiceBean，获取ApplicationContext
		 */
		ApplicationContext context = ServiceBean.getSpringContext();
		ILoginService loginService = (ILoginService) context.getBean("loginService");
		System.out.println(loginService);

		/**
		 * bean中通过实现ApplicationContextAware,来获取当前的applicationContext对象
		 */
		ApplicationContext applicationContext = ApplicationContextHelper.getApplicationContext();
		ILoginService loginService2 = (ILoginService) applicationContext.getBean("loginService");
		System.out.println(loginService2);
	}

	public static void main(String[] args) {
		ApplicationContext context = ServiceBean.getSpringContext();
		ILoginService loginService = (ILoginService) context.getBean("loginService");
		System.out.println(loginService);
	}

}
