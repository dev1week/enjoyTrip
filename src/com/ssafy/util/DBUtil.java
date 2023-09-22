package com.ssafy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private final String driverName = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/enjoytrip?serverTimezone=UTC";
	private final String user = "ssafy";
	private final String pass = "ssafy";

	// 1. 드라이버 로딩
	private static DBUtil instance = new DBUtil();

	private DBUtil() {
		try {
			Class.forName(driverName);
			System.out.println("드라이버 로딩 완료");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static DBUtil getInstance() {
		return instance;
	}

	// 2. DB 연결
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, pass);
	}

	// 5. 연결 해제, 종료
	public void close(AutoCloseable... closeables) {
		for (AutoCloseable c : closeables) {
			if (c != null) {
				try {
					c.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
