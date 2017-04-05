package com.yfairy.demo.mybatis3;

import java.io.Serializable;

public class Student implements Serializable {
	private Integer id;

	private IntEnum enumId;

	private String name;

	private String sex;

	private Integer age;

	private String addName;

	private static final long serialVersionUID = 1L;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public IntEnum getEnumId() {
		return enumId;
	}

	public void setEnumId(IntEnum enumId) {
		this.enumId = enumId;
	}

	public String getAddName() {
		return addName;
	}

	public void setAddName(String addName) {
		this.addName = addName;
	}

}