package com.yfairy.demo.mybatis3;

import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

public class MyObjectFactory extends DefaultObjectFactory {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public <T> T create(Class<T> type) {
		// TODO Auto-generated method stub
		T t = super.create(type);
		if (t instanceof Student) {
			System.err.println("t instanceof Student");
			Student s = (Student) t;
			s.setAddName("hahahha自定义对象创建工厂");
			return (T) s;
		}
		return t;
	}

	@Override
	public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
		// TODO Auto-generated method stub
		return super.create(type, constructorArgTypes, constructorArgs);
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		properties.list(new PrintWriter(System.err));
		super.setProperties(properties);
	}

	@Override
	public <T> boolean isCollection(Class<T> type) {
		boolean b = super.isCollection(type);
		System.err.println(this.getClass().getName() + "isCollection:" + b);
		return super.isCollection(type);
	}

}
