package com.yfairy.demo.spring_in_action_2;

import java.io.IOException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Chapter2 {
	public static void main(String[] args) throws IOException {
		/**
		 * SpringInAction第二版<br>
		 * 目录(17/505)<br>
		 * 第2章：基本bean装配(42/505)<br>
		 * 2.1.1BeanFactory介绍<br>
		 * 2.1.3:Bean的生命<br>
		 * 实例化-->设置属性值-->调用BeanFactoryAware的setBeanName方法<br>
		 * -->调用BeanFactoryAware的setBeanFactory方法-->BeanPostProcessor的postProcessBeforeInitialization方法<br>
		 * -->调用的InitializingBean的afterPropertiesSet方法-->调用定制的初始化方法<br>
		 * -->调用BeanPostProcessor的postProcessAfterInitialization(后初始化)方法<br>
		 * -->bean可以被使用了-->容器关闭-->调用DisposableBean的destroy方法-->调用定制的销毁方法<br>
		 * 到2.2创建bean(48/505)<br>
		 */

		// 2.1.1BeanFactory介绍
		// BeanFactory使用工厂设计模式,是一个通用的工厂可以创建和分发各种bean
		// Resource接口，常用实现类ClassPathResource,FileSystemResource

		String xmlfileStr = "com\\yfairy\\demo\\spring_in_action_2\\spring-demo.xml";
		Resource resource = new ClassPathResource(xmlfileStr);
		System.out.println(resource.getURL().getPath());

		BeanFactory beanFactory = new XmlBeanFactory(resource);
		// XmlBeanFactory无法使用aop，ApplicationContext可使用aop
		IHelloService helloService = (IHelloService) beanFactory.getBean("helloService");
		helloService.sayHello();

		// ApplicationContext提供了比BeanFactory更多的功能,
		// 常用实现类ClassPathXmlApplicationContext,FileSystemXmlApplicationContext,XmlWebApplicationContext
		ApplicationContext context = new ClassPathXmlApplicationContext(xmlfileStr);
		IHelloService chelloService = (IHelloService) context.getBean("helloService");
		chelloService.sayHello();

		// BeanFactory会在调用getBean时才加载bean，而ApplicationContext会在启动时就加载bean，调用getBean直接使用加载后的

		// aware 察觉到，感知
		// 2.1.3:Bean的生命<br>
		BeanLifeCycle lifeCycle = (BeanLifeCycle) context.getBean("beanLifeCycle");
		System.out.println(lifeCycle);

	}
}
