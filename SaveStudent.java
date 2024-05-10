package com.StudenManagement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SaveStudent {

	public static void main(String[] args) throws SQLException {

		Connection connection = null;

		try {
			connection = DatabaseConnection.getDatabaseConnection();

//			Student student = new Student(101, "Rushikesh", "B.E CS", "Pune", 7447663401L);
//			Student student = new Student(102, "Rhushikesh", "B.E CS", "Pune", 8767139898L);
//			Student student = new Student(103, "Hitesh", "B.E CS", "Pune", 9022179700L);
//			Student student = new Student(104, "Manmath", "B.E CS", "Pune", 9545151964L);
//			Student student = new Student(105, "Ganesh", "B.E CS", "Pune", 9373961764L);
			Student student = new Student(109, "Abhishek", "BA", "Nandura", 9529241907L);
			
			String query = "insert into student values('"+student.getStudentId()+"', '"+student.getStudentName()+"', '"+student.getStudentClass()+"', '"+student.getStudentAddress()+"', '"+student.getStudentContactN0()+"')";

			Statement statement = connection.createStatement();
//			statement.execute(query);

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
