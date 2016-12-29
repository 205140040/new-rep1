package com.yfairy.demo.javacore;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectiveDemo extends ReflectiveParent {

	private String name;

	public String currentBir;

	private double score;

	public ReflectiveDemo() {
		super();
	}

	public ReflectiveDemo(String name) {
		super();
		this.name = name;
	}

	public ReflectiveDemo(String name, String currentBir) {
		super();
		this.name = name;
		this.currentBir = currentBir;
	}

	public ReflectiveDemo(String name, String currentBir, double score) {
		super();
		this.name = name;
		this.currentBir = currentBir;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrentBir() {
		return currentBir;
	}

	public void setCurrentBir(String currentBir) {
		this.currentBir = currentBir;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	private void privateMethod(int age, String bir) {
		System.out.println("privateMethod");
	}

	public static void main(String[] args) throws Exception {
		/**
		 * 5.7反射209/720<br>
		 * Class类的类型信息<br>
		 * 5.7.4在运行时使用反射设置对象217/720<br>
		 * 
		 */
		// 获取Class
		ReflectiveDemo rd1 = new ReflectiveDemo();
		Class c1 = rd1.getClass();
		// 或
		Class c2 = ReflectiveDemo.class;
		// 或
		Class<ReflectiveDemo> c3 = (Class<ReflectiveDemo>) Class.forName("com.yfairy.demo.javacore.ReflectiveDemo");
		System.out.println(c1.getName());
		System.out.println("c2:" + c2.getName());
		// 用反射创建对象
		ReflectiveDemo rd2 = (ReflectiveDemo) c2.newInstance();
		System.out.println("rd1:" + rd1);
		System.out.println("rd2:" + rd2);

		//
		ReflectiveDemo rd3 = c3.newInstance();
		System.out.println("c3newInstance:" + c3);

		// 获取对象的字段及其父类的字段
		System.out.println("获取对象的属性及其父类的public的属性:");
		Field[] fields = c3.getFields();
		for (Field field : fields) {
			System.out.println(field);
		}
		System.out.println("-------------");
		// 获取当前类的全部属性
		System.out.println("获取当前类的全部属性");
		Field[] dFields = c3.getDeclaredFields();
		for (Field field : dFields) {
			System.out.println(field);
		}
		System.out.println("--------------------");

		Method[] methods = c3.getMethods();
		System.out.println("获取当前及父类所有public的方法");
		for (Method method : methods) {
			System.out.println(method);
		}
		System.out.println("--------------------");
		Method[] dmMethods = c3.getDeclaredMethods();
		System.out.println("获取当前类所有的方法:");
		for (Method method : dmMethods) {
			System.out.println("--------方法信息:------------");
			System.out.println(method);
			System.out.println("方法名称:" + method.getName());
			System.out.println("方法参数:" + method.getParameterTypes());
			System.out.println("返回值:" + method.getReturnType());
			System.out.println("getModifiers:" + method.getModifiers());
			System.out.println("--------------------");

		}
		System.out.println("--------------------");
		System.out.println("获取所有的构造器:");
		Constructor[] constructors = c3.getDeclaredConstructors();
		for (Constructor constructor : constructors) {
			System.out.println(constructor);
		}

		// 使用反射获取对象信息
		System.out.println("使用反射获取对象信息");
		ReflectiveDemo rd5 = new ReflectiveDemo("张三", "1995", 98.88);
		@SuppressWarnings("rawtypes")
		Class class5 = rd5.getClass();
		Field field = class5.getDeclaredField("name");
		System.out.println("字段:" + field);
		// 设置可访问
		field.setAccessible(true);
		System.out.println("是否可访问:" + field.isAccessible());
		// 返回对象的字段值field.get()
		System.out.println("反射获得的值:" + field.get(rd5));

		// 反射获取基本类型的值
		Field scoreField = class5.getDeclaredField("score");
		System.out.println("scoreField:" + scoreField);
		double sd = scoreField.getDouble(rd5);
		System.out.println("score:" + sd);
		// set()方法设置值
		field.set(rd5, "李四");
		System.out.println(rd5.getName());

		// getComponentType()
		System.out.println(class5.getComponentType());

		System.out.println("--------------------");
		Method m2 = class5.getDeclaredMethod("setName", String.class);
		m2.invoke(rd5, "invoke改值");
		// 反射调用方法,获取Method
		Method method = class5.getDeclaredMethod("getName");
		System.out.println(method);
		// 反射调用方法
		String mname = (String) method.invoke(rd5);
		System.out.println(mname);

	}

}
