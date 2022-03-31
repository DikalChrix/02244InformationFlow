import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		
		//Publicate the database
		Date date = new Date(); // Patient
		Date date2 = null; // Patient
		Patient Ahmed = new Patient(0000, true, date); //Patient
		Patient Brian = new Patient(1234, false, date2); //Patient
		Patient Charlotte = new Patient(6969, true, date); //Patient
		
		
		//Add patients to "database"
		ArrayList<Patient> patientData = new ArrayList<Patient>(); //Nurse
		patientData.add(Ahmed); //Patient -> Nurse
		patientData.add(Brian); //Patient -> Nurse
		patientData.add(Charlotte); //Patient -> Nurse
			
		//Functionalities:
		int userCpr = loginFunction(); // Patient

		// Find 
		for(int i=0; i<patientData.size(); i++) {
			if(patientData.get(i).getCpr()==userCpr) { // Nurse == Patient
				loggedInPatient(patientData.get(i));
				
				//Test if appointment is logged
				System.out.println(patientData.get(i).getAppointments().get(0).getLocation());
			}
		}
		

	}
	
	
	
	// Input: N/A, Output: Patient
	public static int loginFunction() {
		
		//Create console object
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
		
		System.out.println("Please input your cpr:");
		String userInput = scanner.nextLine(); // Patient
		
			if(true) {
			
				return Integer.parseInt(userInput); 			
		
			}
		
		}
		
		
	}
	
	// Input: Patient, Output: N/A
	public static void loggedInPatient(Patient patient) {
		
		boolean logout = false; // Patient
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
		
			System.out.println("Welcome, what would you like to do?");
			System.out.println("1 to book test appointment");
			System.out.println("2 to book vaccination appointment");
			System.out.println("3 to see test results");
			System.out.println("4 to see vaccination results");
			System.out.println("5 to logout");

			String input = scanner.nextLine(); // Patient

			switch (Integer.parseInt(input)) { // Patient
			case 1:
				// Book test appointment

				System.out.println("Possible locations and dates for testing: ");
				System.out.println("1: Copenhagen NV, 6th May 2022 13:00 ");
				System.out.println("2: Lyngby, 13th May 2022 09:40 ");
				System.out.println("3: Holte, 15th May 2022 17:25 ");

				input = scanner.nextLine(); //Patient

				switch (Integer.parseInt(input)) { //Patient
				case 1:

					Date date = new Date(1651838440); // Patient

					patient.addAppointment(date, false, "Copenhagen NV"); //Patient
					System.out.println("Test appointment booked!");
					break;
				case 2:

					Date date2 = new Date(1652431200); //Patient

					patient.addAppointment(date2, false, "Lyngby"); //Patient
					System.out.println("Test appointment booked!");
					break;
				case 3:

					Date date3 = new Date(1652631900); //Patient

					patient.addAppointment(date3, false, "Holte"); //Patient
					System.out.println("Test appointment booked!");
					break;
				default:
					break;
				}
				
				break;
			case 2:
				// Book vaccination appointment

				System.out.println("Possible locations and dates for vaccination: ");
				System.out.println("1: Copenhagen NV, 6th May 2022 13:00 ");
				System.out.println("2: Lyngby, 13th May 2022 09:40 ");
				System.out.println("3: Holte, 15th May 2022 17:25 ");

				input = scanner.nextLine(); //Patient

				switch (Integer.parseInt(input)) { //Patient
				case 1:

					Date date = new Date(1651838440); //Patient

					patient.addAppointment(date, true, "Copenhagen NV"); //Patient
					System.out.println("Vaccination appointment booked!");
					break;
				case 2:

					Date date2 = new Date(1652431200); //Patient

					patient.addAppointment(date2, true, "Lyngby"); //Patient
					System.out.println("Vaccination appointment booked!");
					break;
				case 3:

					Date date3 = new Date(1652631900); //Patient

					patient.addAppointment(date3, true, "Holte"); //Patient
					System.out.println("Vacciniatoin appointment booked!");
					break;
				default:
					break;
				}
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				System.out.println("You have now been logged out");
				logout = true;
			}
			
			if(logout) {
				scanner.close();
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
