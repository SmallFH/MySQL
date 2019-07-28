package com.sql.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sql.control.StudentControl;
import com.sql.control.TeacherControl;
import com.sql.control.UserControl;
import com.sql.control.ViewData;
import com.sql.util.FaceUtil;
import com.sql.util.SwingUtil;

public class RegisterViewText extends FaceUtil implements ActionListener {
	JPanel jp_up, jp_fl;
	StudentPanelText st = new StudentPanelText();
	JPanel s = st.JP();
	TeacherPanelText tp = new TeacherPanelText();
	JPanel t = tp.JP();

	public RegisterViewText() {
		dataMap = ViewData.RegisterView();
		CreateJF();
	}

	@Override
	protected JPanel JP() {
		super.JP();
		jp_up = new JPanel();
		jp_fl = new JPanel();
		jp_up.setBackground(Color.YELLOW);
		jp_fl.setBackground(Color.BLUE);
		jp_up.setPreferredSize(new Dimension(0, 40));
		jp_fl.setPreferredSize(new Dimension(0, 40));
		SwingUtil.JRB(dataMap, this, jp_up);
		SwingUtil.JB(dataMap, this, jp_fl);
		this.add(jp_up, BorderLayout.NORTH);
		this.add(jp_fl, BorderLayout.SOUTH);
		return null;
	}

	public static void main(String[] args) {
		new RegisterViewText();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		UserControl user = new UserControl();
		if (e.getSource() == SwingUtil.jrb[0]) {
			System.out.println("添加学生面板");
			this.jp.removeAll();
			this.jp.add(s);
			s.setBounds(0, 0, 800, 800);
			this.jp.repaint();
			return;
		} else if ((e.getSource() == SwingUtil.jb[0]) && (SwingUtil.jrb[0].isSelected())) {
			int a = 0, b = 2;
			StudentControl stc = new StudentControl();
			System.out.println("提交学生信息");
			String[] stu_prame = new String[9];
			String[] user_para = new String[5];
			String gard = (String) st.jcb.getSelectedItem();
			String sex = new String();
			if (st.jrb[1].isSelected()) {
				sex = "女";
			}
			for (int i = 0; i <= 9; i++) {
				if (i < 7) {
					stu_prame[i] = st.jtf[i].getText();
				} else if (6 < i && i < 9) {
					user_para[a] = new String(st.jpf[a].getPassword());
					user_para[b] = new String(st.jtf[i].getText());
					a++;
					b++;
				} else {
					user_para[4] = st.jtf[3].getText();
					stu_prame[7] = gard;
					stu_prame[8] = sex;
				}
			}
			
			int stucon = stc.registerStu(stu_prame);
			
			 switch (stucon) {
			 case 0:
				 JOptionPane.showMessageDialog(this, "请输入学院名！");
				 return;
			 case 1:
				 JOptionPane.showMessageDialog(this, "请输入专业名！");
				 return;
			 case 2:
				 JOptionPane.showMessageDialog(this, "请输入班级名！");
				 return;
			 case 3:
				 JOptionPane.showMessageDialog(this, "请输入学号！");
			 return;
			 case 4:
				 JOptionPane.showMessageDialog(this, "请输入姓名！");
			 return;
			 case 5:
				 JOptionPane.showMessageDialog(this, "请输入出生日期！");
			 return;
			 case 6:
				 JOptionPane.showMessageDialog(this, "请输入手机号！");
			 return;
			 case 33:
				 JOptionPane.showMessageDialog(this, "请输入11位数字学号！");
			 return;
			 case 55:
				 JOptionPane.showMessageDialog(this, "出生日期格式错误！");
			 return;
			 }
			 int u = user.addUser(1, user_para);
			switch (u) {
			case 0:
				JOptionPane.showMessageDialog(this, "请输入密码！");
				return;
			case 1:
				JOptionPane.showMessageDialog(this, "请确认密码！");
				return;
			case 2:
				JOptionPane.showMessageDialog(this, "请输入密保问题！");
				return;
			case 3:
				JOptionPane.showMessageDialog(this, "请输入密保答案！");
				return;
			case 10:
				JOptionPane.showMessageDialog(this, "两次密码不一致，请重新输入");
				return;
			}
			if (stucon == 9 && u == 9) {
				if (!stc.addStu()) {
					JOptionPane.showMessageDialog(this, "注册失败！");
					return;
				}else
				if (stc.addStu()&&user.addUser()) {
					JOptionPane.showMessageDialog(this, "注册成功！");
					new UserView();
					this.dispose();
				} 
			}

		}

		if (e.getSource() == SwingUtil.jrb[1]) {
			System.out.println("提交教师信息");
			this.jp.removeAll();
			this.jp.add(t);
			t.setBounds(0, 0, 1000, 600);
			this.jp.repaint();
			return;
		} else if ((e.getSource() == SwingUtil.jb[0]) && (SwingUtil.jrb[1].isSelected())) {
			System.out.println("");
			int a = 0, b = 2;
			TeacherControl tec = new TeacherControl();
			String[] tea_prame = new String[8];
			String[] user_para = new String[5];
			String sex = new String();
			if (tp.jrb[1].isSelected()) {
				sex = "女";
			}
			for (int i = 0; i <= 9; i++) {
				if (i < 7) {
					tea_prame[i] = tp.jtf[i].getText();
				} else if (6 < i && i < 9) {
					user_para[a] = new String(tp.jpf[a].getPassword());
					user_para[b] = new String(tp.jtf[i].getText());
					a++;
					b++;
				} else {
					user_para[4] = tp.jtf[2].getText();
					tea_prame[7] = sex;
				}
			}
			int tecon = tec.addTea(tea_prame);
			 switch (tecon) {
			 case 0:
				 JOptionPane.showMessageDialog(this, "请输入学院名！");
				 return;
			 case 1:
				 JOptionPane.showMessageDialog(this, "请输入专业名！");
				 return;
			 case 2:
				 JOptionPane.showMessageDialog(this, "请输入职工号！");
				 return;
			 case 3:
				 JOptionPane.showMessageDialog(this, "请输入教授科目！");
			 return;
			 case 4:
				 JOptionPane.showMessageDialog(this, "请输入姓名！");
			 return;
			 case 5:
				 JOptionPane.showMessageDialog(this, "请输入出生日期！");
			 return;
			 case 6:
				 JOptionPane.showMessageDialog(this, "请输入手机号！");
			 return;
			 case 22:
				 JOptionPane.showMessageDialog(this, "职工号只能是数字，不能为其他字符！");
			 return;
			 case 55:
				 JOptionPane.showMessageDialog(this, "出生日期格式错误！");
			 return;
			 }
			 int u = user.addUser(2, user_para);
			 switch (u) {
				case 0:
					JOptionPane.showMessageDialog(this, "密码不能为空！");
					return;
				case 1:
					JOptionPane.showMessageDialog(this, "请再次确认密码！");
					return;
				case 2:
					JOptionPane.showMessageDialog(this, "请输入密保问题！");
					return;
				case 3:
					JOptionPane.showMessageDialog(this, "请输密保答案！");
					return;
				case 10:
					JOptionPane.showMessageDialog(this, "请输入手机号！");
					return;
				}
			 if (tecon == 9 && u == 9) {
				 boolean aaa = true,bbb = true;
				 aaa = tec.addTeacher();
				 bbb = user.addUser();
					if (!aaa) {
						JOptionPane.showMessageDialog(this, "注册失败！");
						return;
					}else
					if (aaa&&bbb) {
						JOptionPane.showMessageDialog(this, "注册成功！");
						new UserView();
						this.dispose();
					} 
				}
		}

	}
}
