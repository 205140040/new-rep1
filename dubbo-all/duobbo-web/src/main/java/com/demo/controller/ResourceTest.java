package com.demo.controller;

import java.io.FileInputStream;
import java.util.Properties;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jca.support.ResourceAdapterFactoryBean;

public class ResourceTest {

	public static void main(String[] args) throws Exception {
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resource = resourceLoader.getResource("file:/WEB-INF/my.properties");
		System.out.println(resource.getFilename());
		Properties properties=new Properties();
		properties.load(new FileInputStream(resource.getFile()));
		System.out.println("name:"+properties.getProperty("name"));
	}

}
