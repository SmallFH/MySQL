package com.sql.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sql.control.StudentControl;
import com.sql.control.TeacherControl;

public class UpdateInfo implements ActionListener{
	JButton saveUpdata,exitUpdata;
	JTable jt;
	JDialog jd;
	int idNumber;
	DefaultTableModel defautifulTableModel;
	public UpdateInfo(int idNumber,JFrame jf,Vector<Object> rowData,String[] columnName) {
		this.idNumber = idNumber;
		Vector<Object> columnNames = new Vector<>();
		for (int i = 0; i < columnName.length; i++) {
			columnNames.add(columnName[i]);
		}
		jd = new JDialog(jf, "修改窗口测试", true);
		
		defautifulTableModel = new DefaultTableModel(rowData, columnNames);
		jt = new JTable(defautifulTableModel);
		JScrollPane jsp = new JScrollPane(jt);
		jd.add(jsp);
		
		JPanel jp_down = new JPanel();
		jp_down.setBackground(Color.red);
		jp_down.setPreferredSize(new Dimension(0, 50));
		saveUpdata = new JButton("保存修改数据");
		saveUpdata.addActionListener(this);
		exitUpdata = new JButton("退出修改");
		exitUpdata.addActionListener(this);
		jp_down.add(saveUpdata);
		jp_down.add(exitUpdata);
		jd.add(jp_down,BorderLayout.SOUTH);
		jd.setSize(800, 800);
		jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		jd.setLocationRelativeTo(null);
		jd.setVisible(true);
	}
	
	
//	public static void main(String[] args) {
//		new UpdateInfo(new JFrame("随便"), new Vector<Object>(), new String[] {"A","B","C"});
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == saveUpdata) {
			System.out.println("保存修改的数据");
			int row = defautifulTableModel.getRowCount()-1;
			int column = defautifulTableModel.getColumnCount();
			String[] data = new String[column];
			for (int i = 0; i < column; i++) {
				data[i]= String.valueOf(jt.getValueAt(row, i));
			}
			switch (idNumber) {
			case 0:
				new StudentControl().updateStudentInfo(data);
				break;
			case 1:
				new TeacherControl().updateTeacherInfo(data);
				break;
			}
		} else {
			System.out.println("退出修改");
			jd.dispose();
		}
	}

}
