package n1exercici1.utils;

public class Constants {
	
	public class Exceptions	{
		public static final String TYPE = "Invalid product type.";
	}
	
	public class Messages {
		public static final String CHOOSE = "Choose a valid option:\n";
		public static final String ID = "Enter a valid id: \n";
		public static final String ID_NOT_FOUND = "Id not found.\n";
		
	}
	
	public class MainMenu {
		public static final String MAIN_MENU = "Main Menu";
		public static final String CATALOGUE = "Catalogue";
		public static final String STOCK = "Stock";
		public static final String SALES = "Sales";
		public static final String EXIT_MAIN_MENU = "Closing down.";	
	}
	
	public class CreateProduct {
		
		public static final String PRODUCT_NAME = "";
		public static final String PRODUCT_COST_PRICE = "";
		public static final String PRODUCT_SALE_PRICE = "";
		public static final String PRODUCT_STOCK = "";
		public static final String ATTRIBUTE_TREE = "Enter the height of the tree: \n";
		public static final String ATTRIBUTE_FLOWER = "Enter the colour of the flower: \n";
		public static final String ATTRIBUTE_DECORATION = "Enter the material of the decoration: \n";
		public static final String PRODUCT_ADD = "Product was added successfully.\n";
		public static final String PRODUCT_REMOVE = "The product was removed successfully.\n";
		
	}
	
	
	public class Errors {
		public static final String JSON_SERIALIZATION = "Object to JSON failed, ";
		public static final String IO_EXCEPTION = "I/O Exeception thrown, ";
		public static final String FNF_EXCEPTION = "File Not Found Exeception thrown, ";
		public static final String JSON_DESERIALIZATION = "JSON to object failed, ";
		public static final String PARSE_EXCEPTION = "Parsing failed, ";
	}
	
	public class Files {
		public static final String PATH_PERSISTENCE = "src/main/resources/persistence/";
		public static final String FLOWER_SHOP = "flower-shop.json";
		public static final String SALES = "sales.json";
		public static final String STOCK = "stock.json";
	}
	
}
