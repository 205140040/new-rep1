package com.yfairy.demo.effective_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
		 * 27条优先考虑泛型方法<br>
		 * 静态工具方法比较适合泛型化<br>
		 * 29优先考虑类型安全的异构容器<br>
		 */

		List list = new ArrayList();
		list.add("5");
		list.add(3);

		// The method saveDbColumn(Class<T>, T) in the type Chapter5Generic.Util
		// is not applicable for the arguments (Class<String>, int)
		//Util.saveDbColumn(String.class, 1);
		Util.saveDbColumn(String.class, "1");
	}

	static class Util {

		public static <K, V> Map<K, V> newHashMap() {
			return new HashMap<K, V>();
		}

		public static <E> Set<E> union(Set<E> set1, Set<E> set2) {
			set1.addAll(set2);
			return set1;
		}

		/**
		 * 此方法使用泛型，确保某种类型键添加某种类型的值
		 * 
		 * @param t
		 * @param value
		 * @return
		 */
		public static <T> Map<Class<T>, T> saveDbColumn(Class<T> t, T value) {
			Map<Class<T>, T> map = new HashMap<>();
			map.put(t, value);
			return map;
		}
	}

}
