package n1exercici1.singletons;

import java.util.ArrayList;
import java.util.List;

public class TicketSingleton {

private static TicketSingleton ticketSingleton;
	
	private List<String> ticketsList;
	
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

	public List<String> getticketsList() {
		return ticketsList;
	}

	public void setStockList(List<String> ticketsList) {
		this.ticketsList = ticketsList;
	}

	@Override
	public String toString() {
		return "TicketSingleton [ticketsList=" + ticketsList + "]";
	}

}
