package com.yfairy.demo.android.v1.controller;

import static com.yfairy.demo.android.MobileUrl.MOBILE_URL_V1;
import static com.yfairy.mobile.bean.MobileResponse.SUCCESS_CN_MSG;
import static com.yfairy.mobile.bean.MobileResponse.trueMsgAndData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yfairy.mobile.bean.MobileResponse;
import com.yfairy.user.bean.User;
import com.yfairy.user.bean.UserFactory;

@RequestMapping(MOBILE_URL_V1 + "/mobileHello")
@Controller
public class MobileHelloController {

	@RequestMapping("/listHelloUser")
	@ResponseBody
	public MobileResponse listHelloUser() {
		List<User> users = new ArrayList<>();
		Calendar c=Calendar.getInstance();
		Date date=c.getTime();
		for (int i = 0; i < 150; i++) {
			users.add(UserFactory.newInstance("张三" + (i + 1), "123", 18, date));
			c.add(Calendar.MINUTE, 2);
			date=c.getTime();
		}
		return trueMsgAndData(SUCCESS_CN_MSG, users);
	}

}
