package n1exercici1.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Decoration extends Product implements Serializable{

	private static final long serialVersionUID = 1L;
	private String type;
	
	public Decoration(String name, double price, int stock) {
		super(name, price, stock);
		
	}

	public Decoration(String name, double price, int stock, String type) {
		super(name, price, stock);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Decoration [type=" + type + "]";
	}

}
