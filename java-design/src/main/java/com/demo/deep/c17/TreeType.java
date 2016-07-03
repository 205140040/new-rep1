package com.demo.deep.c17;

public class TreeType extends SetType implements Comparable<TreeType>{

	public TreeType(int i) {
		super(i);
	}

	/**
	 * treeSet保持次序的set，使用它可以从提取有序的序列，必须实现comparable接口
	 */
	public int compareTo(TreeType o) {
		if(o.i<i){
			return -1;
		}else if (o.i==i) {
			return 0;
		}else {
			return 1;
		}
	}

}
