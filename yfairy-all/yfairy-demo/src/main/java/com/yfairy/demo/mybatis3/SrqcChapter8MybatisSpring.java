package com.yfairy.demo.mybatis3;

import java.sql.Connection;
import java.sql.Savepoint;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.fastjson.JSON;

public class SrqcChapter8MybatisSpring {

	public static void main(String[] args) {
		/**
		 * 第8章：mybatis-spring(180/272)<br>
		 * (官网)http://www.mybatis.org/spring/zh/sample.html<br>
		 */
		SqlSession sqlSession=null;
		try {
			Connection connection=null;
			Savepoint sp=connection.setSavepoint();
			connection.commit();
			
			sqlSession = SqlSessionFactoryUtil.openSqlSession();
			BlogTitleMapper blogTitleMapper = sqlSession.getMapper(BlogTitleMapper.class);
			
			//8.1.3 spring事务管理
//			DataSourceTransactionManager
			
			//8.2 mybatis-spring 应用
			
			//TODO 8.2.2 配置 ,通过SqlSessionFactoryBean配置SqlSessionFactory(193/272)
//			SqlSessionFactoryBean
			
			BlogTitle search = new BlogTitle();
			// search.setId(5);
			search.setIdList(Arrays.asList(1, 2, 5, 6));
			List<BlogTitle> sbt = blogTitleMapper.listBlogTitleWithCon(search);
			System.err.println(JSON.toJSONString(sbt));
			
			sqlSession.commit(); //提交事务
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally{
			if(null!=sqlSession){
				sqlSession.close();
			}
		}
	}

}
