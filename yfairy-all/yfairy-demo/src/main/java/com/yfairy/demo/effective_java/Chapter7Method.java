package com.yfairy.demo.effective_java;

import java.util.Collections;
import java.util.List;

public class Chapter7Method {

	public static void main(String[] args) {
		/**
		 * 第7章:方法156(169/303)<br>
		 * 38条检查参数的有效性<br>
		 * 40条谨慎的设计方法名称<br>
		 * 避免方法中的参数过多，尽量用接口当做参数，而不是具体的类当做参数<br>
		 * 42慎用可变参数<br>
		 * 43条返回零长度的数组或集合而不是null<br>
		 * 返回零长度的数组或集合可以避免每次其他人调用都进行null判断，或者遗忘null判断,<br>
		 * //可调用这些方法，一直返回同一个空collection，<br>
		 * 可以减少对象创建，回收 Collections.emptyList();<br>
		 * Collections.emptySet(); Collections.emptyMap();<br>
		 */

		// 可调用这些方法，一直返回同一个空collection，可以减少对象创建，回收
		Collections.emptyList();
		Collections.emptySet();
		Collections.emptyMap();
		List<String> list=EmptyCollectionUtil.getList();
		for (String string : list) {
			System.out.println(string);
		}
		List<String> a=EmptyCollectionUtil.getCanNullList(null);
		for (String s : a) {
			System.out.println(s);
		}

	}
	
	static class EmptyCollectionUtil{
		public static <E> List<E> getList(){
			return Collections.emptyList();
		}
		
		public static <E> List<E> getCanNullList(String p){
			if(null==p){
				return null;
			}
			return Collections.emptyList();
		}
	}

}
