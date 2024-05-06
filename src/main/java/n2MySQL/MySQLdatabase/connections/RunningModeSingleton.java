package n2MySQL.MySQLdatabase.connections;

public class RunningModeSingleton {

	private static RunningModeSingleton runningModeSingleton;
	
	private String runningMode;
	
	private RunningModeSingleton() {
		super();
	}
	
	public static RunningModeSingleton getRunningModeSingleton() {
		if(runningModeSingleton == null) {
			runningModeSingleton = new RunningModeSingleton();
		}
		return runningModeSingleton;
	}

	public String getRunningMode() {
		return runningMode;
	}

	public void setRunningMode(String runningMode) {
		this.runningMode = runningMode;
	}
}
