package n1exercici1.enums;

public enum DecorationEnum {

	PLASTIC("Plastic"),
	WOOD("Wood");
	
	private String materialType;

	private DecorationEnum(String materialType) {
		this.materialType = materialType;
	}

	public String getMaterialType() {
		return materialType;
	}
}
