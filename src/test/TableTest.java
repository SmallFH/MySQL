package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableTest {
	JFrame jf;
	DefaultTableModel defaultTableModel;
	
	public TableTest() {
		jf = new JFrame("增加信息表格测试");
		jf.setLayout(new BorderLayout());
		
		Vector<Object> rowCount = rowCount();
		Vector<Object> columnNames = columnNames();
		defaultTableModel = new DefaultTableModel(rowCount, columnNames);
		JTable jTable = new JTable(defaultTableModel);
		JScrollPane JSP = new JScrollPane(jTable);
		
		JPanel buttonJp = new JPanel();
		buttonJp.setBackground(Color.RED);
		buttonJp.setPreferredSize(new Dimension(0, 80));
		
		JButton addRow = new JButton("添加空白行");
		addRow.addActionListener(new AddRow(defaultTableModel));
		buttonJp.add(addRow);
		
		JButton saveData = new JButton("保存数据");
		saveData.addActionListener(new SaveData(defaultTableModel));
		buttonJp.add(saveData);
		
		JButton delRow = new JButton("删除选中行");
		delRow.addActionListener(new DelRow(defaultTableModel, jTable));
		buttonJp.add(delRow);
		
		jf.add(JSP,BorderLayout.CENTER);
		jf.add(buttonJp,BorderLayout.SOUTH);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(1000, 800);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
	}
	
	private Vector<Object> columnNames() {
		Vector<Object> columnNames = new Vector<>();
		columnNames.add("A");
		columnNames.add("B");
		columnNames.add("C");
		return columnNames;
	}

	private Vector<Object> rowCount() {
		Vector<Object> rowCount = new Vector<>();
		Vector<Object> hang = null;
		for (int i = 1; i < 7; i++) {
			hang = new Vector<>();
			hang.add("A"+i);
			hang.add("B"+i);
			hang.add("C"+i);
			rowCount.add(hang);
		}
		return rowCount;
	}

	public static void main(String[] args) {
		new TableTest();
	}
	
	
	public class AddRow implements ActionListener{
		DefaultTableModel defaultTableModel;
		public AddRow(DefaultTableModel defaultTableModel) {
			this.defaultTableModel = defaultTableModel;
		}
		
		public void actionPerformed(ActionEvent e) {
			Vector<Object> a = new Vector<>();
			defaultTableModel.insertRow(0, a);
		}
	}
	
	public class SaveData implements ActionListener{
		JTable jTable;
		DefaultTableModel defaultTableModel;
		public SaveData(DefaultTableModel defaultTableModel) {
			this.defaultTableModel = defaultTableModel;
		}
		
		public void actionPerformed(ActionEvent e) {
			System.out.println("---------");
			int rowCount = defaultTableModel.getRowCount();
			int columnCount = defaultTableModel.getColumnCount();
			System.out.println(rowCount+" / "+columnCount);
			int a = 1;
			b: for (int i = 0; i < rowCount; i++) {
				if (defaultTableModel.getValueAt(i, 0)==null||defaultTableModel.getValueAt(i, 0).equals("")) {
					a = 0;
					break;
				} else {
					for (int j = 0; j < columnCount; j++) {
						if (defaultTableModel.getValueAt(i, j)==null||defaultTableModel.getValueAt(i, j).equals("")) {
							System.out.println("空");
							a = 0;
							break b;
						}
					}
				}
			}
			if (a == 0) {
				JOptionPane.showMessageDialog(jf, "表格中存在空的单元格，请先删除空单元格行");
			}else {
				//判断表中的数据是不是自己要的数据类型？
				System.out.println(defaultTableModel.getDataVector());
			}
			System.out.println("---------");
		}
	}
	
	public class DelRow implements ActionListener{
		JTable jTable;
		DefaultTableModel defaultTableModel;
		public DelRow(DefaultTableModel defaultTableModel,JTable jTable) {
			this.defaultTableModel = defaultTableModel;
			this.jTable = jTable;
		}
		
		public void actionPerformed(ActionEvent e) {
			int a = jTable.getSelectedRow();
			if (a<0) {
			}else {
				defaultTableModel.removeRow(a);
			}
		}
	}
	
}
