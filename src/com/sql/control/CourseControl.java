package com.sql.control;

import java.util.Vector;

import com.sql.dao.CourseDao;
import com.sql.model.Course;

public class CourseControl {
	CourseDao courseDao = new CourseDao();
	
	public void addCourseInfo(Course course) {
		courseDao.addCourseInfo(course);
	}
	
	public void addClassCourse(Course course) {
		courseDao.addClassCourse(course);
	}
	
	
	/**
	 * for循环遍历结果进行改值
	 * @param stuclass
	 * @return
	 */
	@SuppressWarnings({ "unchecked"})
	public Vector<Object> queryStudentCourse(String stuclass) {
		Vector<Object> a = courseDao.queryStuClassCourse(stuclass);
		Vector<Object>[] b = new Vector[a.size()];
		Vector<Object>  rowData = new Vector<>();
		for (int i = 0; i < a.size(); i++) {
			b[i] = (Vector<Object>) a.get(i);
			switch ((String)b[i].get(9)) {
			case "0": b[i].set(9, "考查"); break;
			case "1": b[i].set(9, "考试"); break;
			}
			rowData.add(b[i]);
		}
		return rowData;
	}
	public Vector<Object> queryCourseInfo() {
		return courseDao.queryAllCourseInfo();
	}
	
	public Vector<Object> queryCourseClass() {
		return courseDao.queryAllCourseClass();
	}
	
	@SuppressWarnings("unchecked")
	public Vector<Object> queryElectiveCourse(){
		Vector<Object> a = courseDao.queryElectiveCourse();
		Vector<Object>[] b = new Vector[a.size()];
		Vector<Object>  rowData = new Vector<>();
		for (int i = 0; i < a.size(); i++) {
			b[i] = (Vector<Object>) a.get(i);
			switch ((String)b[i].get(9)) {
			case "0": b[i].set(9, "考查"); break;
			case "1": b[i].set(9, "考试"); break;
			}
			rowData.add(b[i]);
		}
		return rowData;
	}
	
	@SuppressWarnings("unchecked")
	public Vector<Object> queryTeacherCourse(String teacherName){
		Vector<Object> a = courseDao.queryTeacherCourse(teacherName);
		Vector<Object>[] b = new Vector[a.size()];
		Vector<Object>  rowData = new Vector<>();
		for (int i = 0; i < a.size(); i++) {
			b[i] = (Vector<Object>) a.get(i);
			switch ((String)b[i].get(3)) {
			case "0": b[i].set(3, "考查"); break;
			case "1": b[i].set(3, "考试"); break;
			}
			rowData.add(b[i]);
		}
		return rowData;
	}
	
}
