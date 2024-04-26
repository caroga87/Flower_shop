package n2MySQL.MySQLdatabase;

import n2MySQL.utils.Input;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDatabaseConnection {
	private static SQLDatabaseConnection instance;
	private Connection connection;
	private  String db_url;
	private  String user;
	private  String password;

	/*private SQLDatabaseConnection (){
		this.db_url = Input.inputString("Introduce your MySQL url");
		this.user = Input.inputString("Introduce your user");
		this.password= Input.inputString("Introduce your password");
	}*/

	public SQLDatabaseConnection(String db_url, String user, String password) {
		this.db_url = db_url;
		this.user = user;
		this.password = password;
	}

	public static SQLDatabaseConnection getInstance(String db_url, String user, String password){
		if (instance == null){
			instance = new SQLDatabaseConnection(db_url, user, password);
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





