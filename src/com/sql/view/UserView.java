package com.sql.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sql.control.UserControl;
import com.sql.control.ViewData;
import com.sql.util.FaceUtil;
import com.sql.util.SwingUtil;

public class UserView extends FaceUtil implements ActionListener {

	public UserView() {
		dataMap = ViewData.enterView();
		CreateJF();
	}

	@Override
	protected JPanel JP() {
		super.JP();
		SwingUtil.JB(dataMap, this, jp);
		SwingUtil.JL(dataMap, jp);
		SwingUtil.JTF(dataMap, jp);
		SwingUtil.JPF(dataMap, jp);
		SwingUtil.JCB(dataMap, jp);
		return jp;
	}

	public static void main(String[] args) {
		new UserView();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == SwingUtil.jb[0]) {
			UserControl userControl = new UserControl();
			String name = SwingUtil.jtf[0].getText();
			String pass = new String(SwingUtil.jpf[0].getPassword());
			switch (userControl.enterJudge((String) SwingUtil.jcb.getSelectedItem(), name, pass)) {
			case 0:
				JOptionPane.showMessageDialog(this, "查无此号！");
				break;
			case 1:
				System.out.println("学生");
				System.out.println(name);
				new StuViewTest(name);
				this.dispose();
				break;
			case 2:
				System.out.println("教师");
				System.out.println(name);
				new TeachViewTest(name);
				this.dispose();
				break;
			case 3:
				System.out.println("管理员");
				new AdminViewTest(name);
				this.dispose();
				break;
			case 4:
				JOptionPane.showMessageDialog(this, "请输入用户账号！");
				break;
			case 5:
				JOptionPane.showMessageDialog(this, "请输入密码！");
				break;
			case 6:
				JOptionPane.showMessageDialog(this, "密码错误！");
				break;
			}
		}else {
			new RegisterViewText();
			this.dispose();
		}
	}

}
