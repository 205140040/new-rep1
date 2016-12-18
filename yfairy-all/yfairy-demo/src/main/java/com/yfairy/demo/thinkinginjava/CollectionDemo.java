package com.yfairy.demo.thinkinginjava;

import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.Vector;

public class CollectionDemo {

	/**
	 * 没有泛型前，创建一个指定类型的容器
	 * 
	 * @param args
	 */
	static class Cat {
		private String catName;

		public Cat(String catName) {
			super();
			this.catName = catName;
		}

		public String getCatName() {
			return catName;
		}

		public void setCatName(String catName) {
			this.catName = catName;
		}

		@Override
		public String toString() {
			return "Cat [catName=" + catName + "]";
		}

	}

	/**
	 * 
	 * @author jiangzi 没有泛型前，创建一个指定类型的容器
	 */
	static class CatVector {
		@SuppressWarnings("rawtypes")
		private Vector vector;

		public CatVector() {
			super();
			vector = new Vector<>();
		}

		public void add(Cat cat) {
			vector.add(cat);
		}

		public Cat get(Integer index) {
			return (Cat) vector.get(index);
		}

		public int size() {
			return vector.size();
		}

	}

	public static void main(String[] args) {
		/**
		 * 第八章：容器
		 */
		/**
		 * 
		 * @author jiangzi 没有泛型前，创建一个指定类型的容器
		 */
		CatVector catVectors = new CatVector();
		catVectors.add(new Cat("cat1"));
		catVectors.add(new Cat("cat2"));
		for (int i = 0; i < catVectors.size(); i++) {
			Cat cat = catVectors.get(i);
			System.out.println(cat);
		}
		// 使用vector
		Vector<String> vectors = new Vector<>();
		vectors.add("1");
		vectors.add("2");
		vectors.add("3");
		for (int i = 0; i < vectors.size(); i++) {
			System.out.println(vectors.get(i));
		}
		// Stack
		Stack<String> stacks = new Stack<>();
		stacks.push("1");
		stacks.push("2");
		// 使用Hashtable测试随机数生成是否均匀
		Random random = new Random();
		Hashtable<Integer, Integer> tables = new Hashtable<>();
		for (int i = 0; i < 1000; i++) {
			Integer r = random.nextInt(10);
			if (tables.containsKey(r)) {
				Integer rcount = tables.get(r);
				tables.put(r, ++rcount);
			} else {
				tables.put(r, 1);
			}
		}
		System.out.println(tables);
//		List<E>
	}
}
