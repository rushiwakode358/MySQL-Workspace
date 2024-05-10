package com.StudenManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FetchStudent1 {

	public static void main(String[] args) throws SQLException {

		Connection connection = null;

		try {
			connection = DatabaseConnection.getDatabaseConnection();
			
			Student student = new Student();
			student.setStudentId(101);

			String query = "select * from student";

			Statement statement = connection.createStatement();
			statement.execute(query);

			ResultSet rs = statement.executeQuery(query);

//			List<Student> listOfStudents = new ArrayList<Student>();

//			Collections.sort(listOfStudents, Comparator.comparing(Student::getstudentContactNo));

			while (rs.next()) {

				int id = rs.getInt(1);
				String name = rs.getString(2);
				String sClass = rs.getString(3);
				String address = rs.getString(4);
//				long sContact = rs.getString(5);
				long sContact = rs.getLong(5);

//				long contact = Long.parseLong(sContact);

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
