package com.timobb.hadoop.demo.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordcountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		// 得到输入的每一行数据:
		String line = value.toString();
		// 通过空格分割数据
		String[] words = line.split(" ");
		// 遍历输出数据
		for (String word : words) {
			// new IntWritable(1) 计数一次
			context.write(new Text(word), new IntWritable(1));
		}
	}

}
