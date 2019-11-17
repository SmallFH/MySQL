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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.sql.control.AdminControl;
import com.sql.control.GradeControl;
import com.sql.control.StudentControl;
import com.sql.control.TeacherControl;
import com.sql.control.ViewData;
import com.sql.dao.GradeDao;
import com.sql.model.Grade;
import com.sql.util.FaceUtil;
import com.sql.util.SwingUtil;
import com.sql.util.TableUtil;

public class AdminInfoPanel extends FaceUtil implements ActionListener {
	JButton[] jbb = null;
	int allPage;
	int pageSize = 3;
	int page = 1;
	int tableNumber;
	JPanel jp_center;
	JLabel jl1;
	JTable jt;
	JTextField jtf1;
	AdminControl ac;
	Vector<Object> rowData;
	String[] columnName;

	public AdminInfoPanel(int tableNumber) {
		ac = new AdminControl(tableNumber);
		this.tableNumber = tableNumber;
		switch (tableNumber) {
		case 0:
			columnName = new String[] { "院系", "专业", "年级", "班级", "学号", "姓名", "性别", "出生日期", "电话" };
			break;
		case 1:
			columnName = new String[] { "院系", "所属专业", "教职工号", "教授科目", "姓名", "性别", "出生日期", "联系方式" };
			break;
		case 2:
			columnName = new String[] { "院系", "专业", "班级", "学号", "姓名", "科目", "教师", "成绩" };
			break;
		case 3:
			columnName = new String[] { "课程编号", "院系", "课程名称", "课时", "学分", "选修", "授课教师", "上课班级", "上课时间", "上课地点",
					"考核方式" };
			break;
		}
		allPage = ac.allNumber("", pageSize);

		dataMap = ViewData.AdminInfoPanel();
		// CreateJF();
	}

