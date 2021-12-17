import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Request {

	public static void readFile(String[] args) {
		try {
			File requestFile = new File(args[0]);
			Scanner readFile = new Scanner(requestFile);
			while(readFile.hasNextLine()) {
				String data = readFile.nextLine();
				System.out.println(data);
			}
			readFile.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("An Error has occurred");
			e.printStackTrace();
		}
	}
	
	
}
