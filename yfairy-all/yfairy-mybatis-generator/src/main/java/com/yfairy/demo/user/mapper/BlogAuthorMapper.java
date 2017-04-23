package com.yfairy.demo.user.mapper;

import com.yfairy.demo.user.bean.BlogAuthor;

public interface BlogAuthorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogAuthor record);

    int insertSelective(BlogAuthor record);

    BlogAuthor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogAuthor record);

    int updateByPrimaryKey(BlogAuthor record);
}