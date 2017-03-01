package com.yfairy.demo.spring_in_action_2;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class GuanzongAdvice implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice, MethodInterceptor {

	public void sitDown() {
		System.out.println("坐下");
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object result = null;
		try {
			System.out.println("before");
			System.out.println("方法环绕通知MethodInterceptor");
			// 调用目标方法
			result = invocation.proceed();
			System.out.println("after");
		} catch (Exception e) {
			System.out.println("方法异常时执行");
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("方法返回会通知AfterReturningAdvice");
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("方法前置通知MethodBeforeAdvice");
	}

	public void afterThrowing(Method method, Object[] args, Object target, Throwable throwable) {
		throwable.printStackTrace();
		System.out.println("方法异常通知ThrowsAdvice");
	}

}
