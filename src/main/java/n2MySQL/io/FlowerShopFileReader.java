package n2MySQL.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import n2MySQL.utils.Constants;



public class FlowerShopFileReader {

	private static Logger logger = LoggerFactory.getLogger(FlowerShopFileReader.class);

	
	
	public static List<String> readColours(String fileName) {
		
		logger.info("FlowerShopFileReader :: readColours :: " + Constants.Messages.READING_FROM + fileName);
		
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
				logger.error("FlowerShopFileReader :: readColours :: " + Constants.Errors.FNF_EXCEPTION, e);
			} catch (IOException e) {
				logger.error("FlowerShopFileReader :: readColours :: " + Constants.Errors.IO_EXCEPTION, e);
			} finally {
				
				try {
					br.close();
				} catch (IOException e) {
					logger.error("FlowerShopFileReader :: readColours :: br.close() :: " + Constants.Errors.IO_EXCEPTION, e);
				}
				
			}
			
		}

		return colours;
		
	}

}
