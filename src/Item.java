
public class Item {

	String name;
	String description;
	double price;
	String picture;
	int stock;
	
	public Item(String item, String desc, String pric, String pict, String currentStockAmount) {
		this.name = item;
		this.description = desc;
		this.price = Double.parseDouble(pric);
		this.picture = pict;
		this.stock = Integer.parseInt(currentStockAmount);
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public int getStock() {
		return this.stock;
	}
	
	public void setStock(int amt) {
		this.stock = amt;
	}
	
}
