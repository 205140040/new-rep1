package com.timobb.demo;

import java.util.Scanner;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.InitialContext;

public class Chat implements MessageListener {
	private TopicSession pubSession;
	private TopicPublisher publisher;
	private TopicConnection connection;

	public Chat(String topicFactory, String topicName) {
		try {
			// 使用jndi.properties获取一个连接
			InitialContext ctx = new InitialContext();
			// 查找连接工厂
			TopicConnectionFactory conFactory = (TopicConnectionFactory) ctx.lookup(topicFactory);
			// 创建连接
			TopicConnection connection = conFactory.createTopicConnection();
			// 创建两个jms回话对象
			/**
			 * boolean transacted,
			 * 是否支持事务
			 *  int acknowledgeMode
			 *  使用的确认模式,AUTO_ACKNOWLEDGE自动确认
			 */
			TopicSession pubSession = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			TopicSession subSession = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			// 查找一个JMS主题
			Topic chatTopic = (Topic) ctx.lookup(topicName);
			// 创建一个JMS发布者和订阅者
			TopicPublisher publisher = pubSession.createPublisher(chatTopic);
			// 订阅者,选择器null,nolocal,表明这个发布者生产的消息不应该被自己消费
			TopicSubscriber subscriber = subSession.createSubscriber(chatTopic, null, false);
			// 设置一个JMS监听器
			subscriber.setMessageListener(this);
			// 初始化chat应用程序变量
			this.connection = connection;
			this.pubSession = pubSession;
			this.publisher = publisher;
			// 启动JMS连接，允许传送消息
			connection.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 接收消息
	 */
	@Override
	public void onMessage(Message message) {
		try {
			/**
			 * Message:消息
			 * 第三章：剖析一条消息
			 * 消息对象包含:消息头，消息属性，消息数据
			 * 
			 */
			TextMessage textMessage = (TextMessage) message;
			
			//消息头...
			System.out.println("消息目的地:"+textMessage.getJMSDestination());
			//消息传送模式：持久型模式，非持久型模式，默认为持久型的
			int deliveryMode=textMessage.getJMSDeliveryMode();
			if(javax.jms.DeliveryMode.PERSISTENT==deliveryMode){
				System.out.println("消息传送模式:"+textMessage.getJMSDeliveryMode()+",持久型");
			}else if (javax.jms.DeliveryMode.NON_PERSISTENT==deliveryMode) {
				System.out.println("消息传送模式:"+textMessage.getJMSDeliveryMode()+",非持久型");
			}
			//JMSMessageID消息id唯一索引
			System.out.println("JMSMessageID:"+textMessage.getJMSMessageID());
			//JMSPriority优先级
			System.out.println("JMSPriority:"+textMessage.getJMSPriority());
			//2.消息属性，基本类型
			//应用程序特定的属性,textMessage.setStringProperty("username", "lalla");
			//3.3消息类型：基类：message，textmessage，mapmessage等
			//3.3.8客户端确认的消息Session.CLIENT_ACKNOWLEDGE
			//设置为客户端确认时，需在onmessage中调用textMessage.acknowledge();确认消息
			//textMessage.acknowledge();
			
			System.out.println("getJMSType:"+textMessage.getJMSType());

			System.out.println("接收的消息:" + textMessage.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 使用发布者创建并发布消息
	 */
	public void writeMessage(String text) {
		try {
			TextMessage textMessage = pubSession.createTextMessage();
			textMessage.setText(text);
			// System.out.println("发送消息:"+username + ":" + text);
			//通过publisher设置消息传送模式为非持久型的
			publisher.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			publisher.publish(textMessage);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭JMS连接
	 */
	public void close() {
		try {
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// 运行
		Chat chat = new Chat("TopicCF", "topic1");
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入消息:");
		String msg = scanner.nextLine();
		while (!"end".equalsIgnoreCase(msg)) {
			chat.writeMessage(msg);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("请输入消息:");
			msg = scanner.nextLine();
		}
		chat.close();
		scanner.close();
	}
}
