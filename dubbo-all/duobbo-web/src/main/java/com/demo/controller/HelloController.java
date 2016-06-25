package com.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.demo.beans.Student;
import com.demo.hello.service.IHelloService;

@Controller
@RequestMapping("/hello")
public class HelloController {
	@Autowired
	private IHelloService helloService;

	@RequestMapping("/sayHello")
	@ResponseBody
	public String sayHello() throws IOException {
		
		ResourceLoader resourceLoader=new DefaultResourceLoader();
		Resource resource=resourceLoader.getResource("file:/WEB-INF/my.properties");
		Properties properties=new Properties();
		properties.load(resource.getInputStream());
		System.out.println("name:"+properties.getProperty("name"));
		List<Student> students = helloService.sayHello("酱紫");
		System.out.println(JSON.toJSONString(students));
		return JSON.toJSONString(students);
	}
	
	public static void main(String[] args) throws Exception {
		ResourceLoader resourceLoader=new DefaultResourceLoader();
		Resource resource = resourceLoader.getResource("file:/WEB-INF/my.properties");
		Properties properties=new Properties();
		properties.load(resource.getInputStream());
		System.out.println("name:"+properties.getProperty("name"));
	}
}
