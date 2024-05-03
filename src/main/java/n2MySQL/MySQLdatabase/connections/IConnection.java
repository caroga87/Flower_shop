package n2MySQL.MySQLdatabase.connections;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnection {

	Connection openConnection()throws SQLException;
	void closeConnection(Connection conection) throws SQLException;
}
