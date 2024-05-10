package com.TCL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SaveProduct {

	public static void main(String[] args) throws SQLException {

		Connection connection = null;
		Scanner scanner = null;

		try {

			connection = DatabaseConnection.getDatabaseConnection();

			while (true) {
				connection.setAutoCommit(false);

				scanner = new Scanner(System.in);

				System.out.println("Enter Product Id : ");
				int id = scanner.nextInt();

				scanner.nextLine();

				System.out.println("Enter Product Brand : ");
				String brand = scanner.nextLine();

				System.out.println("Enter Product Model : ");
				String model = scanner.nextLine();

				System.out.println("Enter customer Price: ");
				double price = scanner.nextDouble();

				Product product = new Product(id, brand, model, price);

				String query = "insert into product(Product_Id, Product_Brand, Product_Model, Product_Price) values(?, ?, ?, ?)";

				PreparedStatement preparedStatement = connection.prepareStatement(query);

				preparedStatement.setInt(1, product.getProductId());
				preparedStatement.setString(2, product.getProductBrand());
				preparedStatement.setString(3, product.getProductModel());
				preparedStatement.setDouble(4, product.getProductPrice());

				preparedStatement.executeUpdate();

				System.out.println("\nwant to 'commit/rollback' the Product object?");
				String inputAnswer = scanner.next().toLowerCase();

				if (inputAnswer.equals("commit")) {
					connection.commit();
				} else if (inputAnswer.equals("rollback")) {
					connection.rollback();
				}

				System.out.println("\nwant to save more Product objects? 'yes/no'");
				String response = scanner.next().toLowerCase();

				if (response.equals("no")) {
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			scanner.close();
		}

	}

}
