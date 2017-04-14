package com.yfairy.demo.mybatis3;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.binding.MapperProxy;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.reflection.ExceptionUtil;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.alibaba.fastjson.JSON;

public class SrqcChapter6 {

	public static void main(String[] args) {
		/**
		 * 第6章：mybatis的解析和运行原理(139/272)<br>
		 */
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtil.openSqlSession();
			BlogTitleMapper blogTitleMapper = sqlSession.getMapper(BlogTitleMapper.class);

			BlogTitle search = new BlogTitle();
			// search.setId(5);
			search.setIdList(Arrays.asList(1, 2, 5, 6));
			List<BlogTitle> sbt = blogTitleMapper.listBlogTitleWithCon(search);
			System.err.println(JSON.toJSONString(sbt));

			// Configuration
			//
			// MapperProxy<T>

			// 6.1.3 cglib动态代理

			// 6.2构建sqlsessionfactory过程
			// SqlSessionFactoryBuilder

			/**
			 * 映射器mapper 由三部分组成: MappedStatement SqlSource BoundSql
			 * 拥有参数类型，和具体的sql
			 */

			// statement
			// 英 [ˈsteɪtmənt] 美 [ ˈstetmənt]
			// n.
			// 声明;（思想、观点、文章主题等的）表现;（文字）陈述;结算单
			// vi.
			// （英国）对儿童进行特殊教育评估认定
			// vt.
			// 申请（小孩）有特殊教育需要

			// 6.3 sqlsession 运行过程

			// 6.3.1映射器的动态代理
			// protected T newInstance(MapperProxy<T> mapperProxy) {
			// return (T)
			// Proxy.newProxyInstance(mapperInterface.getClassLoader(), new
			// Class[] { mapperInterface }, mapperProxy);
			// }
			
			/*	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			    if (Object.class.equals(method.getDeclaringClass())) {
			      try {
			        return method.invoke(this, args);
			      } catch (Throwable t) {
			        throw ExceptionUtil.unwrapThrowable(t);
			      }
			    }
			    final MapperMethod mapperMethod = cachedMapperMethod(method);
			    return mapperMethod.execute(sqlSession, args);
			  }
			 */
			//先判断动态代理的调用的方法，是不是一个类，如果是，则调用类的方法，
			//默认代理是个接口，所以走下面的
			//			 final MapperMethod mapperMethod = cachedMapperMethod(method);
			//			    return mapperMethod.execute(sqlSession, args);
			//			StatementHandler
			//			ParameterHandler
			//			ResultSetHandler
			
			
			sqlSession.commit(); // 提交事务
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			if (null != sqlSession) {
				sqlSession.close();
			}
		}

	}

}
