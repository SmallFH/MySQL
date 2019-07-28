package com.sql.dao;

import java.util.Vector;

import com.sql.model.User;
import com.sql.util.ChangeSqlUtil;

public class UserDao {
	ChangeSqlUtil changeSqlUtil = new ChangeSqlUtil();
	
	public Vector<Object> queryOne(int id, String name) {
		return changeSqlUtil.query("SELECT userpass,userquestion,useranswer FROM user WHERE userid=? AND username=? ", id,name);
	}
	
	public Vector<Object> queryPass(String name, String passWord){
		return changeSqlUtil.query("SELECT * FROM user WHERE username=? AND userpass=MD5(?)", name, passWord);
	}
	
	public Vector<Object> queryAccount(String account,int id){
		return changeSqlUtil.query("SELECT * FROM user WHERE username=? AND userid=?", account, id);
		
	}
	
	public Vector<Object> queryAnswer(String userName,String newUserAnswer){
		return changeSqlUtil.query("SELECT * FROM user WHERE username=? AND useranswer=MD5(?)", userName, newUserAnswer);
	}
	
//	public static void main(String[] args) {
//		Vector<Object> a = new UserDao().queryPass("52147896321","a");
//		System.out.println(a);
//	}
	
	public boolean addUser(User user) {
		return changeSqlUtil.write("REPLACE INTO user VALUE(?,?,MD5(?),?,MD5(?))",
				user.getId(),
				user.getUsername(),
				user.getPassword(),
				user.getQuestion(),
				user.getAnswer());
	}
	
	public void updatePass(int userID,String userAccount,String newPass) {
		 changeSqlUtil.write("UPDATE user SET userpass=MD5(?) WHERE userid=? AND username=?",newPass,userID,userAccount);
	}
	
	public void updateSecurityIssue(int userID,String userAccount,String newQuestion, String newAnswer) {
		changeSqlUtil.write("UPDATE user SET userquestion=?,useranswer=MD5(?) WHERE userid=? AND username=?", newQuestion,newAnswer,userID,userAccount);
	}
	
	
}
