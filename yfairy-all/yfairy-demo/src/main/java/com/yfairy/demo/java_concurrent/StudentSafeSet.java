package com.yfairy.demo.java_concurrent;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class StudentSafeSet {
	/**
	 * 使用final确保初始化studentSet线程安全
	 */
	private final Set<Student> studentSet = new HashSet<>();

	public synchronized Set<Student> getStudentSet() {
		return studentSet;
	}

	public synchronized void addStudent(Student student) {
		getStudentSet().add(student);
	}

	static class BetterVector<E> extends Vector<E> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public synchronized void addIfNotExist(E e) {
			if (!contains(e)) {
				add(e);
			}
		}

	}

	static class VectorHelper<E> {
		private final Vector<E> vector;

		public VectorHelper(Vector<E> v) {
			this.vector = v;
		}

		/**
		 * 线程不安全，应为使用的不是同一个Vector的锁
		 * 
		 * @param e
		 */
		public synchronized void addIfNotExist(E e) {
			if (!vector.contains(e)) {
				vector.add(e);
			}
		}
	}

	static class VectorHelper2<E> {
		private final Vector<E> vector;

		public VectorHelper2(Vector<E> v) {
			this.vector = v;
		}

		/**
		 * 使用同步代码块，指定使用同一个vector锁
		 * 
		 * @param e
		 */
		public void addIfNotExist(E e) {
			synchronized (vector) {
				if (!vector.contains(e)) {
					vector.add(e);
				}
			}
		}

	}

}
