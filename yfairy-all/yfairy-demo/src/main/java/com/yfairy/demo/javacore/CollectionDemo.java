package com.yfairy.demo.javacore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class CollectionDemo {

	public static void main(String[] args) {
		/**
		 * 第13章：集合576/720<br>
		 * ArrayList和Vector都可以实现动态数组，但是Vector所有方法都是同步的，<br>
		 * 效率不如arraylist，<br>
		 * 不需要同步时使用ArrayList，需要时使用vector<br>
		 * 13.3集合框架611/720<br>
		 */
		// 集合类的基本接口collection
		// boolean add(E e); 添加成功返回true
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");

		// Iterator迭代器接口,Iterator遍历集合
		Iterator<String> its = list.iterator();
		while (its.hasNext()) {
			System.out.println(its.next());
		}
		System.out.println();
		// foreach可与任何实现Iterable接口的对象一起工作
		for (String string : list) {
			System.out.println(string);
		}

		// AbstractCollection该类实现了大多数集合的方法，可通过继承该类实现collection
		// arraylist数组中间删除元素所有的元素都要向前移动，可使用链表list,但是链表不适合随机访问，随机访问访问性能差
		System.out.println("--------------------");
		System.out.println("LinkedList");
		List<String> linkedList = new LinkedList<>();
		linkedList.addAll(list);
		linkedList.remove(1);
		linkedList.add(1, "addtwo"); // 链表指定位置添加元素
		for (String string : linkedList) {
			System.out.println(string);
		}
		System.out.println("--------------------");
		// java中的链表是双向的，链表倒序遍历
		ListIterator<String> listIterator = linkedList.listIterator(3);
		while (listIterator.hasPrevious()) {
			System.out.println(listIterator.previous());
		}

		System.out.println();
		// 散列表Set不会添加重复的元素
		// HashSet，存储数据无序，查找数据很快hascode
		Set<String> set = new HashSet<>();
		for (int i = 0; i < 300; i++) {
			set.add(String.valueOf(i));
		}
		System.out.println(set.contains("158"));

		// 将任意顺序的元素放到treeset中，输出treeset会自动排序，但是性能不如hashset
		// treeset通过对象的compareTo方法进行比较的，所以自定义的类放入treeset中需要实现Comparable接口

		System.out.println();
		Set<String> treeSet = new TreeSet<>();
		treeSet.add("a");
		treeSet.add("e");
		treeSet.add("d");
		treeSet.add("b");
		treeSet.add("c");
		treeSet.add("v");
		treeSet.add("k");
		treeSet.add("f");
		treeSet.add("a");
		for (String string : treeSet) {
			System.out.println(string);
		}

		// 优先级队列一般用在任务调度,默认按照比较器排列队列的顺序
		System.out.println();
		PriorityQueue<String> priorityQueue = new PriorityQueue<>();
		priorityQueue.add("c");
		priorityQueue.add("a");
		priorityQueue.add("d");
		priorityQueue.add("f");
		for (String string : priorityQueue) {
			System.out.println(string);
		}

		// 映射表map,HashMap无序性能高，TreeMap有序性能不如hashmap
		// Map不属于collection
		Map<Integer, String> hashMap = new HashMap<>();
		hashMap.put(1, "one");
		hashMap.put(1, "one1");
		hashMap.put(2, "two");
		hashMap.put(3, "three");
		// 获取所有的键
		System.out.println("获取所有的键");
		Set<Integer> sets = hashMap.keySet();
		for (Integer integer : sets) {
			System.out.println(integer);
		}
		// 获取所有的值
		System.out.println("获取所有的值");
		Collection<String> values = hashMap.values();
		for (String v : values) {
			System.out.println(v);
		}

		// 同时遍历键值对
		System.out.println("同时遍历键值对");
		Set<Entry<Integer, String>> entries = hashMap.entrySet();
		for (Entry<Integer, String> entry : entries) {
			System.out.println("key:" + entry.getKey() + "\tvalue:" + entry.getValue());
			entry.setValue("哈哈哈"); // Entry设置值
		}
		System.out.println("---------");
		for (Entry<Integer, String> entry : entries) {
			System.out.println("key:" + entry.getKey() + "\tvalue:" + entry.getValue());
		}

		// TreeMap<K, V>

		// WeakHashMap<K, V> 弱map，当存放其中的对象不使用时，垃圾收集器将回收该对象

		// RandomAccess 该接口下的子类代表可以高速随机访问

		/**
		 * 如果自己实现collection可以扩展这些类AbstractCollection,<br>
		 * AbstractList,AbstractSet,AbstractMap,AbstractQueue
		 */

		// 找出两个数组中的交集retainAll
		List<String> l1 = new ArrayList<>();
		List<String> l2 = new ArrayList<>();
		l1.add("one");
		l1.add("two");
		l1.add("three");
		l1.add("four");
		l1.add("five");
		l1.add("six");
		l2.add("three");
		l2.add("one");
		l2.add("six");

		// 13.3集合与数组中的转换621/720<br>
		// 数组转集合Arrays.asList
		String[] ss = new String[10];
		ss[0] = "s0";
		List<String> arrToList = Arrays.asList(ss);
		System.out.println("arrToList:" + arrToList);

		// 集合转数组 l1.toArray(new String[l1.size()]);
		String[] listToArr = l1.toArray(new String[l1.size()]);
		for (String a : listToArr) {
			System.out.print(a + ",");
		}
		System.out.println("listToArr:" + listToArr);

		System.out.println("before");
		System.out.println(l1);
		l1.retainAll(l2);
		System.out.println("after");
		System.out.println("l1" + l1);
		System.out.println();
		System.out.println("l2" + l2);

		// 13.4算法,排序与混排，二叉树622/720<br>
		// 通用的计算collection最大值的方法
		List<Integer> maxList = Arrays.asList(99, 2, 1, 3, 66, 99, 68, 77, 888, 93, 89);
		System.out.println(max(maxList));
		// 或Collections.max
		System.out.println(Collections.max(maxList));

		System.out.println("Collections.min:" + Collections.min(maxList));
		// 使用collections.sort排序
		Collections.sort(maxList);
		System.out.println("排序:" + maxList);
		// 反序
		Collections.reverse(maxList);
		System.out.println("Collections.reverse反序：" + maxList);
		// 随机排序
		Collections.shuffle(maxList);
		System.out.println("随机打乱列表中的元素：" + maxList);

		// 二分查找,一个拍好序的数组，查找某个元素可以通过把其拆分成一半不停地查找,比一个一个查找性能高
		Collections.sort(maxList);
		System.out.println("binarySearch:" + Collections.binarySearch(maxList, 77));

		// 13.5遗留的集合
		// Hashtable<K, V>,Hashtable<K,V>
		// extends Dictionary<K,V>
		// implements Map<K,V>, Cloneable, java.io.Serializable
		// Hashtable也实现了map接口, public synchronized V put(K key, V value)
		// 其中大多数方法是同步的，属于线程安全的，性能不如hashmap

	}

	@SuppressWarnings("unchecked")
	public static <T extends Comparable> T max(Collection<T> c) {
		if (null == c) {
			throw new NullPointerException();
		}
		if (c.isEmpty()) {
			throw new NoSuchElementException();
		}
		Iterator<T> iterator = c.iterator();
		T max = iterator.next();
		while (iterator.hasNext()) {
			T next = iterator.next();
			if (max.compareTo(next) < 0) {
				max = next;
			}
		}
		return max;
	}

}
