package com.sql.dao;

import java.util.Vector;

import com.sql.model.Course;
import com.sql.util.ChangeSqlUtil;

public class CourseDao {
	ChangeSqlUtil changeSqlUtil = new ChangeSqlUtil();

	public void addCourseInfo(Course course) {
		changeSqlUtil.write("insert into course_info values(?,?,?,?,?)", course.getInfo_institute(),
				course.getInfo_id(), course.getInfo_name(), course.getInfo_hours(), course.getInfo_credit());
	}

	public void addClassCourse(Course course) {
		changeSqlUtil.write("insert into course_class values(?,?,?,?,?,?)", course.getClass_couid(),
				course.getClass_teacher(), course.getClass_stuclass(), course.getClass_time(),
				course.getClass_location(), course.getClass_test());
	}

	public void delectCourseInfo(int id) {
		changeSqlUtil.write("delete from course_info where id=?", id);
	}

	public void deleteCourseClass(String coutime, String location) {
		changeSqlUtil.write("delete from course_class where time=? and location=? ", coutime, location);
	}

	public void updateCourseInfo(Course course) {
		changeSqlUtil.write("update info_stu set institute=?,cou_name=?,hours=?,credit=? where id=?",
				course.getInfo_institute(), course.getInfo_name(), course.getInfo_hours(), course.getInfo_credit(),
				course.getInfo_id());
	}

	public void updateClassCourse(Course course) {
		/**
		 * //不知道该从哪个字段来查询，用来更正新的数据
		 * 
		 */
		changeSqlUtil.write("update course_class set cou_id=?,teacher=?,stu_class=?,time=?,location=?,test=? where ",
				course.getClass_couid(), course.getClass_teacher(), course.getClass_stuclass(), course.getClass_time(),
				course.getClass_location(), course.getClass_test());
	}

	public Vector<Object> queryStuClassCourse(String stuclass) {
		return changeSqlUtil.query("select " + "institute,id,cou_name,hours,credit,teacher,stu_class,time,location,test,course_stuNumber"
				+ " from course_info,course_class " + "where course_info.id=course_class.cou_id "
				+ "and stu_class regexp ?", stuclass);
	}
	
	public Vector<Object> queryTeacherCourse(String teacherName){
		return changeSqlUtil.query("select stu_class,course_class.time,location,test from course_class where teacher=? ", teacherName);
		
	}

	public Vector<Object> queryAllCourseInfo() {
		return changeSqlUtil.query("select " + "institute,id,cou_name,hours,credit" + " from course_info");
	}

	public Vector<Object> queryElectiveCourse() {
		return changeSqlUtil.query("select" + " institute,id,cou_name,hours,credit,teacher,stu_class,time,location,test,course_stuNumber"
				+ " from course_info,course_class" + " where course_info.id=course_class.cou_id"
				+ " and course_info.id " + " in (select course_info.id from course_info where course_info.elective=2)");
	}
	

	public Vector<Object> queryAllCourseClass() {
		return changeSqlUtil.query("select * from course_class");
	}

}
