package com.yfairy.demo.mybatis3;

import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.alibaba.fastjson.JSON;

public class SrqcMybatisChapter7 {

	public static void main(String[] args) {
		/**
		 * 第7章：插件(163/272)<br>
		 */
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtil.openSqlSession();
			BlogTitleMapper blogTitleMapper = sqlSession.getMapper(BlogTitleMapper.class);

			// 插件实现Interceptor 接口
			// Interceptor
			// Object intercept(Invocation invocation)
			// 将覆盖拦截对象的原有方法，并进行invocation 反射调用
			// Object plugin(Object target); target 是被拦截对象

			// 7.3 插件的代理和反射设计
			// Plugin 可使用该类的wrap 方法生成插件动态代理对象

			// 7.4 常用的工具类
			// MetaObject

			// 7.5 插件开发过程和实例
			// 7.5.1 确定要拦截的 签名(类，方法)
			// Executor 执行器一般不拦截
			// StatementHandler 执行sql的过程，一般拦截
			// ParameterHandler 设置参数时拦截
			// ResultSetHandler 返回结果时拦截

			// 2 确定拦截方法和参数

			// 7.6 尽量不要使用插件，插件会修改mybatis底层，出错了不好弄，其次插件使用代理对象和反射，性能不高

			BlogTitle search = new BlogTitle();
			// search.setId(5);
			search.setIdList(Arrays.asList(1, 2, 5, 6));
			List<BlogTitle> sbt = blogTitleMapper.listBlogTitleWithCon(search);
			System.err.println(JSON.toJSONString(sbt));

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
