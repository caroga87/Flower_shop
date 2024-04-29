package n1exercici1.singletons;


import n1exercici1.sales.Ticket;
import n1exercici1.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class TicketSingleton{

private static TicketSingleton ticketSingleton;


	private List<Ticket> ticketsList;
	
	private TicketSingleton() {
		super();
		ticketsList = new ArrayList<>();
	}
	
	public static synchronized TicketSingleton getTicketSingleton() {
		if(ticketSingleton == null) {
			ticketSingleton = new TicketSingleton();
		}
		return ticketSingleton;
	}

	public List<Ticket> getticketsList() {
		return ticketsList;
	}

	public void setStockList(List<Ticket> ticketsList) {
		this.ticketsList = ticketsList;
	}


	public void addTicket (Ticket ticket){
		ticketsList.add(ticket);

	}

	public void removeTicket(int ticketID) {
		for (Ticket ticket : ticketsList) {
			if (ticket.getTicketID() == ticketID) {
				ticketsList.remove(ticket);
			} else {
				System.out.println(Constants.Messages.ID_NOT_FOUND);
			}
		}
	}

	// l'he fet com si fos accounting del getSalesMenu
	public float totalAmountTickets () {
		float totalAmountTickets = 0.0F;
		for (Ticket ticket:ticketsList){
			totalAmountTickets += ticket.getTotalTicket();
		}
		return totalAmountTickets;
	}


	@Override
	public String toString() {
		return "TicketSingleton [ticketsList=" + ticketsList + "]";
	}

}
