package com.sql.dao;

import java.util.Vector;
import com.sql.util.ChangeSqlUtil;

public class AdminDao {
	ChangeSqlUtil changeSqlUtil = new ChangeSqlUtil();
	String content;
	String table;
	String field;
	String condition;
	/**
	 * ��ҳ��ѯ
	 * table ��ѯ�ı�field ��ѯ���ֶΣ�condition ��ѯ������
	 * @param tableNumber
	 */
	
	public AdminDao(int tableNumber) {
		//0����ѧ��
		if (tableNumber == 0) {
			table = "info_stu";
			field = "institute,major,grade,class,id,stu_name,sex,birthday,phone";
			condition = "concat("+field+")";
		//1�����ʦ
		}else if (tableNumber == 1) {
			table = "info_teacher";
			field = "instutue,major,id,teaching,teach_name,sex,birthday,phone";
			condition = "concat("+field+")";
		//2����ɼ�
		}else if (tableNumber == 2) {
			table = "info_stu,school.grade";
			field = "institute,major,class,id,stu_name,cou_name,cou_teacher,school.grade.grade";
			condition = " school.grade.stu_id=info_stu.id and concat("+field+")";
		//3����γ�
		}else if (tableNumber == 3) {
			table = "course_info left join course_class " + 
					"on course_info.id = course_class.cou_id";
			field = "id,institute,cou_name,hours,credit,elective,"
					+ "teacher,stu_class,course_class.time,location,test";
			condition = "concat("+field+")";
		}
	}
	
	public int queryAllNumber(String queryKey) {
		@SuppressWarnings("unchecked")
		Vector<Object> a = (Vector<Object>) changeSqlUtil.query("select count(*) from "+table+ 
				" where " + condition + "like \"%\"?\"%\" ",queryKey ).get(0);
		int c = Integer.parseInt(String.valueOf(a.get(0)));
		return c;
	}
	
	public Vector<Object> queryAllInfo(String queryKey,int page,int pageSize){
		Vector<Object> a = changeSqlUtil.query("select "+ field +" from " + table + 
				" where "+condition+ "like \"%\" ? \"%\" " + 
				"order by id asc limit ?,?",queryKey,(page-1)*pageSize,pageSize);
		return a;
	}
	
	public void addInfo(String[]...params) {
		changeSqlUtil.writeBatch("REPLACE INTO info_stu VALUES(?,?,?,?,?,?,?,?,?)",params[0],params[1],params[2],params[3],params[4],params[5],params[6],params[7],params[8]);
	}
	
	
	public static void main(String[] args) {
		new AdminDao(0).addInfo();
	}
	
//	public static void main(String[] args) {
//		AdminDao ad = new AdminDao(2);
//		System.out.println(ad.queryAllNumber(""));
//		System.out.println(ad.queryAllInfo("", 1, 2));
//		
//	}
}
