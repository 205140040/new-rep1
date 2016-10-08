package com.timobb.hadoop.demo.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

public class MultiJoinMain {
	public static void main(String[] args) {
		/**
		 * 多表数据关联 
		 * 如: 左: 
		 * beijing lol 1
		 * beijing xingbake 1
		 *  shanghai lol 2 
		 *  beijing coffe 1 
		 *  shanghai mingzhu 2 
		 *  wuhan 黄鹤楼 3 
		 *  shanghai 世纪公园 2 
		 *  右： 1 beijing 
		 *  2 shanghai 
		 *  3 wuhan 
		 *  1.map阶段，把关联的id作为key存入，values中存放数据，同时标识左表，右表
		 * 2.reduce阶段先取到右表的数据，然后输出
		 */
		JobRunUtil.run("multijoin", MultiJoinMain.class, MultiJoinMapper.class, MultiJoinReducer.class,
				IntWritable.class, Text.class, Text.class, Text.class, "/mj", "mjout");
	}

}
