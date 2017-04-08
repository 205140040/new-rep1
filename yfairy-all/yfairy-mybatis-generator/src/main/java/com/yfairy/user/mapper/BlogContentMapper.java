package com.yfairy.user.mapper;

import com.yfairy.user.bean.BlogContent;

public interface BlogContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogContent record);

    int insertSelective(BlogContent record);

    BlogContent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogContent record);

    int updateByPrimaryKey(BlogContent record);
}