package com.yfairy.demo.spring3qiyekaifashizhan;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MoneyTest {

	@BeforeClass
	public static void beforeClassMethod() {
		System.out.println("beforeClassMethod");
	}

	@Before
	public void before1() {
		System.out.println("before1");
	}

	@Before
	public void before2() {
		System.out.println("before2");
	}

	@Test
	public void method1() {
		double n1 = 200;
		double expected = 201;
		// delta the maximum delta between expected and actual for which both
		// numbers are still considered equal.
		// 两个数字误差，如果误差值+原始值=期望，则认为通过
		assertEquals(expected, n1, 0);
	}
	
	@Test
	public void assertMethod() {
		double n1 = 200;
		double expected = 201;
//		assertThat(n1, is(expected));
		double notd=100;
		assertThat(n1, not(notd));
		//字符串匹配
		String url="https://www.baidu.com";
		assertThat(url, endsWith("om1"));
	}

	@Test(expected = NullPointerException.class)
	public void exceptionTestMethod() {
		double n1 = 200;
		double expected = 200;
		// delta the maximum delta between expected and actual for which both
		// numbers are still considered equal.
		// 两个数字误差，如果误差值+原始值=期望，则认为通过
		assertEquals(expected, n1, 0);
		throw new NullPointerException();
	}

	@Test(timeout = 10)
	public void timeoutTestMethod() {
		// 超时测试
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		double n1 = 200;
		double expected = 200;
		// delta the maximum delta between expected and actual for which both
		// numbers are still considered equal.
		// 两个数字误差，如果误差值+原始值=期望，则认为通过
		assertEquals(expected, n1, 0);
	}

	@After
	public void after() {
		System.out.println("after");
	}

	@AfterClass
	public static void afterClassMethod() {
		System.out.println("afterClassMethod");
	}

}
