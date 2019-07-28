package com.sql.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.sql.control.ViewData;
import com.sql.util.FaceUtil;
import com.sql.util.JtextUtil;
import com.sql.util.SwingUtil;

public class TeacherPanelText extends FaceUtil implements ActionListener{

	JTextField[] jtf;
	JPasswordField[] jpf;
	JRadioButton[] jrb;
	
	@Override
	protected JPanel JP() {
		super.JP();
		dataMap = ViewData.TeacherPanel();
		SwingUtil.JL(dataMap, jp);
		jtf = SwingUtil.JTF(dataMap, jp);
		String[] egname = {"e.g. ����Ƽ�ѧԺ","e.g. ����ҽѧ","e.g. 11λ����",
				"e.g. �������ѧ","e.g. ����","e.g. XXXX-XX-XX",
				"e.g. 11λ����","e.g. �ҽ�ʲô���֣�","e.g. ����"};
		for (int i = 0; i < 9; i++) {
			SwingUtil.jtf[i].addFocusListener(new JtextUtil(SwingUtil.jtf[i], egname[i]));
		}
		jpf = SwingUtil.JPF(dataMap, jp);
		jrb = SwingUtil.JRB(dataMap, this, jp);
		return jp;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
