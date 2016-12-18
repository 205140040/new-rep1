package com.yfairy.demo.thinkinginjava;

/**
 * 内部类
 * 
 * @author jiangzi
 *
 */
public class Neibulei {

	private String name;

	private static String staticField = "hahah";

	/**
	 * 类中的内部类
	 * 
	 * @author jiangzi
	 *
	 */
	class Content {
		private int i = 11;

		public int value() {
			System.out.println("访问内部类所在的封装类的属性：" + getName());
			return i;
		}
	}

	/**
	 * 内部类的继承
	 * 
	 * @author jiangzi
	 *
	 */
	class ChildContent extends Content {
		private int i = 889;

		public int value() {
			System.out.println("内部类的继承...........");
			System.out.println("访问内部类所在的封装类的属性：" + getName());
			return i;
		}
	}

	/**
	 * 
	 * @author jiangzi 私有的内部类，通常情况建立的class只能是默认或者public，只有内部类才能设置访问权限为private
	 */
	private class PrivateNeibulei {
		private String pname = "PrivateNeibulei";

		public String value() {
			return pname;
		}
	}

	public void useNeibulei() {
		// 在该类内部使用内部类，直接new 即可
		Content content = new Content();
		System.out.println("content.value:" + content.value());
	}

	/**
	 * 提供一个外部直接获取内部类的方法
	 * 
	 * @return
	 */
	public Content getContent() {
		return new Content();
	}

	public void neibuleiInMethod() {
		// 方法中的内部类,会在方法外失效
		class NeibuleiInMethod {
			public int value() {
				return 10;
			}
		}
		NeibuleiInMethod neibuleiInMethod = new NeibuleiInMethod();
		System.out.println("方法中的内部类value:" + neibuleiInMethod.value());
	}

	/**
	 * 匿名内部类,没有名字无法创建构造函数，但可以在使用前给变量赋默认值
	 * 
	 * @return
	 */
	public NimingInterface getNiming() {
		NimingInterface temp = new NimingInterface() {

			private int i = 66;

			@Override
			public int value() {
				/**
				 * 创建自己的内部类时，那个类的对象同时拥有
				 * 指向封装对象（这些对象封装或生成了内部类）的一个链接。所以它们能访问那个封装对象的成员—— 毋需
				 * 取得任何资格。除此以外，内部类拥有对封装类所有元素的访问权限
				 */
				System.out.println("封装类，即该内部类所在的类：name:" + name);
				return i;
			}
		};
		return temp;
	}

	/**
	 * 静态内部类，为了达到不用创建（new ）封装内，<br>
	 * 即可使用内部类的目的<br>
	 * 静态内部类无法访问，封装类非静态数据<br>
	 * 
	 * @author jiangzi
	 *
	 */
	static class StaticNeibulei {
		private String sname;

		public String value() {
			// 静态内部类无法访问，封装类非静态数据
			// System.out.println(name);
			// 静态内部类可以访问，封装类静态数据
			System.out.println(staticField);
			sname = "哈哈哈";
			return sname;
		}
	}

	public static void main(String[] args) {
		// 在该类内部使用内部类，直接new 即可
		Neibulei neibulei = new Neibulei();
		neibulei.setName("aaa");
		neibulei.useNeibulei();
		// 在该类外部使用内部类时，使用new该内部类的外部类.new 内部类
		Content content = new Neibulei().new Content();
		System.out.println("在该类外部使用内部类时，使用new该内部类的外部类.new 内部类:" + content.value());
		// 3.提供一个外部直接获取内部类的方法,从而快速new 一个内部类
		Neibulei.Content content2 = new Neibulei().getContent();
		System.out.println("提供一个外部直接获取内部类的方法:" + content2.value());
		// 私有的内部类，通常情况建立的class只能是默认或者public，只有内部类才能设置访问权限为private
		// 私有的内部类只能在当前内种访问，其他类里无法访问
		PrivateNeibulei privateNeibulei = new Neibulei().new PrivateNeibulei();
		System.out.println("privateNeibulei:" + privateNeibulei.value());
		// 方法中的内部类,会在方法外失效,报错：NeibuleiInMethod cannot be resolved to a type
		neibulei.neibuleiInMethod();
		// NeibuleiInMethod neibuleiInMethod=new NeibuleiInMethod();

		// 匿名内部类,没有名字无法创建构造函数，但可以在使用前给变量赋默认值
		NimingInterface ni = neibulei.getNiming();
		System.out.println("NimingInterface:value\t" + ni.value());
		// 静态内部类，为了达到不用创建（new ）封装内，即可使用内部类的目的
		System.out.println("-------------------------");
		StaticNeibulei staticNeibulei = new StaticNeibulei();
		System.out.println(staticNeibulei.value());

		/**
		 * 由于每个类都会生成一个.class 文件，用于容纳与如何创建这个类型的对象有关的所有信息（这种信息产生 了一个名为 Class
		 * 对象的元类），所以大家或许会猜到内部类也必须生成相应的.class 文件，用来容纳与它 们的 Class
		 * 对象有关的信息。这些文件或类的名字遵守一种严格的形式：先是封装类的名字，再跟随一个$， 再跟随内部类的名字。例如，由
		 * InheritInner.java 创建的.class 文件包括： InheritInner.class
		 * WithInner$Inner.class WithInner.class
		 * 如果内部类是匿名的，那么编译器会简单地生成数字，把它们作为内部类标识符使用。若内部类嵌套于其他
		 * 内部类中，则它们的名字简单地追加在一个$以及外部类标识符的后面。
		 * 这种生成内部名称的方法除了非常简单和直观以外，也非常“健壮”，可适应大多数场合的要求
		 */

		/**
		 * 若想在方法中的匿名内部类中访问方法中的变量，<br>
		 * 需要把该变量定义为final 的方可访问,不设置成final，<br>
		 * 会报错:Cannot refer to the non-final local variable methodName defined
		 * in an enclosing scope<br>
		 */
		System.out.println("-------------------------------");
		final String methodName = "方法中的变量";
		NimingInterface ni2 = new NimingInterface() {

			@Override
			public int value() {
				System.out.println("methodVarName:" + methodName);
				return 0;
			}
		};
		System.out.println(ni2.value());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
