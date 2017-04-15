package com.yfairy.demo.mybatis3;

import java.sql.Connection;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

/**
 * 设置拦截 的类，方法，参数
 * 
 * @author jiangzi
 *
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class StatementHandlerInterceptor implements Interceptor {

	private Properties copyProperties;

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// 插件 拦截，调用
		System.out.println("StatementHandlerInterceptor before...");
		/**
		 * 自定义插件，限制返回条数
		 */
		// 取出被拦截对象
		StatementHandler stmtHandler = (StatementHandler) invocation.getTarget();

		MetaObject metaObject = SystemMetaObject.forObject(stmtHandler);
		// 找到最原始的代理类
		while (metaObject.hasGetter("h")) {
			Object val = metaObject.getValue("h");
			metaObject = SystemMetaObject.forObject(val);
		}
		// 分离最后一个代理对象的目标类
		while (metaObject.hasGetter("target")) {
			Object val = metaObject.getValue("target");
			metaObject = SystemMetaObject.forObject(val);
		}
		String sql = (String) metaObject.getValue("delegate.boundSql.sql");
		if (sql.contains("select")) {
			sql = sql.trim();
			// System.out.println("original sql:" + sql);
			sql = sql + " limit 2 ";
			// System.out.println("new sql:" + sql);
			// 重写 新的sql
			metaObject.setValue("delegate.boundSql.sql", sql);
		}
		// 调用原始方法
		Object result = invocation.proceed();
		System.out.println("StatementHandlerInterceptor after...");
		return result;
	}

	@Override
	public Object plugin(Object target) {
		// 通过Plugin.wrap 获得动态代理对象
		System.out.println("Plugin.wrap生成代理对象...");
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		this.copyProperties = properties;
		// 打印初始化时设置的属性
		Set<Entry<Object, Object>> sets = properties.entrySet();
		for (Entry<Object, Object> entry : sets) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}

	public Properties getCopyProperties() {
		return copyProperties;
	}

	public void setCopyProperties(Properties copyProperties) {
		this.copyProperties = copyProperties;
	}

}
