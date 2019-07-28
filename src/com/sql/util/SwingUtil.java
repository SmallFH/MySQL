package com.sql.util;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

import com.sql.model.DataMap;

public class SwingUtil {
	public static JButton[] jb;
	public static JLabel[] jl;
	public static JTextField[] jtf;
	public static JPasswordField[] jpf;
	public static JComboBox<String> jcb;
	public static JRadioButton[] jrb;
	public static JMenuBar jmb;
	public static JMenu[] jmu;
	public static JMenuItem[][] jmi;
	
	/**
	 *传参数传一个DataMap过来就好
	 */
	
	public static JButton[] JB(DataMap dataMap,JFrame jf,JPanel jp) {
		int[] jb_parameter = dataMap.getJb_parameter();
		String[] jb_name = dataMap.getJb_name();
		jb = new JButton[jb_parameter[0]];
		for (int i = 0; i < jb_parameter[0]; i++) {
			jb[i] = new JButton(jb_name[i]);
			jb[i].setBounds(jb_parameter[1] + jb_parameter[3] * i, jb_parameter[2], jb_parameter[3], jb_parameter[4]);
			jp.add(jb[i]);
			jb[i].addActionListener((ActionListener) jf);
		}
		return jb;
	}
	
	public static JLabel[] JL(DataMap dataMap, JPanel jp) {
		int[] jl_parameter = dataMap.getJl_parameter();
		String[] jl_name   = dataMap.getJl_name();
		jl = new JLabel[jl_parameter[0]];
		for (int i = 0; i < jl_parameter[0]; i++) {
			jl[i] = new JLabel(jl_name[i]);
			jl[i].setBounds(jl_parameter[1], jl_parameter[2] + jl_parameter[4] * i, jl_parameter[3], jl_parameter[4]);
			jp.add(jl[i]);
		}
		return jl;
	}
	
	public static JComboBox<String> JCB(DataMap dataMap, JPanel jp) {
		int[] jc_parameter = dataMap.getJcb_parameter();
		String[] jc_name = dataMap.getJcb_name();
		jcb = new JComboBox<>(jc_name);
		jcb.setBounds(jc_parameter[1], jc_parameter[2], jc_parameter[3], jc_parameter[4]);
		jp.add(jcb);
		return jcb;
	}
	
	public static JTextField[] JTF(DataMap dataMap, JPanel jp) {
		int[] jtf_parameter = dataMap.getJtf_parameter();
		jtf = new JTextField[jtf_parameter[0]];
		for (int i = 0; i < jtf_parameter[0]; i++) {
			jtf[i] = new JTextField();
			jtf[i].setBounds(jtf_parameter[1], jtf_parameter[2]+10*i + jtf_parameter[4] * i, jtf_parameter[3],
					jtf_parameter[4]);
			jp.add(jtf[i]);
		}
		return jtf;
	}
	
	public static JPasswordField[] JPF(DataMap dataMap, JPanel jp) {
		
		int[] jpf_parameter = dataMap.getJpf_parameter();
			jpf = new JPasswordField[jpf_parameter[0]];
			for (int i = 0; i < jpf_parameter[0]; i++) {
				jpf[i] = new JPasswordField();
				jpf[i].setBounds(jpf_parameter[1], jpf_parameter[2]+10*i + jpf_parameter[4] * i, jpf_parameter[3], jpf_parameter[4]);
				jp.add(jpf[i]);
			}
			return jpf;
	}
	
	public static JRadioButton[] JRB(DataMap dataMap, JFrame jf, JPanel jp) {
		int[] jrb_parameter =dataMap.getJrb_parameter();
		String[] jrb_name=dataMap.getJrb_name();
		ButtonGroup bg = new ButtonGroup();
		jrb = new JRadioButton[jrb_parameter[0]];
		for (int i = 0; i < jrb_parameter[0]; i++) {
			jrb[i] = new JRadioButton(jrb_name[i]);
			jrb[i].setBounds(jrb_parameter[1] + jrb_parameter[3] * i, jrb_parameter[2] , jrb_parameter[3], jrb_parameter[4]);
			bg.add(jrb[i]);
			jp.add(jrb[i]);
			jrb[i].addActionListener((ActionListener) jf);
		}
		return jrb;
	}
	
	public static JMenuBar JMB(DataMap dataMap,JFrame jf) {
		ArrayList<String[]> a = dataMap.getArrayList();
		jmb = new JMenuBar();
		jmu = new JMenu[a.get(0).length];
		jmi = new JMenuItem[a.get(0).length][];
		for (int i = 0; i < a.get(0).length; i++) {
			jmi[i] = new JMenuItem[a.get(i+1).length];
		}
		for (int i = 0; i < a.get(0).length; i++) {
			jmu[i] = new JMenu(a.get(0)[i]);
			for (int j = 0; j < a.get(i+1).length; j++) {
				jmi[i][j] = new JMenuItem(a.get(i+1)[j]);
				jmu[i].add(jmi[i][j]);
				jmi[i][j].addActionListener((ActionListener) jf);
			}
			jmb.add(jmu[i]);
		}
		return jmb;
	}
	
	public static JTable addTable(DataMap dataMap,JPanel jp,Vector<Object> rowData,String[] name) {
			jp.removeAll();
			TableUtil text = new TableUtil(rowData, name);
			text.setBounds(0, 0, dataMap.getJf_size()[0], dataMap.getJf_size()[1]);
			jp.add(text);
			jp.validate();
			return text.table;
	}
	
	public static boolean isValidDate(String str) {
		        boolean convertSuccess=true;
		         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		         try {
		            format.setLenient(false);
		            format.parse(str);
		         } catch (ParseException e) {
		           // e.printStackTrace();
		 // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
		            convertSuccess=false;
		        } 
		        return convertSuccess;
		 }

}
