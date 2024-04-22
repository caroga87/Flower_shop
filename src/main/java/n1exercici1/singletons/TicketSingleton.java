package n1exercici1.singletons;

import java.util.ArrayList;
import java.util.List;

import n1exercici1.beans.Ticket;

public class TicketSingleton {

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

	public List<Ticket> getTicketsList() {
		return ticketsList;
	}

	public void setTicketsList(List<Ticket> ticketsList) {
		this.ticketsList = ticketsList;
	}
}
