package com.timobb.hadoop.demo.wordcount;

import java.io.BufferedInputStream;
import java.net.URI;
import java.net.URL;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.fs.Path;

public class FileSystemReadDemo {
	static {
		// 设置url支持hdfs协议
		URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
	}

	public static void main(String[] args) throws Exception {
		// 使用filesystem读取hdfs文件
		Configuration conf = new Configuration();
		String uri = "hdfs://47.90.9.239:9000/sortout";
		FileSystem fileSystem = FileSystem.get(URI.create(uri), conf);
		FSDataInputStream in = fileSystem.open(new Path(uri));
		// URL url = new URL(uri);
		// InputStream inputStream = url.openStream();
		byte[] bytes = new byte[in.available()];
		BufferedInputStream bufferedInputStream = new BufferedInputStream(in);
		bufferedInputStream.read(bytes);
		System.out.println(new String(bytes));

	}

}
