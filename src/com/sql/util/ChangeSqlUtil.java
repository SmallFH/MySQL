package com.sql.util;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class ChangeSqlUtil {
	Connection connection = GetMySQLUtil.getMySQL();
	PreparedStatement ps = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public boolean write(String sql, Object... params) {
		boolean a = true;
		try {
			ps = connection.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			ps.executeUpdate();
			connection.commit();
			ps.close();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println("SQl写入异常");
			e.printStackTrace();
			return a = false;
		}
		return a;
	}

	public boolean writeBatch(String sql, Object... params) {
		boolean a = true;
		try {
			ps = connection.prepareStatement(sql);
			String[] c = (String[])params[0];
			int clength = c.length;
			for (int i = 0; i < 10; i++) {
					for (int k = 0; k < clength; k++) {
						for (int k2 = 0; k2 < params.length; k2++) {
							String[] b = (String[])params[k2];
							ps.setObject(k2 + 1, (String)b[k]);
						}
						ps.addBatch();
					}
				if (i % 2 == 0) {
					ps.executeBatch();
					connection.commit();
					ps.clearBatch();
				}
			}
			ps.executeBatch();
			connection.commit();
			ps.clearBatch();
			ps.close();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println("SQl写入异常");
			e.printStackTrace();
			return a = false;
		}
		return a;
	}

	/**
	 * params[0] == 0(查询详细信息),1(查询信息总数),2(分页查询信息条数)
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public Vector<Object> query(String sql, Object... params) {
		Vector<Object> res = new Vector<Object>();
		try {
			ps = connection.prepareStatement(sql);
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
			ResultSet rs = ps.executeQuery();
			Vector<Object> hang = null;
			while (rs.next()) {
				hang = new Vector<Object>();
				ResultSetMetaData rs1 = rs.getMetaData();
					for (int i = 0; i < rs1.getColumnCount(); i++) {
						hang.add(rs.getObject(i + 1));
					}
				res.add(hang);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public Date toDate(String stringDate) {
		Date utilDate = null;
		try {
			utilDate = sdf.parse(stringDate);
		} catch (ParseException e) {
			return utilDate;
//			e.printStackTrace();
		}
		return utilDate;
	}
	
	public String toStringDate(Timestamp timestamp) {
		return sdf.format(timestamp);
	}
	
	public String filtrationString(String oldString) {
		String newString = oldString.replaceAll("[\\t\\\b\\\n\\\f\\\r\\\"\\\'\\\\`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？ a-z]","");
		System.out.println(newString.length());
		if (newString.length()!=11) {
			System.out.println(false);
		}else {
			System.out.println(true);
		}
		return newString;
	}
	
	
}
