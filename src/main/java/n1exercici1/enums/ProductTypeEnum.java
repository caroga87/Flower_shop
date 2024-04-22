package n1exercici1.enums;

public enum ProductTypeEnum {

	TREE("Tree"),
	FLOWER("Flower"),
	DECORATION("Decoration");
	
	private String name;
	
	private ProductTypeEnum(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
