package com.yfairy.demo.jvm;

public class HotSwapClassLoader extends ClassLoader {
	public HotSwapClassLoader() {
		//此处设置父类加载器为：HotSwapClassLoader，达到可以执行lib中的jar
		super(HotSwapClassLoader.class.getClassLoader());
	}
	
	/**
	 * 把defineClass开放出来，外部显示调用时才使用，否则使用系统双亲委派模型进行内加载,
	 * 此方法是把java类的 byte数组变为class对象
	 * @param classByte
	 * @return
	 */
	public Class loadByte(byte[] classByte){
		return defineClass(null, classByte, 0, classByte.length);
	}
}
