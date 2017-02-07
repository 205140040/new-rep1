package com.yfairy.demo.java_concurrent;

import java.net.InetAddress;
import java.util.logging.Logger;

public class ConcurrentDemo {

	public static void main(String[] args) throws Exception {
		/**
		 * 第一章:简介15/308<br>
		 * 第二章：线程安全性25/308<br>
		 * 线程安全类定义:当一个类在多线程中使用，这个类的行为都是正确的，可称为线程安全类<br>
		 * 使用线程安全类:原子类atomic,实现变量安全<br>
		 * 第三章:对象的共享41/308(volatile实现可见性，atomic类实现原子性，同步，线程封闭，threadloacl)<br>
		 * 变量声明为static可以确保对象在并发情况下正确的创建，其次使用AtomicReference<V>实现并发安全的new
		 * 对象引用<br>
		 * AtomicReference原子操作引用类型 或者使用并发集合 <br>
		 * 第四章:对象的组合60/308<br>
		 * * Map of bean definition objects, keyed by bean name *<br>
		 * private final Map<String, BeanDefinition> beanDefinitionMap = new
		 * ConcurrentHashMap<String,
		 * BeanDefinition>(256);使用final修饰变量，从而确保并发时对象正确发布<br>
		 * 第五章：基础构建模块80/308<br>
		 * 5.1同步容器类vector和hashtable<br>
		 * 5.2并发容器ConcurrentHashMap,比同步容器快很多，并发迭代时也不会抛出并发修改异常，推荐使用并发容器<br>
		 * CopyOnWriteArrayList<E>并发写入时复制list用于替代同步list，每当容器修改时都会复制底层数组，建议迭代较多的并发情况下使用<br>
		 * CopyOnWriteArraySet<E><br>
		 * BlockQueue阻塞队列，当添加时如果当队列满了将阻塞，移除时当队列为空将阻塞 该队列为并发队列<br>
		 * 5.3.2串行线程封闭90/308<br>
		 * 第6章：任务执行107/308<br>
		 * java 创建线程的三种方法Callable,Runnable,Thread比较及用法<br>
		 * :http://wenku.baidu.com/link?url=hzLqUAs8vWdkoOURyiFEJplGxQ_QlOulkVM67lWW-gFZDOmmhYJw8i-vg072KCrE1WzYw34ZFuWDYd0mRsAVKEZ5PBb-y1kfFR9vFzvxkh7
		 * 第7章：任务取消与关闭125/308<br>
		 * 第8章：线程池的使用152/308<br>
		 * 第9章:图形用户界面应用程序170/308<br>
		 * 第10章:避免活跃性危险183/308<br>
		 * 第11章：性能与可伸缩性197/308<br>
		 * 使用分解锁(不同数据使用不同的锁，如LeftRightDeadLock)，分段锁（对一个数据使用多段锁）,减少锁持有的时间,可提高性能<br>
		 * 第12章：并发程序的测试218/308<br>
		 * 第13章：显式锁241/308<br>
		 * \TODO 继续显式锁
		 * 第14章：构建自定义的同步工具252/308<br>
		 */

		System.out.println("hello");
		InetAddress[] is = InetAddress.getAllByName("localhost");
		for (InetAddress inetAddress : is) {
			System.out.println(inetAddress);
		}
		// ServerSocket serverSocket=new ServerSocket(8081);
		// Socket socket=serverSocket.accept();
		// InputStream in=socket.getInputStream();
		// OutputStream out=socket.getOutputStream();
		// byte[] inb=new byte[in.available()];
		// in.read(inb);
		// System.out.println(new String(inb));
		// out.write("hello".getBytes());
		// socket.close();
		// serverSocket.close();
		Logger.getGlobal().info("success...");
	}

}
