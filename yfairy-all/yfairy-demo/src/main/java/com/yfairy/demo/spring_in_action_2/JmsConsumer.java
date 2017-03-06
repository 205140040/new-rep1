package com.yfairy.demo.spring_in_action_2;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class JmsConsumer {

	public static void main(String[] args) throws JMSException {
		String brokerURL = "tcp://localhost:61616";

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerURL);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = new ActiveMQQueue("des1");
		MessageConsumer messageConsumer = session.createConsumer(destination);
		while (true) { // 循环一直接收消息
			// ActiveMQMessageConsumer
			// Receives the next message produced for this message consumer.
			Message message = messageConsumer.receive();
			System.err.println("TextMessage:" + ((TextMessage) message).getText());
		}

		// session.close();
		// try {
		// Thread.sleep(3 * 60 * 1000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// connection.close();
	}

}
