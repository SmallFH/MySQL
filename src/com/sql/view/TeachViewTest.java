package com.sql.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.sql.control.CourseControl;
import com.sql.control.GradeControl;
import com.sql.control.TeacherControl;
import com.sql.control.UserControl;
import com.sql.control.ViewData;
import com.sql.dao.CourseDao;
import com.sql.util.FaceUtil;
import com.sql.util.SwingUtil;
import com.sql.view.StuViewTest.HaveChangePanel;

public class TeachViewTest extends FaceUtil implements ActionListener{
	JMenuBar jmb;
	Vector<Object> teacherInfo;
	String teachAccount;
	String teacher_name;
	String teach_name;
	String teacherQuestion;
	String teacherAnswer;
	
	public TeachViewTest(String teachAccount) {
		this.teachAccount = teachAccount;
		dataMap = ViewData.TeachView();
		Teacher();
		CreateJF();
	}
	
	@SuppressWarnings("unchecked")
	private void Teacher() {
		teacherInfo = new TeacherControl().queryOneTeacher(teachAccount);
		Vector<Object> teach = (Vector<Object>) teacherInfo.get(0);
		this.teach_name = (String) teach.get(3);
		this.teacher_name = (String) teach.get(4);
		Vector<Object> teacherUserInfo = new UserControl().queryUserInfo(2, teachAccount);
		this.teacherQuestion = (String) teacherUserInfo.get(1);
		this.teacherAnswer = (String) teacherUserInfo.get(2);
	}
	
	protected void JFadd() {
		super.JFadd();
		jmb = SwingUtil.JMB(dataMap, this);
		this.add(jmb, BorderLayout.NORTH);
	}
	
	public static void main(String[] args) {
		new TeachViewTest("20180000000");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == SwingUtil.jmi[0][0]) {
			System.out.println("查看教师信息");
			jp.removeAll();
			HaveChangePanel hcp = new HaveChangePanel(this);
			hcp.setBounds(0, 0, dataMap.getJf_size()[0], dataMap.getJf_size()[1]);
			jp.add(hcp);
			jp.validate();
		}else if (e.getSource() == SwingUtil.jmi[1][0]) {
			Vector<Object> rowData = new GradeControl().queryTeacherGrade(teacher_name, teach_name);
			String[] name = { "学号", "班级", "姓名", "成绩" };
			SwingUtil.addTable(dataMap, jp, rowData, name);
		}else if (e.getSource() == SwingUtil.jmi[1][1]) {
			System.out.println("录入成绩");
			AddGradeTest addGrade = new AddGradeTest();
			JPanel ag = addGrade.JP();
			jp.removeAll();
			addGrade.teacher(teacher_name, teach_name);
			ag.setBounds(0, 0, 1000, 600);
			jp.add(ag);
			jp.repaint();
			jp.validate();
		}else if (e.getSource() == SwingUtil.jmi[2][0]) {
			System.out.println("查看教师本人的课程信息");
			Vector<Object> rowData = new CourseControl().queryTeacherCourse(teacher_name);
			String[] name = { "上课班级", "上课时间", "上课地点", "课程要求" };
			SwingUtil.addTable(dataMap, jp, rowData, name);
		} else if (e.getSource() == SwingUtil.jmi[3][0]) {
			System.out.println("修改密码");
			ChangePassWordText cpw = new ChangePassWordText(2,teachAccount,teacherQuestion,teacherAnswer,this);
			JPanel cp = cpw.JP();
			jp.removeAll();
			cp.setBounds(0, 0, 1000, 600);
			jp.add(cp);
			jp.repaint();
			jp.validate();
		}
	}
	
	public class HaveChangePanel extends JPanel implements ActionListener {
		JTable jt;
		JButton jb;
		JFrame jf;
		String[] name = { "院系", "所属专业", "教职工号", "教授科目", "姓名", "性别", "出生日期", "联系方式" };

		public HaveChangePanel(JFrame jf) {
			this.jf = jf;
			this.setLayout(new BorderLayout());
			jb = new JButton("修改信息");
			jb.addActionListener(this);
			JPanel jp_up = new JPanel();
			jp_up.setLayout(new BorderLayout());
			JPanel jp_down = new JPanel();
			jp_down.setPreferredSize(new Dimension(0, 100));
			jp_down.add(jb);

			jt = SwingUtil.addTable(dataMap, jp_up, teacherInfo, name);
			this.add(jp_up, BorderLayout.CENTER);
			this.add(jp_down, BorderLayout.SOUTH);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jb) {
				System.out.println("修改信息啊");
				int a = jt.getSelectedRow();
				int b = jt.getColumnCount();
				System.out.println(a + " / " + b);
				Vector<Object> d = new Vector<>();

				for (int i = 0; i < b; i++) {
					if (a < 0) {
						return;
					} else {
						d.addElement(jt.getValueAt(a, i));
					}
				}
				Vector<Object> f = new Vector<>();
				f.add(d);
				new UpdateInfo(1,jf, f, name);
			}
		}

	}
}
