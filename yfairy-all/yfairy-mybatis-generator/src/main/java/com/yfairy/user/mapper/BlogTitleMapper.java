package com.yfairy.user.mapper;

import com.yfairy.user.bean.BlogTitle;

public interface BlogTitleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogTitle record);

    int insertSelective(BlogTitle record);

    BlogTitle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogTitle record);

    int updateByPrimaryKey(BlogTitle record);
}