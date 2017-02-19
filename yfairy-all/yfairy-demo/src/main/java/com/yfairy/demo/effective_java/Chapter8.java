package com.yfairy.demo.effective_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Chapter8 {

	public static void main(String[] args) {
		/**
		 * 第8章：通用程序设计181(194/303)<br>
		 * 45将局部变量的作用域最小化<br>
		 * 如果过早的声明变量，而不使用会浪费空间和时间,变量声明了占据内存且不使用，<br>
		 * 其次过早的声明变量可能会导致后面使用时不清楚变量类型<br>
		 * 46foreach循环优先于传统的for循环<br>
		 * foreach循环不会有性能损失，每次它会把循环的次数在外部声明，有时候可能比for循环效率还高<br>
		 * 47条了解和使用类库<br>
		 * 48条如果需要精确的答案，避免使用float和double<br>
		 * 49条基本类型优先于装箱基本类型<br>
		 * 理由如下:1.基本类型在方法运行完会立即回收,且变量在栈上分配,包装类型在堆上分配，不立即回收<br>
		 * 2.包装类型与基本类型比较时,首先要拆箱,可能出现null异常<br>
		 * Integer n1=null;<br>
		 * if(n1==888){<br>
		 * System.out.println("n1==888");<br>
		 * }<br>
		 * 3.基本类型和包装类型平凡交互使用，会存在一直拆装箱性能问题<br>
		 * 4.包装类型的值比较需要用equals方法，如果用==比较，<br>
		 * 会因为比较两个对象的内存地址,导致比较出错<br>
		 * 第50条：如果其他类型更适合，尽量避免使用字符串<br>
		 * 51条当心字符串连接的性能<br>
		 * 重复的+字符串，string不可变，所以会不停地复制，返回一个新的字符串,推荐使用stringbuilder<br>
		 * 52条通过接口引用对象<br>
		 * List<String> list=new Vector<>();<br>
		 * List<String> list2=new ArrayList<>();<br>
		 * 通过接口引用对象更灵活，且修改替换时修改的地方更少<br>
		 * 第53条接口优先于反射机制<br>
		 * 第54条谨慎的使用本地方法<br>
		 * 第55条谨慎的进行优化<br>
		 * 第56条遵循普遍接受的命名惯例<br>
		 */
		for (String string : args) {
			System.out.println(string);
		}
		String[] ss = {};
		for (String s : ss) {
			System.out.println(s);
		}
		Integer n1 = null;
		if (n1 == 888) {
			System.out.println("n1==888");
		}

		List<String> list = new Vector<>();
		List<String> list2 = new ArrayList<>();

	}

}
