package com.timobb.zookeeper.demo;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class JavaZkApiDemo implements Watcher {

	private static CountDownLatch countDownLatch = new CountDownLatch(1);

	private static ZooKeeper zooKeeper;

	public static void main(String[] args) {
		try {
			// 创建一个普通的连接
			zooKeeper = new ZooKeeper("47.90.9.239:2181", 5000, new JavaZkApiDemo());
			// 创建一个复用的sessionId和sessionPasswd，从而复用会话维持之前会话的有效性
			// 错误的sessionid
			// zooKeeper=new ZooKeeper("47.90.9.239:2181", 5000, new
			// JavaZkApiDemo(),1l,"test".getBytes());
			// 正确的sessionid
			long sessionId = zooKeeper.getSessionId();
			byte[] pwd = zooKeeper.getSessionPasswd();
			// zooKeeper=new ZooKeeper("47.90.9.239:2181", 5000, new
			// JavaZkApiDemo(),sessionId,pwd);
			System.out.println(zooKeeper.getState());
			countDownLatch.await();
			// 5.3.2创建节点:dao 106
			// 无序号持久节点
			// String path1 = zooKeeper.create("/node1/node11",
			// "node1".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			// System.out.println("创建节点成功:" + path1);
			// 有序号持久节点
			// String path2 = zooKeeper.create("/node2", "node2".getBytes(),
			// Ids.OPEN_ACL_UNSAFE,
			// CreateMode.PERSISTENT_SEQUENTIAL);
			// System.out.println("创建节点成功:" + path2);
			// 删除
			// zooKeeper.delete("/node1", 0);
			// 获取子节点列表
			List<String> nodes = zooKeeper.getChildren("/", true);
			for (String string : nodes) {
				System.out.println("jiedian:" + string);
			}
			// String path4 = zooKeeper.create("/node1/node12",
			// "node4".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			// System.out.println("创建节点成功:" + path4);
			// Thread.sleep(Integer.MAX_VALUE);
			// 获取节点类容
			byte[] n1datas = zooKeeper.getData("/node1", true, new Stat());
			System.out.println("节点类容:" + new String(n1datas));
			// 设置节点数据:即更新数据，更新时加上版本，可以防止分布式不同机器并发更改问题
			// zooKeeper.setData("/node1", "node1 set".getBytes(), 0);
			// 获取节点类容
			// byte[] n1datas2=zooKeeper.getData("/node1", true, new Stat());
			// System.out.println("节点类容:"+new String(n1datas2));
			// 检测节点是否存在:
			Stat stat = zooKeeper.exists("/node1", true);
			// 5.3.7权限控制，dao 126
			zooKeeper.addAuthInfo("digest", "zll:521".getBytes());
//			zooKeeper.create("/node_auth1", "node_auth1".getBytes(), Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
			ZooKeeper z2 = new ZooKeeper("47.90.9.239:2181", 5000, null);
			byte[] z2n1datas = z2.getData("/node_auth1", false, null);
			z2.addAuthInfo("digest", "zll:555".getBytes());
			System.out.println("节点类容:" + new String(z2n1datas));
			// 5.4开源客户端
			//5.4.1开源客户端,ZKClient
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void process(WatchedEvent event) {
		try {
			System.out.println("接收事件：" + event);
			if (KeeperState.SyncConnected == event.getState()) {
				countDownLatch.countDown();
			} else if (EventType.NodeChildrenChanged == event.getType()) {
				// 获取子节点列表
				List<String> nodes = zooKeeper.getChildren("/", true);
				for (String string : nodes) {
					System.out.println("jiedian:" + string);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
