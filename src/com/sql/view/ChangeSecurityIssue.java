package com.sql.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sql.control.UserControl;
import com.sql.control.ViewData;
import com.sql.util.FaceUtil;
import com.sql.util.SwingUtil;

public class ChangeSecurityIssue extends FaceUtil implements ActionListener {
	int userID;
	String userAccount;

	public ChangeSecurityIssue(int userID, String userAccount) {
		dataMap = ViewData.ChangeSecurityIssue();
		this.userID = userID;
		this.userAccount = userAccount;
		CreateJF();
	}

	protected JPanel JP() {
		super.JP();
		SwingUtil.JL(dataMap, jp);
		SwingUtil.JB(dataMap, this, jp);
		SwingUtil.JTF(dataMap, jp);
		return jp;
	}

	public static void main(String[] args) {
		new ChangeSecurityIssue(1, "20180724105");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == SwingUtil.jb[0]) {
			String newQuestion = SwingUtil.jtf[0].getText();
			String newAnswer = SwingUtil.jtf[1].getText();
			UserControl uc = new UserControl();
			System.out.println("�ύ");
			// �ύ��ȥ���и��²����������ܱ�����.
			System.out.println(newQuestion);
			System.out.println(newAnswer);
			int a = uc.updateSecurityIssue(userID, userAccount, newQuestion, newAnswer);
			switch (a) {
			case 1:
				JOptionPane.showMessageDialog(this, "�ܱ����ⲻ��Ϊ��");
				break;
			case 2:
				JOptionPane.showMessageDialog(this, "�ܱ��𰸲���Ϊ��");
				break;
			case 3:
				JOptionPane.showMessageDialog(this, "�޸ĳɹ�!����Ҫ���µ�¼��");
				new UserView();
				this.dispose();
				break;
			}
		}else {
			new UserView();
			this.dispose();
		}
		

	}

}
