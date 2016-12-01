package com.yfairy.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yfairy.session.UserSession;

@RequestMapping("/user")
@Controller
public class UserController {

	@RequestMapping("/toUserAccountPage")
	public String toUserAccountPage(Model model) {
		model.addAttribute("user", UserSession.getUser());
		return "jsp/user/userAccount";
	}

}
