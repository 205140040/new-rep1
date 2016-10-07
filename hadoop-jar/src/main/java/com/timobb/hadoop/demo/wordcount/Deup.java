package com.timobb.hadoop.demo.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * 数据去重
 * 
 * @author jiangzi
 *
 */
public class Deup {
	public static void main(String[] args) throws Exception {
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
		Configuration configuration = new Configuration();
		Job job = Job.getInstance(configuration, "quchong");
		job.setJarByClass(Deup.class);
		job.setMapperClass(DeupMapper.class);
		job.setReducerClass(DeupReduce.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		FileInputFormat.setInputPaths(job, new Path("hdfs://localhost:9000/qc"));
		FileOutputFormat.setOutputPath(job, new Path("hdfs://localhost:9000/qcout"));
		job.waitForCompletion(true);
	}

}
