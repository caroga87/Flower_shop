package n2exerciciSQL.database;

import n2exerciciSQL.utils.Input;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDatabaseConnection {
	private static SQLDatabaseConnection instance;
	private Connection connection;
	private static String db_url;
	private static String user;
	private static String password;

	private SQLDatabaseConnection (){
		this.db_url = Input.inputString("Introduce your MySQL url");
		this.user = Input.inputString("Introduce your user");
		this.password= Input.inputString("Introduce your password");
	}

	public static SQLDatabaseConnection getInstance(){
		if (instance == null){
			instance = new SQLDatabaseConnection();
		}
		return instance;
	}
	public Connection getConnection () throws SQLException {
		if (connection == null || connection.isClosed()){
			connection = DriverManager.getConnection(db_url, user, password);
		}
		return connection;
	}

	public void closeConnectionSQL() throws SQLException {
		if (connection!=null && !connection.isClosed()){
				connection.close();
			}
		}
	}





