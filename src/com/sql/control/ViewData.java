package com.sql.control;

import java.util.ArrayList;

import com.sql.model.DataMap;

public class ViewData {
	static DataMap dataMap = new DataMap();
	
	public static DataMap enterView() {
		dataMap.setJf_name("登录");
		dataMap.setJf_size(new int[] {400, 400 });
		dataMap.setJb_name(new String[] { "登录", "注册" });
		dataMap.setJb_parameter(new int[] { 2, 100, 170, 70, 40 });
		dataMap.setJl_name(new String[] { "用户名：", "密     码："});
		dataMap.setJl_parameter(new int[] { 2, 100, 85, 80, 30 });
		dataMap.setJtf_parameter(new int[] { 1, 160, 85, 150, 30 });
		dataMap.setJpf_parameter(new int[] { 1, 160, 115, 150, 30 });
		dataMap.setJcb_name(new String[] { "学生", "教师", "管理员" });
		dataMap.setJcb_parameter(new int[] { 3, 240, 170, 70, 40 });
		return dataMap;
	}
	
	public static DataMap StudentPanel() {
		dataMap.setJl_name(new String[] {"年级：","性别：","院系：",
				"专业：","班级：","学号：","姓名：","生日：",
				"电话：","密保问题：","密保答案：","密码：","确认密码："});
		dataMap.setJl_parameter(new int[] { 13,50,50,70,40 });
		dataMap.setJcb_name(new String[] { "大一", "大二", "大三" ,"大四"});
		dataMap.setJcb_parameter(new int[] { 4, 110, 55, 60, 30 });
		dataMap.setJrb_parameter(new int[] {2,105,90,40,40});
		dataMap.setJrb_name(new String[] {"男","女"});
		dataMap.setJtf_parameter(new int[] { 9,110,135,150,30 });
		dataMap.setJpf_parameter(new int[] { 2,110,495,150,30 });
		dataMap.setJf_name("注册");
		dataMap.setJf_size(new int[] { 1000, 700 });
		return dataMap;
	}
	
	public static DataMap TeacherPanel() {
		dataMap.setJl_name(new String[] {"性别：","院系：","专业：","职工号：",
				"教授科目：","姓名：","生日：","电话：","密保问题：",
				"密保答案：","密码：","确认密码："});
		dataMap.setJl_parameter(new int[] { 12,50,50,70,40 });
		dataMap.setJrb_name(new String[] {"男","女"});
		dataMap.setJrb_parameter(new int[] {2,105,50,40,40});
		dataMap.setJtf_parameter(new int[] { 9,110,95,150,30 });
		dataMap.setJpf_parameter(new int[] { 2,110,455,150,30 });
		dataMap.setJf_name("注册");
		dataMap.setJf_size(new int[] { 1000, 700 });
		return dataMap;
	}
	
	public static DataMap RegisterView() {
		dataMap.setJf_name("注册");
		dataMap.setJf_size(new int[] {1000, 700 });
		dataMap.setJb_name(new String[] { "提交", "退出" });
		dataMap.setJb_parameter(new int[] { 2, 100, 170, 70, 40 });
		dataMap.setJrb_parameter(new int[] {2,100,100,40,40});
		dataMap.setJrb_name(new String[] {"学生","教师"});
		return dataMap;
	}
	
	public static DataMap StuView() {
		String[] jmu = { "个人信息", "课程信息", "成绩信息", "密码信息"};
		String[] jmi1 = {"查看个人信息"};
		String[] jmi2 = { "查看班级课程", "可选课程", "查看已选课程或退课"};
		String[] jmi3 = {"查看成绩"};
		String[] jmi4 = {"修改密码"};
		ArrayList<String[]> arrayList = new ArrayList<>();
		arrayList.add(jmu);
		arrayList.add(jmi1);
		arrayList.add(jmi2);
		arrayList.add(jmi3);
		arrayList.add(jmi4);
		dataMap.setJf_name("学生端");
		dataMap.setJf_size(new int[] {1000, 700 });
		dataMap.setArrayList(arrayList);
		return dataMap;
	}
	public static DataMap ChoosePanel() {
		dataMap.setJf_name("选课");
		dataMap.setJf_size(new int[] {1000, 700 });
		dataMap.setJl_name(new String[] { "课程编号："});
		dataMap.setJl_parameter(new int[] { 1, 250, 10, 80, 30 });
		dataMap.setJtf_parameter(new int[] { 1,350,10,150,30 });
		dataMap.setJb_name(new String[]{"选课"});
		dataMap.setJb_parameter(new int[] {1,550,10,100,30});
		return dataMap;
		
	}
	
