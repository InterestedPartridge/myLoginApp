package myLoginApp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	
	public static Connection getDBConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, "postgres", "postgres");
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return conn;
	}
}
