package com.yfairy.demo.mybatis3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Map.Entry;
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

	/**
	 * 分页方法标识符
	 */
	private static final String PAGESQL_IDENTITY = "pageList";

	private static final Integer DEFAULT_OFFSET = 0;

	private static final Integer DEFAULT_ROWS = 10;

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		long start = System.currentTimeMillis();
		System.err.println("start:" + start);

		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		// 可能有多个拦截插件,找到原始对象
		MetaObject metaStatementHandler = getMetaStatementHandler(statementHandler);

		// 获得MappedStatement
		MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
		BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
		String originalSql = boundSql.getSql();
		String trimSql = originalSql.trim();
		if (mappedStatement.getId().contains(PAGESQL_IDENTITY)
				&& (trimSql.contains("select") || trimSql.contains("SELECT"))) {
			Object parameterObject = boundSql.getParameterObject();
			PageParam pageParam = getPageParam(parameterObject);
			if (null == pageParam) { // 没有分页参数
				invocation.proceed();
			}

			Connection connection = (Connection) invocation.getArgs()[0];
			int total = getTotal(connection, mappedStatement, boundSql);
			pageParam.setTotal(total);

			// createPageSql
			String pageSql = createPageSql(originalSql, pageParam);
			System.err.println("pageSql:" + pageSql);
			// update sql
			metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);

			long end = System.currentTimeMillis();
			System.err.println("end:" + end);
			System.err.println("diff:" + (end - start));

			return invocation.proceed();
		}

		long end = System.currentTimeMillis();
		System.err.println("end:" + end);
		System.err.println("diff:" + (end - start));

		// 没有分页，运行原始方法
		return invocation.proceed();
	}

	private String createPageSql(String originalSql, PageParam pageParam) {
		int offset = DEFAULT_OFFSET;
		int rows = DEFAULT_ROWS;
		if (null != pageParam.getStart() && null != pageParam.getLength()) {
			offset = pageParam.getStart();
			rows = pageParam.getLength();
		} else if (null != pageParam.getPage()) {
			int page = pageParam.getPage();
			int pageSize = DEFAULT_ROWS;
			if (null != pageParam.getPageSize()) {
				pageSize = pageParam.getPageSize();
			}
			offset = (page - 1) * pageSize;
			rows = pageSize;
		}
		StringBuilder pageSql = new StringBuilder();
		if ("mysql".equals(DEFAULT_DIALECT)) {
			pageSql.append(originalSql).append(" limit ").append(offset).append(",").append(rows);
		}
		return pageSql.toString();
	}

	private PageParam getPageParam(Object parameterObject) {
		PageParam pageParam = null;
		if (null == parameterObject) {
			return pageParam;
		}
		if (parameterObject instanceof Map) {
			@SuppressWarnings("unchecked")
			Map<String, Object> paramObjMap = (Map<String, Object>) parameterObject;
			for (Entry<String, Object> entry : paramObjMap.entrySet()) {
				Object value = entry.getValue();
				if (value instanceof PageParam) {
					pageParam = (PageParam) value;
					break;
				}
			}
		} else if (parameterObject instanceof PageParam) {
			pageParam = (PageParam) parameterObject;
		}
		return pageParam;
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

	private int getTotal(Connection connection, MappedStatement mappedStatement, BoundSql boundSql) {
		int total = 0;
		Configuration configuration = mappedStatement.getConfiguration(); // Configuration
		String sql = boundSql.getSql();
		String countSql = " select count(*) as total from (" + sql + ") ct ";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			preparedStatement = connection.prepareStatement(countSql);

			// setParameters
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
