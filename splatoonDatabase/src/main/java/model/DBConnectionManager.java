package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
	private static final String JDBC_URL = "jdbc:mysql://localhost/splatoon3_database";
	private static final String DB_USER = "test";
	private static final String DB_PASS = "2525";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}

	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
	}
}
