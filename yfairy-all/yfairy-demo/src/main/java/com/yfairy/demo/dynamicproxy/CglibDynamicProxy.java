package com.yfairy.demo.dynamicproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibDynamicProxy implements MethodInterceptor {

	/**
	 * 代理真实类
	 */
	private Object target;

	public Object bind(Object tar) {
		this.target = tar;

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		// 设置回调方法
		enhancer.setCallback(this);
		// 创建代理对象
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		Object result = null;
		System.out.println("----------------- Cglib 动态代理 start -----------------");
		result = method.invoke(target, args);
		System.out.println("----------------- Cglib 动态代理 end -----------------");
		return result;
	}

}
