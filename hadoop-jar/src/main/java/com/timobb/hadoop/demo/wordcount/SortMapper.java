package com.timobb.hadoop.demo.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SortMapper extends Mapper<LongWritable, Text, IntWritable, IntWritable> {
	@Override
	protected void map(LongWritable key, Text value,
			Mapper<LongWritable, Text, IntWritable, IntWritable>.Context context)
			throws IOException, InterruptedException {
		// 利用mapreduce中key默认排序的特点，把value当做key输出
		// ,同时输出一个int 1的数值，用于序号计算
		String line = value.toString();
		context.write(new IntWritable(Integer.parseInt(line)), new IntWritable(1));
	}
}
