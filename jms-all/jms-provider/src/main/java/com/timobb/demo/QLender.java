package com.timobb.demo;

import java.util.Enumeration;
import java.util.Scanner;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class QLender implements MessageListener {
	private QueueConnection queueConnection;
	private QueueSession queueSession;
	private Queue requestQueue;

	public QLender(String connectionFactory, String reqQueue) {
		try {
			Context ctx = new InitialContext();
			QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) ctx.lookup(connectionFactory);
			this.queueConnection = queueConnectionFactory.createQueueConnection();
			queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			requestQueue = (Queue) ctx.lookup(reqQueue);
			// 启动
			queueConnection.start();
			// 创建消息侦听器
			QueueReceiver queueReceiver = queueSession.createReceiver(requestQueue);
			// 设置消息监听器
			queueReceiver.setMessageListener(this);
			System.out.println("等待请求.........");

			/**
			 * 查看队列中的消息快照
			 */
			QueueBrowser queueBrowser = queueSession.createBrowser(requestQueue);// 请求队列中的快照
			Enumeration enumeration = queueBrowser.getEnumeration();
			while (enumeration.hasMoreElements()) {
				TextMessage message = (TextMessage) enumeration.nextElement();
				System.out.println(message.getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onMessage(Message message) {
		try {
			MapMessage mapMessage = (MapMessage) message;
			double salary = mapMessage.getDouble("salary");
			double loanAmt = mapMessage.getDouble("loanAmt");
			System.out.println("接收到的消息:" + "salary:" + salary + ",amt:" + loanAmt);
			// 将结果发送回借方
			TextMessage resMsg = queueSession.createTextMessage("同意");
			// 设置消息关联，设置一个唯一的id作为消息关联
			resMsg.setJMSCorrelationID(mapMessage.getJMSMessageID());

			QueueSender sender = queueSession.createSender((Queue) message.getJMSReplyTo());
			sender.send(resMsg);
			System.out.println("等待请求...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		QLender qLender = new QLender("QueueCF", "LoanRequestQ");
		Scanner scanner = new Scanner(System.in);
		String opt = scanner.nextLine();
		while ("end".equalsIgnoreCase(opt)) {
			try {
				qLender.queueConnection.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
			System.exit(0);
		}
	}

}
