package com.yfairy.demo.thinkinginjava;

/**
 * 类注释
 * 
 * @author jiangzi
 *
 */
public class JavaDoc1 {
	/**
	 * 变量注释
	 */
	private int age;

	/**
	 * 方法注释
	 * 
	 * <pre>
	 * System.out.println(age);
	 * </pre>
	 * <ol>
	 * <li>参数1</li>
	 * <li>参数2</li>
	 * <li>参数3</li>
	 * </ol>
	 * <br>
	 * 
	 * @see com.yfairy.demo.thinkinginjava#main<br>
	 *      引用其他类<br>
	 * @version 1.0 版本
	 * @author jiangzi 作者
	 * @param p1
	 *            参数1
	 * @exception no
	 *                exception
	 * @return void
	 */
	public void sayAge(String p1) {
		System.out.println(age);
	}

	public static void main(String[] args) {
		/**
		 * 2.8.1注释文档57/688 <br>
		 * javadoc用于提取注释的工具,<br>
		 * javadoc只能为public和protected显示注释文档<br>
		 * javadoc将html命令传递给生成的html。doc文档<br>
		 * eclipse生成doc文档及乱码的解决:http://blog.csdn.net/kqygww/article/details/8170678<br>
		 */
	}
}
