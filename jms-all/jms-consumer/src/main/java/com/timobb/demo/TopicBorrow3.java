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

public class TopicBorrow3 implements MessageListener {

	private TopicConnection topicConnection;
	private TopicSession topicSession;
	private Topic topic;

	public TopicBorrow3(String factory, String topicName) {
		try {
			Context context = new InitialContext();
			TopicConnectionFactory connectionFactory = (TopicConnectionFactory) context.lookup(factory);
			topicConnection = connectionFactory.createTopicConnection();
			topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			topic = (Topic) context.lookup(topicName);
			// 创建消息监听者，并设置监听器
			//设置消息过滤器,type='500'
			TopicSubscriber topicSubscriber = topicSession.createSubscriber(topic,"type='500'",false);
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
			System.out.println("TopicBorrow3订阅的消息:" + textMessage.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TopicBorrow3 topicLender = new TopicBorrow3("TopicCF", "topic2");
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入end:");
		String msg = scanner.nextLine();
		while (!"end".equalsIgnoreCase(msg)) {

		}
		scanner.close();
	}
}
