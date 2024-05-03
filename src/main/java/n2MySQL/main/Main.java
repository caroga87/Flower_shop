package n2MySQL.main;

import java.sql.SQLException;

import n2MySQL.handlers.AppHandler;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		AppHandler flowerShop = new AppHandler();
		flowerShop.runApp();
	}
}
