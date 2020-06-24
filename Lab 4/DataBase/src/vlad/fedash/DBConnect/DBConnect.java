package vlad.fedash.DBConnect;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import vlad.fedash.Library;

public class DBConnect {

	private static Connection conn;
	private static final String URL = "jdbc:mysql://localhost/javalabs?serverTimezone=Europe/Moscow&useSSL=FALSE";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	public static void main(String[] args) {
		Library.select();
	}

	public static void driverConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			try (Connection conn = getConnection()) {

				System.out.println("Connection to Store DB succesfull!");
			}
		} catch (Exception ex) {
			System.out.println("Connection failed...");

			System.out.println(ex);
		}
	}

	public static Connection getConnection() throws SQLException, IOException {

		conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		return conn;
	}

	public static void DBClose() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException sQLException) {
		}

	}
}
