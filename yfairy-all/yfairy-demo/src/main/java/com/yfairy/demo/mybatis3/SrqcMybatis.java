package com.yfairy.demo.mybatis3;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.ibatis.session.SqlSession;

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
		 * 第4章：映射器(85/272)<br>
		 * 第5章：动态sql(131/272)<br>
		 */
		// Configuration
		// SqlSessionFactory
		// 是工厂接口，具体实现有DefaultSqlSessionFactory(默认使用),SqlSessionManager
		// SqlSession也是接口，默认实现是DefaultSqlSession,实际执行 操作sql的是Executor executor;
		// DefaultSqlSession
		// Executor

		// SqlSession是一个会话，相当于jdbc的connection，每次使用完后需要关闭,
		// 不然数据库连接池的资源会一直占用，不够使用
		// SqlSessionFactoryBuilder sessionFactoryBuilder = new
		// SqlSessionFactoryBuilder();
		// String mybatisConfigPath =
		// "com/yfairy/demo/mybatis3/mybatis-config2.xml";
		// Resource resource = new ClassPathResource(mybatisConfigPath);
		// InputStream in = resource.getInputStream();
		// SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new
		// SqlSessionFactoryBuilder();
		// SqlSessionFactory sqlSessionFactory =
		// sqlSessionFactoryBuilder.build(in);

		SqlSession sqlSession = null;

		// SqlSessionFactoryBuilder
		try {
			// sqlSession=sqlSessionFactory.openSession();
			// sqlSession = SqlSessionFactoryUtil.openSqlSession();
			/*
			 * System.out.println("-----------------------"); ExecutorService e
			 * = Executors.newFixedThreadPool(5); for (int i = 0; i < 10; i++) {
			 * e.execute(new Runnable() {
			 * 
			 * @Override public void run() {
			 * SqlSessionFactoryUtil.openSqlSession(); } }); } e.shutdown();
			 * System.out.println("-----------------------");
			 */

			sqlSession = SqlSessionFactoryUtil.openSqlSession();
			BlogTitleMapper blogTitleMapper = sqlSession.getMapper(BlogTitleMapper.class);

			/**
			 * <!-- selectKey自定义主键规则 -->
			 * <selectKey keyProperty="id" order="BEFORE" resultType="int">
			 * select if(max(id) is null,1,max(id)+2) as id from blog_title
			 * </selectKey>
			 */
			BlogTitle insertBlogTitle = new BlogTitle();
			insertBlogTitle.setTitle("酱酱的博客" + new Date().toLocaleString());
			insertBlogTitle.setCreateTime(new Date());
			insertBlogTitle.setAuthorId(3);
			// int result = blogTitleMapper.insert(insertBlogTitle);
			System.out.println("主键:" + insertBlogTitle.getId());

			// insert ,update,delete mybatis在执行完成后，返回执行后影响的记录条数

			List<BlogTitle> blogTitles = blogTitleMapper.listBlogTitle("");
			for (BlogTitle blogTitle : blogTitles) {
				System.err.println(JSON.toJSONString(blogTitle));
			}

			blogTitleMapper.selectBlogTitleMap(1);
			blogTitleMapper.selectBlogTitleMap(1);

			System.err.println("缓存，默认select 只缓存一个会话的select，不同sqlsession不缓存");
			System.err.println("配置<cache /> 开启在所有sqlsession中都起效的缓存 ");
			// 缓存，默认select 只缓存一个会话的select，不同sqlsession不缓存
			// 配置<cache /> 开启在所有sqlsession中都起效的缓存
			// 现在缓存 <cache /> 貌似不起效，看看是否需要添加mybatis-ehcache,使用ehcache
			SqlSession sqlSession2 = SqlSessionFactoryUtil.openSqlSession();
			sqlSession2.getMapper(BlogTitleMapper.class).selectBlogTitleMap(1);

			sqlSession.commit(); // 提交事务
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback(); // 回滚事务
		} finally {
			if (null != sqlSession) {
				sqlSession.close();
			}
		}
	}

}
