package com.sql.util;

import java.awt.CardLayout;
import java.awt.Color;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;

public class TableUtil extends JPanel {
	JTable table;
	public TableUtil(Vector<Object> rowDate, String[] name) {
		Vector<Object> columnNames = new Vector<>();
		for (int i = 0; i < name.length; i++) {
			columnNames.add("" + name[i]);
		}
		table = new Mtable(rowDate, columnNames);
		JScrollPane jsp = new JScrollPane(table);
		this.setLayout(new CardLayout());
		this.add(jsp);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSelectionBackground(Color.YELLOW);
		table.setSelectionForeground(Color.RED);
		table.setRowHeight(30);
		jsp.setViewportView(table);
	}


	public class Mtable extends JTable {
		public Mtable(Vector<Object> rowDate, Vector<Object> columnNames) {
			super(rowDate, columnNames);
		}
		public TableCellRenderer getDefaultRenderer(Class<?> columnClass) {
			JTableHeader tableHeader = super.getTableHeader();
			tableHeader.setReorderingAllowed(false);
			DefaultTableCellRenderer cr = (DefaultTableCellRenderer) super.getDefaultRenderer(columnClass);
			cr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			return cr;
		}
		public boolean isCellEditable(int row, int column) {
			return false;
		}

	}

}
