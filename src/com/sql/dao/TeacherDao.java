package com.sql.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.sql.model.Student;
import com.sql.model.Teacher;
import com.sql.util.ChangeSqlUtil;
import com.sql.util.GetMySQLUtil;

public class TeacherDao {
	ChangeSqlUtil changeSqlUtil = new ChangeSqlUtil();
	
	public boolean addTeacher(Teacher teacher) {
		return changeSqlUtil.write("REPLACE INTO info_teacher VALUE(?,?,?,?,?,?,?,?)",
				teacher.getInstitutue(),
				teacher.getMajor(),
				teacher.getId(),
				teacher.getTeaching(),
				teacher.getName(),
				teacher.getSex(),
				teacher.getBirthday(),
				teacher.getPhone()
				);
	}
	
	public void deleteTeacher(String id){
		changeSqlUtil.write("delete from info_teacher where id=?", id);
	}
	
	public void updateTeacherInfo(Teacher teacher){
		changeSqlUtil.write("update info_teacher set instutue=?,major=?,teaching=?,teach_name=?,sex=?,birthday=?,phone=? where id=? ", 
				teacher.getInstitutue(),
				teacher.getMajor(),
				teacher.getTeaching(),
				teacher.getName(),
				teacher.getSex(),
				teacher.getBirthday(),
				teacher.getPhone(),
				teacher.getId());
	}
	
	public Vector<Object> queryOneTeacher(String id) {
		return changeSqlUtil.query("select * from info_teacher where id=?", id);
	}
	
	public Vector<Object> queryAllTeacher() {
		return changeSqlUtil.query("select * from info_teacher");
	}
	
	

}
