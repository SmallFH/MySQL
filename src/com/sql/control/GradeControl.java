package com.sql.control;

import java.util.Vector;

import com.sql.dao.GradeDao;
import com.sql.model.Grade;

public class GradeControl {
	GradeDao gradeDao = new GradeDao();
	
	public int addGrade(Grade grade) {
		try {
			gradeDao.addGrade(grade);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	
	}
	
	public void deleteGrade(Grade grade) {
		gradeDao.deleteGrade(grade);
	}
	
	public void deleteOnePeopleGrade(String account) {
		gradeDao.deleteOnePeopleGrade(account);
	}
	
	
	public void updateGrade(Grade grade) {
		gradeDao.upateGrade(grade);
	}
	
	public Vector<Object> queryStuGrade(String id) {
		return gradeDao.queryStuGrade(id);
	}
	
	public Vector<Object> queryTeacherGrade(String teacher_name,String cou_name) {
		return gradeDao.queryTeachGrade(teacher_name,cou_name);
	}
	
}
