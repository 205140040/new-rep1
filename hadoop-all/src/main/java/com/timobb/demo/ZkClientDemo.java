package com.timobb.demo;

import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

public class ZkClientDemo {

	public static void main(String[] args) {
		// 5.4.1开源客户端,ZKClient
		ZkClient zkClient = new ZkClient("47.90.9.239:2181", 5000);
		System.out.println("连接成功......");
		// 注册监听器:
		zkClient.subscribeChildChanges("/zkcli1", new IZkChildListener() {

			@Override
			public void handleChildChange(String pPath, List<String> currentChildren) throws Exception {
				System.out.println("父路径:" + pPath + "\t:children:" + currentChildren);
			}
		});
		// 递归创建节点
		zkClient.createPersistent("/zkcli1/c3", true);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<String> s = zkClient.getChildren("/zkcli1");
		for (String string : s) {
			System.out.println(string);
		}
		// 递归删除节点
		// zkClient.deleteRecursive("/zkcli1/c1");
		//设置数据
		String path="/zkcli1/c3";
		zkClient.subscribeDataChanges(path, new IZkDataListener() {
			
			@Override
			public void handleDataDeleted(String arg0) throws Exception {
				System.out.println("arg0:"+arg0);
			}
			
			@Override
			public void handleDataChange(String path, Object data) throws Exception {
				System.out.println("data changed:"+data);
			}
		});
		zkClient.writeData("/zkcli1/c3", new User("/zkcli1/c3", "zss2"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// getData dao 139
		User user=zkClient.readData("/zkcli1/c3");
		System.out.println(user);
		//检查节点是否存在
		System.out.println("node exists:"+zkClient.exists(path));
		System.out.println("node exists:"+zkClient.exists("/noexit"));

	}

}
