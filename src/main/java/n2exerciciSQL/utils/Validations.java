package n1exercici1.utils;

import java.util.Arrays;

import n1exercici1.enums.DecorationEnum;
import n1exercici1.enums.ProductTypeEnum;

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
	
	public static boolean isValidName(String name) {
		return name.matches("^[a-zA-Z0-9��������������\\s]+$");
	}
	
	private static boolean isZeroOrAbove(String option) {
		return option.matches("^[0-9]+$");
	}
	
	public static boolean isValidProductOption(String option) {
		
		boolean validOption = false;
		
		if(isZeroOrAbove(option)) {
			
			int opt = Integer.parseInt(option);
			int size = Arrays.asList(ProductTypeEnum.values()).size();
			
			if(opt >= 0 && opt <= size) {
				validOption = true;
			}
		}

		return validOption;
	}
}
