package com.yfairy.common.zklock;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

/**
 * 
 * @author jiangzi zookeeper分布式排它锁
 */
public class ZkExclusiveLock {

	private static final String SERVER_ADDR = "47.90.44.252:2181";

	private static final int TIME_OUT = 3000;

	private static final String EXCLUSIVE_LOCK_PATH = "/exclusive_lock";
	
	private final CountDownLatch countDownLatch=new CountDownLatch(1);

	private static AtomicInteger count;

	public void tryLock(String path) {
		final ZkClient zkClient = new ZkClient(SERVER_ADDR, TIME_OUT);
		if (!zkClient.exists(EXCLUSIVE_LOCK_PATH)) {
			// 创建排他锁根节点
			zkClient.create(EXCLUSIVE_LOCK_PATH, EXCLUSIVE_LOCK_PATH.getBytes(), CreateMode.PERSISTENT);
		}
		// 注册锁节点下的监听器
		final String lockPath = EXCLUSIVE_LOCK_PATH + path;
		zkClient.subscribeChildChanges(EXCLUSIVE_LOCK_PATH, new IZkChildListener() {

			@Override
			public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
				// 当子节点改变时,即排它锁已经被释放，则获取锁
				lock(lockPath, zkClient);
			}

		});
		// 获取锁
		lock(lockPath, zkClient);
		
		countDownLatch.countDown();
	}

	public void lock(String lockPath, ZkClient zkClient) {
		// 创建临时无序节点
		String createdPath = zkClient.create(lockPath, lockPath.getBytes(), CreateMode.EPHEMERAL);
		if (null != createdPath) {
			System.out.println("业务处理............");
			int temp = count.get();
			count.set(temp + 1);
			System.out.println(count.get());
			// 处理完毕，移除
			releaseLock(createdPath, zkClient);
		}

	}

	public void releaseLock(String createdPath, ZkClient zkClient) {
		// 处理完毕，移除
		zkClient.delete(createdPath);
		zkClient.close();
	}

	public static void exec(String path) {
		ZkExclusiveLock l = new ZkExclusiveLock();
		l.tryLock(path);
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			executorService.execute(new LockRunner());
		}

	}

}
