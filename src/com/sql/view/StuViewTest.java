package com.sql.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.sql.control.ChooseCourseControl;
import com.sql.control.CourseControl;
import com.sql.control.GradeControl;
import com.sql.control.StudentControl;
import com.sql.control.UserControl;
import com.sql.control.ViewData;
import com.sql.model.ChooseCourse;
import com.sql.util.FaceUtil;
import com.sql.util.SwingUtil;
import com.sql.util.TableUtil;

public class StuViewTest extends FaceUtil implements ActionListener {
	JMenuBar jmb;
	Vector<Object> stuInfo;
	String stuAccount;
	String stuClass;
	String stuQuestion;
	String stuAnswer;

	public StuViewTest(String account) {
		this.stuAccount = account;
		dataMap = ViewData.StuView();
		StuClass();
		CreateJF();
	}

	@SuppressWarnings("unchecked")
	private void StuClass() {
		stuInfo = new StudentControl().queryOneStudent(stuAccount);
		Vector<Object> stu = (Vector<Object>) stuInfo.get(0);
		this.stuClass = (String) stu.get(3);
		Vector<Object> teacherUserInfo = new UserControl().queryUserInfo(1, stuAccount);
		this.stuQuestion = (String) teacherUserInfo.get(1);
		this.stuAnswer = (String) teacherUserInfo.get(2);
	}

	@Override
	protected void JFadd() {
		super.JFadd();
		jmb = SwingUtil.JMB(dataMap, this);
		add(jmb, BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		new StuViewTest("20180724105");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == SwingUtil.jmi[0][0]) {
			System.out.println("�鿴������Ϣ");
			jp.removeAll();
			HaveChangePanel hcp = new HaveChangePanel(this);
			hcp.setBounds(0, 0, dataMap.getJf_size()[0], dataMap.getJf_size()[1]);
			jp.add(hcp);
			jp.validate();
		} else if (e.getSource() == SwingUtil.jmi[1][0]) {
			System.out.println("�鿴�༶�γ�");
			String[] name = { "Ժϵ", "�γ̱��", "�γ�����", "��ѧʱ", "�γ�ѧ��", "�ον�ʦ", "�Ͽΰ༶", "�Ͽ�ʱ��", "�Ͽεص�", "���˷�ʽ", "�Ͽ�����" };
			Vector<Object> rowData = new CourseControl().queryStudentCourse(stuClass);
			SwingUtil.addTable(dataMap, jp, rowData, name);
		} else if (e.getSource() == SwingUtil.jmi[1][1]) {
			System.out.println("ѡ��");
			jp.removeAll();
			SelectCourse sc = new SelectCourse(this);
			sc.setBounds(0, 0, dataMap.getJf_size()[0], dataMap.getJf_size()[1]);
			jp.add(sc);
			jp.validate();
		} else if (e.getSource() == SwingUtil.jmi[1][2]) {
			System.out.println("�鿴��ѡ�γ̻����˿�");
			jp.removeAll();
			ExitSelectCourse esc = new ExitSelectCourse(this);
			esc.setBounds(0, 0, dataMap.getJf_size()[0], dataMap.getJf_size()[1]);
			jp.add(esc);
			jp.validate();
		} else if (e.getSource() == SwingUtil.jmi[2][0]) {
			System.out.println("�鿴�ɼ�");
			String[] name = { "�γ�����", "�ον�ʦ", "�ɼ�" };
			Vector<Object> rowData = new GradeControl().queryStuGrade(stuAccount);
			SwingUtil.addTable(dataMap, jp, rowData, name);
		} else if (e.getSource() == SwingUtil.jmi[3][0]) {
			System.out.println("�޸�����");
			ChangePassWordText cpw = new ChangePassWordText(1, stuAccount, stuQuestion, stuAnswer, this);
			JPanel cp = cpw.JP();
			jp.removeAll();
			cp.setBounds(0, 0, 1000, 600);
			jp.add(cp);
			jp.repaint();
			jp.validate();
		}
	}

	public class HaveChangePanel extends JPanel implements ActionListener {
		JTable jt;
		JButton jb;
		JFrame jf;
		String[] name = { "Ժϵ", "רҵ", "�꼶", "�༶", "ѧ��", "����", "�Ա�", "��������", "�绰" };

