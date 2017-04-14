package com.yfairy.demo.mybatis3;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BlogTitle implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private List<Integer> idList;

	private String title;

	private Date createTime;

	private Integer authorId;

	private BlogAuthor author;

	private List<BlogContent> contents;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public BlogAuthor getAuthor() {
		return author;
	}

	public void setAuthor(BlogAuthor author) {
		this.author = author;
	}

	public List<BlogContent> getContents() {
		return contents;
	}

	public void setContents(List<BlogContent> contents) {
		this.contents = contents;
	}

	public List<Integer> getIdList() {
		return idList;
	}

	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}

}