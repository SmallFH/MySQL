package com.sql.control;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;
import com.sql.dao.TeacherDao;
import com.sql.model.Teacher;
import com.sql.util.ChangeSqlUtil;


public class TeacherControl {
	private TeacherDao teacherDao = new TeacherDao();
	ChangeSqlUtil change = new ChangeSqlUtil();
	Teacher teacher = new Teacher();

	public boolean addTeacher() {
		if (teacherDao.addTeacher(teacher)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public void deleteTeacher(String id) {
		teacherDao.deleteTeacher(id);
	}
	
	public void updateTeacherInfo(String[] newInfo) {
		int sex = 0;

		for (int i = 0; i < newInfo.length; i++) {
			System.out.println(i+" / " + newInfo[i]);
		}
		switch (newInfo[5]) {
		case "男":
			sex = 2;
			break;
		case "女":
			sex = 1;
			break;
		}
		Long account = Long.parseLong(newInfo[2]);
		
		Date birthday = change.toDate(newInfo[6]);
		teacher.setInstitutue(newInfo[0]);
		teacher.setMajor(newInfo[1]);
		teacher.setId(account);
		teacher.setTeaching(newInfo[3]);
		teacher.setName(newInfo[4]);
		teacher.setSex(sex);
		teacher.setBirthday(birthday);
		teacher.setPhone(newInfo[7]);
		teacherDao.updateTeacherInfo(teacher);
		
	}
	
	public Vector<Object> queryOneTeacher(String teachAccount) {
		@SuppressWarnings("unchecked")
		Vector<Object> teach = (Vector<Object>) teacherDao.queryOneTeacher(teachAccount).get(0);
		switch ((String)teach.get(5)) {
		case "0": teach.set(5, "女"); break;
		case "1": teach.set(5, "男"); break;
		}
		teach.set(6, change.toStringDate((Timestamp) teach.get(6)));
		Vector<Object>  rowData = new Vector<>();
		rowData.add(teach);
		return rowData;
	}
	
	public Vector<Object> queryAllTeacher() {
		return teacherDao.queryAllTeacher();
	}
	
	public int addTea(String[] tea) {
		int a = 9, sex = 2;
		String[] egname = {"e.g. 动物科技学院","e.g. 动物医学","e.g. 11位数字",
				"e.g. 家畜解剖学","e.g. 张三","e.g. XXXX-XX-XX",
				"e.g. 11位数字"};
		Date birthday = change.toDate(tea[5]);
		switch (tea[7]) {
		case "女":
			sex = 1;
			break;
		}
		for (int i = 0; i < egname.length; i++) {
			if (tea[i].equals(egname[i])) {
				return a = i;
			}
		}
		try {
			teacher.setId(new Long(tea[2]));
		} catch (Exception e) {
			return a=22;
		}
		if (birthday ==  null) {
			return a = 55;
		}
		teacher.setInstitutue(tea[0]);
		teacher.setMajor(tea[1]);
		teacher.setTeaching(tea[3]);
		teacher.setName(tea[4]);
		teacher.setBirthday(birthday);
		teacher.setPhone(tea[6]);
		teacher.setSex(sex);
		return a;
		
	}

}
