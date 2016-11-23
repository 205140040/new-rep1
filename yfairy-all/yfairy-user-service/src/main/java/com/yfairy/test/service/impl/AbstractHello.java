package com.yfairy.test.service.impl;

import org.springframework.stereotype.Component;

@Component
public abstract class AbstractHello {

	public abstract void sayHello(String name);

	public static final AbstractHello getInstance(String code, String version) {
		String className = "com.yfairy.test.service.impl.Hello" + code + version;
		@SuppressWarnings("rawtypes")
		Class clazz = null;
		try {
			clazz = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		@SuppressWarnings("unchecked")
		AbstractHello res = ApplicationContextHelper.getBean(clazz);
		System.out.println(res);
		return res;
	}
}
