package com.timobb.demo;

import javax.jms.ExceptionListener;
import javax.jms.QueueConnection;
import javax.jms.QueueSession;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jndi.JndiTemplate;
import org.springframework.web.servlet.DispatcherServlet;

public class Test {

	public static void main(String[] args) {
		/**
		 * 第4章：点对点消息传送模型 
		 * 第5章：发布订阅消息传送模型 
		 * 第6章：消息过滤
		 * 6.1.3消息过滤时可使用and or like not in,IS NULL
		 * 143页，可以通过指定不同的目的地实现消息过滤
		 * 如:Queue q1=ctx.lookup("queue1");
		 * sesion.createSender(q1)
		 * sesion.createRevicver(q1)
		 * 第7章：保证消息传送和事务
		 *queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE)
			使用自动确认消息时，如果消费方出现问题，消息可能被再次传送
			可通过数据库中添加jmsMessageId校验消息是否被确认过
		 * 
		 * Session.AUTO_ACKNOWLEDGE：只发送一次
		 * Session.DUPS_OK_ACKNOWLEDGE;发送两次以上
		 * Session.CLIENT_ACKNOWLEDGE;客户端确认
		 * 7.3.2消息组列子,发送一组消息后，客户端再确认
		 * 7.4事务性消息
		 * 7.5ExceptionListener丢失连接监听器
		 * 7.6停用消息队列
		 * 第8章：JAVAEE和消息驱动bean
		 * 第9章：spring和JMS
		 * 9.3.2使用本地类配置spring-jms中的连接工厂，url，目的地
		 * dao 209
		 */
		//JndiTemplate
		
	}

}
