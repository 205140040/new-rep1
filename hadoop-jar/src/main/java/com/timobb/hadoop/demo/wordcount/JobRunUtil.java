package com.timobb.hadoop.demo.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class JobRunUtil {
	public static void run(String jobName, Class<?> jarByClass, Class<? extends Mapper> mapperClass,
			Class<? extends Reducer> reducerClass, Class<?> mapOutputKeyClass, Class<?> mapOutputValueClass,
			Class<?> outputKeyClass, Class<?> outputValueClass, String inputPaths, String outputPath) {
		try {
			Configuration configuration = new Configuration();
			//mpareduce中使用压缩
			//http://www.cnblogs.com/yurunmiao/p/4528499.html
			configuration.setBoolean(Job.MAP_OUTPUT_COMPRESS, true);
			configuration.setClass(Job.MAP_OUTPUT_COMPRESS_CODEC, GzipCodec.class, CompressionCodec.class);
			//
			Job job = Job.getInstance(configuration, jobName);
			job.setJarByClass(jarByClass);
			job.setMapperClass(mapperClass);
			job.setReducerClass(reducerClass);
			job.setMapOutputKeyClass(mapOutputKeyClass);
			job.setMapOutputValueClass(mapOutputValueClass);
			job.setOutputKeyClass(outputKeyClass);
			job.setOutputValueClass(outputValueClass);
			FileInputFormat.setInputPaths(job, new Path("hdfs://localhost:9000" + inputPaths));
			FileOutputFormat.setOutputPath(job, new Path("hdfs://localhost:9000" + outputPath));
			job.waitForCompletion(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
