package com.yfairy.demo.effective_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chapter3ObjectDemo {

	public static void main(String[] args) {
		/**
		 * 第3章：对于所有对象都通用的方法41/303<br>
		 * 第8条覆盖equals请遵守约定<br>
		 * 9覆盖equals同时覆盖hashcode方法，以免在map，set中使用出错
		 * 10推荐覆盖toString方法，从而更方便的查看对象信息,方便调试
		 * 12实现Comparable接口，重写compareTo方法，可在Collections.sort(list);中排序
		 */
		OverrideObjectMan man1 = OverrideObjectMan.newInstance(123, "张三");
		OverrideObjectMan man2 = OverrideObjectMan.newInstance(123, "李四");
		System.out.println(man1 + "==" + man2 + "?" + man1.equals(man2));
		Map<OverrideObjectMan, OverrideObjectMan> map = new HashMap<>();
		map.put(man1, man1);
		map.put(man2, man2);
		System.out.println(map.get(man1));
		System.out.println(map.get(man2));

		System.out.println("排序前:");
		List<OverrideObjectMan> list = new ArrayList<>();
		list.add(man1);
		list.add(OverrideObjectMan.newInstance(-123, "李四1"));
		list.add(man2);
		list.add(OverrideObjectMan.newInstance(234, "李四2"));
		list.add(OverrideObjectMan.newInstance(345, "李四3"));
		list.add(OverrideObjectMan.newInstance(1, "李四4"));
		for (OverrideObjectMan item : list) {
			System.out.println(item);
		}

		Collections.sort(list);
		System.out.println("排序后:");

		for (OverrideObjectMan item : list) {
			System.out.println(item);
		}

	}

	static class OverrideObjectMan implements Comparable<OverrideObjectMan> {

		private Integer idCard;

		private String name;

		public static OverrideObjectMan newInstance(Integer idCard, String name) {
			OverrideObjectMan obj = new OverrideObjectMan();
			obj.setIdCard(idCard);
			obj.setName(name);
			return obj;
		}

		/**
		 * 重写了equals,通过身份证识别是否相等
		 */
		@Override
		public boolean equals(Object obj) {
			OverrideObjectMan man = (OverrideObjectMan) obj;
			return this.getIdCard().equals(man.getIdCard());
		}

		/**
		 * 重写hashCode,使用idcard的hashcode
		 */
		@Override
		public int hashCode() {
			return this.getIdCard().hashCode();
		}

		@Override
		public String toString() {
			return "OverrideObjectMan [idCard=" + idCard + ", name=" + name + "]";
		}

		public Integer getIdCard() {
			return idCard;
		}

		public void setIdCard(Integer idCard) {
			this.idCard = idCard;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		/**
		 * 实现Comparable接口，可在Collections.sort(list);中排序
		 */
		@Override
		public int compareTo(OverrideObjectMan o) {
			if (this.getIdCard() < o.getIdCard()) {
				return -1;
			} else if (this.getIdCard() == o.getIdCard()) {
				return 0;
			} else if (this.getIdCard() > o.getIdCard()) {
				return 1;
			}

			return -1;
		}

	}

}
