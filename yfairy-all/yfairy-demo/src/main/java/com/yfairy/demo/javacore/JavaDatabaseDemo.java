package com.yfairy.demo.javacore;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class JavaDatabaseDemo {

	public static void main(String[] args) throws Exception {
		/**
		 * 第4章：数据库编程206/858<br>
		 */
		Properties prop = new Properties();
		Resource r = new ClassPathResource("jdbc.properties");
		prop.load(r.getInputStream());
		String driverClassName = prop.getProperty("jdbc.driverClassName");
		String url = prop.getProperty("jdbc.url");
		String username = prop.getProperty("jdbc.username");
		String password = prop.getProperty("jdbc.password");

		// 获取数据库连接
		Connection connection = DriverManager.getConnection(url, username, password);
		System.out.println(connection);
		// 执行sql
		Statement stat = connection.createStatement();
		// 执行查询
		ResultSet set = stat.executeQuery(" SELECT * from yf_student ");
		// ResultSet getString(colIndex)返回某列的值
		// next()
		while (set.next()) {
			System.out.println(
					set.getString(1) + "\t" + set.getString(2) + "\t" + set.getString(3) + "\t" + set.getInt(4));
		}
		System.out.println("执行sql,");

		// 执行sql,可执行Executes the given SQL statement, which may be an INSERT,
		// UPDATE,
		// or DELETE statement or an SQL statement that returns nothing,
		// such as an SQL DDL statement.
		// 获取自增主键ResultSet keySet=stat.getGeneratedKeys();
		/*
		 * stat.
		 * executeUpdate("INSERT INTO yf_student(name,sex,age) VALUE('l2','哈哈2',18) "
		 * , Statement.RETURN_GENERATED_KEYS); ResultSet keySet =
		 * stat.getGeneratedKeys(); while (keySet.next()) {
		 * System.out.println("key:" + keySet.getInt(1)); }
		 */

		// 再次查询
		ResultSet set2 = stat.executeQuery(" SELECT * from yf_student ");
		printResultSet(set2);

		System.out.println("预编译PreparedStatement");
		// 预编译PreparedStatement,性能更高
		String prepSql = "SELECT * from yf_student WHERE sex like concat('%',?,'%') and age=?";
		PreparedStatement preparedStatement = connection.prepareStatement(prepSql);
		// 设置参数
		preparedStatement.setString(1, "哈哈");
		preparedStatement.setInt(2, 18);
		ResultSet prepres = preparedStatement.executeQuery();
		printResultSet(prepres);

		// 获取数据库元信息
		DatabaseMetaData dtmd = connection.getMetaData();
		System.out.println("getMaxConnections最大连接数:" + dtmd.getMaxConnections());
		String[] t = { "TABLE" };
		ResultSet metaSet = dtmd.getTables(null, null, null, t);
		while (metaSet.next()) {
			System.out.println(metaSet.getString(1));
		}

		// 事务:
		System.out.println("----------------------------------------");
		System.out.println("事务");
		connection.setAutoCommit(false); // 关闭自动提交

		// 事务保存点
		Savepoint savepoint = connection.setSavepoint(); // 设置一个保存点，回滚时可以回滚到该处
		// connection.rollback(savepoint);
		try {
			// 一个事务中的全部回滚
			Statement s2 = connection.createStatement();
			s2.executeUpdate("INSERT INTO yf_student(name,sex,age) VALUE('l2','哈哈2',18) ");

			PreparedStatement prep = connection.prepareStatement("insert aa(a) value(1)");
			prep.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback(); // 出错回滚
			System.out.println("出错回滚事务");
		}
		// 不出异常时提交事务
		connection.commit(); // 提交事务
		// 再次查询
		ResultSet set3 = stat.executeQuery(" SELECT * from yf_student ");
		printResultSet(set3);

		connection.close();
	}

	private static void printResultSet(ResultSet resultSet) throws SQLException {
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3)
					+ "\t" + resultSet.getInt(4));
		}
	}

}
