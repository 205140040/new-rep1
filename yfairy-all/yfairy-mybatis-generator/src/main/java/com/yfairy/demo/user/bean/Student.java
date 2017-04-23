package com.yfairy.demo.user.bean;

import java.io.Serializable;

public class Student implements Serializable {
    /**
     * id 
     */
    private Integer id;

    /**
     * name 名称
     */
    private String name;

    /**
     * sex 性别
     */
    private String sex;

    /**
     * age 年龄
     */
    private Integer age;

    /**
     * yf_student
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
     * 名称
     *
     * @return name 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
}