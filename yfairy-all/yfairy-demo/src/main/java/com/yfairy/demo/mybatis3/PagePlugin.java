package com.yfairy.demo.mybatis3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;

@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PagePlugin implements Interceptor {

	private static final String DEFAULT_DIALECT = "mysql";

	private static final Integer DEFAULT_PAGESIZE = 10;

	/**
	 * 分页方法标识符
	 */
	private static final String PAGESQL_IDENTITY = "pageList";

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		// 可能有多个拦截插件,通过循环找到原始对象
		MetaObject metaStatementHandler = getMetaStatementHandler(statementHandler);

		// 获得MappedStatement
		MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
		BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
		String sql = boundSql.getSql();
		String trimSql = sql.trim();
		if (mappedStatement.getId().contains(PAGESQL_IDENTITY) && trimSql.contains("select")) {
			// 分页,且是查询的方法
			System.out.println("-----------");
			Connection connection = (Connection) invocation.getArgs()[0];
			Integer total = getTotal(connection, mappedStatement, boundSql);
			System.out.println("total:" + total);
		}

		// 没有分页，运行原始方法
		return invocation.proceed();
	}

	private MetaObject getMetaStatementHandler(StatementHandler statementHandler) {
		// 可能有多个拦截插件,通过循环找到原始对象
		MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
		// 分离代理对象链(由于目标类可能被多个拦截器拦截，从而形成多次代理，通过下面的两次循环
		// 可以分离出最原始的的目标类)
		while (metaStatementHandler.hasGetter("h")) {
			Object object = metaStatementHandler.getValue("h");
			metaStatementHandler = SystemMetaObject.forObject(object);
		}
		// 分离最后一个代理对象的目标类
		while (metaStatementHandler.hasGetter("target")) {
			Object object = metaStatementHandler.getValue("target");
			metaStatementHandler = SystemMetaObject.forObject(object);
		}
		return metaStatementHandler;
	}

	private Integer getTotal(Connection connection, MappedStatement mappedStatement, BoundSql boundSql) {
		Integer total = 0;
		Configuration configuration = mappedStatement.getConfiguration(); // Configuration
		String sql = boundSql.getSql();
		String countSql = "select count(*) as total from (" + sql + ") a ";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			preparedStatement = connection.prepareStatement(countSql);

			BoundSql countBoundSql = new BoundSql(configuration, countSql, boundSql.getParameterMappings(),
					boundSql.getParameterObject());
			ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement,
					boundSql.getParameterObject(), countBoundSql);
			parameterHandler.setParameters(preparedStatement);

			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				total = rs.getInt("total");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != preparedStatement) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return total;
	}

	@Override
	public Object plugin(Object target) {
		// 返回插件 动态代理对象
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {

	}

}
