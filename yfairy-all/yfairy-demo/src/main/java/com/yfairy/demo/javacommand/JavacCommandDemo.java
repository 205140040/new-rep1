package com.yfairy.demo.javacommand;

public class JavacCommandDemo {
	/**
	 * JAVAC命令:<br>
	 * <br>
	 * 1、前提：java分为两部分： 一个是编译（javac命令），一个是运行（java命令） <br>
	 * 2、java与javac的区别： ①、javac负责的是编译，将.java文件编译成.class文件,<br>
	 * 当执行javac的时候，会启动java的编译器程序，对指定的扩展名为.java的文件进行编译，<br>
	 * 生成了jvm可识别的字节码文件，即.class文件（java的运行程序）<br>
	 * ②、java负责的是运行 当执行java时，会启动jvm加载运行时所需要的类库，<br>
	 * 并执行.class文件 <br>
	 * 3、注意：一个文件被执行，必须有一个执行的起始点，这个起始点就是main函数。<br>
	 * <br>
	 * 百度JAVAC命令详解：http://wenku.baidu.com/link?url=CpTOI-QCQOZXpciL7HRAz2xmDBu3pGxc2jtrmLfR2agvS07nTaE-2NvNhzrMHwaD1ug5ZKfzgsTCSnkyXn-ayQcWc69rzAUAVIYi5M7I8Ua
	 * <br>
	 * <br>
	 * 1.打开一个.java文件的目录：如 cd C:\Users\xx\Desktop\javacmd, 使用javac
	 * filename.java即可编译生成file.class的文件,如javac Hello.java , 使用java
	 * filename可运行经过编译的文件，如java Hello<br>
	 * (此种方式Hello.java中要在src包下，如果不在src包下，需要建立和包名一样的路径方可运行)<br>
	 * 
	 * <br>
	 * ubuntu下使用java、javac命令行编译工程:
	 * 这篇文章挺好:http://blog.csdn.net/wen294299195/article/details/39964971
	 * 
	 * <br>
	 * javac -d 指定编译输出的路径 flename.java 编译的jar <br>
	 * javac -classpath <路径> 指定查找用户类文件和注释处理程序的位置(即引用的其他类路径或者jar路径，多个jar用";"分割)
	 * <br>
	 * -d 输出路径 flename.java <br>
	 * 编译的jar <br>
	 * <br>
	 * java运行jar包<br>
	 * 方式1：java -jar xx.jar(建议使用maven插件把jar包打成可执行的jar)<br>
	 * 把一个jar文件打成可执行的jar包方式:<br>
	 * 用maven打包,然后修改该jar中的META-INF中的MANIFEST.MF Main-Class:
	 * com.alibaba.dubbo.container.Main（启动类） Class-Path: . lib/xxx.jar
	 * (指定查找用户类文件和注释处理程序的位置) 即可，可参考：http://xinklabi.iteye.com/blog/2157591 <br>
	 * <br>
	 * 方式2：java运行jar包：使用java 命令，<br>
	 * 指定classpath,多个jar用";"分割,在指定Main.class<br>
	 * 如:java -classpath lib/jar1-0.0.1-SNAPSHOT.jar;lib/jar2-0.0.1-SNAPSHOT.jar
	 * com.yfairy.jar2.TestJavaCommand<br>
	 * 
	 */
}
