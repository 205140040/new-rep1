package com.yfairy.session;

import java.io.Serializable;

import com.yfairy.user.bean.User;

public class UserSession implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static ThreadLocal<User> threadLocal = new ThreadLocal<User>();

	public static void setUser(User user) {
		threadLocal.set(user);
	}

	public static User getUser() {
		return threadLocal.get();
	}

	public static Integer getUserId() {
		User res = threadLocal.get();
		Integer userId = res == null ? null : res.getId();
		return userId;
	}

}
