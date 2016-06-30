package com.demo.deep.c14;

import java.util.Arrays;
import java.util.List;

public class ClassDemo {

	public static void main(String[] args) throws Exception {
		List<Shape> shapes = Arrays.asList(new Circle(), new Square(), new Juxing());
		for (Shape shape : shapes) {
			if (shape instanceof Circle) { // instanceof判断变量是否是某个类的实例
				System.out.println(shape + " is circle");
			}
			shape.draw();
		}
		// 使用？泛型通配符获取class对象
		// Class<?> class1=Class.forName("com.demo.deep.c14.Circle");
		Class<?> class1 = Circle.class;
		Circle circle1 = (Circle) class1.newInstance();
		if (class1.isInstance(circle1)) {
			// CLASS.isInstance提供了一种动态测试对象的方法
			circle1.draw();
		}

	}

}
