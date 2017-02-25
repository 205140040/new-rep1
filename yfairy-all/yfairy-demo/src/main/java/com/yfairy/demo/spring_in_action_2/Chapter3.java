package com.yfairy.demo.spring_in_action_2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Chapter3 {

	public static void main(String[] args) {
		/**
		 * 第3章：高级bean装配(69/505)<br>
		 * 3.1声明父bean和子bean<br>
		 */
		String xmlfileStr = "com\\yfairy\\demo\\spring_in_action_2\\spring-demo.xml";

		ApplicationContext context = new ClassPathXmlApplicationContext(xmlfileStr);

		// <!-- abstract设置bean 为抽象的不能实例化 -->
		// <!-- 通过parent设置父类实现继承 -->

		// Parent parent=(Parent)context.getBean("parent");
		Parent parentc1 = (Parent) context.getBean("parentc1");
		System.out.println(parentc1);
		Parent parentc2 = (Parent) context.getBean("parentc2");
		System.out.println(parentc2);

		// 3.1.2 抽象共同属性 ,假设两个bean不是同一个父类，spring中也可以通过parent共享属性配置<br>
		Parent parent2 = (Parent) context.getBean("parent2");
		System.out.println(parent2.getName());
		People people = (People) context.getBean("people");
		System.out.println(people.getName());
		
		//3.2方法注入 73/505
		

	}

}
