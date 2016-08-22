package com.timobb.demo;

import java.util.Scanner;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;

public class TopicBorrow implements MessageListener {

	private TopicConnection topicConnection;
	private TopicSession topicSession;
	private Topic topic;

	public TopicBorrow(String factory, String topicName) {
		try {
			Context context = new InitialContext();
			TopicConnectionFactory connectionFactory = (TopicConnectionFactory) context.lookup(factory);
			topicConnection = connectionFactory.createTopicConnection();
			topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			topic = (Topic) context.lookup(topicName);
			// 创建消息监听者，并设置监听器
			// TopicSubscriber topicSubscriber =
			// topicSession.createSubscriber(topic);
			// 创建一个持久订阅者，持久订阅者如果重启了，可以接收到之前停止时的订阅信息
			TopicSubscriber topicSubscriber = topicSession.createDurableSubscriber(topic, "TopicBorrow");
			// 取消持久订阅者
			// topicSession.unsubscribe("TopicBorrow");
			topicSubscriber.setMessageListener(this);
			topicConnection.start();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onMessage(Message message) {
		try {
			TextMessage textMessage = (TextMessage) message;
			System.out.println("订阅的消息:" + textMessage.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TopicBorrow topicLender = new TopicBorrow("TopicCF", "topic2");
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入end:");
		String msg = scanner.nextLine();
		while (!"end".equalsIgnoreCase(msg)) {

		}
		scanner.close();
	}

}
