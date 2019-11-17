package com.sql.dao;

import java.util.Vector;

import com.sql.model.Grade;
import com.sql.util.ChangeSqlUtil;

public class GradeDao {
	ChangeSqlUtil changeSqlUtil = new ChangeSqlUtil();
	
	public void addGrade(Grade grade) {
		changeSqlUtil.write("insert into grade values(?,?,?,?)", 
				grade.getStu_id(),
				grade.getCou_name(),
				grade.getCou_teacher(),
				grade.getGrade());
	}
	
	public void deleteGrade(Grade grade) {
		changeSqlUtil.write("delete from grade where stu_id=? and cou_name=?", 
				grade.getStu_id(),
				grade.getCou_name());
	}
	public void deleteOnePeopleGrade(String account) {
		changeSqlUtil.write("DELETE FROM grade WHERE stu_id=?",account);
	}
	
//	public static void main(String[] args) {
//		Grade grade = new Grade();
//		grade.setStu_id(new Long("20180724105"));
//		grade.setCou_name("解剖学");
//		new GradeDao().deleteGrade(grade);
//	}
	
	public void upateGrade(Grade grade) {
		changeSqlUtil.write("update grade set greade=? where stu_id=? and cou_name=?", 
				grade.getStu_id(),
				grade.getCou_name());
	}
	
	public Vector<Object> queryStuGrade(String id) {
		return changeSqlUtil.query("select cou_name,cou_teacher,grade from grade where stu_id=?",id);
	}
	
	public Vector<Object> queryTeachGrade(String teacher_name,String cou_name) {
		return changeSqlUtil.query("select "
				+ "stu_id,class,stu_name,school.grade.grade "
				+ "from grade,info_stu "
				+ "where school.grade.stu_id=school.info_stu.id "
				+ "and school.grade.cou_teacher=?"
				+ " and school.grade.cou_name=?"
				+"order by info_stu.id", 
				teacher_name,cou_name);
	}
	
	public Vector<Object> queryStuChooseTeacher(long stuNumber,String teacher){
		changeSqlUtil.query("", teacher,stuNumber);
		
		
		
		
		return null;
		
	}
	
//	public static void main(String[] args) {
//		Vector<Object> a =new GradeDao().queryTeachGrade("柳东阳","解剖学");
//		System.out.println(a);
//	}
	
}
