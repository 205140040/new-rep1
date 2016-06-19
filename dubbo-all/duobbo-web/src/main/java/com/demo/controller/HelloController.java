package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.hello.service.IHelloService;

@Controller
@RequestMapping("/hello")
public class HelloController {
	@Autowired
	private IHelloService helloService;

	@RequestMapping("/sayHello")
	@ResponseBody
	public String sayHello() {
		helloService.sayHello("酱紫");
		return "world";
	}
}
