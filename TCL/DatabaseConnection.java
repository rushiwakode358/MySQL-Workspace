package com.TCL;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/database_name";
	private static final String DATABASE_USERNAME = "username";
	private static final String DATABASE_PASSWORD = "password";

	public static Connection getDatabaseConnection() {

		Connection connection = null;

		try {

			Class.forName(DATABASE_DRIVER);
			
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;

	}

}
