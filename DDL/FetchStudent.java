package com.StudenManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchStudent {

	public static void main(String[] args) throws SQLException {

		Connection connection = null;

		try {
			connection = DatabaseConnection.getDatabaseConnection();
			
			Student student = new Student();
			student.setStudentId(101);

			String query = "select * from student where student_Id = '"+student.getStudentId()+"'";

			Statement statement = connection.createStatement();
			statement.execute(query);

			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {

				int id = rs.getInt(1);
				String name = rs.getString(2);
				String sClass = rs.getString(3);
				String address = rs.getString(4);
				long sContact = rs.getLong(5);

				Student student1 = new Student(id, name ,sClass, address, sContact);
				
				System.out.println(student1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}

}
