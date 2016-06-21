package com.demo.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.hello.service.IHelloService;

public class TestConsumer {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("dubbo-consumer.xml");
		IHelloService helloService=(IHelloService)context.getBean("helloService");
		helloService.sayHello("啦啦啦");
	}
}
