package com.yfairy.demo.javacore;

public class SecurityDemo {
	
	static class MyClassLoader extends ClassLoader{

		public MyClassLoader() {
			super();
		}

		public MyClassLoader(ClassLoader parent) {
			super(parent);
		}
		
	}

	public static void main(String[] args) throws Exception {
		/**
		 * 第9章：安全659/858<br>
		 * 9.1类加载器<br>
		 */
		System.out.println(SecurityDemo.class.getClassLoader().getParent().getParent());
		System.out.println(SecurityDemo.class.getClassLoader().getParent());
		System.out.println(SecurityDemo.class.getClassLoader());
		
		//设置上下文类加载器，通过此方式可以在类加载时设置父类加载器加载子类加载器中的类
		Thread thread=Thread.currentThread();
		ClassLoader pClassLoader=new MyClassLoader();
		ClassLoader myClassLoader=new MyClassLoader(pClassLoader);
		thread.setContextClassLoader(myClassLoader);
		//获取上下文类加载器
		ClassLoader loader=thread.getContextClassLoader(); 
		System.out.println(loader);
		Class c=loader.loadClass("com.yfairy.demo.javacore.SecurityDemo");
		System.out.println("自定义类加载器:"+c.getClassLoader());
		
		//9.2类校验，查看是否有局部变量未初始化，其他类中访问private字段，等
//		VerifyError 校验异常
		
		//9.3安全管理器与访问权限672/858<br>
	}

}
