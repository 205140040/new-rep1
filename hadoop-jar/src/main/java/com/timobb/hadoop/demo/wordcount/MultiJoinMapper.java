package com.timobb.hadoop.demo.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MultiJoinMapper extends Mapper<LongWritable, Text, IntWritable, Text> {
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, IntWritable, Text>.Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
		Character c = line.charAt(0);
		String firstChar = c.toString();
		String keystr = "";
		String valuestr = "";
		String[] liness = line.split(" "); // 空格拆分
		if (firstChar.matches("^[0-9]{1}$")) {
			// 右表，地区表
			keystr = firstChar;
			valuestr = "r#" + liness[liness.length - 1];
		} else {
			// 左表
			keystr = liness[liness.length - 1];
			valuestr = "l#" + liness[0] + " " + liness[1];
		}
		context.write(new IntWritable(Integer.parseInt(keystr)), new Text(valuestr));
	}
}
