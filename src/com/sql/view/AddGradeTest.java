package com.sql.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sql.control.GradeControl;
import com.sql.control.ViewData;
import com.sql.model.Grade;
import com.sql.util.FaceUtil;
import com.sql.util.SwingUtil;

public class AddGradeTest extends FaceUtil implements ActionListener{
	JButton[] jb;
	JTextField[] jtf;
	String teacherName,teach;
	Grade grade = new Grade();
	GradeControl gC = new GradeControl();
	@Override
	protected JPanel JP() {
		dataMap = ViewData.AddGradePanel();
		super.JP();
		jb = SwingUtil.JB(dataMap, this, jp);
		SwingUtil.JL(dataMap, jp);
		jtf = SwingUtil.JTF(dataMap, jp);
		return jp;
	}
	public void teacher(String teacherName,String teach) {
		this.teacherName = teacherName;
		this.teach = teach;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == jb[0]) {
			try {
				long stuNumber = Long.parseLong(jtf[0].getText());
				float stuGrade = Float.parseFloat(jtf[1].getText());
				grade.setStu_id(stuNumber);
				grade.setGrade(stuGrade);
				grade.setCou_name(teach);
				grade.setCou_teacher(teacherName);
				int a = gC.addGrade(grade);
				if (a == 1) {
					JOptionPane.showMessageDialog(this, "成绩录入成功");
				}else {
					JOptionPane.showMessageDialog(this, "成绩录入失败");
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "只能输入数字！");
			}
		}
	}

}
