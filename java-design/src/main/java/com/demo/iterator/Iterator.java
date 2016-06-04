package com.demo.iterator;

public interface Iterator {

	/**
	 * 是否有下个元素
	 * 
	 * @author admin
	 * @date 2016年6月2日
	 * @description
	 * @return Boolean
	 */
	Boolean hasNext();

	/**
	 * 获取下一个元素
	 * 
	 * @author admin
	 * @date 2016年6月2日
	 * @description
	 * @return Object
	 */
	Object next();
}
