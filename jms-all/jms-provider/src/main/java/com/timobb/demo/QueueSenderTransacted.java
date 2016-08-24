package com.timobb.demo;

import java.util.Scanner;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * 带有事务的发送
 * 
 * @author jiangzi
 *
 */
public class QueueSenderTransacted {
	private QueueConnection queueConnection;
	private QueueSession queueSession;
	private Queue queue;

	public QueueSenderTransacted(String factoryName, String queueName) {
		try {
			Context context = new InitialContext();
			QueueConnectionFactory connectionFactory = (QueueConnectionFactory) context.lookup(factoryName);
			queueConnection = connectionFactory.createQueueConnection();
			// 消息生产者,事务性的会话,生产者的确认模式为自动确认
			queueSession = queueConnection.createQueueSession(true, Session.AUTO_ACKNOWLEDGE);
			queue = (Queue) context.lookup(queueName);
			queueConnection.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendTransacted(String text) {
		try {
			TextMessage message = queueSession.createTextMessage(text);
			QueueSender queueSender = queueSession.createSender(queue);
			queueSender.send(message);
			// 未提交事务,消息不会发送
			queueSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				// 回滚事务
				System.out.println("回滚事务");
				queueSession.rollback();
			} catch (JMSException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		try {
			QueueSenderTransacted senderTransacted = new QueueSenderTransacted("connectionFactory", "queue1");
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入消息:");
			String text = scanner.nextLine();
			while (!"end".equalsIgnoreCase(text)) {
				senderTransacted.sendTransacted(text);
				Thread.sleep(800);
				System.out.println("请输入消息:");
				text = scanner.nextLine();
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
