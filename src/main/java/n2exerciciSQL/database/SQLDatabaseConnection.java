package n2exerciciSQL.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDatabaseConnection {

	private Connection databaseConnection = null;

	 public SQLDatabaseConnection(String url, String user, String password) {
	     super(); 	
		 try {
			databaseConnection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println(e);
		}
	 }

	public Connection getDatabaseConnection() {
		return databaseConnection;
	}
}
