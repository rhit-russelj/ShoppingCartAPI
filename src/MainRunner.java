import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainRunner {

	static ArrayList<Item> items = new ArrayList<Item>();
	static ArrayList<Coupon> coupons = new ArrayList<Coupon>();
	
	public static void main(String[] args) {
		
		loadItems();
		loadCoupons();
		
		for(int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i).getName());
		}
		
		Scanner inputS = new Scanner(System.in);
		
		while(true) {
			String cmd = inputS.nextLine();
			
			if(cmd.toLowerCase().equals("exit")) {
				break;
			}
			
			checkCommand(cmd);
		}
		
		
	}
	
	private static void checkCommand(String command) {
		
		command = command.toLowerCase();
		if(command.equals("coupon")) {
			handleCouponCommand();
		} else if (command.equals("OTHER")) {
			// OTHERS
		} else {
			// DEFAULT
		}
		
	}
	
	private static void handleCouponCommand() {
		Scanner couponInput = new Scanner(System.in);
		
		System.out.print("Coupon code: ");
		
		String code = couponInput.nextLine();
		
		for(int i = 0; i < coupons.size(); i++) {
			if(code.equals(coupons.get(i).getCode())) {
				System.out.println(coupons.get(i).getDiscount());
				break;
			}
		}
	}

	private static void loadCoupons() {
		try {
			Scanner readFile = new Scanner(new File("ServerDataCoupons.txt"));
			while(readFile.hasNextLine()) {
				String line = readFile.nextLine();
				
				String[] splitLine = line.split(",");
				
				coupons.add(new Coupon(splitLine[0], splitLine[1]));
			}			
			readFile.close();
		} catch (FileNotFoundException e) {}
	}

	private static void loadItems() {
		try {
			Scanner readFile = new Scanner(new File("ServerDataItems.txt"));
			while(readFile.hasNextLine()) {
				String line = readFile.nextLine();
				
				String[] splitLine = line.split(",");
				
				items.add(new Item(splitLine[0], splitLine[1], splitLine[2], splitLine[3], splitLine[4]));
			}			
			readFile.close();
		} catch (FileNotFoundException e) {}
	}

	
	public void verifyID(){
		
		
	}
	
}
