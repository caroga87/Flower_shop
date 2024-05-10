package n2MySQL.MySQLdatabase.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDatabaseConnection implements IConnection{
	
	private Connection connectionSQL;
	
	private  String url;
	private  String user;
	private  String password;
	
	public SQLDatabaseConnection() {
		super();
		this.url = "jdbc:mysql://localhost:3306/flower_shop";
		this.user = "root";
		this.password = "Claudio2023!"; // Escribir aquí vuestra contraseña.
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public Connection openConnection() throws SQLException {
		
		try {
			this.connectionSQL = DriverManager.getConnection(this.url, this.user, this.password);
		} catch (SQLException e) {
			System.out.println("ConnectionManager :: openConnection :: " + e);
		}
		return connectionSQL;
	}

	@Override
	public void closeConnection(Connection connection) throws SQLException {
		
		try {
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			System.out.println("ConnectionManager :: closeConnection :: " +  e);
		}
	}

	@Override
	public String toString() {
		return "SQLDatabaseConnection [connectionSQL=" + connectionSQL + ", url=" + url + ", user=" + user + ", password="
				+ password + "]";
	}

	
}





