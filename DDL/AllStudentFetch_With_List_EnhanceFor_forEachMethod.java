package com.StudenManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AllStudentFetch_With_List_EnhanceFor_forEachMethod {

	public static void main(String[] args) throws SQLException {

		Connection connection = null;

		try {
			connection = DatabaseConnection.getDatabaseConnection();

			String query = "select * from student";

			Statement statement = connection.createStatement();

			statement.executeQuery(query);

			ResultSet rs = statement.executeQuery(query);

			List<Student> listOfStudents = new ArrayList<Student>();

			while (rs.next()) {

				int id = rs.getInt(1);
				String name = rs.getString(2);
				String sClass = rs.getString(3);
				String address = rs.getString(4);
				long sContact = rs.getLong(5);

				Student student = new Student(id, name, sClass, address, sContact);

				listOfStudents.add(student);
			}

			System.out.println("Display records using Enhance for loop");

			for (Student student : listOfStudents) {
				System.out.println(student);
			}

			System.out.println("-------------------------------------------------------------------------------");

			System.out.println("Display records using forEach method");

			listOfStudents.forEach(student -> System.out.println(student));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}

}
