package com.yfairy.demo.spring_in_action_2;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Student extends People {

	public Student() {
		super();
	}

	public Student(Teacher teacher, String classNo) {
		super();
		this.teacher = teacher;
		this.classNo = classNo;
	}

	private Teacher teacher;

	private Teacher teacher2;

	private String classNo;

	private List<Teacher> teachers;

	private Set<String> kechengSet;

	private Map<String, String> scoreMap;

	private Properties properties;

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getClassNo() {
		return classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Set<String> getKechengSet() {
		return kechengSet;
	}

	public void setKechengSet(Set<String> kechengSet) {
		this.kechengSet = kechengSet;
	}

	public Map<String, String> getScoreMap() {
		return scoreMap;
	}

	public void setScoreMap(Map<String, String> scoreMap) {
		this.scoreMap = scoreMap;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public Teacher getTeacher2() {
		return teacher2;
	}

	public void setTeacher2(Teacher teacher2) {
		this.teacher2 = teacher2;
	}

	@Override
	public String toString() {
		return "Student [teacher=" + teacher + ", teacher2=" + teacher2 + ", classNo=" + classNo + ", teachers="
				+ teachers + ", kechengSet=" + kechengSet + ", scoreMap=" + scoreMap + ", properties=" + properties
				+ "]";
	}

}
