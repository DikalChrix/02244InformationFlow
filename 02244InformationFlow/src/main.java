import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.time.*;


public class main {
	static ArrayList<Patient> patientData = new ArrayList<Patient>(); // {Nurse:Nurse} | {Nurse:Nurse}
	public static void main(String[] args) {

		// *** DISREGAREDED, ONLY USED TO POPULATE "DATABASE" **** 
		
		//Publicate the database
		Date date = new Date(); 
		Date date2 = null; 
		Patient Ahmed = new Patient(0000, true, date); 
		Patient Brian = new Patient(1234, false, date2); 
		Patient Charlotte = new Patient(6969, true, date); 

		//Add previous appointments
		Charlotte.addAppointment(date, true, "Holte"); 
		Brian.addAppointment(date, false, "Holte"); 
		Ahmed.addTestEvaluation(date, true); 
		Charlotte.addTestEvaluation(date, false); 


		//Add patients to "database"
		patientData.add(Ahmed); 
		patientData.add(Brian); 
		patientData.add(Charlotte); 

		
		// *** START OF ACTUAL PROGRAM **** 
		//Functionalities:
		//if_acts_for(main, Patient) 
    	// userCpr = (declassify(loginFunction()), {Patient:Patient,Nurse} | {Patient:}))		
		int userCpr = loginFunction(); // {Patient: Patient} | {Patient: Patient}  -> {Patient:Patient,Nurse} | {Patient:}


		// Find
		//if_acts_for(main, Nurse) 
    	// (declassify(patientData.size(), {Bottom} | {Bottom} )) {Nurse:Nurse} | {Nurse:Nurse} -> {Bottom} | {Bottom}
		for (int i = 0; i < patientData.size(); i++) { // {Bottom} | {Bottom} -> {Patient:Patient,Nurse} | {Patient:} 
			if (patientData.get(i).getCpr() == userCpr) { // {Patient:Patient,Nurse} | {Patient:} -> {Patient:Patient,Nurse} | {Patient:} 
				loggedInPatient(patientData.get(i)); // {Patient:Patient,Nurse} | {Patient:}

			}
		}

	}

	// Output: {Patient: Patient} | {Patient: Patient} 
	public static int loginFunction() {

		//Create console object
		Scanner scanner = new Scanner(System.in); // {} | {}

		// Intial message
		System.out.println("Welcome. Do you want to login or print a staitical report?"); // {} | {}
		System.out.println("1: Login to the system"); // {} | {}
		System.out.println("2: Print statistical reprot"); // {} | {}
        System.out.println("3: Login as nurse"); // {} | {}
		String publicInput = scanner.nextLine(); // {Bottom} | {Bottom}

		switch (Integer.parseInt(publicInput)) { // {Bottom} | {Bottom} -> {Bottom} | {Bottom}
		case 1: // {Patient: Patient} | {Patient: Patient}
			while (true) { // {Bottom} | {Bottom} -> {Patient: Patient} | {Patient: Patient}
				System.out.println("Please input your cpr:"); // {} | {}
				String patientInput = scanner.nextLine(); // {Patient: Patient} | {Patient: Patient} 
					if(true) { // {Bottom} | {Bottom} -> {Patient: Patient} | {Patient: Patient} 
						return Integer.parseInt(patientInput); // {Patient: Patient} | {Patient: Patient} 
					}

				}
		case 2: // {Patient: Patient} | {Patient: Patient} 
			System.out.println("Current Statistics:"); // {} | {}
			System.out.println("Positive percent last 7 days: "+pctPositive(7)+"%"); // {Bottom: Bottom} | {Bottom: Bottom}
			System.out.println("Number of vaccinations last 7 days: "+numVaccinated(7)); // {Bottom: Bottom} | {Bottom: Bottom}

			System.exit(0); // {} | {} 
			return 0; // {Patient: Patient} | {Patient: Patient}

        case 3: // {Bottom: Bottom} | {Bottom: Bottom}
            while (true) { // {Bottom} | {Bottom} -> {Bottom: Bottom} | {Bottom: Bottom}
                System.out.println("Please input nurse login:"); // {} | {}
                if(true) { // {Bottom} | {Bottom} -> {Nurse: Nurse} | {Nurse: Nurse}
					loggedInNurse(); // {Nurse:Nurse} | {Nurse:Nurse}
                }
				System.exit(0); // {} | {}
				return 0; // {Patient: Patient} | {Patient: Patient}

            }

        default: // {Patient: Patient} | {Patient: Patient}
			System.exit(0); // {} | {}
			return 0; // {Patient: Patient} | {Patient: Patient}
		}

	}

