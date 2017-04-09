package com.yfairy.user.mapper;

import com.yfairy.user.bean.BlogAuthor;

public interface BlogAuthorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogAuthor record);

    int insertSelective(BlogAuthor record);

    BlogAuthor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogAuthor record);

    int updateByPrimaryKey(BlogAuthor record);
}