import java.util.ArrayList;

public class Cart {

	Total total = new Total();
	
	ArrayList<Item> cart = new ArrayList<Item>();
	ArrayList<Coupon> coupons = new ArrayList<Coupon>();
	
	String state = "";
	double taxRate = 0.0;
	
	public Cart() {
		
	}
	
	public void addStateRate(String st, double taxR) {
		this.state = st;
		this.taxRate = taxR;
	}
	
	public void addItem(Item itemToAdd) {
		this.cart.add(itemToAdd);
	}
	
	public void addItem(Item itemToAdd, int amount) {
		for(int i = 0; i < amount; i++) {
			this.cart.add(itemToAdd);
		}
	}
	
	public void removeItem(Item itemToRemove, int amount) {
		int amountRemoved = 0;
		
		int index = 0;
		
		while(amountRemoved < amount) {
			
			if(cart.get(index).equals(itemToRemove)) {
				cart.remove(index);
				
				index--;
				if(index < 0) {
					index = 0;
				}
				
				amountRemoved++;
			} else {
				index++;
			}
			
		}
		
	}
	
	public void addCoupon(Coupon couponToAdd) {
		this.coupons.add(couponToAdd);
	}
	
	public int countItems(Item itemToCount) {
		int count = 0;
		
		for(int i = 0; i < cart.size(); i++) {
			if(cart.get(i).equals(itemToCount)) {
				count++;
			}
		}
		
		return count;
	}
	
	public void print() {
		this.total.calculateTotal(this.cart, this.coupons);
		System.out.println();
		this.total.calculateTaxes(this.state, this.taxRate);
		System.out.println();
		System.out.println("Total: $" + this.total.getTotal());
	}
}
