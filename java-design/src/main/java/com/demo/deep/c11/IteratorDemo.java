package com.demo.deep.c11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;

public class IteratorDemo implements Iterable<Integer>{

	public static void main(String[] args) {
		/**
		 * 实现了Iterable接口的类都能使用foreach
		 * 如：collection
		 */
		/**
		 * listIterator
		 */
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

		ListIterator<Integer> listIterator = list.listIterator();
		System.out.println("正序:");
		while (listIterator.hasNext()) {
			System.out.print(listIterator.next() + "\t");
		}
		System.out.println();
		System.out.println("倒序:");
		while (listIterator.hasPrevious()) {
			System.out.print(listIterator.previous() + "\t");
		}
		/**
		 * stack
		 * 先进后出，类似瓶子
		 */
		System.out.println("\nstack");
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(1);
		stack.push(3);
		stack.push(5);
		stack.push(7);
		for (int i = 0; i < 4; i++) {
			System.out.println(stack.pop());
		}
		System.out.println("出站结束");
		/**
		 * queue先进先出
		 * LinkedList实现了list，stack，queue
		 */
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		for (int i = 0; i < 3; i++) {
			System.out.println(queue.poll());
		}
		IteratorDemo iteratorDemo=new IteratorDemo();
		for (Integer integer : iteratorDemo) {
			
		}
	}

	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
