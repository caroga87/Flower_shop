package n2MySQL.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import n2MySQL.utils.Constants;



public class FlowerShopFileReader {


	
	
	public static List<String> readColours(String fileName) {
		
		
		
		List<String> colours = new ArrayList<>();
		
		if(FileManager.fileExists(Constants.Files.PATH_SIMPLE, Constants.Files.COLOURS)) {
			
			BufferedReader br = null;
			
			try {
				
				br = new BufferedReader(new FileReader(Constants.Files.PATH_SIMPLE + fileName));
				
				String line = br.readLine();
				while(line != null) {
					if(!line.trim().equals("")) {
						String colour = line.trim().toUpperCase();
						colours.add(colour);
					}
					line = br.readLine();
				}
				
			} catch (FileNotFoundException e) {
				System.out.println("FlowerShopFileReader :: readColours :: " + Constants.Errors.FNF_EXCEPTION + e);
			} catch (IOException e) {
				System.out.println("FlowerShopFileReader :: readColours :: " + Constants.Errors.IO_EXCEPTION + e);
			} finally {
				
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("FlowerShopFileReader :: readColours :: br.close() :: " + Constants.Errors.IO_EXCEPTION + e);
				}
			}
		}
		return colours;
		
	}

}
