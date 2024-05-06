package n2MySQL.io;

import java.io.File;

public class FileManager {
		
	public static boolean fileExists(String filePath, String fileName) {
		return (new File(filePath + fileName).exists());
	}
}
