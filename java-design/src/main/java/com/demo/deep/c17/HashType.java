package com.demo.deep.c17;

public class HashType extends SetType {

	public HashType(int i) {
		super(i);
	}

	/**
	 * hashSet为快速查找而设计的set，（默认使用），
	 * 存入hashset中的元素必须定义hashcode
	 */
	@Override
	public int hashCode() {
		return i;
	}
}
