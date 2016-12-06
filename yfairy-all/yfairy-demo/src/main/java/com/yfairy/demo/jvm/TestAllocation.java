package com.yfairy.demo.jvm;

public class TestAllocation {

	public static int _1MB = 1024 * 1024;

	/**
	 * VM参数:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
	 * -XX:SurvivorRatio=8
	 */
	public static void testAllocation() {
		byte[] a1, a2, a3, a4;
		a1 = new byte[2 * _1MB];
		a2 = new byte[2 * _1MB];
		a3 = new byte[2 * _1MB];
		a4 = new byte[4 * _1MB]; // 出现一次minor GC
	}

	public static void main(String[] args) {
		/**
		 * java自动内存管理解决了，1.自动分配内存，2自动回收内存<br>
		 * 此处是分配内存演示:大多数情况下，<br>
		 * 对象优先在新生代eden中分配，大对象(需要连续内存空间的对象)，
		 * 一般在老年代中分配,长期存活的对象将进入老年代,虚拟机通过给对象设置年龄，<br>
		 * 每进行一次GC，还存活的对象年龄+1<br>
		 * 虚拟机提供了一个:-XX:PretenureSizeThresold参数，令大于这个值得大对象直接在老年代分配,
		 * 避免在新生代区产生大量的内存复制
		 */
		testAllocation();
		/**
		 * 运行结果: Heap PSYoungGen total 9216K, used 7456K [0x00000000ff600000,
		 * 0x0000000100000000, 0x0000000100000000) eden space 8192K, 91% used
		 * [0x00000000ff600000,0x00000000ffd481d8,0x00000000ffe00000) from space
		 * 1024K, 0% used
		 * [0x00000000fff00000,0x00000000fff00000,0x0000000100000000) to space
		 * 1024K, 0% used
		 * [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000) ParOldGen
		 * total 10240K, used 4096K [0x00000000fec00000, 0x00000000ff600000,
		 * 0x00000000ff600000) object space 10240K, 40% used
		 * [0x00000000fec00000,0x00000000ff000010,0x00000000ff600000) Metaspace
		 * used 2671K, capacity 4486K, committed 4864K, reserved 1056768K class
		 * space used 288K, capacity 386K, committed 512K, reserved 1048576K
		 */
	}

}
