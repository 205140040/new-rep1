package com.yfairy.demo.mybatis3;

import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.alibaba.fastjson.JSON;

public class SrqcMybatisChapter7 {

	public static void main(String[] args) {
		/**
		 * 第7章：插件(163/272)<br>
		 */
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtil.openSqlSession();
			BlogTitleMapper blogTitleMapper = sqlSession.getMapper(BlogTitleMapper.class);

			BlogTitle search = new BlogTitle();
			// search.setId(5);
			search.setIdList(Arrays.asList(1, 2, 5, 6));
			List<BlogTitle> sbt = blogTitleMapper.listBlogTitleWithCon(search);
			System.err.println(JSON.toJSONString(sbt));

			sqlSession.commit(); // 提交事务
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			if (null != sqlSession) {
				sqlSession.close();
			}
		}
	}

}
