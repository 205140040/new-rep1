package com.yfairy.demo.spring_in_action_2;

public class Teacher {
	private String teacherNo;

	public String getTeacherNo() {
		return teacherNo;
	}

	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}

	@Override
	public String toString() {
		return "Teacher [teacherNo=" + teacherNo + "]";
	}

}
