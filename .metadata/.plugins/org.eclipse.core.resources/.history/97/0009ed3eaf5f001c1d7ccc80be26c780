import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainRunner {

	static ArrayList<Item> items = new ArrayList<Item>();
	static ArrayList<Coupon> coupons = new ArrayList<Coupon>();
	
	static ArrayList<String> stateName = new ArrayList<String>();
	static ArrayList<Double> stateRate = new ArrayList<Double>();
	
	static Cart cart = new Cart();
	
	public static void main(String[] args) {
		
		loadServerData();
		
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
		} else if (command.equals("add")) {
			handleAddItem();
		} else if (command.equals("remove")) {
			handleRemoveItem();
		} else if (command.equals("state")) {
			handleStateCommand();
		} else if (command.equals("stock")) {
			handleStockCheckCommand();
		} else if (command.equals("print")) {
			printCart();
		}
		else {
			// DEFAULT
		}
		
	}
	
	private static void handleStockCheckCommand() {
		Scanner itemInput = new Scanner(System.in);
		System.out.print("Item to check: ");
		String item = itemInput.nextLine();
		item = item.toLowerCase();
		boolean flag = false;
		
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getName().equals(item)) {
				System.out.println("Stock for " + item + ": " + items.get(i).getStock());
				flag = true;
				break;
			}
		}
		if(!flag) {
			System.out.println("Could not find item to check!");
		}
	}
	
	private static void handleRemoveItem() {
		Scanner itemInput = new Scanner(System.in);
		System.out.print("Item to remove: ");
		String item = itemInput.nextLine();
		item = item.toLowerCase();
		
		for(int i = 0; i < items.size(); i++) {
			if(item.equals(items.get(i).getName())) {
				int amtAvailable = cart.countItems(items.get(i));
				System.out.println("Amount in cart: " + amtAvailable);
				System.out.println("Amount in stock: " + items.get(i).getStock());
				System.out.print("How many to remove?: ");
				int amt = itemInput.nextInt();
				int amtToRemove = 0;
				if(amt <= amtAvailable) {
					amtToRemove = amt;
				} else {
					amtToRemove = amtAvailable;
				}
				cart.removeItem(items.get(i), amtToRemove);
				items.get(i).setStock(items.get(i).getStock() + amtToRemove);
				System.out.println("Removed " + amtToRemove + " " + items.get(i).getName() + "(s)!");
			}
		}
	}
	
	private static void handleStateCommand() {
		Scanner stateInput = new Scanner(System.in);
		System.out.print("Your State: ");
		String yourState = stateInput.nextLine();
		yourState = yourState.toLowerCase();
		boolean flag = false;
		
		for(int i = 0; i < stateName.size(); i++) {
			if(yourState.equals(stateName.get(i))) {
				cart.addStateRate(stateName.get(i), stateRate.get(i));
				flag = true;
				System.out.println("State tax-rate of " + (stateRate.get(i) * 100) + "% added!");
				break;
			}
		}
		
		if(!flag) {
			System.out.println("Could not find your state's tax-rate!");
		}
	}
	
	private static void printCart() {
		cart.print();
	}
	
	private static void handleAddItem() {
		Scanner itemInput = new Scanner(System.in);
		System.out.print("Item to add: ");
		String itemToAdd = itemInput.nextLine();
		itemToAdd = itemToAdd.toLowerCase();
		boolean flag = false;
		
		for(int i = 0; i < items.size(); i++) {
			if(itemToAdd.equals(items.get(i).getName())) {
				int available = items.get(i).getStock();
				System.out.println("Items in stock: " + available);
				
				System.out.print("How many to add?: ");
				int amt = itemInput.nextInt();
				
				int amtToAdd;
				
				if(available > 0) {
					if(amt <= available) {
						int fin = available - amt;
						items.get(i).setStock(fin);
						amtToAdd = amt;
						cart.addItem(items.get(i), amtToAdd);
					} else {
						items.get(i).setStock(0);
						amtToAdd = available;
						cart.addItem(items.get(i), amtToAdd);
					}
					
					System.out.println("Added " + amtToAdd + " " + items.get(i).getName() + "(s)!");
					
				} else {
					System.out.println("None left in stock!");
				}
				
				
				flag = true;
				break;
			}
		}
		
		if(!flag) {
			System.out.println("We could not find the item you were looking for!");
		}
	}
	
	private static void handleCouponCommand() {
		Scanner couponInput = new Scanner(System.in);
		System.out.print("Coupon code: ");
		String code = couponInput.nextLine();
		boolean flag = false;
		
		for(int i = 0; i < coupons.size(); i++) {
			if(code.equals(coupons.get(i).getCode())) {
				cart.addCoupon(coupons.get(i));
				System.out.println("Added coupon " + coupons.get(i).getCode() + " for " + (coupons.get(i).getDiscount() * 100) + "% off!");
				flag = true;
				break;
			}
		}
		
		if(!flag) {
			System.out.println("Could not find coupon!");
		}
	}

	private static void loadServerData() {
		
		try {
			Scanner readFile = new Scanner(new File("ServerData.txt"));
			while(readFile.hasNextLine()) {
				String line = readFile.nextLine();
				line = line.toLowerCase();
				String[] splitLine = line.split(",");
				
				if(splitLine[0].equals("item")) {
					items.add(new Item(splitLine[1], splitLine[2], splitLine[3], splitLine[4], splitLine[5]));
				} else if (splitLine[0].equals("coupon")) {
					coupons.add(new Coupon(splitLine[1], splitLine[2]));
				} else if (splitLine[0].equals("salestax")) {
					stateName.add(splitLine[1]);
					stateRate.add(Double.parseDouble(splitLine[2]));
				}
				
			}			
			readFile.close();
		} catch (FileNotFoundException e) {}
		
	}
	
	public void verifyID(){
		
		
	}
	
}