	// Input: {Patient:Patient,Nurse} | {Patient:}, Body: {Patient:Patient,Nurse} | {Patient: }
	public static void loggedInPatient(Patient patient) {

		boolean logout = false; // {Bottom} | {Bottom} -> {Patient:Patient, Nurse} | {Patient: }

		Scanner scanner = new Scanner(System.in); // {} | {}

		while(true) { // {Bottom} | {Bottom} -> {Patient:Patient, Nurse} | {Patient: }

			System.out.println("Welcome, what would you like to do?"); // {} | {}
			System.out.println("1 to book test appointment"); // {} | {}
			System.out.println("2 to book vaccination appointment"); // {} | {}
			System.out.println("3 to see test results"); // {} | {}
			System.out.println("4 to see vaccination results"); // {} | {}
			System.out.println("5 to logout"); // {} | {}

			String input = scanner.nextLine(); // {Patient:Patient, Nurse} | {Patient: }
				
			switch (Integer.parseInt(input)) { // {Patient:Patient, Nurse} | {Patient:  } -> // {Patient:Patient, Nurse} | {Patient: Patient }
			case 1:  // {Patient:Patient, Nurse} | {Patient:Patient}
				// Book test appointment

				System.out.println("Possible locations and dates for testing: "); // {} | {}
				System.out.println("1: Copenhagen NV, 6th May 2022 13:00 "); // {} | {}
				System.out.println("2: Lyngby, 13th May 2022 09:40 "); // {} | {}
				System.out.println("3: Holte, 15th May 2022 17:25 "); // {} | {}

				input = scanner.nextLine(); // {Patient:Patient, Nurse} | {Patient:Patient} 

				switch (Integer.parseInt(input)) { // {Patient:Patient, Nurse} | {Patient:Patient} -> {Patient:Patient, Nurse} | {Patient:Patient}
				case 1:  // {Patient:Patient, Nurse} | {Patient:Patient}

					Date date = new Date(1651838440); // {Bottom} | {Bottom} -> {Patient:Patient, Nurse} | {Patient:Patient}

					patient.addAppointment(date, false, "Copenhagen NV"); // {Patient:Patient,Nurse} | {Patient: Patient}
					System.out.println("Test appointment booked!"); // {} | {}
					break;
				case 2: // {Patient:Patient, Nurse} | {Patient:Patient}

					Date date2 = new Date(1652431200); // {Bottom} | {Bottom} -> {Patient:Patient, Nurse} | {Patient:Patient}

					patient.addAppointment(date2, false, "Lyngby"); // {Patient:Patient,Nurse} | {Patient: Patient}
					System.out.println("Test appointment booked!"); // {} | {}
					break;
				case 3: // {Patient:Patient, Nurse} | {Patient:Patient}

					Date date3 = new Date(1652631900); // {Bottom} | {Bottom} -> {Patient:Patient, Nurse} | {Patient:Patient}

					patient.addAppointment(date3, false, "Holte"); // {Patient:Patient,Nurse} | {Patient: Patient}
					System.out.println("Test appointment booked!"); // {} | {}
					break;
				default:
					break;
				}

				break;
			case 2: // {Patient:Patient, Nurse} | {Patient:Patient}
				// Book vaccination appointment

				System.out.println("Possible locations and dates for vaccination: "); // {} | {}
				System.out.println("1: Copenhagen NV, 6th May 2022 13:00 "); // {} | {}
				System.out.println("2: Lyngby, 13th May 2022 09:40 "); // {} | {}
				System.out.println("3: Holte, 15th May 2022 17:25 "); // {} | {}

				input = scanner.nextLine(); // {Patient:Patient, Nurse} | {Patient:Patient}

				switch (Integer.parseInt(input)) { // {Patient:Patient} | {Patient:Patient}  -> {Patient:Patient} | {Patient:Patient}
				case 1: // {Patient:Patient, Nurse} | {Patient:Patient}

					Date date = new Date(1651838440); // {Bottom} | {Bottom} -> {Patient:Patient, Nurse} | {Patient:Patient}

					patient.addAppointment(date, true, "Copenhagen NV"); //  {Patient:Patient,Nurse} | {Patient: Patient}
					System.out.println("Vaccination appointment booked!"); // {} | {}

				case 2: // {Patient:Patient, Nurse} | {Patient:Patient}

					Date date2 = new Date(1652431200); // {Bottom} | {Bottom} -> {Patient:Patient, Nurse} | {Patient:Patient}

					patient.addAppointment(date2, true, "Lyngby"); // {Patient:Patient,Nurse} | {Patient: Patient}
					System.out.println("Vaccination appointment booked!"); // {} | {}
					break;
				case 3: // {Patient:Patient, Nurse} | {Patient:Patient}

					Date date3 = new Date(1652631900); // {Bottom} | {Bottom} -> {Patient:Patient, Nurse} | {Patient:Patient}

					patient.addAppointment(date3, true, "Holte"); // {Patient:Patient,Nurse} | {Patient: Patient}
					System.out.println("Vaccination appointment booked!"); // {} | {}
					break; 
				default:
					break;
				}
				break;
			case 3: //{Patient:Patient,Nurse} | {Patient: Nurse}
				int testLen = patient.getTests().size(); // {Patient:Patient,Nurse} | {Patient: Nurse} -> {Patient:Patient,Nurse} | {Patient: Nurse}
				TestEvaluation lstTstEval = patient.getTest(testLen-1); // {Patient:Patient,Nurse} | {Patient: Nurse} -> {Patient:Patient,Nurse} | {Patient: Nurse}
				if (testLen > 0) { // {Patient:Patient,Nurse} | {Patient: Nurse} -> {Patient:Patient,Nurse} | {Patient: Nurse}
					System.out.println("Last test result: " + lstTstEval.isTestResult() + "\n"); //{Patient:Patient,Nurse} | {Patient: Nurse}
				}else{System.out.println("No tests found\n");} // {} | {}

				break;
			case 4: // {Patient:Patient,Nurse} | {Patient: Nurse}
				System.out.println("Vaccination status: "+patient.isVaccinated()+"\n"); // {Patient:Patient,Nurse} | {Patient: Nurse}
				break;
			default: // {Patient:Patient, Nurse} | {Patient: }
				System.out.println("You have now been logged out"); // {} | {}
				logout = true; // {Patient:Patient, Nurse} | {Patient: }
				break; 
			}

			if(logout) { // {} | {}
				scanner.close(); // {} | {}
				break;
			}

		}
	}
	
