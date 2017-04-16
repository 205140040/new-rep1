package com.yfairy.demo.mybatis3;

import java.util.Arrays;

import org.apache.ibatis.binding.MapperProxy;
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

		// MapperProxy<T>

		// 9.5 分页

		// 9.5.1RowBounds分页

		// offset 英[ˈɒfset]
		// 美[ˈɔ:fset]
		// vt. 抵消; 补偿; （为了比较的目的而）把…并列（或并置） ; 为（管道等）装支管;
		// vi. 形成分支，长出分枝; 装支管;
		// n. 开端; 出发; 平版印刷; 抵消，补偿;

		// TODO 9.5.2 插件分页 (241/272) <br>

		// RowBounds

	}

}
