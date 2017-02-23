package com.yfairy.demo.spring_in_action_2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringInAction2 {

	public static void main(String[] args) {
		/**
		 * SpringInAction第二版<br>
		 * 目录(17/505)<br>
		 * 第1章：开启spring之旅(24/505)<br>
		 * 第2章：基本bean装配(42/505)<br>
		 * 到2.2创建bean(48/505)<br>
		 * 到2.5控制bean创建(64/505)<br>
		 */
		String userDir = System.getProperty("user.dir");
		System.out.println(userDir);
		String xmlfileStr = userDir + "\\src\\main\\java\\com\\yfairy\\demo\\spring_in_action_2\\spring-demo.xml";

		// BeanFactory beanFactory = new XmlBeanFactory(new
		// FileSystemResource(xmlfileStr));
		// XmlBeanFactory无法使用aop，ApplicationContext可使用aop
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(xmlfileStr);
		IHelloService helloService = (IHelloService) applicationContext.getBean("helloService");
		helloService.sayHello();
	}

}
