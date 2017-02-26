package com.yfairy.demo.spring_in_action_2;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Chapter3 {

	public static void main(String[] args) {
		/**
		 * 第3章：高级bean装配(69/505)<br>
		 * 3.1声明父bean和子bean<br>
		 * 3.3注入非spring bean(重要)<br>
		 * 比如类A是new的，并不是通过spring获取的，但是类A中包含类B，类B配置在类A中，<br>
		 * 此时需要通过spring自动为类A注入类B，首先配置类A添加注解@Configurable<br>
		 * 配置文件添加:<context:spring-configured></context:spring-configured><br>
		 * 可参考:http://blog.csdn.net/liuwenbo0920/article/details/8254670<br>
		 * 到:3.5.5程序事件的解耦 (88/505)<br>
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

		// 3.2方法注入 73/505
		// 通过spring在运行时给类添加方法<br>
		// 实现MethodReplacer接口
		// <replaced-method name="getContent" replacer="methodReplaceer">
		// </replaced-method>

		MethodReplaceDemo mr = (MethodReplaceDemo) context.getBean("methodReplaceDemo");
		mr.getContent();
		// 3.2.2获取器注入
		// <lookup-method name="" bean=""/>

		// 3.3注入非spring bean
		// 比如类A是new的，并不是通过spring获取的，但是类A中包含类B，类B配置在类A中，
		// 此时需要通过spring自动为类A注入类B，首先配置类A添加注解@Configurable("id")
		// 配置文件添加:<context:spring-configured></context:spring-configured>
		// 可参考:http://blog.csdn.net/liuwenbo0920/article/details/8254670
		// 还要在jvm启动时设置:-javaagent:D:\M2\rep\org\aspectj\aspectjweaver\1.8.8\aspectjweaver-1.8.8.jar
		// User user = new User();
		// user.sayHello();

		// 3.4注册自定义属性编辑器 79/505
		// 出错了，暂时不看这个了
		// ParentEditDemo ped = (ParentEditDemo)
		// context.getBean("parentEditDemo");
		// System.out.println(ped.getParent());

		// 3.5使用特殊的bean
		// 3.6.1后处理bean,BeanPostProcessor获取的bean 有误，暂时不看了
		AdvanceBeanLifeCycle advanceBeanLifeCycle = (AdvanceBeanLifeCycle) context.getBean("advanceBeanLifeCycle");
		System.out.println(advanceBeanLifeCycle.getName());

		// 3.5.2bean工厂的后处理,实现BeanFactoryPostProcessor接口，可在bean工厂设置后处理器
		// BeanFactoryPostProcessor

		// 3.5.3配置外部属性文件,PropertyPlaceholderConfigurer

		// 3.5.4提取文本消息,ResourceBundleMessageSource 实现属性文件国际化
		Locale locale = Locale.US;

		String msg = context.getMessage("hello", null, locale);
		System.out.println(msg);

		// 3.5.5程序事件的解耦 (88/505)
		// ServiceConfig<T>
//		context.
	}

}
