package com.yfairy.common.utils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Man implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private Integer age;

	private String sex;

	private Date birthday;

	private BigDecimal money;

	private boolean marry;

	public Man() {
		super();
	}

	public Man(String name, Integer age, String sex, Date birthday, BigDecimal money, boolean marry) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.birthday = birthday;
		this.money = money;
		this.marry = marry;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public boolean isMarry() {
		return marry;
	}

	public void setMarry(boolean marry) {
		this.marry = marry;
	}

	@Override
	public String toString() {
		return "Man [name=" + name + ", age=" + age + ", sex=" + sex + ", birthday=" + birthday + ", money=" + money
				+ ", marry=" + marry + "]";
	}

}
