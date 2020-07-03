package entities;

import java.util.ArrayList;
import java.util.List;

public class ImportedProduct extends Product {
	private Double customsFee;


	public ImportedProduct(String name, Double price, Double customsFee ) {
		super(name, price);
		this.customsFee = customsFee;
	 
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}

	public String priceTag() {

		StringBuilder sb = new StringBuilder();
		sb.append(getName());
		sb.append("\n"+totalPrice());

		return sb.toString();
	}
	
	public Double totalPrice() {
		return getPrice()+customsFee;
	}
}
