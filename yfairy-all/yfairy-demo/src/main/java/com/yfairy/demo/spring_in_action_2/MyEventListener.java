package com.yfairy.demo.spring_in_action_2;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;

public class MyEventListener implements ApplicationListener<ApplicationEvent> {

	private IHelloService helloService;

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (ContextRefreshedEvent.class.getName().equals(event.getClass().getName())) {
			System.out.println("事件ContextRefreshedEvent:上下文被初始化或刷新时发布:" + event.getSource());
		} else if (ContextClosedEvent.class.getName().equals(event.getClass().getName())) {
			System.out.println("上下文关闭事件发生ContextClosedEvent");
		}
	}

	public void execSayHello() {
		helloService.sayHello();
	}

	public IHelloService getHelloService() {
		return helloService;
	}

	public void setHelloService(IHelloService helloService) {
		this.helloService = helloService;
	}

}
