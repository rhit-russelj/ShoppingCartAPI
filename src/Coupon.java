
public class Coupon {

	String code;
	double discount;
	
	public Coupon(String cd, String amt) {
		this.code = cd;
		this.discount = Double.parseDouble(amt);
	}
	
	public String getCode() {
		return this.code;
	}
	
	public double getDiscount() {
		return this.discount;
	}
	
}
