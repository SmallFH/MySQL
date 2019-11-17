package com.sql.control;

import java.util.Vector;

import com.sql.dao.ChooseDao;
import com.sql.model.ChooseCourse;

public class ChooseCourseControl {
	ChooseDao chooseDao = new ChooseDao();

	@SuppressWarnings("unchecked")
	public int addChooseCourse(ChooseCourse chooseCourse, int maxNumber) {
		int a = 0;
			Vector<Object> b = (Vector<Object>) chooseDao.queryChooseCourse(chooseCourse.getStu_id());
			Vector<Object> c = (Vector<Object>) chooseDao.querySelectOneCourseNumber(chooseCourse.getCou_id()).get(0);
			long e = (long) c.get(0);
			if (e >= maxNumber) {
				return a = 99;
			}else 
			if (b.size() == 0) {
				chooseDao.addChooseCourse(chooseCourse);
			}else
			if (b.size() > 0 && b.size() <= 2) {
			Vector<Object>[] d = new Vector[b.size()];
			for (int i = 0; i < b.size(); i++) {
				d[i] = (Vector<Object>) b.get(i);
				if (d[i].get(1).equals(chooseCourse.getCou_id())) {
					return a = 11;//已经选过该课程了
				}else {
					a = 12; 
				}
			}
			if (a == 12) {
				chooseDao.addChooseCourse(chooseCourse);
				return a = 9;
			}
			}else {
				return a=13;
			}
		
		return a;
	}

	public void deleteChooseCourse(ChooseCourse chooseCourse) {
		chooseDao.deleteChooseCourse(chooseCourse);
	}

	@SuppressWarnings("unchecked")
	public Vector<Object> queryChoosedCourse(String stu_id) {
		Vector<Object> a = chooseDao.queryChoosedCourse(stu_id);
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

	public Vector<Object> queryAllChooseCourse() {
		return chooseDao.queryAllChooseCourse();
	}

}
