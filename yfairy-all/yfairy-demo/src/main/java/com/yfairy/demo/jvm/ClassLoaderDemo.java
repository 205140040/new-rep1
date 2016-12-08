package com.yfairy.demo.jvm;

public class ClassLoaderDemo {

	public static void main(String[] args) {
		/**
		 * 7.4.2:双亲委派模型：22(250/460) 应用由，BootstrapClassLoader，ExtClassLoader，
		 * AppClassLoader这三种类加载器进行配合进行加载的,<br>
		 * 首先：BootstrapClassLoader由c实现，看不到，加载rt.jar等 <br>
		 * 第二步：ExtClassLoader加载ext 扩展的jar，<br>
		 * 第三步：AppClassLoader加载lib中的jar <br>
		 * 第四步：自定义类加载器<br>
		 * 类加载器这种层次称为双亲委派模型：要求一个类加载器必须有一个父类加载器，当加载器运行时，<br>
		 * 先委派父类加载，父类无法加载时，才自己加载，以确保rt.jar系统类不会被破坏<br>
		 * 以下情况可能不会使用双亲委派模型：如jndi，jdbc他们加载时会使用厂商类，<br>
		 * 可通过设置一个类加载线程，先加载使用的类，在加载该类，osgi，模块化加载更好(推荐学习)<br>
		 */
		ClassLoaderDemo demo = new ClassLoaderDemo();
		System.out.println("BootstrapClassLoader:" + demo.getClass().getClassLoader().getParent().getParent());
		System.out.println("sun.misc.Launcher$ExtClassLoader:" + demo.getClass().getClassLoader().getParent());
		System.out.println("sun.misc.Launcher$AppClassLoader:" + demo.getClass().getClassLoader());

	}

}
