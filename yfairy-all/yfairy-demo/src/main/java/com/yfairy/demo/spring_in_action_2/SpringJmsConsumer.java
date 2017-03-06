package com.yfairy.demo.spring_in_action_2;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class SpringJmsConsumer {

	public static void main(String[] args) throws JMSException {
		String xmlfileStr = "com\\yfairy\\demo\\spring_in_action_2\\spring-demo.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(xmlfileStr);
		// 10.2.2使用JMS 模板 JmsTemplate
		// JmsTemplate

		JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
		// 同步接收消息
		TextMessage textMessage = (TextMessage) jmsTemplate.receive();
		System.err.println("spring msg:" + textMessage.getText());
		try {
			Thread.sleep(360 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