	@Override
	protected JPanel JP() {
		super.JP();
		jp.setLayout(new BorderLayout());
		String[] jbbName = { "首页", "上一页", "下一页", "尾页", "跳转" };
		JPanel jp_up = new JPanel();
		JPanel jp_down = new JPanel();
		jp_center = new JPanel();
		jl1 = new JLabel();
		jl1.setText(page + " / " + allPage);
		jl1.setBounds(500, 10, 80, 30);
		jp_up.setLayout(null);
		jp_down.setLayout(null);
		jp_center.setLayout(new BorderLayout());
		jp_up.setBackground(Color.GRAY);
		jp_down.setBackground(Color.BLUE);
		jp_center.setBackground(Color.green);
		jp_up.setPreferredSize(new Dimension(0, 50));
		jp_down.setPreferredSize(new Dimension(0, 50));
		jp.add(jp_up, BorderLayout.NORTH);
		jp.add(jp_down, BorderLayout.SOUTH);
		jp.add(jp_center, BorderLayout.CENTER);
		SwingUtil.JTF(dataMap, jp_up);
		SwingUtil.JB(dataMap, this, jp_up);
		jtf1 = new JTextField();
		jtf1.setBounds(600, 10, 80, 50);
		jp_down.add(jl1);
		jp_down.add(jtf1);
		jbb = new JButton[5];
		rowData = ac.queryAllInfo(tableNumber, SwingUtil.jtf[0].getText(), page, pageSize);
		jt = SwingUtil.addTable(dataMap, jp_center, rowData, columnName);

		/**
		 * 需要改的
		 */
		for (int i = 0; i < jbb.length; i++) {
			jbb[i] = new JButton(jbbName[i]);
			jbb[i].setBounds(100 * i, 10, 80, 50);
			jbb[i].addActionListener(this);
			jp_down.add(jbb[i]);
		}
		return jp;
	}

//	 public static void main(String[] args) {
//	 new AdminInfoPanel(0);
//	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == SwingUtil.jb[0]) {
			jp_center.removeAll();
			rowData = ac.queryAllInfo(tableNumber, SwingUtil.jtf[0].getText(), page, pageSize);
			allPage = ac.allNumber(SwingUtil.jtf[0].getText(), pageSize);
			jl1.setText(page + " / " + allPage);
			SwingUtil.addTable(dataMap, jp_center, rowData, columnName);
			System.out.println("查询");
		} else if (e.getSource() == SwingUtil.jb[1]) {
			System.out.println("添加");
			new AdminAdd(this, columnName);
		} else if (e.getSource() == SwingUtil.jb[2]) {
			System.out.println("修改");
			int a = jt.getSelectedRow();
			int b = jt.getColumnCount();
			System.out.println(a + " / " + b);
			Vector<Object> d = new Vector<>();

			for (int i = 0; i < b; i++) {
				if (a < 0) {
					return;
				} else {
					d.addElement(jt.getValueAt(a, i));
				}
			}
			Vector<Object> f = new Vector<>();
			f.add(d);
			new UpdateInfo(0, this, f, columnName);

		} else if (e.getSource() == SwingUtil.jb[3]) {
			System.out.println("删除");
			int judge = JOptionPane.showConfirmDialog(this, "你真的确定删除这条记录吗？");
			if (judge == 0) {
				int row = jt.getSelectedRow();
				switch (tableNumber) {
				case 0:
					String b = jt.getValueAt(row, 4).toString();
					new StudentControl().deleteStu(b);
					new GradeControl().deleteOnePeopleGrade(b);
					break;
				case 1:
					new TeacherControl().deleteTeacher(jt.getValueAt(row, 2).toString());
					break;
				case 2:
					System.out.println(jt.getValueAt(row, 5));
					Grade grade = new Grade();
					grade.setStu_id((long) jt.getValueAt(row, 3));
					grade.setCou_name((String)jt.getValueAt(row, 5));
					new GradeControl().deleteGrade(grade);
					break;
				case 3:
					
					break;
				}
				JOptionPane.showMessageDialog(this, "删除成功");
			}
		} else if (e.getSource() == jbb[0]) {
			if (page == 1) {
			} else {
				page = 1;
				jp_center.removeAll();
				rowData = ac.queryAllInfo(tableNumber, SwingUtil.jtf[0].getText(), page, pageSize);
				allPage = ac.allNumber(SwingUtil.jtf[0].getText(), pageSize);
				jl1.setText(page + " / " + allPage);
				jt = SwingUtil.addTable(dataMap, jp_center, rowData, columnName);
				System.out.println("首页");
			}
		} else if (e.getSource() == jbb[1]) {
			if (page <= 1) {
			} else {
				page--;
				jp_center.removeAll();
				rowData = ac.queryAllInfo(tableNumber, SwingUtil.jtf[0].getText(), page, pageSize);
				allPage = ac.allNumber(SwingUtil.jtf[0].getText(), pageSize);
				jl1.setText(page + " / " + allPage);
				jt = SwingUtil.addTable(dataMap, jp_center, rowData, columnName);
				System.out.println("上一页");
			}
		} else if (e.getSource() == jbb[2]) {
			if (page >= allPage) {
			} else {
				page++;
				jp_center.removeAll();
				rowData = ac.queryAllInfo(tableNumber, SwingUtil.jtf[0].getText(), page, pageSize);
				allPage = ac.allNumber(SwingUtil.jtf[0].getText(), pageSize);
				jl1.setText(page + " / " + allPage);
				jt = SwingUtil.addTable(dataMap, jp_center, rowData, columnName);
				System.out.println("下一页");
			}
		} else if (e.getSource() == jbb[3]) {
			page = allPage;
			jp_center.removeAll();
			rowData = ac.queryAllInfo(tableNumber, SwingUtil.jtf[0].getText(), page, pageSize);
			allPage = ac.allNumber(SwingUtil.jtf[0].getText(), pageSize);
			jl1.setText(page + " / " + allPage);
			jt = SwingUtil.addTable(dataMap, jp_center, rowData, columnName);
			System.out.println("尾页");
		} else if (e.getSource() == jbb[4]) {
			String number = null;
			try {
				number = jtf1.getText();
				page = Integer.parseInt(number);
				if (page <= allPage && page > 0) {
					jp_center.removeAll();
					rowData = ac.queryAllInfo(tableNumber, SwingUtil.jtf[0].getText(), page, pageSize);
					allPage = ac.allNumber(SwingUtil.jtf[0].getText(), pageSize);
					jl1.setText(page + " / " + allPage);
					jt = SwingUtil.addTable(dataMap, jp_center, rowData, columnName);
				} else {
					JOptionPane.showMessageDialog(this, "页码超出范围");
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "页码不正确");
			}
		}

	}

	public class AdminAdd implements ActionListener {
		JButton addRow, saveData, delRow;
		DefaultTableModel defaultTableModel;
		JTable jt;
		JDialog jd;
		Vector<Object> cloumnNames;

		public AdminAdd(JFrame jf, String[] cloumnName) {
			cloumnNames = new Vector<>(Arrays.asList(cloumnName));
			Vector<Object> rowData = new Vector<>();
			JDialog jd = new JDialog(jf, "添加信息", true);
			defaultTableModel = new DefaultTableModel(rowData, cloumnNames);
			jt = new JTable(defaultTableModel);
			JScrollPane jsp = new JScrollPane(jt);
			jd.add(jsp, BorderLayout.CENTER);
			JPanel jp = new JPanel();
			jp.setBackground(Color.GREEN);
			jp.setPreferredSize(new Dimension(0, 50));
			jd.add(jp, BorderLayout.SOUTH);
			addRow = new JButton("添加空白行");
			saveData = new JButton("保存数据");
			delRow = new JButton("删除行");
			jp.add(addRow);
			jp.add(saveData);
			jp.add(delRow);
			addRow.addActionListener(this);
			saveData.addActionListener(this);
			delRow.addActionListener(this);
			jd.setSize(600, 400);
			jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			jd.setLocationRelativeTo(null);
			jd.setVisible(true);
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == addRow) {
				System.out.println("添加空白行");
				Vector<Object> a = new Vector<>();
				defaultTableModel.insertRow(0, a);
			} else if (e.getSource() == saveData) {
				System.out.println("保存数据");
				System.out.println("---------");
				int rowCount = defaultTableModel.getRowCount();
				int columnCount = defaultTableModel.getColumnCount();
				System.out.println(rowCount + " / " + columnCount);
				String[][] data = new String[rowCount][columnCount];
				for (int i = 0; i < rowCount; i++) {
					for (int j = 0; j < columnCount; j++) {
						if (!(defaultTableModel.getValueAt(i, j) == null
								|| defaultTableModel.getValueAt(i, j).equals(""))) {
							data[i][j] = (String) defaultTableModel.getValueAt(i, j);
						} else {
							JOptionPane.showMessageDialog(jd, "表格中存在空的单元格，请先删除含有空单元格的行");
							return;
						}
					}
				}
				int reVlue = ac.addAllInfo(tableNumber, data);
				switch (reVlue) {
				case 7:
					JOptionPane.showMessageDialog(jd, "日期格式错误");
					break;
				case 0:
					JOptionPane.showMessageDialog(jd, "数据错误，请对照原表格式");
					break;
				case 2:
					JOptionPane.showMessageDialog(jd, "年级出错");
					break;
				case 3:
					JOptionPane.showMessageDialog(jd, "性别出错");
					break;
				}
				System.out.println("---------");

			} else if (e.getSource() == delRow) {
				System.out.println("删除空白行");
				int a = jt.getSelectedRow();
				if (a < 0) {
				} else {
					defaultTableModel.removeRow(a);
				}
			}

		}
	}
}
