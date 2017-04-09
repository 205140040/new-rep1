package com.yfairy.demo.mybatis3;

import java.io.Serializable;

public class BlogAuthor implements Serializable {
    private Integer id;

    private String authorName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? null : authorName.trim();
    }
}