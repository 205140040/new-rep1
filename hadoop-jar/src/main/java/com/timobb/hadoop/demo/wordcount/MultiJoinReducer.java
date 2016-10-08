package com.timobb.hadoop.demo.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MultiJoinReducer extends Reducer<IntWritable, Text, Text, Text> {
	@Override
	protected void reduce(IntWritable key, Iterable<Text> values,
			Reducer<IntWritable, Text, Text, Text>.Context context) throws IOException, InterruptedException {
		for (Text val : values) {
			context.write(new Text(key.toString()), val);
		}
	}
}
