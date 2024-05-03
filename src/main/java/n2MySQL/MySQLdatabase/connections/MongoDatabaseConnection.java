package n2MySQL.MySQLdatabase.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MongoDatabaseConnection implements IConnection{
	
	private static Logger logger = LoggerFactory.getLogger(MongoDatabaseConnection.class);
	private Connection connectionMongo;
	
	private String url;
	private String user;
	private String password;
	
	public MongoDatabaseConnection() {
		super();
		this.url = "mongodb://localhost:27017/flower_shop";
		this.user = "root";
		this.password = "";
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
			this.connectionMongo = DriverManager.getConnection(this.url, this.user, this.password);
		} catch (SQLException e) {
			logger.error("ConnectionManager :: openConnection :: " , e);
		}
		
		return this.connectionMongo;
	}

	@Override
	public void closeConnection(Connection connection) throws SQLException {
		
		try {
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			logger.error("ConnectionManager :: closeConnection :: " , e);
		}
		
	}

	@Override
	public String toString() {
		return "MongoDatabaseConnection [connectionMongo=" + connectionMongo + ", url=" + url + ", user=" + user + ", password="
				+ password + "]";
	}	
}
