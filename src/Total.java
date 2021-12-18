import java.util.ArrayList;

public class Total {

	double totalCost = 0.0;
	double tax = 0.0;
	
	public void calculateTotal(ArrayList<Item> allItems, ArrayList<Coupon> allCoupons) {
		double totalPrice = 0.0;
		
		System.out.println("Cart:");
		for(int i = 0; i < allItems.size(); i++) {
			System.out.println("- " + allItems.get(i).getName() + ", " + allItems.get(i).getPrice());
			totalPrice = totalPrice + allItems.get(i).getPrice();
		}
		System.out.println();
		if(allCoupons.size() > 0) {
			System.out.println("Coupons");
			for(int i = 0; i < allCoupons.size(); i++) {
				System.out.println("- " + allCoupons.get(i).getCode() + " - " + (allCoupons.get(i).discount * 100) + "% off");
				totalPrice = totalPrice - (totalPrice * allCoupons.get(i).getDiscount());
			}
			System.out.println();
		}
		
		
		System.out.println("Total w/o Taxes: $" + totalPrice);
		
		this.totalCost = totalPrice;
	}
	
	public void calculateTaxes(String state, double taxRate) {
		
		if(state.equals("") || taxRate == 0.0) return;
		
		double taxVal = this.totalCost * taxRate;
		
		System.out.println("Tax rate for " + state.toUpperCase() + " is " + taxRate);
		System.out.println("Tax: $" + taxVal);
		
		this.tax = taxVal;
	}
	
	public double getTotal() {
		return (this.totalCost + this.tax);
	}
	
}
