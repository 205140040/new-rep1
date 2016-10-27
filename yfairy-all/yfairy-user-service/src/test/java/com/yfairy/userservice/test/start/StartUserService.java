package com.yfairy.userservice.test.start;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yfairy.user.service.IHelloService;

public class StartUserService {

	public static void main(String[] args) {
		// Main.main(null);
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		IHelloService hs = (IHelloService) context.getBean("HelloServiceImpl");
		hs.hello("6666");
	}

}
