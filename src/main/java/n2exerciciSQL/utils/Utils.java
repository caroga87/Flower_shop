package n1exercici1.utils;

public class Utils {
	
	public static String replaceUnwantedJsonFileCharacters(String str) {
		return str.replace("[", "").replace("]", "").replace(",]", "").trim();
	}
}

