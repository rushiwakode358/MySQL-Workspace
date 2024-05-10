package com.StudenManagement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SaveStudent {

	public static void main(String[] args) throws SQLException {

		Connection connection = null;

		try {
			connection = DatabaseConnection.getDatabaseConnection();
      
			Student student = new Student(101, "Rushikesh", "BE", "Pune", 1234567890L);
			
			String query = "insert into student values('"+student.getStudentId()+"', '"+student.getStudentName()+"', '"+student.getStudentClass()+"', '"+student.getStudentAddress()+"', '"+student.getStudentContactN0()+"')";

			Statement statement = connection.createStatement();
//			statement.execute(query);  //if you want to execute this statement then you can comment the following int status and if else statement.

			int status = statement.executeUpdate(query);

			if (status > 0) {
				System.out.println("Student data stored in database table");
			} else {
				System.out.println("Student data not stored in database table");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}

}
