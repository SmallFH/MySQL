package com.sql.model;

public class Grade {
	private String cou_name,cou_teacher;
	private  long stu_id; 
	private Float grade;
	public String getCou_name() {
		return cou_name;
	}
	public void setCou_name(String cou_name) {
		this.cou_name = cou_name;
	}
	public String getCou_teacher() {
		return cou_teacher;
	}
	public void setCou_teacher(String cou_teacher) {
		this.cou_teacher = cou_teacher;
	}
	public long getStu_id() {
		return stu_id;
	}
	public void setStu_id(long stu_id) {
		this.stu_id = stu_id;
	}
	public Float getGrade() {
		return grade;
	}
	public void setGrade(Float grade) {
		this.grade = grade;
	}


}
