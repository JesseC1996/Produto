package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date manufacturedDate;
	Product product;
	
	
	public UsedProduct() {
		
	}

	public UsedProduct(String name, Double price, Date manufacturedDate) {
		super(name, price);
		this.manufacturedDate = manufacturedDate;
		
	}

	public Date getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(Date manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}
	
	public String priceTag() {
		StringBuilder sb = new StringBuilder();
		sb.append( getName()+ " (used)");
		sb.append("\nR$"+getPrice());
		sb.append("\n"+sdf.format(manufacturedDate));
		return sb.toString();
	}
	
}
