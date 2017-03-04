package com.yfairy.demo.spring_in_action_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyJdbcTemplate {

	private String url;

	private String username;

	private String password;

	public MyJdbcTemplate() {
		super();
	}

	public MyJdbcTemplate(String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void executeQuery(String sql, IJdbcTemplateCallBack callBack, Object object) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection(this.url, this.username, this.password);
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);
			callBack.executeQueryCallBack(resultSet, object);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != resultSet) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != statement) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != connection) {
				try {
					connection.close();
					System.out.println("connection.close();");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
