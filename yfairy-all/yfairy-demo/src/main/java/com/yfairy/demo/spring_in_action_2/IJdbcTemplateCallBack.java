package com.yfairy.demo.spring_in_action_2;

import java.sql.ResultSet;

public interface IJdbcTemplateCallBack {
	<T> void executeQueryCallBack(ResultSet resultSet, Object object);
}
