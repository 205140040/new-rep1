package com.yfairy.demo.spring_in_action_2;

import org.springframework.context.ApplicationEvent;

public class MyApplicationEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyApplicationEvent(Object source) {
		super(source);
	}

}
