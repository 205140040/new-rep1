package com.yfairy.demo.mybatis3;

import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

@Intercepts({ @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }),
		@Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
				RowBounds.class, ResultHandler.class }) })
public class ExamplePlugin implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		System.err.println("ExamplePlugin:query");
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		System.err.println("ExamplePlugin:query:plugin");
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub

	}

	/*
	 * public static void main(String[] args) { ExamplePlugin ep = new
	 * ExamplePlugin(); Class clazz = ep.getClass(); Intercepts in=(Intercepts)
	 * clazz.getAnnotation(Intercepts.class); Signature[] ss=in.value(); for
	 * (Signature signature : ss) { System.out.println(signature); } }
	 */

}
