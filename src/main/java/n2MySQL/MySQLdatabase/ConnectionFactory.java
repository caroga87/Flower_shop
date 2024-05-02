package n2MySQL.MySQLdatabase;

public class ConnectionFactory {

	public IConnection getConnection(String motor) {
		
		if(motor == null) {
			
		}else if(motor.equalsIgnoreCase("MySQL")) {
			return (IConnection) new SQLDatabaseConnection("db_url", "user", "password");
		}else if(motor.equalsIgnoreCase("MongoDB")) {
			return new MongoDatabaseConnection("host", "user", "password");
		}
		
		return null;
	}	
}
