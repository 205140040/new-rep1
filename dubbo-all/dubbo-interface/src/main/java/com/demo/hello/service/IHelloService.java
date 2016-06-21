package com.demo.hello.service;

import java.util.List;

import com.demo.beans.Student;

public interface IHelloService {

	List<Student> sayHello(String name);

}