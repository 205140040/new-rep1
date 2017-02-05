package com.yfairy.demo.java_concurrent;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class CountServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 使用线程安全类:原子类,管理对象变量同步
	 */
	private AtomicLong count;

	/**
	 * AtomicReference确保并发时安全创建对象引用 原子更新引用类型
	 */
	private AtomicReference<Student> studentAtomicReference = new AtomicReference<Student>(new Student());

	public long getCount() {
		return count.get();
	}

	public Student getStudent() {
		return studentAtomicReference.get();
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service");
		long c = count.incrementAndGet();
		System.out.println(c);
	}

}
