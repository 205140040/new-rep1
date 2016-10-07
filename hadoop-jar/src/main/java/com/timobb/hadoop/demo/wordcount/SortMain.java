package com.timobb.hadoop.demo.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class SortMain {
	public static void main(String[] args) throws Exception {
		/**
		 * 排序， mapreduce按照key值进行排序， int型的按照大小排序， string形的按照string排序
		 */
		Configuration configuration = new Configuration();
		Job job = Job.getInstance(configuration, "sort");
		job.setJarByClass(SortMain.class);
		job.setMapperClass(SortMapper.class);
		job.setReducerClass(SortReduce.class);
		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(IntWritable.class);
		FileInputFormat.setInputPaths(job, new Path("hdfs://localhost:9000/sort"));
		FileOutputFormat.setOutputPath(job, new Path("hdfs://localhost:9000/sortout"));
		job.waitForCompletion(true);
	}
}
