package n1exercici1.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import n1exercici1.handlers.AppHandler;
import n1exercici1.utils.Constants;


public class FlowerShopFileWriter {
	
	public static void writeIdToFile(String str, String fileName) {
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			
			fw = new FileWriter(Constants.Files.PATH_CONTROL + fileName, true);
			bw = new BufferedWriter(fw);
			
			StringBuffer sb = new StringBuffer();
			sb.append(str);
			bw.write(sb.toString());

		} catch (IOException e) {
			AppHandler.printText(Constants.Errors.IO_EXCEPTION + e);
		} finally {
			
			try {
				bw.close();
			} catch (IOException e) {
				AppHandler.printText(Constants.Errors.IO_EXCEPTION + e);
			}
			
			try {
				fw.close();
			} catch (IOException e) {
				AppHandler.printText(Constants.Errors.IO_EXCEPTION + e);
			}
			
		}
	}
	public static void writeToJsonFile(Object object, String fileName, boolean isFirstElement, boolean isLastElement) {
		
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			
			fw = new FileWriter(Constants.Files.PATH_PERSISTENCE + fileName, true);
			bw = new BufferedWriter(fw);
			
			StringBuffer sb = new StringBuffer();
			sb.append(Serialization.mapObjectToJson(object));
			
			if(isFirstElement && isLastElement) {	
				bw.write("[" + sb.toString() + "]\n");
			} else if(isFirstElement && !isLastElement) {
				bw.write("[" + sb.toString() + ",\n");
			} else if(!isFirstElement && isLastElement) {
				bw.write(sb.toString() + "]\n");
			} else if(!isFirstElement && !isLastElement) {
				bw.write(sb.toString() + ",\n");
			}

		} catch (IOException e) {
			System.out.println(Constants.Errors.IO_EXCEPTION + e);
		} finally {
			
			try {
				bw.close();
			} catch (IOException e) {
				System.out.println(Constants.Errors.IO_EXCEPTION + e);
			}
			
			try {
				fw.close();
			} catch (IOException e) {
				System.out.println(Constants.Errors.IO_EXCEPTION + e);
			}
			
		}

	}

}

