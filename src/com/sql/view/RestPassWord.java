package com.sql.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sql.control.UserControl;
import com.sql.control.ViewData;
import com.sql.util.FaceUtil;
import com.sql.util.SwingUtil;

public class RestPassWord extends FaceUtil implements ActionListener{
	String adminPassWord;
	
	public RestPassWord(String adminPassWord) {
		this.adminPassWord = adminPassWord;
		dataMap=ViewData.RestPassWord();
//		CreateJF();
	}
	
	@Override
	protected JPanel JP() {
		super.JP();
		SwingUtil.JL(dataMap, jp);
		SwingUtil.JB(dataMap, this, jp);
		SwingUtil.JTF(dataMap, jp);
		SwingUtil.JPF(dataMap, jp);
		SwingUtil.JCB(dataMap, jp);
		return jp;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == SwingUtil.jb[0]) {
			String account = SwingUtil.jtf[0].getText();
			String adminPass = new String(SwingUtil.jpf[0].getPassword());
			Integer accountId = SwingUtil.jcb.getSelectedIndex()+1; 
			UserControl uc = new UserControl();
			switch (uc.restPassWord(accountId, account, adminPassWord, adminPass)) {
			case 0: JOptionPane.showMessageDialog(jp, "���������Ա����"); break;
			case 1: JOptionPane.showMessageDialog(jp, "���������������˺�"); break;
			case 2: JOptionPane.showMessageDialog(jp, "��������ɹ�"); break;
			case 3: JOptionPane.showMessageDialog(jp, "����������˺Ų�����"); break;
			case 4: JOptionPane.showMessageDialog(jp, "����Ա���벻��ȷ"); break;
			}
			
		}
		
	}

}
