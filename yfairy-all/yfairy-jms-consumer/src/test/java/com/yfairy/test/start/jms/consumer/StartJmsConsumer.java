package com.yfairy.test.start.jms.consumer;

import com.yfairy.common.jetty.StartJetty;

public class StartJmsConsumer {
	public static void main(String[] args) {
		StartJetty.startJetty(8083, "/yfairy-jms-consumer");
	}
}
