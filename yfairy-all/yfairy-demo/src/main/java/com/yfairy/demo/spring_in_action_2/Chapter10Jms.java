package com.yfairy.demo.spring_in_action_2;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.core.support.JmsGatewaySupport;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

public class Chapter10Jms {

	public static void main(String[] args) throws JMSException {
		/**
		 * TODO 第10章：spring消息(jms)(281/505)<br>
		 * 
		 * broker 英[ˈbrəʊkə(r)]<br>
		 * n. （股票、外币等） 经纪人; 中间人，代理人; 旧货商人; 〈口〉婚姻介绍人;<br>
		 * vt. 作为权力经纪人进行谈判; 作为中间人来安排、设法;<br>
		 * 
		 * destination 英[ˌdestɪˈneɪʃn]<br>
		 * n. 目的，目标; 目的地，终点; [罕用语] 预定，指定;<br>
		 * 
		 * refuse_百度翻译<br>
		 * refuse 英[rɪˈfju:z]<br>
		 * v. 拒绝; 回绝; 推却;<br>
		 * n. 垃圾; 废弃物;<br>
		 * 到10.2.3转换消息(293/505)<br>
		 */

		// 10.1.1构建jms

		// 创建连接工厂
		// ActiveMQConnectionFactory
		String xmlfileStr = "com\\yfairy\\demo\\spring_in_action_2\\spring-demo.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(xmlfileStr);

		// 创建连接工厂
		String brokerURL = "tcp://localhost:61616";
		ActiveMQConnectionFactory activeMQConnectionFactory = null;
		// (ActiveMQConnectionFactory) context
		// .getBean("activeMQConnectionFactory");
		activeMQConnectionFactory = new ActiveMQConnectionFactory(brokerURL);
		// 创建连接
		Connection connection = activeMQConnectionFactory.createConnection();
		connection.start();
		// 创建会话
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		// QueueSession session = connection.createSession(false,
		// Session.AUTO_ACKNOWLEDGE);
		// session.crea

		// 声明消息目的地,Destination,Queue,ActiveMQQueue
		Destination destination = new ActiveMQQueue("des1");
		// 消息生产者
		MessageProducer messageProducer = session.createProducer(destination);
		TextMessage message = session.createTextMessage("hello,world" + "\t" + new Date().toLocaleString());
		// 发送消息
		messageProducer.send(message);
		TextMessage message2 = session.createTextMessage("hello,world222" + "\t" + new Date().toLocaleString());
		messageProducer.send(message2);
		// 关闭
		session.close();
		try {
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		connection.close();

		// 10.2协同使用jms和spirng

		// 10.2.2使用JMS 模板 JmsTemplate
		// JmsTemplate

		JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
		// 发送消息
		MessageCreator messageCreator = new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session
						.createTextMessage("spring jms hello" + "\t" + new Date().toLocaleString());
				return textMessage;
			}
		};
//		jmsTemplate.send(destination,messageCreator);
		
		//发送到默认目的地
//		jmsTemplate.send(messageCreator);
		
		// 到10.2.3转换消息(293/505)<br>
//		MessageConverter,SimpleMessageConverter
		Map<String, String> msgMap=new HashMap<>();
		msgMap.put("1", "hello");
		msgMap.put("2", "world"+(new Date()).toGMTString());
		jmsTemplate.convertAndSend(msgMap);

		//10.2.4 将spring的网关支持类应用于jms JmsGatewaySupport,继承该类，相当于在父类中设置了jmstemplate
//		JmsGatewaySupport
		
		//10.3创建消息驱动POJO
		//10.3.1创建消息监听器
		
		
		//10.4使用基于消息的RPC
		//10.4.1引入Lingo
		
	}

}
