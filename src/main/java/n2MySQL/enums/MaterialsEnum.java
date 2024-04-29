package n2MySQL.enums;

public enum MaterialsEnum {

	WOOD("wood"),
	PLASTIC("plastic");
	
	private String name;
	
	private MaterialsEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
