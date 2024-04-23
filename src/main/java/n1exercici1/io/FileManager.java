package n1exercici1.io;


import java.io.File;
import java.io.IOException;

import n1exercici1.utils.Constants;

public class FileManager {
		
		
	public static void deleteFile(String path, String fileName, boolean delete) {
			
		
		File file = new File(path + fileName);
		
		if(file.exists()) {		
			if(delete) {
				file.delete();
			}		
		}
		
	}
	
	public static void createFile(String path, String fileName) {
		
		File file = new File(path + fileName);
		
		if(!file.exists()) {		
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println(Constants.Errors.IO_EXCEPTION + e);
			}
		}
		
	}
	
	public static boolean fileExists(String filePath, String fileName) {
		return (new File(filePath + fileName).exists());
	}

}

