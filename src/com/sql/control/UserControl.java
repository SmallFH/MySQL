package com.sql.control;

import java.util.Vector;

import org.omg.Messaging.SyncScopeHelper;

import com.sql.dao.UserDao;
import com.sql.model.User;

public class UserControl {
	UserDao ud = new UserDao();
	User user = new User();

	public boolean addUser() {
		if (ud.addUser(user)) {
			return true;
		} else {
			return false;
		}
	}

	public int enterJudge(String id, String account, String userpass) {
		int idNumber = 1;
		switch (id) {
		case "��ʦ":
			idNumber = 2;
			break;
		case "����Ա":
			idNumber = 3;
			break;
		}
		if (account.equals("")) {
			idNumber = 4;
		} else if (userpass.equals("")) {
			idNumber = 5;
		} else {
			try {
				Vector<Object> userAccount = (Vector<Object>) ud.queryAccount(account, idNumber).get(0);
				try {
					@SuppressWarnings("unchecked")
					Vector<Object> user = (Vector<Object>) ud.queryPass(account, userpass).get(0);
					String a = String.valueOf(idNumber);
					if (user.get(0).equals(a)) {
						return idNumber;
					}
				} catch (Exception e) {
					return 6;
				}
			} catch (Exception e) {
				idNumber = 0;
			}
		}
		return idNumber;
	}

	public int addUser(int id, String[] parameter) {
		String[] egname = { "", "", "e.g. �ҽ�ʲô���֣�", "e.g. ����", "e.g. 11λ����" };
		for (int i = 0; i < egname.length; i++) {
			if (parameter[i].equals(egname[i])) {
				return i;
			}
		}
		if (!parameter[0].equals(parameter[1])) {
			return 10;
		}
		user.setUsername(new Long(parameter[4]));
		user.setId(id);
		user.setPassword(parameter[0]);
		user.setQuestion(parameter[2]);
		user.setAnswer(parameter[3]);
		return 9;
	}

	@SuppressWarnings("unchecked")
	public Vector<Object> queryUserInfo(int id, String account) {
		return (Vector<Object>) ud.queryOne(id, account).get(0);
	}

	public int updatePass(int userID, String userAccount, String userAnswer, String answer, String newPass,
			String judgePass) {
		if (answer.equals("")) {
			return 5;
		} else if (newPass.equals("")) {
			return 4;
		} else if (newPass.equals(judgePass)) {
			Vector<Object> a = (Vector<Object>) ud.queryAnswer(userAccount, answer).get(0);
			String b = String.valueOf(userID);
			if (a.get(0).equals(b)) {
				ud.updatePass(userID, userAccount, newPass);// ��Ҫ���������������
				// ���ж��ܱ����Ƿ���ȷ����ȥ�޸�����
				return 1;
			} else {
				return 2;// �ܱ��𰸲���ȷ
			}
		} else {
			return 3;// ������������벻һ��
		}
	}

	public int restPassWord(int accountId, String account, String adminPassWord, String adminPass) {
		if (adminPass.equals("") || adminPass == null) {
			System.out.println("���������Ա����");
			return 0;
		} else if (account.equals("") || account == null) {
			System.out.println("���������������˺�");
			return 1;
		} else {
			try {
				Vector<Object> user = (Vector<Object>) ud.queryPass("0", adminPass).get(0);
				try {
					@SuppressWarnings("unchecked")
					Vector<Object> user1 = (Vector<Object>) ud.queryOne(accountId, account).get(0);
					ud.updatePass(accountId, account, "123456");
					return 2;
				} catch (Exception e) {
					return 3;
				}
			} catch (Exception e) {
				return 4;
			}
		}
	}

	public int updateSecurityIssue(int userID, String userAccount, String newQuestion, String newAnswer) {
		if (newQuestion.equals("") || newQuestion == null) {
			return 1;// ����Ϊ��
		} else if (newAnswer.equals("") || newAnswer == null) {
			return 2;// ��Ϊ��
		} else {
			ud.updateSecurityIssue(userID, userAccount, newQuestion, newAnswer);
			return 3;// �ܱ������޸ĳɹ�
		}
	}
}