		public HaveChangePanel(JFrame jf) {
			this.jf = jf;
			this.setLayout(new BorderLayout());
			jb = new JButton("�޸���Ϣ");
			jb.addActionListener(this);
			JPanel jp_up = new JPanel();
			jp_up.setLayout(new BorderLayout());
			JPanel jp_down = new JPanel();
			jp_down.setPreferredSize(new Dimension(0, 100));
			jp_down.add(jb);

			jt = SwingUtil.addTable(dataMap, jp_up, stuInfo, name);
			this.add(jp_up, BorderLayout.CENTER);
			this.add(jp_down, BorderLayout.SOUTH);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jb) {
				System.out.println("�޸���Ϣ��");
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
				new UpdateInfo(0,jf, f, name);
			}
		}

	}

	public class ExitSelectCourse extends JPanel implements ActionListener {
		JTable jt;
		JButton jb;
		String[] name = { "Ժϵ", "�γ̱��", "�γ�����", "��ѧʱ", "�γ�ѧ��", "�ον�ʦ", "�Ͽΰ༶", "�Ͽ�ʱ��", "�Ͽεص�", "���˷�ʽ", "�Ͽ�����" };

		public ExitSelectCourse(JFrame jf) {
			this.setLayout(new BorderLayout());
			jb = new JButton("�˿�");
			jb.addActionListener(this);
			JPanel jp_up = new JPanel();
			jp_up.setLayout(new BorderLayout());
			JPanel jp_down = new JPanel();
			jp_down.setPreferredSize(new Dimension(0, 100));
			jp_down.add(jb);
			Vector<Object> rowData = new ChooseCourseControl().queryChoosedCourse(stuAccount);
			jt = SwingUtil.addTable(dataMap, jp_up, rowData, name);
			this.add(jp_up, BorderLayout.CENTER);
			this.add(jp_down, BorderLayout.SOUTH);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jb) {
				int a = JOptionPane.showConfirmDialog(this, "�����Ҫ��ѡ���ſγ̣�");
				switch (a) {
				case 0:
					System.out.println("����ȷ����ѡ���ſγ�");
					int row = jt.getSelectedRow();
					if (row < 0) {
						return;
					} else {
						long studentAccount = Long.parseLong(stuAccount);
						ChooseCourse cc = new ChooseCourse();
						cc.setStu_id(studentAccount);
						cc.setCou_id((int) jt.getValueAt(row, 1));
						new ChooseCourseControl().deleteChooseCourse(cc);
					}
					break;
				}
			}
		}

	}
	
	public class SelectCourse extends JPanel implements ActionListener{
		JTable jt;
		JButton jb;
		String[] name ={ "Ժϵ", "�γ̱��","�γ�����", "��ѧʱ",  "�γ�ѧ��", "�ον�ʦ", "�Ͽΰ༶", "�Ͽ�ʱ��",  "�Ͽεص�", "���˷�ʽ", "�Ͽ�����"};
		Vector<Object> rowData;
		public SelectCourse(JFrame jf) {
			this.setLayout(new BorderLayout());
			jb = new JButton("ѡ��");
			jb.addActionListener(this);
			JPanel jp_up = new JPanel();
			jp_up.setLayout(new BorderLayout());
			JPanel jp_down = new JPanel();
			jp_down.setPreferredSize(new Dimension(0, 100));
			jp_down.add(jb);
			rowData = new CourseControl().queryElectiveCourse();
			jt = SwingUtil.addTable(dataMap, jp_up, rowData, name);
			this.add(jp_up, BorderLayout.CENTER);
			this.add(jp_down, BorderLayout.SOUTH);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jb) {
				int a = JOptionPane.showConfirmDialog(this, "�����Ҫѡ���ſγ̣�");
				switch (a) {
				case 0:
					System.out.println("����ȷ��ѡ���ſγ�");
					int row = jt.getSelectedRow();
					if (row < 0) {
						return;
					} else {
						long studentAccount = Long.parseLong(stuAccount);
						ChooseCourse cc = new ChooseCourse();
						cc.setStu_id(studentAccount);
						cc.setCou_id((int) jt.getValueAt(row, 1));
						System.out.println(cc.getStu_id());
						System.out.println(cc.getCou_id());
						ChooseCourseControl ccc = new ChooseCourseControl();
						int cccc = ccc.addChooseCourse(cc,(int)jt.getValueAt(row, 10));
						switch (cccc) {
						case 11: 
							JOptionPane.showMessageDialog(this, "ѡ���ÿγ���");
							 break;
						case 13: 
							JOptionPane.showMessageDialog(this, "ѡ����Ŀ�ﵽ����");
							 break;
						case 9: 
							JOptionPane.showMessageDialog(this, "ѡ�γɹ�");
							  break;
						case 99: 
							JOptionPane.showMessageDialog(this, "�ÿγ�������������ѡ�������γ�");
							  break;
						}
					}
					break;
				}
			
			}
		}
	}
}
