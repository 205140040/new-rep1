package com.yfairy.demo.mybatis3;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SrqcChapter9 {

	public static void main(String[] args) {
		/**
		 * 第9章：实用的场景(223/272) <br>
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("com/yfairy/demo/mybatis3/mybatis-spring.xml");
		BlogTitleDao blogTitleDao = context.getBean(BlogTitleDao.class);
		BlogTitle search = new BlogTitle();
		// search.setId(5);
		search.setIdList(Arrays.asList(1, 2, 5, 6));

		System.out.println();
		System.err.println("使用MapperFactoryBean 生成 mapper 动态代理类");
		System.out.println();
		blogTitleDao.listBlogTitleUseMapperFactoryBean(search);

	}

}
