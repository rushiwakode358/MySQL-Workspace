package com.StudenManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FetchStudentWithSorting {

	public static void main(String[] args) throws SQLException {

		Connection connection = null;

		try {
			connection = DatabaseConnection.getDatabaseConnection();

			String query = "select * from student";

			Statement statement = connection.createStatement();
			statement.execute(query);

			ResultSet rs = statement.executeQuery(query);

			List<Student> listOfStudents = new ArrayList<>();

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String sClass = rs.getString(3);
				String address = rs.getString(4);
				long sContact = rs.getLong(5);

				Student student = new Student(id, name, sClass, address, sContact);
				listOfStudents.add(student);
			}

			// Sorting the list based on Student Contact Number
//			Collections.sort(listOfStudents, Comparator.comparingLong(Student::getStudentContactN0));

//			Sorting the list based on Student Name
			Collections.sort(listOfStudents, Comparator.comparing(Student::getStudentName));

			// Printing sorted students
			for (Student student : listOfStudents) {
				System.out.println(student);
			}

//			System.out.println();
//			System.out.println("----------------------------------------------------------------------------");
//			System.out.println();
//			
//			while (rs.next()) {
//				int id = rs.getInt(1);
//				String name = rs.getString(2);
//				String sClass = rs.getString(3);
//				String address = rs.getString(4);
//				String sContact = rs.getString(5);
//				
//				long contact = Long.parseLong(sContact);
//
//				Student student = new Student(id, name, sClass, address, contact);
//				listOfStudents.add(student);
//			}
//			Error occure this line
//			List<Student> sortedListOfStudents = listOfStudents.stream().sorted(Comparator.comparing(Student::getStudentContactNo)).collect(Collectors.toList());
//			sortedListOfStudents.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}
}
