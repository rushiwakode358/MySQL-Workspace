package com.StudenManagement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Comparator;
import java.util.Comparator;

public class DeleteStudent {

	public static void main(String[] args) throws SQLException {

		Connection connection = null;

		try {
			connection = DatabaseConnection.getDatabaseConnection();

			Student student = new Student();
			
			student.setStudentId(101);

			String query = "delete from student where student_Id = '"+student.getStudentId()+ "'";

			Statement statement = connection.createStatement();
//			statement.execute(query);  //if you want to execute this statement then you can comment the following int status and if-else statement

			int status = statement.executeUpdate(query);

			if (status > 0) {
				System.out.println("Student data deleted from database table");
			} else {
				System.out.println("Student data not deleted from database table");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}

}
