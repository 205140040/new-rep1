package com.yfairy.jms.consumer.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/")
	public String toIndexJsp() {
		return "index";
	}
}
