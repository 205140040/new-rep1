package com.yfairy.demo.mybatis3;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.alibaba.fastjson.JSON;

public class MapperXmlDemo {

	public static void main(String[] args) throws IOException {
		/**
		 * Mapper XML 文件 MyBatis 的真正强大在于它的映射语句，<br>
		 * 也是它的魔力所在。由于它的异常强大，映射器的 XML文件就显得相对简单。<br>
		 * 如果拿它跟具有相同功能的 JDBC 代码进行对比，你会立即发现省掉了将近 95% 的代码 。<br>
		 * MyBatis 就是针对SQL 构建的，并且比普通的方法做的更好。<br>
		 * 
		 * 
		 * extract 英[ˈekstrækt]<br>
		 * 美[ɪkˈstrækt]<br>
		 * vt. 提取; （费力地） 拔出; 选取; 获得;<br>
		 * n. 汁; 摘录; 提炼物; 浓缩物;<br>
		 * 
		 */
		SqlSession sqlSession = openSqlSession();

		BlogTitleMapper blogTitleMapper = sqlSession.getMapper(BlogTitleMapper.class);

		// select
		// 查询语句是 MyBatis
		// 中最常用的元素之一，光能把数据存到数据库中价值并不大，如果还能重新取出来才有用，多数应用也都是查询比修改要频繁。对每个插入、更新或删除操作，通常对应多个查询操作。这是
		// MyBatis 的基本原则之一，也是将焦点和努力放到查询和结果映射的原因。简单查询的 select 元素是非常简单的。比如：
		//
		// <select id="selectPerson" parameterType="int" resultType="hashmap">
		// SELECT * FROM PERSON WHERE ID = #{id}
		// </select>

		Object resultMap = blogTitleMapper.selectBlogTitleMap(1);
		// Object resultMap = blogTitleMapper.selectBlogTitleMap(1);

		System.err.println(resultMap);

		// 添加
		// useGeneratedKeys="true" keyProperty="id" 配置返回主键

		// <insert id="insert"
		// parameterType="com.yfairy.demo.mybatis3.BlogTitle"
		// useGeneratedKeys="true" keyProperty="id">

		BlogTitle insertBlogTitle = new BlogTitle();
		insertBlogTitle.setTitle("酱酱的博客" + new Date().toLocaleString());
		insertBlogTitle.setCreateTime(new Date());
		// int result = blogTitleMapper.insert(insertBlogTitle);
		System.out.println("主键:" + insertBlogTitle.getId());

		// 修改
		BlogTitle updBt = new BlogTitle();
		updBt.setId(7);
		updBt.setTitle("修改后的标题");
		int updResult = blogTitleMapper.updateById(updBt);
		System.out.println("修改rows:" + updResult);

		// <!-- sql 可被其他地方include 复用 -->
		// <sql id="base_column" >
		// id,title,create_time
		// </sql>

		// 字符串替换
		//
		// 默认情况下,使用#{}格式的语法会导致 MyBatis
		// 创建预处理语句属性并安全地设置值（比如?）。这样做更安全，更迅速，通常也是首选做法，不过有时你只是想直接在 SQL
		// 语句中插入一个不改变的字符串。比如，像 ORDER BY，你可以这样来使用：
		//
		// ORDER BY ${columnName}

		List<BlogTitle> blogTitles = blogTitleMapper.listBlogTitle(" create_time desc ");
		for (BlogTitle blogTitle : blogTitles) {
			// System.out.println("author:"+JSON.toJSONString(blogTitle.getAuthor()));
			System.err.println(JSON.toJSONString(blogTitle));
		}

		List<BlogTitle> blogTitles2 = blogTitleMapper.listBlogTitle(" create_time desc ");
		System.out.println(blogTitles2);

		// 自动映射
		// 正如你在前面一节看到的，在简单的场景下，MyBatis可以替你自动映射查询结果。 如果遇到复杂的场景，你需要构建一个result map。
		// 但是在本节你将看到，你也可以混合使用这两种策略。 让我们到深一点的层面上看看自动映射是怎样工作的。
		//
		// 当自动映射查询结果时，MyBatis会获取sql返回的列名并在java类中查找相同名字的属性（忽略大小写）。
		// 这意味着如果Mybatis发现了ID列和id属性，Mybatis会将ID的值赋给id。
		//
		// 通常数据库列使用大写单词命名，单词间用下划线分隔；而java属性一般遵循驼峰命名法。 为了在这两种命名方式之间启用自动映射，需要将
		// mapUnderscoreToCamelCase设置为true。

		// 到 Result Maps

		// Result Maps
		// resultMap 元素是 MyBatis 中最重要最强大的元素。它就是让你远离 90%的需要从结果 集中取出数据的 JDBC
		// 代码的那个东西, 而且在一些情形下允许你做一些 JDBC 不支持的事 情。 事实上, 编写相似于对复杂语句联合映射这些等同的代码,
		// 也许可以跨过上千行的代码。 ResultMap 的设计就是简单语句不需要明确的结果映射,而很多复杂语句确实需要描述它们 的关系。
		//
		// 你已经看到简单映射语句的示例了,但没有明确的 resultMap。比如:

		// 关联对象(关联的嵌套结果)
		// association
		// <association property="author" resultMap="blogAuthor"></association>

		// 集合的嵌套查询
		//

		// <collection property="contents"
		// ofType="com.yfairy.demo.mybatis3.BlogAuthor"
		// column="title" select="listBlogContent"></collection>
		// ofType 代表集合类型,column 代表传入的参数,

		// 缓存 , Cache

		// 缓存
		// MyBatis 包含一个非常强大的查询缓存特性,它可以非常方便地配置和定制。MyBatis 3
		// 中的缓存实现的很多改进都已经实现了,使得它更加强大而且易于配置。
		//
		// 默认情况下是没有开启缓存的,除了局部的 session 缓存,可以增强变现而且处理循环 依赖也是必须的。要开启二级缓存,你需要在你的
		// SQL 映射文件中添加一行:
		//
		// <cache/>
		// 字面上看就是这样。这个简单语句的效果如下:

		// 映射语句文件中的所有 select 语句将会被缓存。
		// 映射语句文件中的所有 insert,update 和 delete 语句会刷新缓存。
		// 缓存会使用 Least Recently Used(LRU,最近最少使用的)算法来收回。
		// 根据时间表(比如 no Flush Interval,没有刷新间隔), 缓存不会以任何时间顺序 来刷新。
		// 缓存会存储列表集合或对象(无论查询方法返回什么)的 1024 个引用。
		// 缓存会被视为是 read/write(可读/可写)的缓存,意味着对象检索不是共享的,而
		// 且可以安全地被调用者修改,而不干扰其他调用者或线程所做的潜在修改。

		// 提交事务
		sqlSession.commit();
		
		//关闭sqlsession
		sqlSession.close();

	}

	private static SqlSession openSqlSession() throws IOException {
		SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
		String mybatisConfigPath = "com/yfairy/demo/mybatis3/mybatis-config2.xml";
		Resource resource = new ClassPathResource(mybatisConfigPath);
		InputStream in = resource.getInputStream();
		SqlSessionFactory sqlSessionFactory = sessionFactoryBuilder.build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}

}
