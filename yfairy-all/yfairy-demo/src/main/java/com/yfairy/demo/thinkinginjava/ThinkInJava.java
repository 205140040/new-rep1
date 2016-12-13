package com.yfairy.demo.thinkinginjava;

import java.util.Date;
import java.util.Properties;

public class ThinkInJava {

	public static void main(String[] args) {
		/**
		 * 1.章对象入门: <br>
		 * public所有包都可访问，protected当前包及子类可以访问，<br>
		 * default默认的，当前包可访问，private当前类可访问<br>
		 * 1.11 JAVA和因特网 第2章：47/688<br>
		 * 2.8.1注释文档57/688<br>
		 * javadoc用于提取注释的工具<br>
		 * 第三章：控制程序流程 61/688
		 */
		System.out.println(new Date().toLocaleString());
		Properties properties = System.getProperties();
		properties.list(System.out);
		System.out.println("---------------------------------------------");
		System.out.println("Memory Usage");
		Runtime rt = Runtime.getRuntime();
		System.out.println("totalMemory:" + rt.totalMemory() + "\tfreeMemory:" + rt.freeMemory());
	}

}
