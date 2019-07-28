package com.sql.dao;

import java.util.Vector;

import com.sql.model.Student;
import com.sql.util.ChangeSqlUtil;

public class StudentDao {
	ChangeSqlUtil changeSqlUtil = new ChangeSqlUtil();
	
	public boolean addStudent(Student student){
		return changeSqlUtil.write("REPLACE INTO info_stu VALUE(?,?,?,?,?,?,?,?,?)", 
				student.getInstitute(),
				student.getMajor(),
				student.getGrade(),
				student.getStuclass(),
				student.getId(),
				student.getName(),
				student.getSex(),
				student.getBirthday(),
				student.getPhone());
	}
	
	public void deleteStudent(String id){
		changeSqlUtil.write("delete from info_stu where id=?", id);
	}
	
	public void updateStudentInfo(Student student){
		changeSqlUtil.write("update info_stu set institute=?,major=?,grade=?,class=?,stu_name=?,sex=?,birthday=?,phone=? where id=? ", 
				student.getInstitute(),
				student.getMajor(),
				student.getGrade(),
				student.getStuclass(),
				student.getName(),
				student.getSex(),
				student.getBirthday(),
				student.getPhone(),
				student.getId());
	}
	
	public Vector<Object> queryOneStudent(String id){
		return changeSqlUtil.query("select * from info_stu where id=?", id);
	}
	
	
	
}
