package com.yfairy.user.service.impl;

import static com.yfairy.common.utils.NullUtil.isEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.yfairy.common.beans.Result;
import com.yfairy.test.service.impl.AbstractHello;
import com.yfairy.test.service.impl.ApplicationContextHelper;
import com.yfairy.user.bean.User;
import com.yfairy.user.mapper.UserMapper;
import com.yfairy.user.service.ILoginService;

public class LoginServiceImpl implements ILoginService {
	@Autowired
	private UserMapper userMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.yfairy.user.service.impl.ILoginService#login(com.yfairy.user.bean.
	 * User)
	 */
	@Override
	public Result login(User user) {
		/**
		 * bean中通过实现ApplicationContextAware,来获取当前的applicationContext对象
		 */
		ApplicationContext applicationContext = ApplicationContextHelper.getApplicationContext();
		ILoginService loginService2 = (ILoginService) applicationContext.getBean("loginService");
		ILoginService loginService3 = ApplicationContextHelper.getBean("loginService");
		System.out.println(loginService2);
		System.out.println(loginService3);

		System.out.println("----------------------------------");
		AbstractHello shanghai = AbstractHello.getInstance("ShangHai", "V1");
		shanghai.sayHello("jack");

		AbstractHello dongbei = AbstractHello.getInstance("DongBei", "V1");
		dongbei.sayHello("jack");

		if (isEmpty(user)) {
			return Result.resultFalse("用户参数不能为空!");
		}
		String userName = user.getUsername();
		String passWord = user.getPassword();
		if (isEmpty(userName)) {
			return Result.resultFalse("用户名不能为空!");
		}
		User old = userMapper.selectByUsername(user);
		if (isEmpty(old)) {
			return Result.resultFalse("该用户不存在!");
		}
		if (!old.getPassword().equals(passWord)) {
			return Result.resultFalse("用户名或密码错误!");
		}
		return Result.resultTrue("登录成功!", old);
	}
}
