package com.yfairy.demo.java_concurrent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHolder {
	/**
	 * 线程封闭，ThreadLocal<T> ==
	 * MAP<Thread,T>,每个线程都有一个自己的该变量，之间不收影响，从而实现线程安全,该线程结束时会回收T
	 */
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>() {
		/**
		 * 调用get时，会调用此初始化方法
		 * 
		 * @return
		 * @throws SQLException
		 */
		public Connection initValue() throws SQLException {
			return DriverManager.getConnection("");
		}
	};

	public static Connection getConnection() {
		return tl.get();
	}

	public static void main(String[] args) throws SQLException {
		Connection c = getConnection();
		c.createStatement().executeQuery("");
	}

}
