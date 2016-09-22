package com.timobb.demo;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

public class CuratorDemo {

	public static void main(String[] args) {
		try {
			// 5.4.2 Curator dao 141
			// 建立zookeeper连接
			//初始休眠时间，最大尝试次数
			RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
			CuratorFramework client = CuratorFrameworkFactory.newClient("47.90.9.239:2181", 5000, 3000, retryPolicy);
			client.start();
			//创建持久节点:
			String path="/curator1";
//			client.create().forPath(path,path.getBytes());
			//创建临时节点:
			String path2="/curator1=2";

//			client.create().withMode(CreateMode.EPHEMERAL).forPath(path2,path2.getBytes());
			//递归创建节点
			String path3="/curator3/1";
//			client.create().creatingParentContainersIfNeeded().forPath(path3,path3.getBytes());
			//递归删除节点
//			client.delete().deletingChildrenIfNeeded().forPath("/curator3");
			//强制保证删除节点:
//			client.delete().guaranteed().deletingChildrenIfNeeded().forPath("/curator3");
			//读取数据
			//设置数据
			client.setData().forPath(path3,"setdata".getBytes());
			Stat stat=new Stat();
			byte[] datas=client.getData().storingStatIn(stat).forPath(path3);
			System.out.println("获取的data:"+new String(datas));
			System.out.println(stat);
			//异步接口 dao 152
			Thread.sleep(Integer.MAX_VALUE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
