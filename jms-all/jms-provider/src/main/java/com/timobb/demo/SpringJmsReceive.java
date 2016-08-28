package com.timobb.demo;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class SpringJmsReceive {
	public static void main(String[] args) {
		/**
		 * 使用receiveAndConvert接收jms消息，该方法会自动把消息转换成不同类型
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
		// Object msg = jmsTemplate.receiveAndConvert();
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入消息:");
		String opt = scanner.nextLine();
		while (!"end".equals(opt)) {
			Object msg = jmsTemplate.receiveSelectedAndConvert("type='eat'");
			if (msg instanceof String) {
				System.out.println("同步接收到的消息:" + msg);
			}
		}
		scanner.close();
	}
}
