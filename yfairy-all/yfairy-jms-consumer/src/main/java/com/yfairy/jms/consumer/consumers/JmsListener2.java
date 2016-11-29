package com.yfairy.jms.consumer.consumers;

import com.alibaba.fastjson.JSON;

public class JmsListener2 extends AbstractHandleMessage {

	@Override
	public void handleMessage(Object message) {
		System.out.println("JmsListener2:" + JSON.toJSONString(message));
	}

}
