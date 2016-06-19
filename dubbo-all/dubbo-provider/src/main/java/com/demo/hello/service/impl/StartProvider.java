package com.demo.hello.service.impl;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartProvider {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		// context.start();
		System.out.println("启动成功");
		try {
			System.in.read();// 按任意键退出
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
