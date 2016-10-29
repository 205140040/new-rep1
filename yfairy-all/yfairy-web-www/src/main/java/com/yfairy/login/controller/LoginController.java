package com.yfairy.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/login")
@Controller
public class LoginController {

	@RequestMapping("/toLoginPage")
	public String toLoginPage() {
		return "jsp/login/login";
	}

}