	public static DataMap TeachView() {
		String[] jmu = { "个人信息", "成绩信息", "上课时间",  "密码管理"};
		String[] jmi1 = {"查看个人信息"};
		String[] jmi2 = { "查看所带班级学生成绩信息", "录入所带班级学生成绩"};
		String[] jmi3 = {"查看课程"};
		String[] jmi4 = {"修改密码"};
		ArrayList<String[]> arrayList = new ArrayList<>();
		arrayList.add(jmu);
		arrayList.add(jmi1);
		arrayList.add(jmi2);
		arrayList.add(jmi3);
		arrayList.add(jmi4);
		dataMap.setJf_name("教师端");
		dataMap.setJf_size(new int[] {1000, 700 });
		dataMap.setArrayList(arrayList);
		return dataMap;
	}
	
	public static DataMap AddGradePanel() {
		dataMap.setJf_name("教师端");
		dataMap.setJf_size(new int[] {1000, 700 });
		dataMap.setJl_name(new String[] { "学号：","成绩："});
		dataMap.setJl_parameter(new int[] { 2, 250, 10, 80, 30 });
		dataMap.setJb_name(new String[]{"录入"});
		dataMap.setJb_parameter(new int[] {1,550,10,100,30});
		dataMap.setJtf_parameter(new int[] { 2,110,135,150,30 });
		return dataMap;
	}
	
	public static DataMap ChangePass() {
		dataMap.setJf_name("修改密码");
		dataMap.setJf_size(new int[] {1000, 700 });
		dataMap.setJl_name(new String[] { "密保问题：","密保答案：","新密码：","确认新密码："});
		dataMap.setJl_parameter(new int[] { 4, 250, 10, 80, 30 });
		dataMap.setJb_name(new String[]{"修改", "忘记密保答案？"});
		dataMap.setJb_parameter(new int[] {2,550,10,100,30});
		dataMap.setJtf_parameter(new int[] { 1,110,135,150,30 });
		dataMap.setJpf_parameter(new int[] { 2,110,170,150,30 });
		return dataMap;
	}
	
	
	
	public static DataMap RestPassWord() {
		dataMap.setJf_name("重置密码");
		dataMap.setJf_size(new int[] {1000, 700 });
		dataMap.setJl_name(new String[] { "重置密码账号：","管理员密码：","用户身份："});
		dataMap.setJl_parameter(new int[] { 3, 250, 10, 80, 30 });
		dataMap.setJb_name(new String[]{"重置"});
		dataMap.setJb_parameter(new int[] {1,550,10,100,30});
		dataMap.setJtf_parameter(new int[] { 1,110,135,150,30 });
		dataMap.setJpf_parameter(new int[] { 1,110,170,150,30 });
		dataMap.setJcb_name(new String[] { "学生", "教师" });
		dataMap.setJcb_parameter(new int[] { 2, 240, 170, 70, 40 });
		return dataMap;
	}
	
	public static DataMap AdminView() {
		String[] jmu = { "学生个人信息管理", "教师个人信息管理", "学生成绩信息管理", "课程信息管理", "密码信息管理"};
		String[] jmi1 = {"学生个人信息"};
		String[] jmi2 = { "教师个人信息"};
		String[] jmi3 = {"成绩信息"};
		String[] jmi4 = {"课程信息"};
		String[] jmi5 = {"修改管理员密码","重置用户密码"};
		ArrayList<String[]> arrayList = new ArrayList<>();
		arrayList.add(jmu);
		arrayList.add(jmi1);
		arrayList.add(jmi2);
		arrayList.add(jmi3);
		arrayList.add(jmi4);
		arrayList.add(jmi5);
		dataMap.setJf_name("管理员端");
		dataMap.setJf_size(new int[] {1000, 700 });
		dataMap.setArrayList(arrayList);
		return dataMap;
		
	}
	
	public static DataMap AdminInfoPanel() {
		dataMap.setJf_name("面板信息");
		dataMap.setJf_size(new int[] {1000, 700 });
		dataMap.setJtf_parameter(new int[] { 1,110,10,150,30 });
		dataMap.setJb_name(new String[]{"查询","添加","修改","删除"});
		dataMap.setJb_parameter(new int[] {4,550,10,100,30});
		return dataMap;
	}
	
	public static DataMap ChangeSecurityIssue() {
		dataMap.setJf_name("更改密保");
		dataMap.setJf_size(new int[] {1000, 700 });
		dataMap.setJl_name(new String[] { "新密保问题：","新密保答案："});
		dataMap.setJl_parameter(new int[] { 2, 250, 10, 80, 30 });
		dataMap.setJtf_parameter(new int[] { 2,110,10,150,30 });
		dataMap.setJb_name(new String[]{"提交" ,"退出修改"});
		dataMap.setJb_parameter(new int[] {2,550,10,100,30});
		return dataMap;
	}
	
}
