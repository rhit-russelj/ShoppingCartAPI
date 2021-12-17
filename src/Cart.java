import java.util.ArrayList;

public class Cart {

	ArrayList<Item> cart = new ArrayList<Item>();
	
	public Cart() {
		
	}
	
	public void addItem(Item itemToAdd) {
		this.cart.add(itemToAdd);
	}
	
}
