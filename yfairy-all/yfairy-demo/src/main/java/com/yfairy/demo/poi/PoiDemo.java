package com.yfairy.demo.poi;

import java.io.IOException;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class PoiDemo {

	public static void main(String[] args) throws Exception {
		/**
		 * Apache POI 是用Java编写的免费开源的跨平台的 Java API，Apache
		 * POI提供API给Java程式对Microsoft Office格式档案读和写的功能。POI为“Poor Obfuscation
		 * Implementation”的首字母缩写，意为“可怜的模糊实现”。
		 */
		// TODO word，pdf，加密，验证码，二维码,结合JMS做一个注册发送邮件确认
		System.out.println("hello");
		Resource resource=new ClassPathResource("fm1.html");
		
		System.out.println(resource.getFile().getAbsolutePath());
	}

}
