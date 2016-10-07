package com.timobb.hadoop.demo.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class SortReduce extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable> {
	private static IntWritable no = new IntWritable(1); // 排序序号

	@Override
	protected void reduce(IntWritable key, Iterable<IntWritable> values,
			Reducer<IntWritable, IntWritable, IntWritable, IntWritable>.Context context)
			throws IOException, InterruptedException {
		for (IntWritable val : values) {
			context.write(no, key);
			int temp = no.get() + 1;
			no = new IntWritable(temp); // 序号增加
		}
	}
}
