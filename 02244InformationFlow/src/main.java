import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		
		//Publicate the database
		Date date = new Date();
		Date date2 = null;
		Patient Ahmed = new Patient(0000, true, date);
		Patient Brian = new Patient(1234, false, date2);
		Patient Charlotte = new Patient(6969, true, date);
		
		
		//Add patients to "database"
		ArrayList<Patient> patientData = new ArrayList<Patient>();
		patientData.add(Ahmed);
		patientData.add(Brian);
		patientData.add(Charlotte);
		
		
		
		//Functionalities:
		loginFunction();
		
		
		
		
		
		//Test
		
		
	}
	
	
	
	
	public static String loginFunction() {
		
		//Create console object
		Console readInput = System.console();
		
		while (true) {
		
		System.out.println("Please input your username:");
		String username = readInput.readLine();
		
		if(checkUsername(username) ) {
			
			return username; 
			
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
	
	public static void loggedInPatient(Patient patient) {
		
		boolean logout = false;
		
		while(true) {
		
			System.out.println("Welcome, what would you like to do?");
			System.out.println("1 to book test appointment");
			System.out.println("2 to book vaccination appointment");
			System.out.println("3 to see test results");
			System.out.println("4 to see vaccination results");
			System.out.println("5 to logout");

			//Create console object
			Console readInput = System.console();

			String input = readInput.readLine();

			switch (Integer.parseInt(input)) {
			case 1:
				// Book test appointment

				System.out.println("Possible locations and dates for testing: ");
				System.out.println("1: Copenhagen NV, 6th May 2022 13:00 ");
				System.out.println("2: Lyngby, 13th May 2022 09:40 ");
				System.out.println("3: Holte, 15th May 2022 17:25 ");

				input = readInput.readLine();

				switch (Integer.parseInt(input)) {
				case 1:

					Date date = new Date();

					patient.addAppointment(date, false, "Copenhagen NV");
					System.out.println("Test appointment booked!");
					break;
				case 2:

					Date date2 = new Date();

					patient.addAppointment(date2, false, "Lyngby");
					System.out.println("Test appointment booked!");
					break;
				case 3:

					Date date3 = new Date();

					patient.addAppointment(date3, false, "Holte");
					System.out.println("Test appointment booked!");
					break;
				}
				




				break;	
			default:
				System.out.println("You have now been logged out");
				logout = true;
			}
			
			if(logout) {
				break;
			}
 
		}
	}
	
	public static void loggedInNurse() {
		
		boolean logout = false;
		
		while(true) {
		
			System.out.println("Welcome, what would you like to do?");
			System.out.println("1 to add test result to patient");
			System.out.println("2 to add vaccination result to patient");
			System.out.println("3 to see test results of patient");
			System.out.println("4 to see vaccination results of patient");
			System.out.println("5 to logout");
			
		}
		
	}
	
}
