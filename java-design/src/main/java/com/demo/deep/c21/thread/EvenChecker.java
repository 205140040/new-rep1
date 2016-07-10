package com.demo.deep.c21.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable{
	
	private IntGenerator intGenerator;
	private final int id;
	

	public EvenChecker(IntGenerator intGenerator, int id) {
		super();
		this.intGenerator = intGenerator;
		this.id = id;
	}


	public void run() {
		System.out.println("currentThread"+Thread.currentThread().getName());
		while(!intGenerator.isCanceled()){
			int val=intGenerator.next();
			System.out.println("val:"+val);
			if(val%2!=0){
				System.out.println(val+"not even!");
				intGenerator.cancel();
			}
		}
	}

	
	public static void test(IntGenerator intGenerator,int count){
		ExecutorService executorService=Executors.newCachedThreadPool();
		for (int i = 0; i < count; i++) {
			executorService.execute(new EvenChecker(intGenerator, i));
		}
		executorService.shutdown();
	}
	
	public static void main(String[] args) {
		IntGenerator intGenerator=new EvenGenerator();
		test(intGenerator, 10);
		intGenerator.cancel(); //手动设置取消
		/**
		 * 加锁解决资源共享问题:
		 * 每个对象自动含有单一的锁（监视器），调用任意synchronized方法，此对象会被加锁，
		 * 其他同步方法必须在该方法完成后才能运行
		 */
	}
}
