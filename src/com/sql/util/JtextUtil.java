package com.sql.util;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

public class JtextUtil implements FocusListener {
	private String hintText;
	private JTextField textField;
	public JtextUtil(JTextField jTextField,String hintText) {
		this.textField = jTextField;
		this.hintText = hintText;
		jTextField.setText(hintText);  //Ĭ��ֱ����ʾ
		jTextField.setForeground(Color.red);
	}
 
	@Override
	public void focusGained(FocusEvent e) {
		//��ȡ����ʱ�������ʾ����
		String temp = textField.getText();
		if(temp.equals(hintText)) {
			textField.setText("");
			textField.setForeground(Color.black);
		}
		
	}
 
	@Override
	public void focusLost(FocusEvent e) {	
		//ʧȥ����ʱ��û���������ݣ���ʾ��ʾ����
		String temp = textField.getText();
		if(temp.equals("")) {
			textField.setText(hintText);
			textField.setForeground(Color.red);
		}
	}
}