	// Input: N/A, Body: {Nurse: Nurse} | {Nurse: Nurse}
	public static void loggedInNurse() { // {Nurse: Nurse} | {Nurse: Nurse}
        Scanner scanner = new Scanner(System.in); // {} | {}
		boolean logout = false; // {Bottom} | {Bottom} -> {Nurse:Nurse} | {Nurse:Nurse}
        Patient p = null; // {Bottom} | {Bottom} -> {Nurse: Nurse} | {Nurse: Nurse}
        System.out.println("Enter cpr of patient");  // {} | {}
        String userInput = scanner.nextLine(); // {Nurse:Nurse} | {Nurse:Nurse}
        for(int i = 0; i<patientData.size(); i++) { // {Nurse:Nurse} | {Nurse:Nurse} -> {Nurse:Nurse} | {Nurse:Nurse}
            if (Integer.parseInt(userInput) == patientData.get(i).getCpr()) { // {Nurse:Nurse} | {Nurse:Nurse} -> {Nurse:Nurse} | {Nurse:Nurse}
                //if_acts_for(loggedInNurse, Patient) 
            	// p = (declassify(patientData.get(i), {Bottom} | {Bottom} )) // {Patient: Patient, Nurse} | {Patient: Nurse} -> {Bottom} | {Bottom}
                p = patientData.get(i); // {Bottom} | {Bottom} -> {Nurse: Nurse} | {Nurse: Nurse}
                break;
            }
        }

		while(true) { // {Bottom} | {Bottom} -> {Nurse: Nurse} | {Nurse: Nurse}

			System.out.println("Welcome, what would you like to do?"); // {} | {}
			System.out.println("1 to add test result to latest test appointment of patient"); // {} | {}
			System.out.println("2 to set vaccination status as of patient as vaccinated"); // {} | {}
			System.out.println("3 to see test results of patient"); // {} | {}
			System.out.println("4 to see vaccination status of patient"); // {} | {}
            System.out.println("5 to select another patient"); // {} | {}
			System.out.println("6 to logout"); // {} | {}
            userInput = scanner.nextLine(); // {Nurse:Nurse} | {Nurse:Nurse}
            
            ArrayList <Appointment> pAppointment = p.getAppointments(); // {Nurse:Nurse} | {Nurse:Nurse} -> {Nurse:Nurse} | {Nurse:Nurse}
            
            switch (Integer.parseInt(userInput)) { // {Nurse: Nurse} | {Nurse: Nurse} -> {Nurse: Nurse} | {Nurse: Nurse}
             
            case 1: // {Nurse: Nurse}
            	
            	System.out.println("What was the test result of the patient?"); // {} | {}
            	System.out.println("0 for Negative"); // {} | {}
            	System.out.println("1 for Positive"); // {} | {}
            	
            	userInput = scanner.nextLine(); // {Nurse:Nurse} | {Nurse:Nurse}
            	            	
            	// Find latest appointment         
               
                Date date = new Date(1000000000); // {Bottom} | {Bottom} -> {Nurse:Nurse} | {Nurse:Nurse}
                Appointment latestAppointment =  new Appointment(date, "", true); // {Nurse:Nurse} | {Nurse:Nurse} -> // {Nurse:Nurse} | {Nurse:Nurse} 
                for(int i = 0; i<pAppointment.size(); i++){ // {Nurse: Nurse} | {Nurse: Nurse} -> {Nurse: Nurse} | {Nurse: Nurse}
                	if(!pAppointment.get(i).getType() & pAppointment.get(i).getAppointmentDate().after(latestAppointment.getAppointmentDate())){ // {Nurse: Nurse} | {Nurse: Nurse} -> {Nurse: Nurse} | {Nurse: Nurse}
                		latestAppointment = pAppointment.get(i); // {Nurse:Nurse} | {Nurse:Nurse} -> {Nurse:Nurse} | {Nurse:Nurse}
					}
				}
                
                // Add test evaluation
                if (Integer.parseInt(userInput) == 0) { // {Nurse: Nurse} | {Nurse: Nurse} -> {Nurse: Nurse} | {Nurse: Nurse}
                	p.addTestEvaluation(latestAppointment.getAppointmentDate(), false); // {Nurse:Nurse} | {Nurse:Nurse} 
                }
                else {
                	p.addTestEvaluation(latestAppointment.getAppointmentDate(), true); // {Nurse:Nurse} | {Nurse:Nurse}
                }
                System.out.println("Test result added to patient!"); // {} | {}
                                
                break;
                
            case 2: // {Nurse: Nurse}
                p.setVaccinated(true); // {Nurse: Nurse}
                for(int i = 0; i<pAppointment.size(); i++){ // {Nurse:Nurse} | {Nurse:Nurse} -> {Nurse:Nurse} | {Nurse:Nurse}
                	if(pAppointment.get(i).getType()){ // {Nurse:Nurse} | {Nurse:Nurse} -> {Nurse:Nurse} | {Nurse:Nurse}
                		p.setVaccinationDate((pAppointment.get(i).getAppointmentDate())); // {Nurse:Nurse} | {Nurse:Nurse} -> {Nurse:Nurse} | {Nurse:Nurse}
					}
				}
                System.out.println("Vaccination status of the patient updated!"); // {} | {}

                break;
            case 3: // {Nurse: Nurse}
                ArrayList<TestEvaluation> pTests=p.getTests(); // {Nurse: Nurse} | {Nurse: Nurse} -> {Nurse: Nurse} | {Nurse: Nurse}
                System.out.println("Test data from patient: "+p.getCpr()); // {Nurse: Nurse} | {Nurse: Nurse}
                for(int j = 0; j<pTests.size();j++) { // {Nurse:Nurse} | {Nurse:Nurse} -> {Nurse:Nurse} | {Nurse:Nurse}
                    System.out.println("Test date: "+pTests.get(j).getTestDate()+"\n\rTest result: "+pTests.get(j).isTestResult()+"\n\r"); // {Nurse: Nurse} | {Nurse: Nurse} 
                }
                 break;
            case 4: // {Nurse: Nurse} | {Nurse: Nurse}
				System.out.println("Vaccination status from patient ("+p.getCpr()+"): "+p.isVaccinated()+"\n\r"); // {Nurse: Nurse} | {Nurse: Nurse}
                break;

            case 5: // {Nurse: Nurse}
                System.out.println("Enter cpr of patient"); // {} | {}
                userInput = scanner.nextLine(); // {Nurse:Nurse} | {Nurse:Nurse}
                for(int i = 0; i<patientData.size(); i++) { // {Nurse: Nurse} | {Nurse: Nurse} -> {Nurse: Nurse} | {Nurse: Nurse}
                    if (Integer.parseInt(userInput) == patientData.get(i).getCpr()) { // {Nurse: Nurse} | {Nurse: Nurse} -> {Nurse: Nurse} | {Nurse: Nurse}
						//if_acts_for(loggedInNurse, Patient)
                        // p = (declassify(patientData.get(i),{Bottom} | {Bottom} )) // {Patient: Patient, Nurse} | {Patient: Nurse} -> {Bottom} | {Bottom}
                        p = patientData.get(i); // {Bottom} | {Bottom} -> {Nurse: Nurse} | {Nurse: Nurse}

                        break;
                    }

                }
                break;
            default: // {Nurse: Nurse} | {Nurse: Nurse}
                System.out.println("You have now been logged out"); // {} | {}
                logout = true; // {Nurse: Nurse} | {Nurse: Nurse}
            }
            
            if(logout) { // {} | {}
                scanner.close();
                break;
            }
		}

	}

