package n1exercici1.utils;

public class Validations {
	
	public static boolean validateMenuThreeOption(String option) {
		
		return option.matches("^[0-3]{1}$");
	}
	
	public static boolean validateMenuFourOption(String option) {
		
		return option.matches("^[0-4]{1}$");
	}
	
	
	public static boolean validateId(String id) {
		
		return id.matches("^[1-9]{1}[0-9]*$");
	}
}
