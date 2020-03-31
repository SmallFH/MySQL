package com.sql.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetMySQLUtil {
	private static final String DIR = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/school?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
	private static final String USER = "Smile_FH";
	private static final String PASS = "Fh0816.";

	public static Connection getMySQL() {
		Connection connection = null;
		try {
			Class.forName(DIR);
			connection = DriverManager.getConnection(URL, USER, PASS);
			connection.setAutoCommit(false);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
