package com.yfairy.user.service;

import com.yfairy.common.beans.Result;
import com.yfairy.user.bean.User;

public interface ILoginService {

	Result login(User user);

}