package com.timobb.demo;

import java.util.Scanner;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class QueueReviceTransacted implements MessageListener, ExceptionListener {
	private QueueConnection queueConnection;
	private QueueSession queueSession;
	private Queue queue;

	public QueueReviceTransacted(String factoryName, String queueName) {
		loadConnection(factoryName, queueName);
	}

	public void loadConnection(String factoryName, String queueName) {
		try {
			Context context = new InitialContext();
			QueueConnectionFactory connectionFactory = (QueueConnectionFactory) context.lookup(factoryName);
			queueConnection = connectionFactory.createQueueConnection();
			//设置连接异常监听器
			queueConnection.setExceptionListener(this);
			// 消息生产者,事务性的会话,生产者的确认模式为自动确认
			queueSession = queueConnection.createQueueSession(true, Session.AUTO_ACKNOWLEDGE);
			queue = (Queue) context.lookup(queueName);
			QueueReceiver queueReceiver = queueSession.createReceiver(queue);
			queueReceiver.setMessageListener(this);
			queueConnection.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("JMSRedelivered" + message.getJMSRedelivered());
			System.out.println("接收到的消息:" + ((TextMessage) message).getText());
			// 未提交事务,消息会被服务器多次传送，直到提交事务
			// queueSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onException(JMSException exception) {
		exception.printStackTrace();
		System.out.println("连接断了....");
		System.out.println("尝试新建连接...........");
		loadConnection("connectionFactory", "queue1");
	}

	public static void main(String[] args) {
		try {
			QueueReviceTransacted reviceTransacted = new QueueReviceTransacted("connectionFactory", "queue1");
			//可通过关闭jms服务器,查看连接丢失侦听器
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入end结束:");
			String text = scanner.nextLine();
			if ("end".equalsIgnoreCase(text)) {
				reviceTransacted.queueConnection.close();
				System.exit(0);
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
