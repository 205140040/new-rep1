package com.yfairy.demo.javacore;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.yfairy.demo.thinkinginjava.Child;
import com.yfairy.demo.thinkinginjava.Parent;

public class GenericDemo {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException {
		/**
		 * 第12章：泛型程序设计543/720<br>
		 * 1.为什么要使用泛型: 不使用泛型时，需要强制类型转换， 添加到集合中的类型没有做安全检查<br>
		 * 泛型的限制:不能使用基本类型作为泛型，<br>
		 * instanceof 只能检查类型擦除后的信息如instanceof Pair<String> 等同于Pair<br>
		 * 不能实例化泛型变量如new T <br>
		 * Java 泛型 <? super T> 中 super 怎么 理解？与 extends 有何不同？<br>
		 * (https://www.zhihu.com/question/20400700)<br>
		 * <? extends T>：是指 “上界通配符（Upper Bounds Wildcards）”<br>
		 * <? super T>：是指 “下界通配符（Lower Bounds Wildcards）” <br>
		 * 12.9反射和泛型<br>
		 */
		// 泛型类
		GenericType1<Child, Integer> gt1 = new GenericType1<Child, Integer>(new Child("11"), 18);
		System.out.println("firstType:" + gt1.getFirstType());
		System.out.println(gt1);
		// 泛型方法
		genericMethod(Arrays.asList(1, 2, 3, 4));

		genericMethod(Arrays.asList("one", "two"));

		// 泛型上限：T extends Type，表示该泛型必须是某个类或其子类,限定多个类型用extends X&Y

		// The inferred type String is not a valid substitute for the bounded
		// parameter <T extends Number>
		// Object o=genericExtends("haha");
		Object o = genericExtends(3.1415926);
		System.out.println(o);

		// GenericType1<String, String>[] gts = new GenericType1[10];
		// 通过泛型获取任意类型的实例
		ManSort ms = GenericType1.getAnyTypeInstance(ManSort.class);
		System.out.println(ms);
		InitBlock s = GenericType1.getAnyTypeInstance(InitBlock.class);
		System.out.println(s);

		// 泛型通配符?代表任意类型
		/**
		 * Java 泛型 <? super T> 中 super 怎么 理解？与 extends 有何不同？<br>
		 * (https://www.zhihu.com/question/20400700)<br>
		 * <? extends T>：是指 “上界通配符（Upper Bounds Wildcards）”<br>
		 * <? super T>：是指 “下界通配符（Lower Bounds Wildcards）” <br>
		 */
		List<? extends Integer> pList = new ArrayList<>();
		System.out.println(pList);
		// <? super T>：是指 “下界通配符（Lower Bounds Wildcards）” <br>
		List<? super Parent> superList = new ArrayList<>();
		superList.add(new Parent("111"));
		superList.add(new Child("111"));

		System.out.println("----------------------------------------------------");
		// 12.9反射和泛型<br>
		// 通过反射获取方法的参数和返回值的泛型信息
		// http://www.blogjava.net/ITdavid/archive/2008/02/28/182608.html
		GenericType3<String> g3 = new GenericType3();
		Class pClass = g3.getClass();

		Method m2 = pClass.getDeclaredMethod("sayHello", GenericType2.class);
		System.out.println(m2.getReturnType());
		System.out.println("----------------------");

		// T newInstance()
		// Parent p = pClass.newInstance();
		// 获取泛型类型变量
		TypeVariable[] typevars = pClass.getTypeParameters();
		for (TypeVariable typeVariable : typevars) {
			System.out.println(typeVariable);
		}

		System.out.println("----------------------");

		Method[] methods = pClass.getDeclaredMethods();
		for (Method method : methods) {
			// 获取泛型方法中的泛型类 ，类型
			TypeVariable[] tvs = method.getTypeParameters();
			for (TypeVariable typeVariable : tvs) {
				System.out.println(typeVariable);
			}

			// 获取泛型方法中的泛型参数 ,类型
			System.out.println();
			Type[] types = method.getGenericParameterTypes();
			for (Type type : types) {
				System.out.println(type);
			}

			// 获取泛型方法中的泛型返回值 ,类型
			Type type = method.getGenericReturnType();
			System.out.println(type);
		}

	}

	static class GenericType3<T> {
		public static <Y> Y sayHello(GenericType2<String> t) {
			return null;
		}
	}

	static class GenericType2<T> {

	}

	public static void tp(GenericType2<?> t) {
		// 泛型通配符?代表任意类型
		System.out.println(t);
	}

	public static <T extends Number> T genericExtends(T t) {
		Integer a = 1;
		// if(a instanceof GenericType1<String, String>){
		// System.out.println("1");
		// }
		return t;
	}

	public static <T extends Number & IHelloService> T genericExtends2(T t) {
		return t;
	}

	/**
	 * 泛型方法在方法的返回值前声明<T>即可使该方法为泛型方法
	 * 
	 * @param t
	 * @return
	 */
	public static <T> T genericMethod(T... t) {
		for (T t2 : t) {
			System.out.println(t2);
		}
		return t[0];
	}

}
