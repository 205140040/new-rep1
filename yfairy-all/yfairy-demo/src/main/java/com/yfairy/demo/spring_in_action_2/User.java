package com.yfairy.demo.spring_in_action_2;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable("user")
public class User {

	private IHelloService helloService;

	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void sayHello() {
		helloService.sayHello();
	}

	public IHelloService getHelloService() {
		return helloService;
	}

	public void setHelloService(IHelloService helloService) {
		this.helloService = helloService;
	}

}
