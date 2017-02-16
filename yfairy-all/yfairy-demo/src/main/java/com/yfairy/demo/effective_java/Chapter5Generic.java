package com.yfairy.demo.effective_java;

import java.util.ArrayList;
import java.util.List;

public class Chapter5Generic {

	public static void main(String[] args) {
		/**
		 * 第5章：泛型97(110/303)<br>
		 * 24消除非受检警告，从而减少问题的出现 如<br>
		 * 
		 * <pre>
		 * List list = new ArrayList();
		 * list.add("5");
		 * list.add(3);
		 * 警告:Multiple markers at this line
		 * - ArrayList is a raw type. References to generic type ArrayList<E> should be 
		 * parameterized
		 * </pre>
		 * 
		 * 25条列表优先于数组<br>
		 * 26条优先考虑泛型109(122/303)<br>
		 */

		List list = new ArrayList();
		list.add("5");
		list.add(3);
	}

}
