package com.yfairy.demo.spring_in_action_2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class GuanzongAspect {
	@Around(value = "execution(* com.yfairy.demo.spring_in_action_2.Duke.*(..) )")
	public Object invoke(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Object result = null;
		try {
			System.out.println("before");
			System.out.println("方法环绕通知@Around");
			// 调用目标方法
			result = proceedingJoinPoint.proceed();
			System.out.println("after");
		} catch (Exception e) {
			System.out.println("方法异常时执行");
			e.printStackTrace();
		}

		return result;
	}

	@AfterReturning(value = "execution(* com.yfairy.demo.spring_in_action_2.Duke.*(..) )", returning = "returnVal")
	public void afterReturning(JoinPoint joinPoint, Object returnVal) throws Throwable {
		System.out.println("------------------------------");
		Object[] args = joinPoint.getArgs();
		for (Object arg : args) {
			System.out.println("参数:" + arg);
		}
		System.out.println("方法返回会通知@AfterReturning\t返回值:" + returnVal);
		System.out.println("------------------------------");
	}

	@Before("execution(* com.yfairy.demo.spring_in_action_2.Duke.*(..) )")
	public void before() throws Throwable {
		System.out.println("方法前置通知@Before");
	}

	@AfterThrowing("execution(* com.yfairy.demo.spring_in_action_2.Duke.*(..) )")
	public void afterThrowing() {
		// throwable.printStackTrace();
		System.out.println("方法异常通知@AfterThrowing");
	}

}