	// Input: {Bottom} | {Bottom}, Output: {Bottom} | {Bottom}
	public static int pctPositive(int days){
		Date currentDate = new Date(); // {Bottom} | {Bottom} -> {Bottom} | {Bottom}
		LocalDateTime LDTcurrentDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(); // {Bottom} | {Bottom} -> {Bottom} | {Bottom}
		LocalDateTime prevDate = LDTcurrentDate.minusDays(days); // {Bottom} | {Bottom} -> {Bottom} | {Bottom}

		int daysBetween = (int) Duration.between(prevDate,LDTcurrentDate).toDays(); // {Bottom} | {Bottom} -> {Bottom} | {Bottom}
		int sumPosTests=0; // {Bottom} | {Bottom} -> {Nurse: Nurse} | {Nurse: Nurse}
		int sumTests=0; // {Bottom} | {Bottom} -> {Nurse: Nurse} | {Nurse: Nurse}
		for (int i=0; i<patientData.size() ;i++){ // {Nurse:Nurse} | {Nurse:Nurse} -> {Nurse:Nurse} | {Nurse:Nurse}
            //if_acts_for(pctPositive, Patient)
            // ArrayList<TestEvaluation> currPatientTests = (declassify(patientData.get(i).getTests(),{})) {Patient:Patient,Nurse} | {Patient: Nurse} -> {Bottom} | {Bottom}
			ArrayList<TestEvaluation> currPatientTests = patientData.get(i).getTests(); // {Bottom} | {Bottom} -> {Nurse:Nurse} | {Nurse:Nurse}
			for(int j=0; j<currPatientTests.size(); j++) { // {Nurse:Nurse} | {Nurse:Nurse} -> {Nurse:Nurse} | {Nurse:Nurse}

				Date testDate = currPatientTests.get(j).getTestDate(); // {Nurse:Nurse} | {Nurse:Nurse} -> {Nurse: Nurse} | {Nurse: Nurse}

				LocalDateTime LDTTestDate = testDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(); // {Nurse: Nurse} | {Nurse: Nurse}
				if (testDate.before(currentDate) && (int) Duration.between(LDTTestDate,LDTcurrentDate).toDays() < daysBetween) {  // {Nurse:Nurse} | {Nurse:Nurse} -> {Nurse:Nurse} | {Nurse:Nurse}
				    sumTests ++;  // {Nurse:Nurse} | {Nurse:Nurse} -> {Nurse: Nurse} | {Nurse: Nurse}
					if (currPatientTests.get(j).isTestResult()) { // {Nurse:Nurse} | {Nurse:Nurse} -> {Nurse:Nurse} | {Nurse:Nurse}
						sumPosTests ++;  // {Nurse:Nurse} | {Nurse:Nurse} -> {Nurse: Nurse} | {Nurse: Nurse}
                    }
				}
			}
		}
		if(sumTests==0){ // {Nurse:Nurse} | {Nurse:Nurse} -> {Nurse:Nurse} | {Nurse:Nurse}
			sumTests = 1; // {Bottom} | {Bottom} -> {Nurse: Nurse} | {Nurse: Nurse} 
		}
		//if_acts_for(pctPositive, Nurse)
        // return = (declassify(100*sumPosTests/sumTests, {Bottom} | {Bottom})) {Nurse: Nurse} | {Nurse: Nurse} -> {Bottom} | {Bottom}
		return (100*sumPosTests/sumTests); // {Bottom} | {Bottom}

	}

