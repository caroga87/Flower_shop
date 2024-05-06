package n2MySQL.singletons;


import n2MySQL.utis.Constants;

import java.util.ArrayList;
import java.util.List;

import n2MySQL.io.FileManager;
import n2MySQL.io.FlowerShopFileReader;
import n2MySQL.io.FlowerShopFileWriter;
import n2MySQL.beans.Ticket;

public class TicketSingleton{

	private static TicketSingleton ticketSingleton;

	private List<Ticket> ticketsList;
	private int maxAssignedTicketId;
	private static int nextTicketId;
	
	private TicketSingleton() {
		super();
		ticketsList = new ArrayList<>();
		if(nextTicketId == 0) {
			nextTicketId = 1;
		}
	}
	
	public static TicketSingleton getTicketSingleton() {
		if(ticketSingleton == null) {
			ticketSingleton = new TicketSingleton();
		}
		return ticketSingleton;
	}
	
	public int getNextTicketId() {
		this.maxAssignedTicketId = nextTicketId;
		nextTicketId++;
		return maxAssignedTicketId;
	}
	
	//assigned from file readAll
	public void setNextTicketId(int readMaxAssignedTicketId) {
		nextTicketId = readMaxAssignedTicketId;
		nextTicketId++;
	}

	public List<Ticket> getTicketsList() {
		return ticketsList;
	}

	public void setTicketsList(List<Ticket> ticketsList) {
		this.ticketsList = ticketsList;
	}


	public void addTicket (Ticket ticket){
		ticketsList.add(ticket);

	}

//	public void removeTicket(int ticketID) {
//		for (Ticket ticket : ticketsList) {
//			if (ticket.getTicketID() == ticketID) {
//				ticketsList.remove(ticket);
//			} else {
//				System.out.println(Constants.Messages.ID_NOT_FOUND);
//			}
//		}
//	}

	// l'he fet com si fos accounting del getSalesMenu
//	public float totalAmountTickets () {
//		float totalAmountTickets = 0.0F;
//		for (Ticket ticket:ticketsList){
//			totalAmountTickets += ticket.getTotalTicket();
//		}
//		return totalAmountTickets;
//	}

	
	public void loadSales() {
		FlowerShopFileReader.readSalesFile(Constants.Files.SALES);		
	}
	
	public void handleMaxAssignedTicketIdPersitence() {
		
		FileManager.deleteFile(Constants.Files.PATH_CONTROL, Constants.Files.IDS, true);
		
		if(!FileManager.fileExists(Constants.Files.PATH_CONTROL, Constants.Files.IDS)) {
			FileManager.createFile(Constants.Files.PATH_CONTROL, Constants.Files.IDS);
		}
		
		FlowerShopFileWriter.writeIdToFile("ticket:" + maxAssignedTicketId + "\n", Constants.Files.IDS);
		
	}
	
	public void handleSalesPersistence() {
		
		FileManager.deleteFile(Constants.Files.PATH_PERSISTENCE, Constants.Files.SALES, true);
		
		if(ticketsList.isEmpty()) {
			FileManager.createFile(Constants.Files.PATH_PERSISTENCE, Constants.Files.SALES);
		} else {
			for(int i = 0; i < ticketsList.size(); i++) {
				if(ticketsList.size() == 1) {
					FlowerShopFileWriter.writeToJsonFile(ticketsList.get(i), Constants.Files.SALES, true, true);
				} else if(i == 0 && ticketsList.size() > 1) {
					FlowerShopFileWriter.writeToJsonFile(ticketsList.get(i), Constants.Files.SALES, true, false);
				} else if(i == ticketsList.size() - 1 && ticketsList.size() > 1) {
					FlowerShopFileWriter.writeToJsonFile(ticketsList.get(i), Constants.Files.SALES, false, true);
				} else {
					FlowerShopFileWriter.writeToJsonFile(ticketsList.get(i), Constants.Files.SALES, false, false);
				}
			}
		}

	}
}
