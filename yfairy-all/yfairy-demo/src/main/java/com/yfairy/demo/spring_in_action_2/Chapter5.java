package com.yfairy.demo.spring_in_action_2;

import java.sql.SQLException;

import org.springframework.dao.CannotAcquireLockException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.alibaba.druid.support.ibatis.SqlMapClientWrapper;

public class Chapter5 {

	public static void main(String[] args) {
		/**
		 * 第5章：使用数据库(125/505)<br>
		 * 5.1spring的数据访问哲学<br>
		 * DAO(Data Access Object) 数据访问对象是一个面向对象的数据库接口<br>
		 * 5.1.1了解spring数据访问的异常体系<br>
		 * java 中SQLException<br>
		 * spring中sql异常,都继承自DataAccessException<br>
		 * 到5.2：配置数据源(130/505)<br>
		 */
//		SQLException
//		CannotAcquireLockException
		
		//5.1.2数据访问的模板化<br>
		//spring常用数据访问模板:JdbcTemplate,HibernateTemplate,SqlMapClientTemplate(ibatis)
		
		//5.1.3使用dao支持类,JdbcDaoSupport,HibernateDaoSupport
//		JdbcTemplate
//		JdbcDaoSupport
//		HibernateDaoSupport

	}

}
