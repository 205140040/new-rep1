package com.yfairy.demo.spring_in_action_2;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Chapter4 {

	public static void main(String[] args) {
		/**
		 * 第4章：通知bean，AOP(98/505) <br>
		 * 高内聚低耦合:<br>
		 * 内聚是从功能角度来度量模块内的联系，一个好的内聚模块应当恰好做一件事。<br>
		 * 它描述的是模块内的功能联系；<br>
		 * 耦合是软件结构中各模块之间相互连接的一种度量，<br>
		 * 耦合强弱取决于模块间接口的复杂程度、<br>
		 * 进入或访问一个模块的点以及通过接口的数据。<br>
		 * http://baike.baidu.com/link?url=rqXBQYLJzggD7ruXInfy-L5pB6WpT29GOPITTuGi51UD_sWuZDS0b4CzsNF9PwVARmDxoKY7n2foaH31GsLy23Wlq1B3qhMIqBqaeaKBgJOvBMqwTqIR1QNga8kZQ2k6P8js4LTgyxt6a3p7iZKCaq<br>
		 * 4.1AOP简介<br>
		 * //aop简介<br>
		 * //切面:切面是通知，和切点的结合,描述切面的常用术语有,通知,切点,连接点<br>
		 * //通知:切面的功能被称为通知,通知定义了切面是什么，以及何时使用<br>
		 * //连接点：连接点是在程序执行过程中插入切面的一个点，切面代码通过连接点插入到程序的执行中<br>
		 * //切点:切点定义了通知要执行的地点<br>
		 * 到 4.2创建spring的典型切面 (102/505)<br>
		 */

		// aop简介
		// 切面:切面是通知，和切点的结合,描述切面的常用术语有,通知,切点,连接点
		// 通知:切面的功能被称为通知,通知定义了切面是什么，以及何时使用
		// 连接点：连接点是在程序执行过程中插入切面的一个点，切面代码通过连接点插入到程序的执行中
		// 切点:切点定义了通知要执行的地点
		//
		
		//4.1.2spring对aop的支持,spring对aop的支持是基于代理的<br>
		//spring生成代理类的方式有两种:如果目标对象实现了接口，使用jdk动态代理,
		//否则使用CGLIB动态的生成目标类的子类，final修饰的方法无法重写，所以无法使用aop
		String xmlfileStr = "com\\yfairy\\demo\\spring_in_action_2\\spring-demo.xml";

		ApplicationContext context = new ClassPathXmlApplicationContext(xmlfileStr);
		IHelloService helloService=(IHelloService)context.getBean("helloService");
		helloService.sayHello();
		System.out.println();
		helloService.sayName();
		//到 4.2创建spring的典型切面 (102/505)<br>
//		JdkDynamicAopProxy
//		MethodInterceptor
	}

}
