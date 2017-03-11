package com.yfairy.demo.spring_in_action_2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//配置spring运行器
@RunWith(SpringJUnit4ClassRunner.class)
// 配置上下文context配置文件路径
@ContextConfiguration(value = { "classpath:com\\yfairy\\demo\\spring3qiyekaifashizhan\\spring-tdemo.xml" })
public class Junit4SpringTest {

	@Autowired
	private IHelloService helloService;

	@Test
	public void test1() {
		/**
		 * 推荐看: 使用 Spring 进行单元测试:<br>
		 * https://www.ibm.com/developerworks/cn/java/j-lo-springunitest/<br>
		 * 基于Spring MVC做单元测试（一）——使用Spring Test框架:<br>
		 * http://zhaozhiming.github.io/blog/2014/06/16/spring-mvc-unit-test-part-1/<br>
		 */
		System.out.println(helloService);
		helloService.sayHello();
	}
}
