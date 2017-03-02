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
		 * 第3章：高级bean装配(69/505)<br>
		 * 到:3.5.5程序事件的解耦 (88/505)<br>
		 * 第4章：通知bean，AOP(98/505)<br>
		 * 到 4.2创建spring的典型切面 (102/505)<br>
		 * 到 4.3.2自动代理@Aspect切面 (113/505)<br>
		 * 第5章：使用数据库(125/505)<br>
		 * 到5.2：配置数据源(130/505)<br>
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
