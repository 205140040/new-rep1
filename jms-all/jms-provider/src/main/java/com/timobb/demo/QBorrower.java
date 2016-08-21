package com.timobb.demo;

import java.util.Scanner;

import javax.jms.MapMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class QBorrower {
	private QueueConnection queueConnection;
	private QueueSession queueSession;
	private Queue requestQueue;
	private Queue responseQueue;

	public QBorrower(String queueConnectionFactory, String reqQueue, String resQueue) {
		try {
			Context ctx = new InitialContext();
			QueueConnectionFactory connectionFactory = (QueueConnectionFactory) ctx.lookup(queueConnectionFactory);
			this.queueConnection = connectionFactory.createQueueConnection();
			// 创建JMS回话
			this.queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			// 查找请求和响应队列
			this.requestQueue = (Queue) ctx.lookup(reqQueue);
			this.responseQueue = (Queue) ctx.lookup(resQueue);
			// 启动
			queueConnection.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendLoanRequest(double salary, double loanAmt) {
		// 创建jms消息
		try {
			MapMessage mapMessage = queueSession.createMapMessage();
			mapMessage.setDouble("salary", salary);
			mapMessage.setDouble("loanAmt", loanAmt);
			// 设置ReplyTo，消息回复者队列
			mapMessage.setJMSReplyTo(responseQueue);

			// 创建发送者并发送消息
			QueueSender sender = queueSession.createSender(requestQueue);
			sender.send(mapMessage);

			// 等待查看贷款申请响应
			// 设置消息关联，设置一个唯一的id作为消息关联
			String filter = "JMSCorrelationID='" + mapMessage.getJMSMessageID() + "'";
			QueueReceiver receiver = queueSession.createReceiver(responseQueue, filter);
			TextMessage responseMsg = (TextMessage) receiver.receive(30000);
			if (null == responseMsg) {
				System.out.println("QLender 无响应");
			} else {
				System.out.println("响应类容:" + responseMsg.getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		QBorrower qBorrower = new QBorrower("QueueCF", "LoanRequestQ", "LoanResponseQ");
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入类容:");
		String msg = scanner.nextLine();
		while (!"end".equalsIgnoreCase(msg)) {
			String[] ss = msg.split(",");
			double salary = new Double(ss[0]);
			double loanAmt = new Double(ss[1]);
			qBorrower.sendLoanRequest(salary, loanAmt);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("请输入类容:");
			msg = scanner.nextLine();
		}
	}
}
