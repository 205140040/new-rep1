package com.yfairy.demo.effective_java;

public class Chapter9Exception {

	public static void main(String[] args) {
		/**
		 * 第9章:异常211(223/303)<br>
		 * 57条只针对异常的情况才使用异常<br>
		 * 第58条对可恢复的情况使用受检异常，对编程错误使用运行时异常<br>
		 * 如：FileNotFoundException是一个受检异常,<br>
		 * 文件不存在是可恢复的，即保证文件存在<br>
		 * 第59条避免不必要的使用受检的异常<br>
		 * 60条优先使用标准的异常<br>
		 * 优先使用标准的异常可以达到代码复用,更符合标准<br>
		 * IllegalArgumentException(不合法的参数异常,Illegal不合法)<br>
		 * illegal 英[ɪˈli:gl]<br>
		 * adj. 不合法的，违法的; 违反规则的;<br>
		 * n. 非法移民，非法劳工; 间谍;<br>
		 * 第61条抛出与抽象相对应的异常<br>
		 * 62条每个方法抛出的异常都要有文档<br>
		 * 尽量避免throws Exception或throws Throwable,这样会使调用者不清楚出了什么异常<br>
		 * 64条努力使失败保持原子性<br>
		 * 65条不要忽略异常<br>
		 * try {<br>
		 * 
		 * } catch (Exception e) <br>
		 * { <br>
		 * // TODO: handle exception <br>
		 * }<br>
		 * 不要忽略异常，这样会导致出错时无法知道错误，<br>
		 * 就好像火灾报警器响了，却被忽略了<br>
		 */
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
