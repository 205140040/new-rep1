package com.timobb.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class SpringJmsReceive {
	public static void main(String[] args) {
		/**
		 * 使用receiveAndConvert接收jms消息，该方法会自动把消息转换成不同类型
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("");
		JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
		//Object msg = jmsTemplate.receiveAndConvert();
		Object msg = jmsTemplate.receiveSelectedAndConvert("type='eat'");
		if (msg instanceof String) {
			System.out.println(msg);
		}
	}
}
