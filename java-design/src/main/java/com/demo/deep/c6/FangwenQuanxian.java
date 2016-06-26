package com.demo.deep.c6;

public class FangwenQuanxian {

	public static void main(String[] args) {
		/**
		 * 访问权限：
		 * default:包访问权限，同一包有效，其他的无效
		 * public:任意类都能访问
		 * private:私有的，只能当前类访问
		 * protecd:继承访问权限，同时也提供包访问权限
		 */
		/**
		 * 向上转型：子类转为父类（安全的）
		 */
		/**
		 * 7.8final关键字
		 * final参数，运行方法时将无法更改该参数的值
		 * final方法，防止子类修改父类的方法
		 */
	}

	public static void finalFun(final String a) {
//		a="8";
		System.out.println(a);
	}
}
