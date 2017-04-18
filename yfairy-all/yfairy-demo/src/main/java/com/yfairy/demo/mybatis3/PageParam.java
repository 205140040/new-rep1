package com.yfairy.demo.mybatis3;

import java.io.Serializable;

public class PageParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 当前页码
	 */
	private Integer page;
	/**
	 * 每页显示的数量
	 */
	private Integer pageSize;

	/**
	 * datatables 第一条数据的起始位置，比如0代表第一条数据
	 */
	private Integer start;
	/**
	 * datatables中每页显示的数量
	 */
	private Integer length;

	/**
	 * 记录总数
	 */
	private Integer total;

	/**
	 * 查询参数对象
	 */
	private Object param;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Object getParam() {
		return param;
	}

	public void setParam(Object param) {
		this.param = param;
	}

}
