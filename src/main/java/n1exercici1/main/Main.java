package n1exercici1.main;

import n1exercici1.handlers.AppHandler;
import n1exercici1.utils.Constants;

public class Main {

	public static void main(String[] args) {
		
		AppHandler shop = new AppHandler();
		shop.runApp(Constants.Menu.APP);
	}
}
