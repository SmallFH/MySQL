package com.sql.control;

import java.sql.Timestamp;
import java.util.Vector;

import com.sql.dao.AdminDao;
import com.sql.util.ChangeSqlUtil;
import com.sql.util.SwingUtil;

public class AdminControl {
	AdminDao adminDao;
	ChangeSqlUtil change= new ChangeSqlUtil();
	
	public AdminControl(int tableNumber) {
		adminDao = new AdminDao(tableNumber);
	} 
	
	public int allNumber(String queryKey, int pageSize) {
		int a = adminDao.queryAllNumber(queryKey);
		int b = a / pageSize; 
		if (a % pageSize == 0) {
			return b;
		} else {
			return b + 1;
		}
	}
	
	public Vector<Object> queryAllInfo(int tableNumber, String queryKey, int page, int pageSize){
		Vector<Object> adminQueryResult = adminDao.queryAllInfo(queryKey,page, pageSize);
		Vector<Object>[] newResult = new Vector[adminQueryResult.size()];
		Vector<Object>  rowData = new Vector<>();
		for (int i = 0; i < adminQueryResult.size(); i++) {
			newResult[i] = (Vector<Object>) adminQueryResult.get(i);
			switch (tableNumber) {
			case 0:
				switch ((String)newResult[i].get(2)) {
				case "1": newResult[i].set(2, "大一"); break;
				case "2": newResult[i].set(2, "大二"); break;
				case "3": newResult[i].set(2, "大三"); break;
				case "4": newResult[i].set(2, "大四"); break;
				}
				switch ((String)newResult[i].get(6)) {
				case "0": newResult[i].set(6, "女"); break;
				case "1": newResult[i].set(6, "男"); break;
				}
				newResult[i].set(7, change.toStringDate((Timestamp) newResult[i].get(7)));
				break;
			case 1:
				switch ((String)newResult[i].get(5)) {
				case "0": newResult[i].set(5, "女"); break;
				case "1": newResult[i].set(5, "男"); break;
				}
				newResult[i].set(6, change.toStringDate((Timestamp) newResult[i].get(6)));
				break;
			case 3:
				switch ((String)newResult[i].get(10)) {
				case "0": newResult[i].set(10, "考查"); break;
				case "1": newResult[i].set(10, "考试"); break;
				}
				switch ((String)newResult[i].get(5)) {
				case "0":
					newResult[i].set(5, "正课");
					break;
				case "1":
					newResult[i].set(5, "选修课");
					break;
				}
			}
			rowData.add(newResult[i]);
		}
		return rowData;
	}
	
	public int addAllInfo(int tableNumber, String[][] data) {
		int judge = 1;
		String[][] passArray = new String[data[0].length][data.length];
		//判断data中的数据
		switch (tableNumber) {
		case 0:
			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data[i].length; j++) {
					if (data[i][0].length()>15||data[i][1].length()>15||data[i][3].length()>8||data[i][4].length()!=11||data[i][5].length()>15||data[i][8].length()!=11) {
						return 0;
					}
					else if (!SwingUtil.isValidDate(data[i][7])) {
						//日期错误
						return 7;
					}
					
					switch (data[i][2]) {
					case "大一":
						data[i][2] = "1";
						break;
					case "大二":
						data[i][2] = "2";
						break;
					case "大三":
						data[i][2] = "3";
						break;
					case "大四":
						data[i][2] = "4";
						break;
					case "1":
						break;
					case "2":
						break;
					case "3":
						break;
					case "4":
						break;
					default:
						return 2;
					}
					switch (data[i][6]) {
					case "男":
						data[i][6] = "1";
						break;
					case "女":
						data[i][6] = "0";
						break;
					case "1":
						break;
					case "0":
						break;
					default:
						return 3;
					}
					passArray[j][i] = data[i][j];
				}
			}
			adminDao.addInfo(passArray[0],passArray[1],passArray[2],passArray[3],passArray[4],passArray[5],passArray[6],passArray[7],passArray[8]);
			break;
		}
		return judge;
	}
	
	
}
