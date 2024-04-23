package n1exercici1.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import n1exercici1.beans.FlowerShop;
import n1exercici1.beans.Product;
import n1exercici1.beans.Ticket;
import n1exercici1.singletons.FlowerShopSingleton;
import n1exercici1.singletons.StockSingleton;
import n1exercici1.singletons.TicketSingleton;
import n1exercici1.utils.Constants;
import n1exercici1.utils.Utils;
import n1exercici1.utils.Validations;


public class FlowerShopFileReader {

	public static FlowerShop readFlowerShopFile(String fileName) {
		
		
		FlowerShop flowerShop = null;
		
		if(FileManager.fileExists(Constants.Files.PATH_PERSISTENCE, Constants.Files.FLOWER_SHOP)) {
			
			BufferedReader br = null;	
			
			try {
				
				br = new BufferedReader(new FileReader(Constants.Files.PATH_PERSISTENCE + fileName));
				
				String line = br.readLine().trim();
				if(line != null) {
					flowerShop = Serialization.mapJsonToFlowerShop(Utils.replaceUnwantedJsonFileCharacters(line));
				}
				
				if(flowerShop != null) {
					FlowerShopSingleton.getFlowerShopSingleton().setFlowerShop(flowerShop);
				}
				
			} catch (FileNotFoundException e) {
				System.out.println(Constants.Errors.FNF_EXCEPTION + e);
			} catch (IOException e) {
				System.out.println(Constants.Errors.IO_EXCEPTION + e);

			} finally {
				
				try {
					br.close();
				} catch (IOException e) {
					System.out.println(Constants.Errors.IO_EXCEPTION + e);
				}
				
			}
		}
		
		return flowerShop;

	}
	
	public static void readSalesFile(String fileName) {
		
		
		if(FileManager.fileExists(Constants.Files.PATH_PERSISTENCE, Constants.Files.SALES)) {
			
			BufferedReader br = null;	
			
			try {
				
				br = new BufferedReader(new FileReader(Constants.Files.PATH_PERSISTENCE + fileName));
				
				String line = br.readLine();
				while(line != null) {
					if(!line.trim().equals("")) {
						Ticket ticket = Serialization.mapJsonToTicket(Utils.replaceUnwantedJsonFileCharacters(line));
						if(ticket != null) {
							TicketSingleton.getTicketSingleton().getTicketsList().add(ticket);
						}
					}
					line = br.readLine();
				}
				
			} catch (FileNotFoundException e) {
				System.out.println(Constants.Errors.FNF_EXCEPTION + e);
		
			} catch (IOException e) {
				System.out.println(Constants.Errors.IO_EXCEPTION + e);
			} finally {
				
				try {
					br.close();
				} catch (IOException e) {
					System.out.println(Constants.Errors.IO_EXCEPTION + e);
				}
				
			}
		}

	}
	
	public static void readStockFile(String fileName) {
		
		
		if(FileManager.fileExists(Constants.Files.PATH_PERSISTENCE, Constants.Files.STOCK)) {
			
			BufferedReader br = null;	
			
			try {
				
				br = new BufferedReader(new FileReader(Constants.Files.PATH_PERSISTENCE + fileName));
				
				String line = br.readLine();
				while(line != null) {
					if(!line.trim().equals("")) {
						Product product = Serialization.mapJsonToProduct(Utils.replaceUnwantedJsonFileCharacters(line));
						if(product != null) {
							StockSingleton.getStockSingleton().getStockList().add(product);
						}
					}
					line = br.readLine();
				}
				
			} catch (FileNotFoundException e) {
				System.out.println(Constants.Errors.FNF_EXCEPTION + e);
		
			} catch (IOException e) {
				System.out.println(Constants.Errors.IO_EXCEPTION + e);
			} finally {
				
				try {
					br.close();
				} catch (IOException e) {
					System.out.println(Constants.Errors.IO_EXCEPTION + e);
				}
				
			}
		}

	}
	
	public static void readIds(String fileName) {
		
		
		if(FileManager.fileExists(Constants.Files.PATH_CONTROL, Constants.Files.IDS)) {
			
			BufferedReader br = null;
			
			try {
				
				br = new BufferedReader(new FileReader(Constants.Files.PATH_CONTROL + fileName));
				
				String line = br.readLine();
				while(line != null) {
					if(!line.trim().equals("")) {
						String idsArray[] = line.trim().split(":");
						if(Validations.validateNumber(idsArray[1])) {
							if(idsArray[0].equalsIgnoreCase("ticket")) {
								TicketSingleton.getTicketSingleton().setNextTicketId(Integer.parseInt(idsArray[1]));
							} else if(idsArray[0].equalsIgnoreCase("product")) {
								StockSingleton.getStockSingleton().setNextProductId(Integer.parseInt(idsArray[1]));
							}
						}
					}
					line = br.readLine();
				}
				
			} catch (FileNotFoundException e) {
				System.out.println(Constants.Errors.FNF_EXCEPTION + e);
			} catch (IOException e) {
				System.out.println(Constants.Errors.IO_EXCEPTION + e);
			} finally {
				
				try {
					br.close();
				} catch (IOException e) {
					System.out.println(Constants.Errors.IO_EXCEPTION + e);
				}
				
			}
			
		}
		
	}
	

}

