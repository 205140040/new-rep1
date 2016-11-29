package com.yfairy.jms.provider.service.impl;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;

import com.yfairy.jms.provider.service.IJmsSender;

public class JmsSender implements IJmsSender {
	@Autowired
	private JmsTemplate jmsTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yfairy.jms.provider.service.imp.IJmsSender#send(T,
	 * java.lang.String)
	 */
	@Override
	public <T> void send(T object, final String type) {
		// 通过MessagePostProcessor设置消息属性
		MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
			@Override
			public Message postProcessMessage(Message message) throws JMSException {
				// 设置消息选择器type
				message.setStringProperty("type", type);
				return message;
			}
		};
		jmsTemplate.convertAndSend(object, messagePostProcessor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yfairy.jms.provider.service.imp.IJmsSender#send(T)
	 */
	@Override
	public <T> void send(T object) {
		jmsTemplate.convertAndSend(object);
	}
}
