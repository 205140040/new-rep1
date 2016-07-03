package com.demo.deep.c17;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
		//未重写set中equals方法，看是否能重复添加
		Set<NormalSetType> normalSet=new HashSet<NormalSetType>();
		//重写了equals方法，和hashcode方法的set元素
		Set<HashType> hashSet=new HashSet<HashType>();
		//treeset,实现了comparable接口，可以定义set中元素的排序
		Set<TreeType> treeSet=new TreeSet<TreeType>();
		for (int i = 0; i < 10; i++) {
			normalSet.add(new NormalSetType(i));//重复添加
			normalSet.add(new NormalSetType(i));
			hashSet.add(new HashType(i));
			hashSet.add(new HashType(i));
			treeSet.add(new TreeType(i));
			treeSet.add(new TreeType(i));
		}
		System.out.println("normalSet："+normalSet);
		System.out.println("hashSet："+hashSet);
		System.out.println("treeSet:"+treeSet);
		/**
		 * normalSet：[8, 9, 7, 0, 2, 6, 7, 9, 5, 0, 1, 3, 1, 3, 4, 8, 6, 5, 4, 2]
			hashSet：[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
			未重写set中的equals方法，则可以重复添加
		 */
		//sortedset中的元素可以保证其是有序的，且提供了额外的方法
		SortedSet<String> sortedSet=new TreeSet<String>();
		sortedSet.addAll(Arrays.asList("one","two","three","four","five"));
		System.out.println(sortedSet);
		String first=sortedSet.first();//返回第一个
		System.out.println("first:"+first);
		String last=sortedSet.last();
		System.out.println("last:"+last);
		/**
		 * map
		 * 如果使用自己的类作为map的键，必须重写equals方法，和hashcode方法，
		 * hasMap中的元素是无需的，linkedHashMap中的元素按添加的顺序排列
		 */
		
	}

}
