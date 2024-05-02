package n2MySQL.MySQLdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MongoDatabaseConnection implements IConnection{

	private Connection connection;
	private String url;
	private String user;
	private String password;
	
	public MongoDatabaseConnection(String url, String user, String password) {
		super();
		this.url = url;
		this.user = user;
		this.password = password;
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

	public Connection getConnection () throws SQLException {
		if (connection == null || connection.isClosed()){
			connection = DriverManager.getConnection(db_url, user, password);
			System.out.println("Se ha conectado.");
		}
		return connection;
	}

	public void closeConnection() throws SQLException {
		if (connection!=null && !connection.isClosed()){
				connection.close();
		}
	}
}
