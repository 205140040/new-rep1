package com.yfairy.demo.user.bean;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     * id 主键
     */
    private Integer id;

    /**
     * username 用户名
     */
    private String username;

    /**
     * password 密码
     */
    private String password;

    /**
     * sex 性别
     */
    private String sex;

    /**
     * age 年龄
     */
    private Integer age;

    /**
     * create_date 创建时间
     */
    private Date createDate;

    /**
     * yf_user
     *
     * @mbggenerated 2017-04-23 23:28:26
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     *
     * @return id 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 用户名
     *
     * @return username 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 密码
     *
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 性别
     *
     * @return sex 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 年龄
     *
     * @return age 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 创建时间
     *
     * @return create_date 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}