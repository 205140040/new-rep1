package com.yfairy.demo.mybatis3;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SqlSessionFactoryUtil {

	private static SqlSessionFactory sqlSessionFactory = null;

	private static Lock lock = new ReentrantLock();

	private SqlSessionFactoryUtil() {

	}

	public static SqlSessionFactory getSqlSessionFactoryInstance() {
		InputStream in = null;
		try {
			lock.lock();
			if (null == sqlSessionFactory) {
				String mybatisConfigPath = "com/yfairy/demo/mybatis3/mybatis-config2.xml";
				SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
				Resource resource = new ClassPathResource(mybatisConfigPath);
				in = resource.getInputStream();
				sqlSessionFactory = builder.build(in);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			lock.unlock();
		}
		System.err.println("sqlSessionFactory:" + sqlSessionFactory);
		return sqlSessionFactory;
	}

	public static SqlSession openSqlSession() {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactoryInstance();
		return sqlSessionFactory.openSession();
	}

}
