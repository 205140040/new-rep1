package com.demo.prototype;

public interface Product extends Cloneable{
	void use(String s);
	
	Product createClone();
}
