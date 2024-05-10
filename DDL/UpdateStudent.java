package com.StudenManagement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Comparator;
import java.util.Comparator;

public class UpdateStudent {

	public static void main(String[] args) throws SQLException {

		Connection connection = null;

		try {
			connection = DatabaseConnection.getDatabaseConnection();

			Student student = new Student();
			
			student.setStudentId(101);
			student.setStudentName("Rushi");
			student.setStudentClass("B.E CS");
			student.setStudentAddress("Pune");
			student.setStudentContactN0(9876543210L);

			String query = "update student set student_Name = '"+student.getStudentName()+"',student_class = '"+student.getStudentClass()+"',student_Address =  '"+student.getStudentAddress()+"',student_Contact_No = '"+student.getStudentContactN0()+"'where student_Id = '"+student.getStudentId()+ "'";

			Statement statement = connection.createStatement();
//			statement.execute(query);  //if you want to execute this statement then you can comment the following int status and if-else statement

			int status = statement.executeUpdate(query);

			if (status > 0) {
				System.out.println("Student data Update in database table");
			} else {
				System.out.println("Student data not Update in database table");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}

}
