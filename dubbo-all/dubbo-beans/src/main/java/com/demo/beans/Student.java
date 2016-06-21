package com.demo.beans;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
	/**
	 * @author admin 2016年6月21日
	 * @description
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private String sex;

	private Date bir;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public Date getBir() {
		return bir;
	}

	public void setBir(Date bir) {
		this.bir = bir;
	}

}