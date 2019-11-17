package com.sql.dao;

import java.util.Vector;

import com.sql.model.ChooseCourse;
import com.sql.util.ChangeSqlUtil;

public class ChooseDao {
	ChangeSqlUtil changeSqlUtil = new ChangeSqlUtil();
	
	public void addChooseCourse(ChooseCourse chooseCourse) {
		changeSqlUtil.write("insert into course_choose values(?,?)", chooseCourse.getStu_id(),chooseCourse.getCou_id());
	}
	
	public void deleteChooseCourse(ChooseCourse chooseCourse) {
		changeSqlUtil.write("delete from course_choose where stu_id=? and cou_id=?", chooseCourse.getStu_id(),chooseCourse.getCou_id());
	}
	
	public Vector<Object> queryChooseCourse(long l) {
		return changeSqlUtil.query("select * from course_choose where stu_id=?", l );
	}
	
	public Vector<Object> queryAllChooseCourse() {
		return changeSqlUtil.query("select * from course_choose");
	}
	
	public Vector<Object> querySelectOneCourseNumber(int courseID){
		return changeSqlUtil.query("select count(*) from course_choose where cou_id=?", courseID );
	}
	
	
	public Vector<Object> queryChoosedCourse(String stuAccount) {
		return  changeSqlUtil.query("select" + " institute,id,cou_name,hours,credit,teacher,stu_class,time,location,test,course_stuNumber"
				+ " from course_info,course_class" + " where course_info.id=course_class.cou_id"
				+ " and course_info.id " + "in (select course_choose.cou_id from course_choose where stu_id=?)",
				stuAccount);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void batchAdd() {
		changeSqlUtil.write("insert into info_stu values('动物科技学院','动物医学','1','动医181','20180724111','计划还发','1','1999-08-05','15516515122')");
	}
	
	
	
//	
//	public static void main(String[] args) {
//		new ChooseDao().batchAdd();
//	}

}
