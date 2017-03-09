package com.yfairy.demo.spring3qiyekaifashizhan;

public class Chapter16Test {

	public static void main(String[] args) {
		/**
		 * 第16章：实战型单元测试(607/725)<br>
		 * 单元测试（unit testing），是指对软件中的最小可测试单元进行检查和验证。<br>
		 * 一般是指对一个方法进行测试<br>
		 * 16.2Junit4快速进阶<br>
		 * 16.3模拟利器：Mockito(623/725)<br>
		 */
		// 16.2Junit4快速进阶<br>
		// 16.2.2Junit4生命周期
		// 类初始化@BeforeClass，方法初始化@Before，执行测试用例中的方法@Test，方法销毁@After，类销毁@AfterClass
		// @BeforeClass,@AfterClass在类运行时执行一次,必须声明为public
		// static方法,而@Before和@After在测试用例方法执行时，每次都执行

		// 16.2.3使用Junit4

		// 异常测试:@Test(expected=NullPointerException.class)
		// 超时测试:@Test(timeout=10)

		// 测试运行器:@RunWith,所有的测试方法都由测试运行器负责执行,
		// 都继承Runner抽象类,默认为:BlockJUnit4ClassRunner运行器

		// 如：使用打包测试:
		// @RunWith(value=Suite.class) //指定打包测试运行器
		// @SuiteClasses(value={MoneyTest.class,Test2.class}) //指定要运行的测试用例

		// Junit4断言:
		// double n1 = 200;
		// double expected = 201;
		//// assertThat(n1, is(expected));
		// double notd=100;
		// assertThat(n1, not(notd));
		// //字符串匹配
		// String url="https://www.baidu.com";
		// assertThat(url, endsWith("om1"));

		// 16.3模拟利器：Mockito(623/725)<br>
	}

}
