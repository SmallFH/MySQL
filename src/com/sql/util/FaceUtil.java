package com.sql.util;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sql.model.DataMap;

public class FaceUtil extends JFrame{
	protected JPanel jp;
	protected DataMap dataMap;

	protected FaceUtil() {

	}

	protected void CreateJF() {
		setTitle(dataMap.getJf_name());
		setLayout(new BorderLayout());
		JFadd();
		setSize(dataMap.getJf_size()[0], dataMap.getJf_size()[1]);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	protected void JFadd() {
		JP();
		add(jp, BorderLayout.CENTER);
		
	}

	protected JPanel JP() {
		jp = new JPanel();
		jp.setLayout(null);
//		jp.setBackground(Color.red);
		return jp;
	}
	
}

