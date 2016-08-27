package com.timobb.demo;

import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.listener.adapter.MessageListenerAdapter;

public class SpringAsyncReceive extends MessageListenerAdapter {
	@Override
	protected void handleResult(Object result, Message request, Session session) {
		// TODO Auto-generated method stub
		super.handleResult(result, request, session);
	}
}
