package com.yfairy.test.service.impl;

import org.springframework.stereotype.Component;

@Component
public class HelloDongBeiV1 extends AbstractHello {

	@Override
	public void sayHello(String name) {
		System.out.println("东北V1:" + name);
	}

}
