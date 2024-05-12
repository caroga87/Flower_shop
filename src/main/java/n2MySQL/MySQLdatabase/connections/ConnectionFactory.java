package n2MySQL.MySQLdatabase.connections;

import n2MySQL.exceptions.EmptyDatabaseException;
import n2MySQL.utils.Constants;

public class ConnectionFactory {

	public static IConnection getConnection(String database) throws EmptyDatabaseException {
		
		if(database == null || database.equals("")) {
			throw new EmptyDatabaseException(Constants.Exceptions.EMPTY_EXCEPTION);
		}else if(database.equalsIgnoreCase(Constants.RunningModes.MY_SQL)) {
			return (IConnection) new SQLDatabaseConnection();
			
		}else if(database.equalsIgnoreCase(Constants.RunningModes.MONGODB)) {
			return null;
		}
		
		return null;
	}	
}
