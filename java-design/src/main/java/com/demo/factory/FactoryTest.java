package com.demo.factory;

import com.alibaba.fastjson.JSON;

public class FactoryTest {
	public static void main(String[] args) {
		IdCardFactory factory = new IdCardFactory();
		Product p1 = factory.createInstance("A");
		Product p2 = factory.createInstance("B");
		Product p3 = factory.createInstance("C");
		p1.use();
		p2.use();
		p3.use();
		System.out.println(JSON.toJSONString(factory.getOwners()));
	}
}
