package n1exercici1.utils;

import n1exercici1.enums.DecorationEnum;

public class Validations {
	
	public static boolean validateMenuEightOption(String option) {
		
		return option.matches("^[0-8]{1}$");
	}
	
	public static boolean validateNumber(String id) {
		
		return id.matches("^[1-9]{1}[0-9]*$");
	}
	
	public static boolean validateMaterial(String material) {
		
		return material.equalsIgnoreCase(DecorationEnum.WOOD.getMaterialType())
				|| material.equalsIgnoreCase(DecorationEnum.PLASTIC.getMaterialType());
	}
}
