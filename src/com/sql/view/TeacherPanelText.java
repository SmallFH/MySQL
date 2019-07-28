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
		String[] egname = {"e.g. 动物科技学院","e.g. 动物医学","e.g. 11位数字",
				"e.g. 家畜解剖学","e.g. 张三","e.g. XXXX-XX-XX",
				"e.g. 11位数字","e.g. 我叫什么名字？","e.g. 张三"};
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
