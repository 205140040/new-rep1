package com.yfairy.demo.effective_java;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Chapter4ClassAndInterface {

	public static void main(String[] args) {
		/**
		 * 第4章：类和接口71/303<br>
		 * 13使类和成员的可访问性最小化，良好的设计应该是暴露API，<br>
		 * 实现全部隐藏,最小化可以防止别人直接引用，降低耦合度，<br>
		 * 如：封装，降低耦合度，单个模块修改不影响其他模块,<br>
		 * 14在共有类中使用访问方法而非共有字段<br>
		 * 16复合优先于继承<br>
		 * 16:继承时父类某个改动会影响到子类,导致子类比较脆弱<br>
		 * ，可通过复合(组合),即把父类作为变量，然后新写方法，调用父类,这也是装饰模式,warpper<br>
		 * 到17条要么为继承而设计76(89/303)<br>
		 */

	}

	/**
	 * 
	 * @author jiangzi
	 *
	 *         16复合优先于继承<br>
	 */
	static class CountAddSet<E> extends HashSet<E> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private int addcount = 0;

		@Override
		public boolean add(E e) {
			boolean b = super.add(e);
			addcount++;
			return b;
		}

	}

	/**
	 * 
	 * @author jiangzi
	 *
	 *         16复合优先于继承<br>
	 */
	static class CountAddWarpperSet<E> {

		private int addcount = 0;

		private Set<E> set;

		public CountAddWarpperSet(Set<E> set) {
			super();
			this.set = set;
		}

		public boolean add(E e) {
			boolean b = set.add(e);
			addcount++;
			return b;
		}

		public boolean remove(Object o) {
			return set.remove(o);
		}

		public int size() {
			return set.size();
		}

		public Iterator<E> iterator() {
			return set.iterator();
		}

	}

}
