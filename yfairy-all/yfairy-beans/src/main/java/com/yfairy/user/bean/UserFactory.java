package com.yfairy.user.bean;

import java.util.Date;

public class UserFactory {

	public static User newInstance(String name, String pwd, Integer age, Date date) {
		User user = new User();
		user.setUsername(name);
		user.setPassword(pwd);
		user.setAge(age);
		user.setCreateDate(date);
		return user;
	}

}
