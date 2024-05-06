package n2MySQL.io;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import n2MySQL.beans.FlowerShop;
import n2MySQL.beans.Product;
import n2MySQL.beans.Ticket;
import n2MySQL.utis.Constants;



public class Serialization {

private static Logger logger = LoggerFactory.getLogger(Serialization.class);
	
	public static String mapObjectToJson(Object object) {
		
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			logger.error("SerializationController :: mapObjectToJson :: " + Constants.Errors.JSON_SERIALIZATION, e);
		}
		
		return json;
		
	}
	
	public static FlowerShop mapJsonToFlowerShop(String str) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		FlowerShop flowerShop = null;
		try {
			flowerShop = mapper.readValue(str, FlowerShop.class);
		} catch (JsonMappingException e1) {
			logger.error("SerializationController :: mapJsonToFlowerShop :: " + Constants.Errors.JSON_DESERIALIZATION, e1);
		} catch (JsonProcessingException e2) {
			logger.error("SerializationController :: mapJsonToFlowerShop :: " + Constants.Errors.JSON_DESERIALIZATION, e2);
		}
		
		return flowerShop;
		
	}
	
	public static Ticket mapJsonToTicket(String str) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		Ticket ticket = null;
		try {
			ticket = mapper.readValue(str, Ticket.class);
		} catch (JsonMappingException e1) {
			logger.error("SerializationController :: mapJsonToTicket :: " + Constants.Errors.JSON_DESERIALIZATION, e1);
		} catch (JsonProcessingException e2) {
			logger.error("SerializationController :: mapJsonToTicket :: " + Constants.Errors.JSON_DESERIALIZATION, e2);
		}
		
		return ticket;
		
	}
	
	public static Product mapJsonToProduct(String str) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		Product product = null;
		try {
			product = mapper.readValue(str, Product.class);
		} catch (JsonMappingException e1) {
			logger.error("SerializationController :: mapJsonToProduct :: " + Constants.Errors.JSON_DESERIALIZATION, e1);
		} catch (JsonProcessingException e2) {
			logger.error("SerializationController :: mapJsonToProduct :: " + Constants.Errors.JSON_DESERIALIZATION, e2);
		}
		
		return product;
		
	}

}
