package com.yfairy.demo.user.bean;

import java.io.Serializable;

public class BlogAuthor implements Serializable {
    /**
     * id 
     */
    private Integer id;

    /**
     * author_name 作者
     */
    private String authorName;

    /**
     * yf_blog_author
     *
     * @mbggenerated 2017-04-23 23:28:26
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     *
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     *
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 作者
     *
     * @return author_name 作者
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * 作者
     *
     * @param authorName 作者
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? null : authorName.trim();
    }
}