package com.yfairy.demo.spring3qiyekaifashizhan;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.yfairy.demo.spring_in_action_2.HelloServiceImpl;
import com.yfairy.demo.spring_in_action_2.IHelloService;

public class MockSimple {
	
	//对接口进行模拟
	IHelloService iHelloService=mock(IHelloService.class);
	
	//对类进行模拟
	HelloServiceImpl helloServiceImpl=mock(HelloServiceImpl.class);
	
	//使用注解模拟
	@Mock
	IHelloService helloService;

	@Before
	public void initAllMocks(){
		MockitoAnnotations.initMocks(this);
		System.out.println("初始化所有@Mock模拟的对象");
	}
	
	@Test
	public void testMethod1(){
		System.out.println(iHelloService);
		System.out.println(helloServiceImpl);
		System.out.println(helloService);
		helloService.sayHello();
	}

}
