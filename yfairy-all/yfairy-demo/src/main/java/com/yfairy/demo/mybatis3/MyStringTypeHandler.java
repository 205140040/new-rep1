package com.yfairy.demo.mybatis3;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class MyStringTypeHandler extends BaseTypeHandler<String> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setString(i, parameter);
	}

	@Override
	public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
		System.err.println(this.getClass().getName() + "\t" + columnName + "\t getNullableResult");
		System.err.println(this.getClass());
		return rs.getString(columnName);
	}

	@Override
	public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		System.err.println(this.getClass().getName() + "\t" + columnIndex + "\t getNullableResult");
		System.err.println(this.getClass());
		return rs.getString(columnIndex);
	}

	@Override
	public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return cs.getString(columnIndex);
	}

	/*
	 * @Override public void setNonNullParameter(PreparedStatement ps, int i,
	 * String parameter, JdbcType jdbcType) throws SQLException { // TODO
	 * Auto-generated method stub }
	 * 
	 * @Override public String getNullableResult(ResultSet rs, String
	 * columnName) throws SQLException { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * @Override public String getNullableResult(ResultSet rs, int columnIndex)
	 * throws SQLException { // TODO Auto-generated method stub return null; }
	 * 
	 * @Override public String getNullableResult(CallableStatement cs, int
	 * columnIndex) throws SQLException { // TODO Auto-generated method stub
	 * return null; }
	 */
}
