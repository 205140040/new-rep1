package com.demo.deep.c20;

import java.lang.reflect.Method;

public class UseTestAnnation {
	@Test(name="sayHello",description="sayHello方法")
	public void sayHello() {
		System.out.println("hello");
	}
	
	@Test(name="count",description="count方法")
	public void count() {
		System.out.println("count");
	}
	
	@Test(name="sum")
	public void sum() {
		System.out.println("sum");
	}
	
	public static void main(String[] args) {
		//注解处理器,通过反射获取注解信息
		Class<UseTestAnnation> c=UseTestAnnation.class;
		//遍历所有的方法
		for (Method method : c.getDeclaredMethods()) {
			Test test=method.getAnnotation(Test.class);
			if(null!=test){
				System.out.println("方法名:"+method.getName()+"\tname:"+test.name()+"\t描述:"+test.description());
			}
		}
		
	}
}
