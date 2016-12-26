package com.yfairy.demo.javacore;

import java.util.ArrayList;

public class ObjectDemo {

	private String name;

	public ObjectDemo() {
		super();
	}

	public ObjectDemo(String name) {
		super();
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("---------------");
		System.out.println("重写equals，假设两个对象的名称相等，即这两个对象相等");
		if (null == obj) {
			return false;
		}
		ObjectDemo otherObj = (ObjectDemo) obj;
		if (otherObj.name == this.name) {
			return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return getClass().getName() + " [name=" + name + "]";
	}

	public static void main(String[] args) {
		/**
		 * 5.2 Object所有类的超类,会介绍object中的方法(重要)<br>
		 * object.equals(obj)方法用于检测一个对象是否等于另一个对象<br>
		 * java语言规范要求equals方法具有下面的特性<br>
		 * 1.自反性：对于任何非空引用，x.equals(x) 应该返回true<br>
		 * 2.对称性，x.equals(y)返回true则y.equals(x)也要返回true<br>
		 * 3.传递性 ,4一致性<br>
		 * 5.2.3:hashCode()方法189/720<br>
		 * 散列码是对象导出的一个整形值，散列码是没有规律的，<br>
		 * 两个不同的对象,hashCode方法的值基本不会相同<br>
		 * Object.hashCode()返回对象的散列码，散列码可以是任意的整数<br>
		 * 两个相等的对象要求返回相等的散列码<br>
		 * <br>
		 * toString()方法，返回描述该对象值得字符串<br>
		 * 默认的tostring方法返回的是对象类名和hashcode<br>
		 * return getClass().getName() + "@" +
		 * Integer.toHexString(hashCode());<br>
		 * <br>
		 * ArrayList.set(i,obj)设置指定元素的值
		 */

		ObjectDemo od1 = new ObjectDemo("od1");
		ObjectDemo od2 = new ObjectDemo("od1");
		if (od1 == od2) {
			System.out.println("这两个对象相等");
		}
		System.out.println("od1==od2?" + od1.equals(od2));

		System.out.println("------------");
		System.out.println(od1.hashCode());
		System.out.println(od2.hashCode());
		//
		System.out.println("tostring:" + od1);
		Object object = new Object();
		System.out.println(object);
		
		ArrayList<Integer> integers=new ArrayList<>();
		integers.add(1);
		integers.add(2);
		integers.add(3);
		System.out.println(integers);
		//trimToSize把ArrayList大小调整到size一致
		integers.trimToSize();
		//设置ArrayList某个元素
		integers.set(1, 5);
		System.out.println(integers);
	}

}
