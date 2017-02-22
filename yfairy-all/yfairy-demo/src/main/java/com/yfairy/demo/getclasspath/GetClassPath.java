package com.yfairy.demo.getclasspath;

public class GetClassPath {

	public static void main(String[] args) {
		// Java Web 项目获取运行时路径
		// classpath:http://www.cnblogs.com/zemliu/p/3192905.html

		String cp = GetClassPath.class.getClassLoader().getResource("").getPath();
		System.out.println(cp);
	}

}
