package com.timobb.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

public class CuratorDemo {

	public static void main(String[] args) {
		try {
			// 5.4.2 Curator dao 141
			// 建立zookeeper连接
			// 初始休眠时间，最大尝试次数
			RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
			CuratorFramework client = CuratorFrameworkFactory.newClient("47.90.9.239:2181", 5000, 3000, retryPolicy);
			String cachePath = "/cachePath";
			final NodeCache nodeCache = new NodeCache(client, cachePath, false);
			client.start();
			nodeCache.getListenable().addListener(new NodeCacheListener() {
				@Override
				public void nodeChanged() throws Exception {
					System.out.println("nodeChanged:" + new String(nodeCache.getCurrentData().getData()));
				}
			});
			// client.create().forPath(cachePath,cachePath.getBytes());
			client.setData().forPath(cachePath, cachePath.getBytes());
			Thread.sleep(1000);
			// 创建持久节点:
			String path = "/curator1";
			// client.create().forPath(path,path.getBytes());
			// 创建临时节点:
			String path2 = "/curator1=2";
			// 使用异步接口
			client.create().withMode(CreateMode.EPHEMERAL).inBackground(new BackgroundCallback() {

				@Override
				public void processResult(CuratorFramework framework, CuratorEvent event) throws Exception {
					System.out.println("eventType:" + event.getType());
				}
			}).forPath("/curator-cb", "/curator-cb".getBytes());
			// 递归创建节点
			String path3 = "/curator3/1";
			// client.create().creatingParentContainersIfNeeded().forPath(path3,path3.getBytes());
			// 递归删除节点
			// client.delete().deletingChildrenIfNeeded().forPath("/curator3");
			// 强制保证删除节点:
			// client.delete().guaranteed().deletingChildrenIfNeeded().forPath("/curator3");
			// 读取数据
			// 设置数据
			client.setData().forPath(path3, "setdata".getBytes());
			Stat stat = new Stat();
			byte[] datas = client.getData().storingStatIn(stat).forPath(path3);
			System.out.println("获取的data:" + new String(datas));
			System.out.println(stat);
			// 异步接口 dao 152
			// client.create().withMode(CreateMode.EPHEMERAL).inBackground(new
			// BackgroundCallback() {
			//
			// @Override
			// public void processResult(CuratorFramework framework,
			// CuratorEvent event) throws Exception {
			// System.out.println("eventType:" + event.getType());
			// }
			// }).forPath("/curator-cb", "/curator-cb".getBytes());
			// 典型使用场景:dao 155
			// 设置监听器:1.NodeCache,2.PathChildrenCache用于监听数据节点的子节点的变化情况

			// Master选举:160页:(解释：对于一个复杂的任务，需要从集群中选出一台进行处理，称为master选举)
			String leaderPath = "/leaderPath";
			// LeaderSelector leaderSelector = new LeaderSelector(client,
			// leaderPath, new LeaderSelectorListenerAdapter() {
			//
			// @Override
			// public void takeLeadership(CuratorFramework client) throws
			// Exception {
			// System.out.println("成为master角色:");
			// System.out.println("处理XX业务............");
			// Thread.sleep(3000);
			// System.out.println("完成master操作，释放master权利");
			// }
			// });
			// leaderSelector.autoRequeue();
			// leaderSelector.start();
			// 分布式锁:162页
			/**
			 * CountDownLatch 多线程：
			 * CountDownLatch，一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
			 * http://www.iteye.com/topic/1002652
			 */
			String lockPath = "/lock1";
			final InterProcessMutex lock = new InterProcessMutex(client, lockPath);
			final CountDownLatch countDownLatch = new CountDownLatch(1);
			for (int i = 0; i < 30; i++) {
				if (i + 1 == 30) {
					countDownLatch.countDown();
					System.out.println("countDownLatch.countDown()");
				}
				new Thread(new Runnable() {

					@Override
					public void run() {
						try {
							// 等待完成工作
							countDownLatch.await();
							// 获取分布式锁
							lock.acquire();
						} catch (Exception e) {
							e.printStackTrace();
						}
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss | SSS");
						String orderNo = sdf.format(new Date());
						System.out.println("生成的订单号是:" + orderNo);
						try {
							// 释放锁
							lock.release();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}).start();
			}
			System.out.println("循环完成........");
			// 工具:169页
			// ZKPaths,EnsurePath:创建节点，如果不存在，则创建，否则不做任何操作
			// 第6章：zookeeper的典型应用场景：dao 173
			// 6.1.7分布式锁dao 199
			// 6.2zookeeper在大型分布式系统中的应用dao 208
			// 6.3.6实时计算引擎jstorm 249
			// 第7章：zookeeper技术内幕 254
			// 7.1.3版本 257页，讲到版本对并发的控制
			// 7.2 序列化与协议 dao 283,zookeeper 在连接时127.0.0.1:2181/namespace1 设置命名空间
			// 7.9.2事务日志:zookeeper实现一致性的重要部分 369 

			Thread.sleep(Integer.MAX_VALUE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
