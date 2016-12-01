package com.yfairy.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yfairy.common.annotation.NotNeedSession;

@Controller
public class IndexController {

	@NotNeedSession
	@RequestMapping("/")
	public String toIndexJsp() {
		return "index";
	}
}
