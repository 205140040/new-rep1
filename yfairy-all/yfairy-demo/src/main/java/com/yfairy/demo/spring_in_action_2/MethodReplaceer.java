package com.yfairy.demo.spring_in_action_2;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class MethodReplaceer implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println(this);
		System.out.println("实现:MethodReplacer接口从而配置替换方法");
		return "实现:MethodReplacer接口从而配置替换方法";
	}

}
