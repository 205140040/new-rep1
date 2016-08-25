package com.timobb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/hello")
@Controller
public class HelloController {
	@RequestMapping("/sayHello")
	@ResponseBody
	public String sayHello(HttpServletRequest request) {
		System.out.println("hello");
		return "hello";
	}
}
