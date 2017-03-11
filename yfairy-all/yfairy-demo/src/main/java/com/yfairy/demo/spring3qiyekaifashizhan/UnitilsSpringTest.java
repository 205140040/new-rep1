package com.yfairy.demo.spring3qiyekaifashizhan;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.unitils.UnitilsJUnit4;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

import com.yfairy.demo.spring_in_action_2.IHelloService;

public class UnitilsSpringTest extends UnitilsJUnit4 {

	// 加载spring配置文件
	@SpringApplicationContext({ "com\\yfairy\\demo\\spring3qiyekaifashizhan\\spring-tdemo.xml" })
	private ApplicationContext applicationContext;

	// 加载spring bean
	@SpringBean("helloService")
	private IHelloService helloService;

	@Test
	public void test1() {
		
		//比较老，不用这个测试了
		System.out.println(applicationContext);
		System.out.println(helloService);

	}

}
