import java.io.*;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		
		//Publicate the database
		readFromFile();
		
		//Functionalities:
		
			//Allow paitient to book appointments 
		
		
		
		
	}
	
	
	
	
	public static boolean loginFunction() {
		
		//Create console object
		Console readInput = System.console();
		
		while (true) {
		
		System.out.println("Please input your username:");
		String username = readInput.readLine();
		
		if(checkUsername(username) ) {
		
			return true; 
			
		} else {
			System.out.println ("Wrong username, please try again");
		}
		
		}
		
		
	}
	
	public static boolean checkUsername(String username) {
		return true;
	}
	
	public static void readFromFile() {
	
		try {
			Scanner dataReader = new Scanner(new File("C:\\Users\\Kicc7\\Documents\\test.csv"));
			dataReader.useDelimiter(",");
			
			while(dataReader.hasNext()) {
				System.out.println(dataReader.next());
			}
			dataReader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
