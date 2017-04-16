package com.yfairy.demo.mybatis3;

import java.io.Serializable;

/**
 * 分页查询条件封装类
 * 
 * @author liuyijun
 * 
 * @param <T>
 */
public class PageSearch implements Serializable {

	private static final long serialVersionUID = 587754556498974978L;

	/**
	 * 这对easyui设计的分页请求时当前页变量
	 */

	private Integer page = 1;
	/**
	 * 这对easyui设计的分页请求时每页显示数量变量
	 */
	private Integer rows = 10;

	private int totalResult;

	@SuppressWarnings("unused")
	private int currentResult;

	private String sort;
	private String order;
	private Object entity;

	public int getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Object getEntity() {
		return entity;
	}

	public void setEntity(Object entity) {
		this.entity = entity;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;

	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;

	}

	public int getCurrentResult() {
		return (this.page - 1) * this.rows;
	}

	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}

}
