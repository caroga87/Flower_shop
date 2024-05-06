package n2MySQL.exceptions;

public class EmptyDatabaseException extends Exception{

	private static final long serialVersionUID = 1L;

	public EmptyDatabaseException(String message) {
		super(message);
	}
}
