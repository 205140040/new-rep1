package com.timobb.hadoop.demo.wordcount;

public class Demo {

	public static void main(String[] args) {
		/**
		 * linux运行步骤：
		 * 1.打成jar包
		 * 2.bin/hdfs dfs -mkdir /qc  创建输入目录
		 * 3.把文件添加到输入目录:bin/hdfs dfs -put 
		 * bin/hdfs dfs -put /home/hadoopdata/qc/* /qc
		 * 4.运行maprecude jar包:
		 *  bin/hadoop jar /home/hadoopdata/jars/qc.jar
		 *  5.查看输出类容:
		 *  bin/hdfs dfs -ls /qcout
		 *  bin/hdfs dfs -cat /qcout/part-r-00000
		 */
		// 1.6.2 HBase的数据管理 27
		//第二章：hadoop的安装与配置 33
		//第三章:hadoop应用案例分析 50
		//第4章：mapreduce计算模型  69
		//第5章：开发mapreduce应用程序 90
		//第6章：mapreduce应用案列 113
		//6.3排序 121
		//第7章：mapreduce工作机制 132
		//7.5.2任务JVM重用 149
		//第8章：hadoop IO操作 152
		//hadoop压缩:http://www.cnblogs.com/ggjucheng/archive/2012/04/22/2465580.html
		//第9章：hdfs详解 177

	}

}
