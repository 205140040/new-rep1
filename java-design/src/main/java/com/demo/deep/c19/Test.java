package com.demo.deep.c19;

public class Test {

	public static void main(String[] args) {
		/**
		 * 枚举.enum.values()遍历enum实例
		 * ordinal()返回声明时的顺序，从0开始
		 * 
		 * name()方法返回声明时的名字
		 * valueOf()根据指定的名字返回相应的enum
		 */
		for (ColorEnum e : ColorEnum.values()) {
			System.out.println("ordinal"+e.ordinal()+",name:"+e.name());
			System.out.println("是否red:"+(e.equals(ColorEnum.RED)));
		}
		System.out.println(ColorEnum.valueOf("RED"));
		System.out.println("自定义方法返回描述:----------------------------------------");
		for (ColorEnum e : ColorEnum.values()) {
			System.out.println("构造器description:"+e.getDescription());
		}
		/**
		 * switch中使用枚举
		 */
		System.out.println("-----------------------------------");
		ColorEnum colorEnum=ColorEnum.RED;
		switch (colorEnum) {
		case RED:
			System.out.println("红色");
			break;
		case BLUE:
			System.out.println("蓝色");
			break;
		case GREEN:
			System.out.println("绿色");
			break;
		default:
			break;
		}
	}

}
