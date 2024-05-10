package com.TCL;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/productdb";
	private static final String DATABASE_USERNAME = "root";
	private static final String DATABASE_PASSWORD = "Rushikesh";

	public static Connection getDatabaseConnection() {

		Connection connection = null;

		try {
			// Object creation
			//Class can fetch the DATABASE_DRIVER and create the object
			Class.forName(DATABASE_DRIVER);
			
			// DriverManager can manage the all Drivers
			// getConnection method return connection to the url. It is establish the connectionn to the database
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;

	}

}
