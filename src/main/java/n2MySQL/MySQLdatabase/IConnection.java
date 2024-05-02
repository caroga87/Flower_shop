package n2MySQL.MySQLdatabase;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnection {

	Connection getConnection();
	void closeConnection() throws SQLException;
}