	// Input: {Bottom} | {Bottom}, Output: {Bottom} | {Bottom}
	public static int numVaccinated(int days) {
		Date currentDate = new Date(); // {Bottom} | {Bottom} -> {Bottom} | {Bottom}
		LocalDateTime LDTcurrentDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(); // {Bottom} | {Bottom} -> {Bottom} | {Bottom}
		LocalDateTime prevDate = LDTcurrentDate.minusDays(days); // {Bottom} | {Bottom} -> {Bottom} | {Bottom}

		int daysBetween = (int) Duration.between(prevDate,LDTcurrentDate).toDays(); // {Bottom} | {Bottom} -> {Bottom} | {Bottom}
		int sumVaccs=0; //  {Bottom} | {Bottom} -> {Nurse: Nurse}
		for (int i=0; i<patientData.size() ;i++){ // {Nurse:Nurse} | {Nurse:Nurse} -> {Nurse:Nurse} | {Nurse:Nurse}
            //if_acts_for(numVaccinated, Patient)
            // ArrayList<Appointment> patientAppointments = (declassify(patientData.get(i).getAppointments(),{Bottom} | {Bottom})) // {Patient:Patient,Nurse} | {Patient:Patient} -> {Bottom} | {Bottom}
			ArrayList<Appointment> patientAppointments = patientData.get(i).getAppointments(); // {Bottom} | {Bottom} -> {Nurse: Nurse} | {Nurse: Nurse}
			for(int j=0; j<patientAppointments.size(); j++) { // {Nurse:Nurse} | {Nurse:Nurse} -> {Nurse:Nurse} | {Nurse:Nurse}
				Appointment currAppointment = patientAppointments.get(j); // {Nurse: Nurse} | {Nurse: Nurse} -> {Nurse: Nurse} | {Nurse: Nurse} 
				Date vaccDate = currAppointment.getAppointmentDate(); // {Nurse: Nurse} | {Nurse: Nurse} ->  {Nurse: Nurse} | {Nurse: Nurse}
				LocalDateTime LDTTestDate = vaccDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(); // {Nurse: Nurse} | {Nurse: Nurse} -> {Nurse: Nurse} | {Nurse: Nurse}
				if (vaccDate.before(currentDate) && (int) Duration.between(LDTTestDate,LDTcurrentDate).toDays() < daysBetween && currAppointment.getType()==true) { // {Nurse:Nurse} | {Nurse:Nurse} -> {Nurse:Nurse} | {Nurse:Nurse}
					sumVaccs ++; // {Nurse: Nurse} -> {Nurse: Nurse} 
				}
			}
		}
		//if_acts_for(numVaccinated, Nurse)
        // sumVaccs = (declassify(sumVaccs,{Bottom} | {Bottom})) {Nurse: Nurse} | {Nurse: Nurse} -> {Bottom} | {Bottom}
		return sumVaccs; // {Bottom} | {Bottom}

	}
}
