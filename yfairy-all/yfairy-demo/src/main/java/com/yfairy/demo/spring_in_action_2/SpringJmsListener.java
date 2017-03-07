package com.yfairy.demo.spring_in_action_2;

import java.util.Enumeration;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

public class SpringJmsListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		MapMessage mapMessage = (MapMessage) message;
		try {
			@SuppressWarnings("rawtypes")
			Enumeration enumeration = mapMessage.getMapNames();
			while (enumeration.hasMoreElements()) {
				Object key = enumeration.nextElement();
				Object value = mapMessage.getObject(key.toString());
				System.err.println("key:" + key + "\tvalue:" + value);
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
