package com.yfairy.demo.mybatis3;

import java.util.List;
import java.util.Map;

public interface BlogTitleMapper {

	Map<String, Object> selectBlogTitleMap(Integer id);

	Integer insert(BlogTitle blogTitle);

	Integer updateById(BlogTitle blogTitle);

	List<BlogTitle> listBlogTitle(String orderbyStr);

	List<BlogTitle> listBlogTitleWithCon(BlogTitle search);

	List<BlogTitle> pageListBlogTitleWithCon(PageParam pageParam);

}
