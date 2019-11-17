package com.sql.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JMenuBar;
import javax.swing.JPanel;

import com.sql.control.UserControl;
import com.sql.control.ViewData;
import com.sql.util.FaceUtil;
import com.sql.util.SwingUtil;

public class AdminViewTest extends FaceUtil implements ActionListener{
	JMenuBar jmb;
	String adminAccount;
	String adminPassWord;
	String adminQuestion;
	String adminAnswer;
	
	public AdminViewTest(String adminAccount) {
		this.adminAccount = adminAccount;
		dataMap = ViewData.AdminView();
		adminInfo();
		CreateJF();
	}
	
	private void adminInfo() {
		Vector<Object> adminUserInfo = new UserControl().queryUserInfo(3, adminAccount);
		this.adminPassWord = (String) adminUserInfo.get(0);
		this.adminQuestion = (String) adminUserInfo.get(1);
		this.adminAnswer = (String) adminUserInfo.get(2);
	}
	
	protected void JFadd() {
		super.JFadd();
		jmb = SwingUtil.JMB(dataMap, this);
		this.add(jmb, BorderLayout.NORTH);
	}
	
	public static void main(String[] args) {
		new AdminViewTest("0");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == SwingUtil.jmi[0][0]) {
			System.out.println("查看学生信息");
			AdminInfoPanel aip = new AdminInfoPanel(0);
			JPanel ap = aip.JP();
			jp.removeAll();
			ap.setBounds(0, 0, 1000, 620);
			jp.add(ap);
			jp.repaint();
			jp.validate();
			
		}else if (e.getSource() == SwingUtil.jmi[1][0]) {
			System.out.println("查看教师信息");
			AdminInfoPanel aip = new AdminInfoPanel(1);
			JPanel ap = aip.JP();
			jp.removeAll();
			ap.setBounds(0, 0, 1000, 620);
			jp.add(ap);
			jp.repaint();
			jp.validate();
		}else if (e.getSource() == SwingUtil.jmi[2][0]) {
			System.out.println("查看成绩信息");
			AdminInfoPanel aip = new AdminInfoPanel(2);
			JPanel ap = aip.JP();
			jp.removeAll();
			ap.setBounds(0, 0, 1000, 620);
			jp.add(ap);
			jp.repaint();
			jp.validate();
		}else if (e.getSource() == SwingUtil.jmi[3][0]) {
			System.out.println("查看课程信息");
			AdminInfoPanel aip = new AdminInfoPanel(3);
			JPanel ap = aip.JP();
			jp.removeAll();
			ap.setBounds(0, 0, 1000, 620);
			jp.add(ap);
			jp.repaint();
			jp.validate();
		}else if (e.getSource() == SwingUtil.jmi[4][0]) {
			System.out.println("修改管理员密码");
			ChangePassWordText cpw = new ChangePassWordText(3,adminAccount,adminQuestion,adminAnswer,this);
			JPanel cp = cpw.JP();
			jp.removeAll();
			cp.setBounds(0, 0, 1000, 620);
			jp.add(cp);
			jp.repaint();
			jp.validate();
			
		}else if (e.getSource() == SwingUtil.jmi[4][1]) {
			System.out.println("重置用户密码");
			RestPassWord rpw = new RestPassWord(adminPassWord);
			JPanel rp = rpw.JP();
			jp.removeAll();
			rp.setBounds(0, 0, 1000, 620);
			jp.add(rp);
			jp.repaint();
			jp.validate();
		}
	}

}
