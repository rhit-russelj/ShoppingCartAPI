import java.io.FileWriter;
import java.io.IOException;

public class Response {
	public static void writeFile(String[] args) {
	    try {
	      FileWriter myWriter = new FileWriter("ServerData.TXT");
	      myWriter.write("item,Tire,car tire,100.00,tire.png,5");
	      myWriter.close();
	      System.out.println("Successfully wrote to the file.");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }
}
