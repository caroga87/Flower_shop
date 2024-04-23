package n2exerciciSQL.database;

import n1exercici1.database.SQLDatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class SQLDatabaseQueries {

	private Connection createConnection() {
		
		n1exercici1.database.SQLDatabaseConnection connection = new SQLDatabaseConnection("jdbc:mysql://localhost/Flower_shop",
				"root", "Claudio2023!");
		
		return connection.getDatabaseConnection();
	}
	

	public void insertProduct(String name, int price) {
		
		Connection connection = createConnection();
		
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("insert into products(product_name, price) values(?,?)");
			statement.setString(1, name);
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		try {
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}	
}
