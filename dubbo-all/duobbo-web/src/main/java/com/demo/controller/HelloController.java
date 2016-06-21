package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String sayHello() {
		List<Student> students = helloService.sayHello("酱紫");
		System.out.println(JSON.toJSONString(students));
		return JSON.toJSONString(students);
	}
}
