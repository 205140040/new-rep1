package com.demo.hello.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.beans.Student;
import com.demo.dao.StudentMapper;
import com.demo.hello.service.IHelloService;

public class HelloServiceImpl implements IHelloService {
	@Autowired
	private StudentMapper studentMapper;
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.demo.hello.service.impl.IHelloService#sayHello(java.lang.String)
	 */
	private Logger logger = Logger.getLogger(HelloServiceImpl.class);

	@Override
	public List<Student> sayHello(String name) {
		logger.info("访问了:sayHello");
		System.out.println(name + ",hello");
		return studentMapper.selectList();
	}
}
