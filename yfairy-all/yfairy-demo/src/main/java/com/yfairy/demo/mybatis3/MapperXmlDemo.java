package com.yfairy.demo.mybatis3;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

		Map<String, Object> resultMap = blogTitleMapper.selectBlogTitleMap(1);
		System.out.println(resultMap);

		// 添加
		// useGeneratedKeys="true" keyProperty="id" 配置返回主键

		// <insert id="insert"
		// parameterType="com.yfairy.demo.mybatis3.BlogTitle"
		// useGeneratedKeys="true" keyProperty="id">

		BlogTitle insertBlogTitle = new BlogTitle();
		insertBlogTitle.setTitle("酱酱的博客" + new Date().toLocaleString());
		insertBlogTitle.setCreateTime(new Date());
		int result = blogTitleMapper.insert(insertBlogTitle);
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
			System.out.println(JSON.toJSONString(blogTitle));
		}

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

		// 提交事务
		// Cache
		sqlSession.commit();

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
