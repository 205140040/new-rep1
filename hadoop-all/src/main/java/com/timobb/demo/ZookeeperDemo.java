package com.timobb.demo;

public class ZookeeperDemo {

	public static void main(String[] args) {
		/**
		 * 第2章：一致性协议:dao 28
		 * 第3章:dao 63
		 * 第4章：zookeeper与paxos dao 70
		 * 4.2.3深入zab协议,dao 82
		 * 第5章：使用zookeeper,dao 90
		 * bin目录下的脚本作用:
		 * zkCleanup清除zookeeper历史数据，包括日志和事务
		 * zkCli：zookeeper的一个简易客户端
		 * zkEnv：设置zookeeper的环境变量
		 * zkServer:zookeeper的启动，停止和重启
		 * 启动:./zkServer.sh start
		 * 如：停止服务: ./zkServer.sh stop
		 * 5.2客户端脚本:zkCli dao 99
		 * 1.create 创建zookeeper节点
		 * 不设置参数默认创建持久节点:create /zk-node1 123  创建一个
		 * zk-node1 内容为123
		 * 2读取命令:ls path
		 * 如ls /
		 * 3.get path获取指定path节点的类容信息
		 * 4.set path更新节点的数据类容:set /zk-node1 456
		 * 5.删除:delete path
		 * 如:delete /zl-node1
		 * 5.3:JAVA客户端api使用
		 * 
		 */

	}

}
