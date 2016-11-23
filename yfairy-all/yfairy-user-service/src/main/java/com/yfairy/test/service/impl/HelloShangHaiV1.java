package com.yfairy.test.service.impl;

import org.springframework.stereotype.Component;

@Component
public class HelloShangHaiV1 extends AbstractHello {

	@Override
	public void sayHello(String name) {
		System.out.println("上海V1:" + name);
	}

}
