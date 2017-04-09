package com.yfairy.demo.mybatis3;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionManager;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.alibaba.fastjson.JSON;

public class SrqcMybatis {

	public static void main(String[] args) throws IOException {
		/**
		 * 深入浅出mybatis<br>
		 * 
		 * 第1章：mybatis简介(13/272)<br>
		 * JDBC（Java Data Base Connectivity,java数据库连接）是一种用于执行SQL语句的Java API，<br>
		 * 可以为多种关系数据库提供统一访问，它由一组用Java语言编写的类和接口组成。<br>
		 * JDBC提供了一种基准，据此可以构建更高级的工具和接口，使数据库开发人员能够编写数据库应用程序，<br>
		 * 同时，JDBC也是个商标名。<br>
		 * 
		 * 第2章：mybatis入门(25/272)<br>
		 * 第3章：配置(49/272) <br>
		 */
		// Configuration
		// SqlSessionFactory
		// 是工厂接口，具体实现有DefaultSqlSessionFactory(默认使用),SqlSessionManager
		// SqlSession也是接口，默认实现是DefaultSqlSession,实际执行 操作sql的是Executor executor;
		// DefaultSqlSession
		// Executor

		// SqlSession是一个会话，相当于jdbc的connection，每次使用完后需要关闭,
		// 不然数据库连接池的资源会一直占用，不够使用
		SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
		String mybatisConfigPath = "com/yfairy/demo/mybatis3/mybatis-config2.xml";
		Resource resource = new ClassPathResource(mybatisConfigPath);
		InputStream in = resource.getInputStream();
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(in);
		
		SqlSession sqlSession=null;
		
		try {
			sqlSession=sqlSessionFactory.openSession();
			BlogTitleMapper blogTitleMapper=sqlSession.getMapper(BlogTitleMapper.class);
			
			List<BlogTitle> blogTitles=blogTitleMapper.listBlogTitle("");
			for (BlogTitle blogTitle : blogTitles) {
				System.err.println(JSON.toJSONString(blogTitle));
			}
			sqlSession.commit(); //提交事务
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback(); //回滚事务
		}finally{
			if(null!=sqlSession){
				sqlSession.close();
			}
		}
	}

}
