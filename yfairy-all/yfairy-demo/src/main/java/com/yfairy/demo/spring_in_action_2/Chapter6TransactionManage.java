package com.yfairy.demo.spring_in_action_2;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

public class Chapter6TransactionManage {

	public static void main(String[] args) {
		/**
		 * 第6章:事务管理(168/505)<br>
		 * 6.1理解事务<br>
		 * 百度:数据库事务:数据库事务(Database Transaction) ，是指作为单个逻辑工作单元执行的一系列操作，<br>
		 * 要么完全地执行，要么完全地不执行。 <br>
		 * 推荐查看:http://baike.baidu.com/link?url=gSgTf9M31HaTmWvFrhEbMIlUUA9Yi9o68cxH7USakj-w_n1gmk-kD4om_4MqCmHsO-l1DhRQXWB5qkAMDKndkhyJQwWnaXe7T2hYHgz3E2EvwCcBZvCvqQdKGXn3XEiU<br>
		 * 到6.4声明式事务(176/505)<br>
		 */
		// 4个词解释事务:a,原子性:事务由多个工作单元组成，原子性确保事务的所有操作要么全部执行，要么都不执行<br>

		// 6.1.2理解spring对事务管理的支持 (170/505)

		// 6.2选择事务管理器
		// DataSourceTransactionManager
		// JmsTransactionManager
		// HibernateTransactionManager

		// 6.3在spring中编写事务

		String xmlfileStr = "com\\yfairy\\demo\\spring_in_action_2\\spring-demo.xml";

		ApplicationContext context = new ClassPathXmlApplicationContext(xmlfileStr);
		
		//使用编程式事务:TransactionTemplate,可查看StudentDao中具体怎么使用的
		System.err.println("-----------------------------------");
		StudentDao studentDao = (StudentDao) context.getBean("studentDao");
		studentDao.addStudent("INSERT INTO yf_student(name,sex,age) VALUES('jjjj','haha',18) ");
		System.err.println("-----------------------------------");

		studentDao.addStudent("INSERT INTO yf_student(name,sex,age) VALUES('jjjj2','haha2',18) ");
		System.err.println("-----------------------------------");

		List<People> all = studentDao.listAllStudent();
		for (People people : all) {
			System.out.println(people);
		}
		
		//到6.4声明式事务(176/505)<br>
	}

}
