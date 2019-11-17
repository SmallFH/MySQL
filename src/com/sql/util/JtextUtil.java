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
		jTextField.setText(hintText);  //默认直接显示
		jTextField.setForeground(Color.red);
	}
 
	@Override
	public void focusGained(FocusEvent e) {
		//获取焦点时，清空提示内容
		String temp = textField.getText();
		if(temp.equals(hintText)) {
			textField.setText("");
			textField.setForeground(Color.black);
		}
		
	}
 
	@Override
	public void focusLost(FocusEvent e) {	
		//失去焦点时，没有输入内容，显示提示内容
		String temp = textField.getText();
		if(temp.equals("")) {
			textField.setText(hintText);
			textField.setForeground(Color.red);
		}
	}
}

