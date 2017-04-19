package com.yfairy.demo.mybatis3;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

public class BlogTitleDao {

	private SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	private BlogTitleMapper blogTitleMapper;

	public void listBlogTitleWithCon(BlogTitle search) {
		System.err.println("BlogTitleDao use SqlSessionTemplate start...");
		BlogTitleMapper blogTitleMapper1 = sqlSessionTemplate.getMapper(BlogTitleMapper.class);
		Map<String, Object> res = blogTitleMapper1.selectBlogTitleMap(9);
		System.out.println(res);

		List<BlogTitle> blogTitles = blogTitleMapper1.listBlogTitleWithCon(search);
		System.err.println(JSON.toJSONString(blogTitles));
		System.err.println("BlogTitleDao use SqlSessionTemplate end...");
	}

	@Transactional
	public void listBlogTitleUseMapperFactoryBean(BlogTitle search) {
		System.err.println("BlogTitleDao use MapperFactoryBean start...");
		Map<String, Object> res = blogTitleMapper.selectBlogTitleMap(9);
		System.err.println(res);

		List<BlogTitle> blogTitles = blogTitleMapper.listBlogTitleWithCon(search);
		System.err.println(JSON.toJSONString(blogTitles));
		System.err.println("BlogTitleDao use MapperFactoryBean end...");

	}

	public void pageListBlogTitle(PageParam pageParam, BlogTitle search) {
		System.err.println("分页插件...");
		pageParam.setParam(search);
		List<BlogTitle> blogTitles = blogTitleMapper.pageListBlogTitleWithCon(pageParam);
		System.err.println(JSON.toJSONString(blogTitles));
		System.err.println("分页插件...");
	}

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	/*
	 * public BlogTitleMapper getBlogTitleMapper() { return blogTitleMapper; }
	 * 
	 * public void setBlogTitleMapper(BlogTitleMapper blogTitleMapper) {
	 * this.blogTitleMapper = blogTitleMapper; }
	 */

}
