package com.yfairy.demo.mybatis3;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * 
 * @author jiangzi
 *
 * @param <E>
 */
public class GenericTypeHandler<E extends Object> extends BaseTypeHandler<E> {
	/**
	 * 你能创建一个泛型类型处理器，它可以处理多于一个类。<br>
	 * 为达到此目的， 需要增加一个接收该类作为参数的构造器，这样在构造一个类型处理器的时候<br>
	 * MyBatis 就会传入一个具体的类。<br>
	 */

	private Class<E> type;

	public GenericTypeHandler(Class<E> type) {
		if (type == null)
			throw new IllegalArgumentException("Type argument cannot be null");
		this.type = type;
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
