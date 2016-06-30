package com.demo.deep.c14;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassDemo {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		/*
		 * List<Shape> shapes = Arrays.asList(new Circle(), new Square(), new
		 * Juxing()); for (Shape shape : shapes) { if (shape instanceof Circle)
		 * { // instanceof判断变量是否是某个类的实例 System.out.println(shape + " is circle"
		 * ); } shape.draw(); } // 使用？泛型通配符获取class对象 // Class<?>
		 * class1=Class.forName("com.demo.deep.c14.Circle"); Class<?> class1 =
		 * Circle.class; Circle circle1 = (Circle) class1.newInstance(); if
		 * (class1.isInstance(circle1)) { // CLASS.isInstance提供了一种动态测试对象的方法
		 * circle1.draw(); }
		 */
		/**
		 * 反射
		 */
		Class<?> c2 = Juxing.class;
		// 获取所有的构造方法
		Constructor<?>[] cons = c2.getConstructors();
		for (Constructor<?> constructor : cons) {
			System.out.println("constructor:" + constructor.getName());
		}
		Method[] methods = c2.getMethods();// 获取所有(包含父类，接口)的方法
		for (Method method : methods) {
			System.out.println("methodName:" + method.getName());
		}
		Method method = c2.getMethod("draw");
		// 调用方法
		/**
		 * 参数： obj：从中调用底层方法的对象，必须是实例化对象 args： 用于方法调用，是一个object的数组，因为参数有可能有多个 返回：
		 * 使用参数args在obj上指派该对象所表示的方法的结果。
		 */
		method.invoke(new Juxing());
		// 调用私有方法,getDeclaredMethod，私有方法无法从所有的方法中获取
		Method m2 = c2.getDeclaredMethod("myFun1");
		m2.setAccessible(true); // 设置可访问私有方法
		m2.invoke(new Juxing());

		// 动态代理
		// Juxing juxing = new Juxing();
		// DyamicInterface dyamicInterface = (DyamicInterface)
		// Proxy.newProxyInstance(
		// DyamicInterface.class.getClassLoader(), new Class[] {
		// DyamicInterface.class },
		// new DyamicProxyHandler(juxing));
		// dyamicInterface.sayHello();
	}

}
