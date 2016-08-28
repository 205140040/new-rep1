package com.timobb.demo;

import java.util.Scanner;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;

public class SpringJmsSender {
	public static void main(String[] args) {
		/**
		 * 使用convertAndSend发送jms消息，该方法会自动把消息转换成不同类型
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
		// 通过MessagePostProcessor设置消息属性
		MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
			@Override
			public Message postProcessMessage(Message message) throws JMSException {
				message.setJMSPriority(9); // 设置高优先级
				message.setStringProperty("type", "eat");
				return message;
			}
		};
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入消息:");
		String msg = scanner.nextLine();
		while (!"end".equalsIgnoreCase(msg)) {
			jmsTemplate.convertAndSend((Object) msg, messagePostProcessor);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("请输入消息:");
			msg = scanner.nextLine();
		}
	}
}
