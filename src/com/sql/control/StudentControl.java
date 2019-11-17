package com.sql.control;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;

import com.sql.dao.StudentDao;
import com.sql.model.Student;
import com.sql.util.ChangeSqlUtil;

public class StudentControl {
	private StudentDao studentDao = new StudentDao();
	Student student = new Student();
	ChangeSqlUtil change = new ChangeSqlUtil();

	public boolean addStu(){
		if (studentDao.addStudent(student)) {
			return true;
		}else {
			return false;
		}
	}
	
	public void deleteStu(String id) {
		studentDao.deleteStudent(id);
	}

	public void updateStudentInfo(Student student) {
		studentDao.updateStudentInfo(student);
	}

	public Vector<Object> queryOneStudent(String id) {
		@SuppressWarnings("unchecked")
		Vector<Object> stu = (Vector<Object>) studentDao.queryOneStudent(id).get(0);
		switch ((String)stu.get(2)) {
		case "1": stu.set(2, "大一"); break;
		case "2": stu.set(2, "大二"); break;
		case "3": stu.set(2, "大三"); break;
		case "4": stu.set(2, "大四"); break;
		}
		switch ((String)stu.get(6)) {
		case "0": stu.set(6, "女"); break;
		case "1": stu.set(6, "男"); break;
		}
		stu.set(7, change.toStringDate((Timestamp) stu.get(7)));
		Vector<Object>  rowData = new Vector<>();
		rowData.add(stu);
		return rowData;
	}

	public int registerStu(String[] stu) {
		int a = 9, grade = 1, sex = 2;
		ChangeSqlUtil change = new ChangeSqlUtil();
		Date birthday = change.toDate(stu[5]);
		String[] egname = { "e.g. 动物科技学院", "e.g. 动物医学", "e.g. 动医181", "e.g. 11位数字", "e.g. 张三", "e.g. XXXX-XX-XX",
				"e.g. 11位数字" };
		switch (stu[7]) {
		case "大二": grade = 2; break;
		case "大三": grade = 3; break;
		case "大四": grade = 4; break;
		}
		switch (stu[8]) {
		case "女": sex = 1; break;
		}
		for (int i = 0; i < egname.length; i++) {
			if (stu[i].equals(egname[i])) {
				return i;
			}
		}
		try {
			student.setId(new Long(stu[3]));
		} catch (Exception e) {
			return 33;
		}
		if (birthday ==  null) {
			return 55;
		}
		student.setBirthday(birthday);
		student.setName(stu[4]);
		student.setGrade(grade);
		student.setSex(sex);
		student.setInstitute(stu[0]);
		student.setMajor(stu[1]);
		student.setStuclass(stu[2]);
		student.setPhone(stu[6]);
		return a;
	
	}
	
	public void updateStudentInfo(String[] newInfo) {
		int sex = 0,grade = 0;
		for (int i = 0; i < newInfo.length; i++) {
			System.out.println(i+" / " + newInfo[i]);
		}
		switch (newInfo[6]) {
		case "男":
			sex = 2;
			break;
		case "女":
			sex = 1;
			break;
		}
		
		switch (newInfo[2]) {
		case "大一":
			grade = 1;
			break;
		case "大二":
			grade = 2;
			break;
		case "大三":
			grade = 3;
			break;
		case "大四":
			grade = 4;
			break;

		}
		
		Long account = Long.parseLong(newInfo[4]);
		
		ChangeSqlUtil change = new ChangeSqlUtil();
		Date birthday = change.toDate(newInfo[7]);
		
		student.setInstitute(newInfo[0]);
		student.setMajor(newInfo[1]);
		student.setGrade(grade);
		student.setStuclass(newInfo[3]);
		student.setId(account);
		student.setName(newInfo[5]);
		student.setSex(sex);
		student.setBirthday(birthday);
		student.setPhone(newInfo[8]);
		studentDao.updateStudentInfo(student);
	}
	
	

}
