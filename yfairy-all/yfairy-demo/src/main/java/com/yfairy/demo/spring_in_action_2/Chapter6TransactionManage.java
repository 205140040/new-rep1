package com.yfairy.demo.spring_in_action_2;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.Transactional;

public class Chapter6TransactionManage {

	public static void main(String[] args) {
		/**
		 * 第6章:事务管理(168/505)<br>
		 * 6.1理解事务<br>
		 * 百度:数据库事务:数据库事务(Database Transaction) ，是指作为单个逻辑工作单元执行的一系列操作，<br>
		 * 要么完全地执行，要么完全地不执行。 <br>
		 * 推荐查看:http://baike.baidu.com/link?url=gSgTf9M31HaTmWvFrhEbMIlUUA9Yi9o68cxH7USakj-w_n1gmk-kD4om_4MqCmHsO-l1DhRQXWB5qkAMDKndkhyJQwWnaXe7T2hYHgz3E2EvwCcBZvCvqQdKGXn3XEiU<br>
		 * 到6.4声明式事务(176/505)<br>
		 * 6.4.1定义事务参数:@Transactional<br>
		 * 传播行为:propagation<br>
		 * 隔离级别:isolation<br>
		 * 超时:timeout,一个事务如果没在指定的时间完成，则在超时时自动回滚<br>
		 * 回滚规则：定义哪些异常引起回滚rollbackFor，哪些异常不引起回滚noRollbackFor<br>
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

		// 使用编程式事务:TransactionTemplate,可查看StudentDao中具体怎么使用的
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
		// @Transactional

		// 到6.4声明式事务(176/505)<br>

		// 6.4.1定义事务参数:@Transactional
		// 传播行为:propagation
		// 隔离级别:isolation
		// 超时:timeout,一个事务如果没在指定的时间完成，则在超时时自动回滚
		// 回滚规则：定义哪些异常引起回滚rollbackFor，哪些异常不引起回滚noRollbackFor

		// 6.4.2代理事务
		// 6.4.3在spring2中声明事务
		System.err.println("-----------------------------------");
		System.err.println("-----------------------------------");

		studentDao.insertStudent("INSERT INTO yf_student(name,sex,age) VALUES('jjjj3','haha3',18) ");
		System.err.println("-----------------------------------");

		studentDao.insertStudentNewTra("INSERT INTO yf_student(name,sex,age) VALUES('jjjj3','haha3',18) ");

		System.err.println("-----------------------------------");
		System.out.println("hello");

		// 建议只配置使用事务注解，如果注解和xml方式配置事务同时存在，匹配事务的切点可能会覆盖事务注解的配置

	}

}
