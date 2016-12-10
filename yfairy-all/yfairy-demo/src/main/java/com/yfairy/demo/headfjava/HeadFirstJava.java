package com.yfairy.demo.headfjava;

public class HeadFirstJava {

	public static void main(String[] args) {
		/**
		 * HeadFirstJava
		 * javax包曾经是代表扩展的<br>
		 * 17章：包，jar存档文件与部署<br>
		 * 编译包下的所有java文件: javac -d ../classes com/yfairy/*.java,<br>
		 * 执行：cd classes然后java com.yfairy.Main<br>
		 * -d 选项，把编译的文件输出到指定目录，-d通过输入包名，主动建立包<br>
		 * 如：javac -d ./classes com/yfairy/jar1/Jar1Util.java编译jar1
		 * ，编译jar2中引用jar1：javac -classpath ./classes -d ./classes TestJavaCommand.java
		 * 运行：java -classpath ./classes com.yfairy.jar2.TestJavaCommand
		 * -classpath指定类路径，-d指定编译后生成的路径
		 * 18章：RMI  TODO 学习RMI
		 */
		System.out.println("hello");

	}

}
