package com.timobb.demo;

import java.util.Scanner;

import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;

public class TopicLender {
	// 连接
	private TopicConnection connection;
	// 会话
	private TopicSession session;
	// 目的地，主题或queue
	private Topic topic;

	public TopicLender(String connFactory, String topicName) {
		try {
			// 通过jndi获得JMS提供的初始化上下文
			Context context = new InitialContext();
			// 获得连接工厂
			TopicConnectionFactory connectionFactory = (TopicConnectionFactory) context.lookup(connFactory);
			// 创建连接
			this.connection = connectionFactory.createTopicConnection();
			// 创建会话
			this.session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			// 查找请求队列
			topic = (Topic) context.lookup(topicName);
			// 启动连接
			connection.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void publishRate(String rate) {
		try {
			// 发布利率
			TextMessage message = session.createTextMessage(rate);
			TopicPublisher topicPublisher = session.createPublisher(topic);
			topicPublisher.publish(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TopicLender topicLender = new TopicLender("TopicCF", "topic2");
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入利率:");
		String msg = scanner.nextLine();
		while (!"end".equalsIgnoreCase(msg)) {
			topicLender.publishRate(msg);
			System.out.println("请输入利率:");
			msg = scanner.nextLine();
		}
		scanner.close();
	}

}
