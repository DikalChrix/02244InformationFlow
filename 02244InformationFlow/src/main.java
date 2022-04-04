import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.time.*;

public class main {
	public static void main(String[] args) {
		
		//Publicate the database
		Date date = new Date(); // Patient
		Date date2 = null; // Patient
		Patient Ahmed = new Patient(0000, true, date); //Patient
		Patient Brian = new Patient(1234, false, date2); //Patient
		Patient Charlotte = new Patient(6969, true, date); //Patient
		
		//Add previous appointments
		Charlotte.addAppointment(date, true, "Holte"); // Patient
		Brian.addAppointment(date, false, "Holte"); // Patient
		Ahmed.addTestEvaluation(date, true); // Patient
		Charlotte.addTestEvaluation(date, false); //Patient
		
		
		//Add patients to "database"
		ArrayList<Patient> patientData = new ArrayList<Patient>(); //Nurse
		patientData.add(Ahmed); //Patient -> Nurse
		patientData.add(Brian); //Patient -> Nurse
		patientData.add(Charlotte); //Patient -> Nurse
		
		
		
			
		//Functionalities:
		int userCpr = loginFunction(patientData); // Patient

		// Find 
		for(int i=0; i<patientData.size(); i++) {
			if(patientData.get(i).getCpr()==userCpr) { // Nurse == Patient
				loggedInPatient(patientData.get(i));
				
				//Test if appointment is logged
				//System.out.println(patientData.get(i).getAppointments().get(0).getLocation());
			}
		}
		

	}
	
	
	
	// Input: N/A, Output: Patient
	public static int loginFunction(ArrayList<Patient> patientData) {
		
		//Create console object
		Scanner scanner = new Scanner(System.in);
		
		// Intial message
		System.out.println("Welcome. Do you want to login or print a staitical report?");
		System.out.println("1: Login to the system");
		System.out.println("2: Print statistical reprot");
		
		String userInput = scanner.nextLine(); // Public
		
		switch (Integer.parseInt(userInput)) {
		case 1:
			while (true) {				
				System.out.println("Please input your cpr:");
				userInput = scanner.nextLine(); // Patient				
					if(true) {
					
						return Integer.parseInt(userInput); 							
					}
			
				}	
		case 2:
			System.out.println("Current Statistics:");
			Date date = new Date();  // Public
			System.out.println("Positive percent last 7 days: "+pctPositive(patientData,7)+"%");
			System.out.println("Number of vaccinations last 7 days: "+numVaccinated(patientData,7));
			
			System.exit(0);
			return 0;
		default:
			System.exit(0);
			return 0;
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
				int testLen = patient.getTests().size();
				TestEvaluation lstTstEval = patient.getTest(testLen-1);
				if (testLen > 0) {
					System.out.println("Last test result: " + lstTstEval.isTestResult() + "\n");
				}else{System.out.println("No tests found\n");}

				break;
			case 4:
				System.out.println("Vaccination status: "+patient.isVaccinated()+"\n");
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

	// Input: (Nurse, Public), Output: Public
	public static int pctPositive(ArrayList<Patient>patientList, int days){
		Date currentDate = new Date(); // Public
		LocalDateTime LDTcurrentDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(); // Public
		LocalDateTime prevDate = LDTcurrentDate.minusDays(days); // Public

		int daysBetween = (int) Duration.between(prevDate,LDTcurrentDate).toDays(); // Public
		int sumPosTests=0; // Public
		int sumTests=0; // Public
		for (int i=0; i<patientList.size() ;i++){
			ArrayList<TestEvaluation> currPatientTests = patientList.get(i).getTests(); // Patient
			for(int j=0; j<currPatientTests.size(); j++) {
				Date testDate = currPatientTests.get(j).getTestDate(); // Patient
				LocalDateTime LDTTestDate = testDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(); // Patient
				if (testDate.before(currentDate) && (int) Duration.between(LDTTestDate,LDTcurrentDate).toDays() < daysBetween) { // Patient && Patient < Public
					sumTests ++; // Public
					if (currPatientTests.get(j).isTestResult()) { // Patient
						sumPosTests ++; // Public
					}
				}
			}
		}
		if(sumTests==0){ // Public
			sumTests = 1;
		}
		return (100*sumPosTests/sumTests);
	}
	
	// Input: (Nurse, Public), Output: Public
	public static int numVaccinated(ArrayList<Patient>patientList, int days) {
		Date currentDate = new Date(); // Public
		LocalDateTime LDTcurrentDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(); // Public
		LocalDateTime prevDate = LDTcurrentDate.minusDays(days); // Public

		int daysBetween = (int) Duration.between(prevDate,LDTcurrentDate).toDays(); // Public
		int sumVaccs=0; // Public
		for (int i=0; i<patientList.size() ;i++){
			ArrayList<Appointment> patientAppointments = patientList.get(i).getAppointments(); // Patient
			for(int j=0; j<patientAppointments.size(); j++) {
				Appointment currAppointment = patientAppointments.get(j); // Patient
				Date vaccDate = currAppointment.getAppointmentDate(); // Patient
				LocalDateTime LDTTestDate = vaccDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(); // Patient
				if (vaccDate.before(currentDate) && (int) Duration.between(LDTTestDate,LDTcurrentDate).toDays() < daysBetween && currAppointment.getType()==true) { // Patient && Patient < Public && Patient
					sumVaccs ++;
				}
			}
		}

		return sumVaccs;		
	}
}
