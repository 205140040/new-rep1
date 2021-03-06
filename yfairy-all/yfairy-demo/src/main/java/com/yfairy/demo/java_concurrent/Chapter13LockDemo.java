package com.yfairy.demo.java_concurrent;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Chapter13LockDemo {

	public static void main(String[] args) {
		/**
		 * 第13章：显式锁241/308<br>
		 * ReentrantLock 重入锁; 可重入锁;<br>
		 * java lock
		 * doc:http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/locks/Lock.html推荐使用谷歌翻译此页面<br>
		 * Lock接口:<br>
		 * void lock（） 获取锁。 如果锁不可用，<br>
		 * 则当前线程变为禁用以用于线程调度目的，并且处于休眠状态，直到获取锁为止。<br>
		 * boolean tryLock（） 尝试获取锁，
		 * 如果它是可用的和值立即返回true。如果锁不可用，则此方法将值立即返回false。<br>
		 * boolean tryLock(long time, TimeUnit unit) throws
		 * InterruptedException; <br>
		 * 尝试获取锁，如果没获取到，那么将再次获取，直到超时，将释放锁<br>
		 * void unlock（）释放锁。<br>
		 * <br>
		 * (重要:显示锁对象是针对对象的，所以lock变量的声明要放在对象里,如果在方法体中声明lock,<br>
		 * 那么每个方法使用的锁对象都是不同的锁，无法达到同步)<br>
		 * <br>
		 * 可通过Lock lock=new ReentrantLock(boolean fair);
		 * true设置公平锁，从而实现先等待的线程先获得锁(不推荐使用公平锁)<br>
		 */

		// java.util.concurrent.locks
		// 接口锁定
		//
		// 所有已知实现类：
		// ReentrantLock的，ReentrantReadWriteLock.ReadLock，ReentrantReadWriteLock.WriteLock
		//
		// 公共接口锁
		// Lock实现提供了比使用得到更广泛的锁定操作synchronized方法和语句。它们允许更灵活的结构，可具有完全不同的特性，并可能支持多个相关联的
		// Condition对象。
		// 锁是用于控制多个线程对共享资源的访问的工具。通常，锁提供对共享资源的独占访问：一次只有一个线程可以获取锁，并且对共享资源的所有访问都需要首先获取锁。然而，一些锁可以允许对共享资源的并发访问，如一个读锁定ReadWriteLock。
		//
		// 使用synchronized方法或报表提供了访问与每个对象相关的隐式监视器锁定，但强制所有锁定获取和释放一个块结构发生：当多个锁被收购，他们必须以相反的顺序被释放，并且所有锁必须在获取它们的相同词汇作用域中释放。
		//
		// 而对于作用域机制synchronized方法和语句使得它更容易与显示器锁编程，并有助于避免涉及许多锁常见的编程错误，在有些情况下，你需要以更为灵活的方式与锁的工作场合。例如，用于遍历并发访问的数据结构的一些算法需要使用“切换”或“链锁定”：获取节点A的锁，然后获取节点B，然后释放A并获取C，然后释放B并获取D等。的的实现
		// Lock接口，允许被收购，并在不同范围内发布了锁，并允许被收购，并以任意顺序释放多个锁，从而支持使用这种技术。
		//
		// 随着这种增加的灵活性，额外的责任 不使用块结构锁定移除锁的自动释放与发生synchronized
		// 方法和语句。在大多数情况下，应使用以下成语：
		//
		// Lock l = ...;
		// l.lock（）;
		// 尝试{
		// //访问受此锁保护的资源
		// } finally {
		// l.unlock（）;
		// }}
		//
		// 当在不同范围内发生锁定和解锁时，必须注意确保在锁定被保持时执行的所有代码由try-finally或try-catch保护，以确保在必要时释放锁定。
		// Lock实施方式提供了对使用附加的功能，synchronized通过提供一种无阻塞试图获取锁（方法和语句tryLock()），在试图获得可中断（锁lockInterruptibly()，并获取超时锁（尝试tryLock(long,
		// TimeUnit)）。
		//
		// 一Lock类还可以提供行为和语义在与隐式监视器锁，如保证排序，非重入用法或死锁检测有很大的不同。如果实现提供了这样的专门语义，那么实现必须记录那些语义。
		//
		// 注意，Lock实例仅仅是普通的对象，本身可以用作一个目标synchronized的语句。获取的监视器锁定Lock实例与调用任何的没有特定的关系lock()的实例的方法。建议为了避免混淆，永远不要使用Lock
		// 实例以这种方式，除了其自身的实现中。
		//
		// 除非另有说明，传递null价值的任何参数将导致NullPointerException被抛出。
		//
		// 内存同步
		//
		// 所有的Lock实现必须执行由内置监视器锁定提供的，如第17.4描述的相同内存同步语义 Java™语言规范：
		//
		// 一个成功的lock操作具有同样的内存同步效应作为一个成功的锁定动作。
		// 一个成功的unlock操作具有同样的内存同步效应作为一个成功的解锁动作。
		// 不成功的锁定和解锁操作以及可重入的锁定/解锁操作不需要任何内存同步效应。
		// 实施注意事项
		//
		// 锁获取的三种形式（可中断，不可中断和定时）可以在它们的性能特性，顺序保证或其它实现特性方面不同。此外，中断的能力不断
		// 收购锁定可能无法在一个给定的可用Lock
		// 类。因此，实现不需要为所有三种形式的锁获取精确地定义相同的保证或语义，也不需要支持正在进行的锁获取的中断。需要实现来清楚地记录每个锁定方法提供的语义和保证。它还必须遵守在该接口中定义的中断语义，在支持锁获取的中断的程度上：这是完全或仅在方法入口。
		//
		// 由于中断通常意味着取消，并且用于中断的检查通常很少，实现可以有利于响应于正常方法返回的中断。这是真的，即使可以显示中断发生在另一个动作可能已解除线程之后。实现应该记录这种行为。
		//
		// 以来：
		// 1.5
		// 也可以看看：
		// ReentrantLock， Condition， ReadWriteLock
		// 方法摘要
		//
		// 方法
		// 修饰符和类型 方法和说明
		// void lock()
		// 获取锁。
		// void lockInterruptibly()
		// 除非当前线程获取锁 中断。
		// Condition newCondition()
		// 返回一个新的Condition绑定到该实例 Lock的实例。
		// boolean tryLock()
		// 只有在调用时它是自由的，才获取锁。
		// boolean tryLock(long time, TimeUnit unit)
		// 获取锁，如果它是在给定的等待时间内免费，并且当前线程未被中断。
		// void unlock()
		// 释放锁。
		// 方法详细信息
		//
		// 锁
		// void lock（）
		// 获取锁。
		// 如果锁不可用，则当前线程变为禁用以用于线程调度目的，并且处于休眠状态，直到获取锁为止。
		//
		// 实施注意事项
		//
		// 一个Lock实现可能能够检测到错误使用锁，如这将导致死锁，在这种情况下可能会抛出（未经检查的）异常的调用。情况和异常类型必须由记录在案
		// Lock的实现。
		//
		// lockInterruptably
		// void lockInterruptibly（）
		// 抛出InterruptedException的
		// 除非当前线程获取锁 中断。
		// 获取锁如果可用并立即返回。
		//
		// 如果锁不可用，则当前线程变为禁用以用于线程调度目的，并且处于休眠状态直到发生以下两种情况之一：
		//
		// 锁由当前线程获取; 要么
		// 其他某些线程中断当前线程，并且支持对锁获取的中断。
		// 如果当前线程：
		//
		// 在进入该方法时设置其中断状态; 要么
		// 被打断而获取锁，并且被支撑锁定获取的中断，
		// 然后InterruptedException被抛出，并且当前线程的中断状态被清除。
		// 实施注意事项
		//
		// 在一些实现中中断锁获取的能力可能是不可能的，并且如果可能的话可能是昂贵的操作。程序员应该知道可能是这种情况。实现应该记录这种情况。
		//
		// 实现可以有利于响应于正常方法返回的中断。
		//
		// 一个Lock实现可能能够检测到错误使用锁，如这将导致死锁，在这种情况下可能会抛出（未经检查的）异常的调用。情况和异常类型必须由记录在案Lock的实现。
		//
		// 投掷：
		// InterruptedException - 如果在获取锁定时中断当前线程（并且支持中断锁定获取）。
		// tryLock
		// boolean tryLock（）
		// 只有在调用时它是自由的，才获取锁。
		// 获取锁，如果它是可用的和值立即返回true。如果锁不可用，则此方法将值立即返回false。
		//
		// 这种方法的典型使用习惯是：
		//
		// 锁定锁= ...;
		// if（lock.tryLock（））{
		// 尝试{
		// //操纵受保护状态
		// } finally {
		// lock.unlock（）;
		// }}
		// } else {
		// //执行替代操作
		// }}
		//
		// 此使用确保锁被解锁，如果它被获取，并且不尝试解锁，如果没有获取锁。
		// 返回：
		// true如果锁被收购和 false其他方式
		// tryLock
		// 布尔的tryLock（很长一段时间，
		// 的TimeUnit 单位）
		// 抛出InterruptedException的
		// 获取锁，如果它是在给定的等待时间内免费，并且当前线程未被中断。
		// 如果锁可用此方法的价值立即返回true。如果锁不可用，则当前线程变为禁用以用于线程调度目的，并且处于休眠状态直到发生以下三种情况之一：
		//
		// 锁由当前线程获取; 要么
		// 其他某些线程中断当前线程，并且支持对锁获取的中断; 要么
		// 指定的等待时间已过
		// 如果获得了锁，则该值true被返回。
		//
		// 如果当前线程：
		//
		// 在进入该方法时设置其中断状态; 要么
		// 被打断而获取锁，并且被支撑锁定获取的中断，
		// 然后InterruptedException被抛出，并且当前线程的中断状态被清除。
		// 如果指定的等待时间，则该值false 被返回。如果时间小于或等于零，该方法将不会等待。
		//
		// 实施注意事项
		//
		// 在一些实现中中断锁获取的能力可能是不可能的，并且如果可能的话可能是昂贵的操作。程序员应该知道可能是这种情况。实现应该记录这种情况。
		//
		// 实现可以有利于响应于正常方法返回的中断，或者报告超时。
		//
		// 一个Lock实现可能能够检测到错误使用锁，如这将导致死锁，在这种情况下可能会抛出（未经检查的）异常的调用。情况和异常类型必须由记录在案
		// Lock的实现。
		//
		// 参数：
		// time - 等待锁的最长时间
		// unit-所述的时间单位time的参数
		// 返回：
		// true如果锁被收购而false 如果等待时间经过的获取锁定之前，
		// 投掷：
		// InterruptedException - 如果在获取锁定时当前线程中断（并且支持中断锁定获取）
		// 开锁
		// void unlock（）
		// 释放锁。
		// 实施注意事项
		//
		// 一个Lock实现通常会强加给哪个线程可以释放锁（通常只有锁的持有人可以释放它），如果限制违反可能会抛出（未经检查的）异常的限制。任何限制和异常类型必须由记录在案Lock的实现。
		//
		// newCondition
		// 条件 newCondition（）
		// 返回一个新的Condition绑定到该实例 Lock的实例。
		// 在等待条件之前，锁必须由当前线程保持。呼叫到Condition.await()等待前将原子释放锁和重新获取等待返回之前锁。
		//
		// 实施注意事项
		//
		// 在确切的操作Condition实例依赖于Lock实施，必须由执行记录在案。
		//
		// 返回：
		// 一个新的Condition此实例Lock的实例
		// 投掷：
		// UnsupportedOperationException-如果此Lock 实现不支持条件

		System.out.println(Chapter13LockDemo.class);
		System.out.println(new Chapter13LockDemo().getClass());

		ExecutorService exec = Executors.newFixedThreadPool(100);
		SellTicket ticket = new SellTicket();
		for (int i = 0; i < 200; i++) {
			exec.execute(new SellTicketThread(ticket, "lala" + i));
		}
		exec.shutdown();

		// 可重入读写锁,读写锁允许多个读线程并发的访问被保护的对象,当访问读操作为主的数据结构时，能提供较好的性能
		// private final ReadWriteLock readWriteLock = new
		// ReentrantReadWriteLock();
		//
		// private final Lock readLock = readWriteLock.readLock(); //读锁
		//
		// private final Lock writeLock = readWriteLock.writeLock(); //写锁

	}

	static class ReadWriteMap<K, V> {

		private final Map<K, V> map;

		public ReadWriteMap(Map<K, V> map) {
			this.map = map;
		}

		// 可重入读写锁
		private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

		private final Lock readLock = readWriteLock.readLock(); // 读锁

		private final Lock writeLock = readWriteLock.writeLock(); // 写锁

		public V put(K key, V value) {
			writeLock.lock();
			try {
				return map.put(key, value);
			} finally {
				writeLock.unlock();
			}
		}

		public V get(K key) {
			readLock.lock();
			try {
				return map.get(key);
			} finally {
				readLock.unlock();
			}
		}

	}

	static class SellTicketThread extends Thread {

		private SellTicket ticket;

		private String name;

		public SellTicketThread(SellTicket ticket, String name) {
			super();
			this.ticket = ticket;
			this.name = name;
		}

		@Override
		public void run() {
			ticket.sellTicket(name);
			// ticket.sellTicket_trylock(name);
			// try {
			// ticket.sellTicket_trylock_timeout(name);
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// }
		}
	}

	static class SellTicket {

		private Lock lock = new ReentrantLock(); // 显示锁对象(重要:显示锁对象是针对对象的，所以lock变量的声明要放在对象里)

		// private Lock lock = new ReentrantLock(true); //公平锁

		private Lock try_lock = new ReentrantLock();

		private Lock try_lock_timeout = new ReentrantLock();

		private int no = 0;

		public void sellTicket(String name) {
			lock.lock(); // 获得锁，没获得会一直轮训，直到获得锁
			try {
				no++;
				System.out.println(name + "买到了第" + no + "张票");
			} finally {
				System.out.println(name + "\tunlock");
				lock.unlock(); // 释放锁
			}
		}

		public void sellTicket_trylock(String name) {
			if (try_lock.tryLock()) {
				try {
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					no++;
					System.out.println(name + "买到了第" + no + "张票");
				} finally {
					System.out.println("unlock");
					try_lock.unlock(); // 释放锁
				}
			} else {
				System.err.println("获取锁失败...");
			}

		}

		public void sellTicket_trylock_timeout(String name) throws InterruptedException {
			if (try_lock_timeout.tryLock(3000, TimeUnit.MILLISECONDS)) { // 在指定时间内尝试获取锁，超时失败
				try {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					no++;
					System.out.println(name + "买到了第" + no + "张票");
				} finally {
					System.out.println("unlock");
					try_lock_timeout.unlock(); // 释放锁
				}
			} else {
				System.err.println("获取锁超时...");
			}

		}
	}

}
