package n1exercici1.io;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import n1exercici1.beans.FlowerShop;
import n1exercici1.beans.Product;
import n1exercici1.beans.Ticket;
import n1exercici1.utils.Constants;


public class Serialization {
	
	
	public static String mapObjectToJson(Object object) {
		
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			System.out.println(Constants.Errors.JSON_SERIALIZATION + e);
		}
		
		return json;
		
	}
	
	public static FlowerShop mapJsonToFlowerShop(String str) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		FlowerShop flowerShop = null;
		try {
			flowerShop = mapper.readValue(str, FlowerShop.class);
		} catch (JsonMappingException e1) {
			System.out.println(Constants.Errors.JSON_DESERIALIZATION + e1);
		} catch (JsonProcessingException e2) {
			System.out.println(Constants.Errors.JSON_DESERIALIZATION + e2);
		}
		
		return flowerShop;
		
	}
	
	public static Ticket mapJsonToTicket(String str) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		Ticket ticket = null;
		try {
			ticket = mapper.readValue(str, Ticket.class);
		} catch (JsonMappingException e1) {
			System.out.println(Constants.Errors.JSON_DESERIALIZATION + e1);
		} catch (JsonProcessingException e2) {
			System.out.println(Constants.Errors.JSON_DESERIALIZATION + e2);
		}
		
		return ticket;
		
	}
	
	public static Product mapJsonToProduct(String str) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		Product product = null;
		try {
			product = mapper.readValue(str, Product.class);
		} catch (JsonMappingException e1) {
			System.out.println(Constants.Errors.JSON_DESERIALIZATION + e1);
		} catch (JsonProcessingException e2) {
			System.out.println(Constants.Errors.JSON_DESERIALIZATION + e2);
		}
		
		return product;
		
	}
}
