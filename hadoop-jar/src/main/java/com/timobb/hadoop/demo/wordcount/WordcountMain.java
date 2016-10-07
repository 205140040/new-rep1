package com.timobb.hadoop.demo.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordcountMain {

	public static void main(String[] args) throws Exception {
		// 创建配置对象
		Configuration configuration = new Configuration();
		// 创建job
		Job job = Job.getInstance(configuration, "wordcount");
		// 设置运行job的主类
		job.setJarByClass(WordcountMain.class);
		// 设置运行map的类
		job.setMapperClass(WordcountMapper.class);
		// 设置运行reduce的类
		job.setReducerClass(WordcountReduce.class);
		// 设置mapper输出的key value
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		// 设置reduce输出的key value
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		// 设置文件读入，输出路径
		FileInputFormat.setInputPaths(job, new Path("hdfs://localhost:9000/wc"));
		FileOutputFormat.setOutputPath(job, new Path("hdfs://localhost:9000/wcout1"));
		// 提交job
		boolean b = job.waitForCompletion(true);
		if (!b) {
			System.out.println("wordcount 运行失败");
		} else {
			System.out.println("success......");
		}

	}

}
