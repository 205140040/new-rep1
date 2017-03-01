package com.yfairy.demo.spring_in_action_2;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class GuanzongAspect {
	@Around(value = "")
	public Object invoke(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Object result = null;
		try {
			System.out.println("before");
			System.out.println("方法环绕通知MethodInterceptor");
			// 调用目标方法
			result = proceedingJoinPoint.proceed();
			System.out.println("after");
		} catch (Exception e) {
			System.out.println("方法异常时执行");
			e.printStackTrace();
		}

		return result;
	}

	@AfterReturning("")
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("方法返回会通知AfterReturningAdvice");
	}

	@Before("")
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("方法前置通知MethodBeforeAdvice");
	}

	@AfterThrowing("")
	public void afterThrowing(Method method, Object[] args, Object target, Throwable throwable) {
		throwable.printStackTrace();
		System.out.println("方法异常通知ThrowsAdvice");
	}

}
