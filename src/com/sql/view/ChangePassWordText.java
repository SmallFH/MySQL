package com.sql.view;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sql.control.UserControl;
import com.sql.control.ViewData;
import com.sql.util.FaceUtil;
import com.sql.util.SwingUtil;

public class ChangePassWordText extends FaceUtil implements ActionListener {
	String userQuestion;
	int userID;
	String userAccount;
	String userAnswer;
	JFrame jf;

	public ChangePassWordText(int userID, String userAccount, String question, String answer,JFrame jf) {
		dataMap = ViewData.ChangePass();
		this.userQuestion = question;
		this.userID = userID;
		this.userAccount = userAccount;
		this.userAnswer = answer;
		this.jf = jf;
	}

	@Override
	protected JPanel JP() {
		super.JP();
		SwingUtil.JL(dataMap, jp);
		SwingUtil.JB(dataMap, this, jp);
		SwingUtil.JTF(dataMap, jp);
		SwingUtil.JPF(dataMap, jp);
		JLabel jl1 = new JLabel(userQuestion);
		jl1.setBounds(350, 10, 200, 30);
		jp.add(jl1);
		return jp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == SwingUtil.jb[0]) {
			String answer = SwingUtil.jtf[0].getText();
			String newPass = new String(SwingUtil.jpf[0].getPassword());
			String judgePass = new String(SwingUtil.jpf[1].getPassword());
			UserControl uc = new UserControl();
			int a = uc.updatePass(userID, userAccount, userAnswer, answer, newPass, judgePass);
			switch (a) {
			case 0:
				break;
			case 1:
				JOptionPane.showMessageDialog(this, "������ĳɹ�");
				// �޸�����֮��Ӧ���˳��ͻ������µ�¼��
				jf.dispose();
				new UserView();
				break;
			case 2:
				JOptionPane.showMessageDialog(this, "�ܱ��𰸲���ȷ");
				break;
			case 3:
				JOptionPane.showMessageDialog(this, "�������벻һ��");
				break;
			case 4:
				JOptionPane.showMessageDialog(this, "������������");
				break;
			case 5:
				JOptionPane.showMessageDialog(this, "�������ܱ���");
				break;
			}
		} else {
			int a = JOptionPane.showConfirmDialog(null, "�Ƿ�Ҫ�����ܱ����˲������޷����ص�ǰ���棬�����ѡ��");
			switch (a) {
			case 0:
				jf.dispose();
				new ChangeSecurityIssue(userID, userAccount);
				break;
			}
			
		}
	}
}
