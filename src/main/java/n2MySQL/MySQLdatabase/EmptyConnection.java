package n2MySQL.MySQLdatabase;

import java.sql.Connection;
import java.sql.SQLException;

public class EmptyConnection implements IConnection{

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void closeConnection() throws SQLException {
		// TODO Auto-generated method stub
		
	}	
}
