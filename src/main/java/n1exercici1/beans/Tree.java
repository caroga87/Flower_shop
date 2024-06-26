package n1exercici1.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Tree extends Product implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int height;

	public Tree(String name, double price, int stock) {
		super(name, price, stock);
	}

	public Tree(String name, double price, int stock, int height) {
		super(name, price, stock);
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Tree [height=" + height + "]";
	}
	
}



	
	
