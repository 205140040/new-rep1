package com.yfairy.demo.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * java堆溢出,java堆用于存储对象实例，只要不断创建对象，<br>
 * 并且不让gc回收，且设置jvm堆大小不可扩展，即可出现堆溢出
 * -XX:+HeapDumpOnOutOfMemoryError(让虚拟机出现内存溢出时dump日志)
 * 
 * @author jiangzi VM args :-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

	static class OOMObject {
		// OutOfMemory
		// out of memory（内存溢出）是一个程序员常见的错误类型。通常是开启应用程序过多所导致。
	}

	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<>();
		while (true) {
			list.add(new OOMObject());
		}
		/**
		 * target\classes>java -classpath . -Xms20m -Xmx20m
		 * -XX:+HeapDumpOnOutOfMemoryError com.yfairy.demo.jvm.HeapOOM
		 * java.lang.OutOfMemoryError: Java heap space Dumping heap to
		 * java_pid19172.hprof ... Heap dump file created [28106682 bytes in
		 * 0.105 secs] Exception in thread "main" java.lang.OutOfMemoryError:
		 * Java heap space at java.util.Arrays.copyOf(Unknown Source) at
		 * java.util.Arrays.copyOf(Unknown Source) at
		 * java.util.ArrayList.grow(Unknown Source) at
		 * java.util.ArrayList.ensureExplicitCapacity(Unknown Source) at
		 * java.util.ArrayList.ensureCapacityInternal(Unknown Source) at
		 * java.util.ArrayList.add(Unknown Source) at
		 * com.yfairy.demo.jvm.HeapOOM.main(HeapOOM.java:23)
		 * 
		 */
		/**
		 * 安装eclipse memory analyzer 插件，把java_pid19172.hprof,文件复制到eclipse中，<br>
		 * 双击打开，即可使用内存分析工具查看错误
		 */
	}

}
