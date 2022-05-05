import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.time.*;


public class main {
	static ArrayList<Patient> patientData = new ArrayList<Patient>(); //Nurse {Nurse:Nurse} | {Nurse:Nurse}
	public static void main(String[] args) {

		//Publicate the database
		Date date = new Date(); // {Patient:Patient,Nurse} | {Patient: Nurse} 
		Date date2 = null; // {Patient:Patient,Nurse} | {Patient:Nurse}
		Patient Ahmed = new Patient(0000, true, date); // {Patient:Patient,Nurse} | {Patient:Nurse}
		Patient Brian = new Patient(1234, false, date2); // {Patient:Patient,Nurse} | {Patient:Nurse}
		Patient Charlotte = new Patient(6969, true, date); // {Patient:Patient,Nurse} | {Patient:Nurse}

		//Add previous appointments
		Charlotte.addAppointment(date, true, "Holte"); // {Patient:Patient,Nurse} | {Patient:Nurse}
		Brian.addAppointment(date, false, "Holte"); // {Patient:Patient,Nurse} | {Patient:Nurse}
		Ahmed.addTestEvaluation(date, true); // {Patient:Patient,Nurse} | {Patient:Nurse}
		Charlotte.addTestEvaluation(date, false); //{Patient:Patient,Nurse} | {Patient:Nurse}


		//Add patients to "database"

		patientData.add(Ahmed); //Patient -> Nurse {Patient:Nurse,Nurse:Nurse} | {Patient:Nurse,Nurse:Nurse}
		patientData.add(Brian); //Patient -> Nurse {Patient:Nurse,Nurse:Nurse} | {Patient:Nurse,Nurse:Nurse}
		patientData.add(Charlotte); //Patient -> Nurse {Patient:Nurse,Nurse:Nurse} | {Patient:Nurse,Nurse:Nurse}




		//Functionalities:
		int userCpr = loginFunction(); // {Patient:Patient} | {Patient:Patient}


		// Find
		for (int i = 0; i < patientData.size(); i++) {
			if (patientData.get(i).getCpr() == userCpr) { // {Patient:Patient}
				loggedInPatient(patientData.get(i));

				//Test if appointment is logged
				//System.out.println(patientData.get(i).getAppointments().get(0).getLocation());
			}
		}

	}



	// Input: {Nurse:Nurse} | {Nurse:Nurse}, Output: {Patient:Patient} | {Patient:Patient}  TODO declassify somewhere?
	public static int loginFunction() {

		//Create console object
		Scanner scanner = new Scanner(System.in);

		// Intial message
		System.out.println("Welcome. Do you want to login or print a staitical report?"); // {} | {}
		System.out.println("1: Login to the system"); // {} | {}
		System.out.println("2: Print statistical reprot"); // {} | {}
        System.out.println("3: Login as nurse"); // {} | {}
		String publicInput = scanner.nextLine(); // {Public: Public} | {Public: Public}
		String patientInput;

		switch (Integer.parseInt(publicInput)) {
		case 1:
			while (true) {
				System.out.println("Please input your cpr:");
				patientInput= scanner.nextLine(); // {Public: Public} |{Public: Public}->{Patient: Patient} | {Patient: Patient} 	TODO analyse flow
					if(true) {
						return Integer.parseInt(patientInput);
					}

				}
		case 2:
			System.out.println("Current Statistics:"); // {} | {}
			System.out.println("Positive percent last 7 days: "+pctPositive(7)+"%"); // {Bottom: Bottom} | {Bottom: Bottom}
			System.out.println("Number of vaccinations last 7 days: "+numVaccinated(7)); // {Bottom: Bottom} | {Bottom: Bottom}

			System.exit(0); // {} | {} 
			return 0;

        case 3:
            while (true) {
                System.out.println("Please input nurse login:"); // {} | {}
                if(true) {
					loggedInNurse(); //  {Nurse:Nurse} | {Nurse:Nurse} -> {Nurse:Nurse} | {Nurse:Nurse}
                }
				System.exit(0); // {} | {}
				return 0;

            }

        default:
			System.exit(0); // {} | {}
			return 0;
		}

	}

	// Input: // {Patient:Patient,Nurse} | {Patient:Patient} , Output: N/A
	public static void loggedInPatient(Patient patient) {

		boolean logout = false; // {Patient:Patient} | {Patient:Patient}

		Scanner scanner = new Scanner(System.in);

		while(true) {

			System.out.println("Welcome, what would you like to do?"); // {} | {}
			System.out.println("1 to book test appointment"); // {} | {}
			System.out.println("2 to book vaccination appointment"); // {} | {}
			System.out.println("3 to see test results"); // {} | {}
			System.out.println("4 to see vaccination results"); // {} | {}
			System.out.println("5 to logout"); // {} | {}

			String input = scanner.nextLine(); // {Patient:Patient} | {Patient:Patient}

			switch (Integer.parseInt(input)) { // {Patient:Patient} | {Patient:Patient} -> TODO evaluate implicit flow
			case 1:
				// Book test appointment

				System.out.println("Possible locations and dates for testing: "); // {} | {}
				System.out.println("1: Copenhagen NV, 6th May 2022 13:00 "); // {} | {}
				System.out.println("2: Lyngby, 13th May 2022 09:40 "); // {} | {}
				System.out.println("3: Holte, 15th May 2022 17:25 "); // {} | {}

				input = scanner.nextLine(); // {Patient:Patient} | {Patient:Patient}  -> {Patient:Patient} | {Patient:Patient} 

				switch (Integer.parseInt(input)) { // {Patient:Patient} | {Patient:Patient} -> {Patient:Patient} | {Patient:Patient}
				case 1:

					Date date = new Date(1651838440); // {} | {}

					patient.addAppointment(date, false, "Copenhagen NV"); // {Patient:Patient, Nurse} | {Patient:Patient}  -> {Patient:Patient,Nurse} | {Patient: Patient}
					System.out.println("Test appointment booked!"); // {Patient: Patient} | {patient: }
					break;
				case 2:

					Date date2 = new Date(1652431200); // {} | {}

					patient.addAppointment(date2, false, "Lyngby"); // {Patient:Patient, Nurse} | {Patient:Patient}  -> {Patient:Patient,Nurse} | {Patient: Patient}
					System.out.println("Test appointment booked!"); // {Patient: Patient} | {patient: }
					break;
				case 3:

					Date date3 = new Date(1652631900); // {} | {}

					patient.addAppointment(date3, false, "Holte"); // {Patient:Patient, Nurse} | {Patient:Patient}  -> {Patient:Patient,Nurse} | {Patient: Patient}
					System.out.println("Test appointment booked!"); // {Patient: Patient} | {} 
					break;
				default:
					break;
				}

				break;
			case 2:
				// Book vaccination appointment

				System.out.println("Possible locations and dates for vaccination: "); // {} | {}
				System.out.println("1: Copenhagen NV, 6th May 2022 13:00 "); // {} | {}
				System.out.println("2: Lyngby, 13th May 2022 09:40 "); // {} | {}
				System.out.println("3: Holte, 15th May 2022 17:25 "); // {} | {}

				input = scanner.nextLine(); // {Patient:Patient} | {Patient:Patient}  -> {Patient:Patient} | {Patient:Patient}

				switch (Integer.parseInt(input)) { // {Patient:Patient} | {Patient:Patient}  -> {Patient:Patient} | {Patient:Patient}
				case 1:

					Date date = new Date(1651838440); // {} | {}

					patient.addAppointment(date, true, "Copenhagen NV"); // {Patient:Patient, Nurse} | {Patient:Patient}  -> {Patient:Patient,Nurse} | {Patient: Patient}
					System.out.println("Vaccination appointment booked!"); // {Patient: Patient} | {top}
					break;
				case 2:

					Date date2 = new Date(1652431200); // {} | {}

					patient.addAppointment(date2, true, "Lyngby"); // {Patient:Patient, Nurse} | {Patient:Patient}  -> {Patient:Patient,Nurse} | {Patient: Patient}
					System.out.println("Vaccination appointment booked!"); // {Patient: Patient} | {top}
					break;
				case 3:

					Date date3 = new Date(1652631900); // {} | {}

					patient.addAppointment(date3, true, "Holte"); // {Patient:Patient, Nurse} | {Patient:Patient}  -> {Patient:Patient,Nurse} | {Patient: Patient}
					System.out.println("Vaccination appointment booked!"); // {Patient: Patient} | {top} 
					break; 
				default:
					break;
				}
				break;
			case 3:
				int testLen = patient.getTests().size(); // {Patient:Patient,Nurse} | {Patient: Nurse} -> {Patient:Patient,Nurse} | {Patient: Nurse}
				TestEvaluation lstTstEval = patient.getTest(testLen-1); // {Patient:Patient,Nurse} | {Patient: Nurse} -> {Patient:Patient,Nurse} | {Patient: Nurse}
				if (testLen > 0) { // {Patient:Patient,Nurse} | {Patient: Nurse}
					System.out.println("Last test result: " + lstTstEval.isTestResult() + "\n"); //{Patient:Patient,Nurse} | {Patient: Nurse}
				}else{System.out.println("No tests found\n");} //{Patient:Patient,Nurse}

				break;
			case 4:
				System.out.println("Vaccination status: "+patient.isVaccinated()+"\n"); // {Patient:Patient,Nurse} | {Patient: Nurse}
				break;
			default:
				System.out.println("You have now been logged out"); // {} | {}
				logout = true;
			}

			if(logout) { // {Patient:Patient} | {Patient:Patient} ->{Patient:Patient} | {Patient:Patient}
				scanner.close();
				break;
			}

		}
	}

	// Input: N/A, Output: N/A
	public static void loggedInNurse() {
        Scanner scanner = new Scanner(System.in); // {Nurse:Nurse} | {Nurse:Nurse}
		boolean logout = false; // {Nurse:Nurse} | {Nurse:Nurse}
        Patient p = null; // {Nurse: Nurse} | {Nurse: Nurse}
        System.out.println("Enter cpr of patient");  // {Nurse:Nurse}
        String userInput = scanner.nextLine(); // {Nurse:Nurse} | {Nurse:Nurse} -> {Nurse:Nurse} | {Nurse:Nurse}
        for(int i = 0; i<patientData.size(); i++) {
            if (Integer.parseInt(userInput) == patientData.get(i).getCpr()) { // {Nurse: Nurse} | {Nurse: Nurse} ==  TODO implicit flow
            	//if_acts_for(loggedInNurse, Patient)
                p = patientData.get(i); // {Patient: Patient, Nurse} | {Patient: Nurse} -> {Nurse: Nurse} | {Nurse: Nurse} {⊥}
				// p = (declassify(patientData.get(i),{}))
                break;
            }
        }

		while(true) {

			System.out.println("Welcome, what would you like to do?"); // {} | {}
			System.out.println("1 to add test result to latest test appointment of patient"); // {} | {}
			System.out.println("2 to set vaccination status as of patient as vaccinated"); // {} | {}
			System.out.println("3 to see test results of patient"); // {} | {}
			System.out.println("4 to see vaccination status of patient"); // {} | {}
            System.out.println("5 to select another patient"); // {} | {}
			System.out.println("6 to logout"); // {} | {}
            userInput = scanner.nextLine(); // {Nurse:Nurse} | {Nurse:Nurse} -> {Nurse:Nurse} | {Nurse:Nurse}
            
            ArrayList <Appointment> pAppointment = p.getAppointments(); // {Patient:Patient,Nurse} | {Patient: Patient} -> {Patient:Patient,Nurse} | {Patient:Patient} 
            
            switch (Integer.parseInt(userInput)) { // {Nurse:Nurse} | {Nurse:Nurse} TODO implicit flow

            
            
            case 1:
            	
            	System.out.println("What was the test result of the patient?"); // {} | {}
            	System.out.println("0 for Negative"); // {} | {}
            	System.out.println("1 for Positive"); // {} | {}
            	
            	userInput = scanner.nextLine(); // {Nurse:Nurse} | {Nurse:Nurse} -> {Nurse:Nurse} | {Nurse:Nurse}
            	            	
            	// Find latest appointment         
               
                Date date = new Date(1000000000); // {} | {}
                Appointment latestAppointment =  new Appointment(date, "", true); // {Nurse:Nurse} | {Nurse:Nurse} -> // {Nurse:Nurse} | {Nurse:Nurse} 
                for(int i = 0; i<pAppointment.size(); i++){
                	if(!pAppointment.get(i).getType() & pAppointment.get(i).getAppointmentDate().after(latestAppointment.getAppointmentDate())){ // {Patient:Patient,Nurse} | {Patient:Patient} TODO implicit flow
                		latestAppointment = pAppointment.get(i);  // {Patient:Patient, Nurse} | {Patient:Patient} -> // {Nurse:Nurse} | {Nurse:Nurse}
					}
				}
                
                // Add test evaluation
                if (Integer.parseInt(userInput) == 0) { // {Nurse:Nurse} | {Nurse:Nurse} TODO implicit flow
                	p.addTestEvaluation(latestAppointment.getAppointmentDate(), false); // {Nurse:Nurse} | {Nurse:Nurse} -> {Patient:Patient,Nurse} | {Patient: Patient} TODO explicit flow
                }
                else {
                	p.addTestEvaluation(latestAppointment.getAppointmentDate(), true); // {Nurse:Nurse} | {Nurse:Nurse} -> {Patient:Patient,Nurse} | {Patient: Patient} TODO explicit flow
                }
                System.out.println("Test result added to patient!"); // {Nurse: Nurse} | {top}
                                
                break;
                
            case 2:
                p.setVaccinated(true); // TODO change owners? 
                for(int i = 0; i<pAppointment.size(); i++){
                	if(pAppointment.get(i).getType()){ // {Patient:Patient,Nurse} | {Patient:Patient} TODO implicit flow
                		p.setVaccinationDate((pAppointment.get(i).getAppointmentDate())); // {Patient:Patient} | {Patient: top,Nurse} -> {Patient:Patient,Nurse} | {Patient: Nurse}
					}
				}
                System.out.println("Vaccination status of the patient updated!"); // {Nurse: Nurse} | {top}

                break;
            case 3:

                ArrayList<TestEvaluation> pTests=p.getTests(); // {Patient:Patient,Nurse} | {Patient: Nurse} -> {Patient:Patient,Nurse} | {Patient: Nurse}
                System.out.println("Test data from patient: "+p.getCpr()); // {Nurse: Nurse} | {top}
                for(int j = 0; j<pTests.size();j++) {
                    System.out.println("Test date: "+pTests.get(j).getTestDate()+"\n\rTest result: "+pTests.get(j).isTestResult()+"\n\r"); //	{Patient:Patient,Nurse} | {Patient: Nurse} ->  {Nurse: Nurse} | {top} TODO explicit flow
                }
                 break;
            case 4:
				System.out.println("Vaccination status from patient ("+p.getCpr()+"): "+p.isVaccinated()+"\n\r"); // {Patient:Patient} | {top} UNION {Patient:Patient,Nurse} | {Patient: Nurse} -> {Nurse: Nurse} | {top} TODO declassify, explicit flow, union
                break;

            case 5:
                System.out.println("Enter cpr of patient"); // {Nurse: Nurse} | {top}
                userInput = scanner.nextLine(); // {Nurse:Nurse} | {Nurse:Nurse} -> {Nurse:Nurse} | {Nurse:Nurse}
                for(int i = 0; i<patientData.size(); i++) {
                    if (Integer.parseInt(userInput) == patientData.get(i).getCpr()) { // {Nurse:Nurse} | {Nurse:Nurse} == {Patient:Patient} | {top}  TODO implicit flow
						//if_acts_for(loggedInNurse, Patient)
                        p = patientData.get(i); // {Patient: Patient, Nurse} | {Patient: Nurse} -> {Nurse: Nurse} | {Nurse: Nurse}
						// p = (declassify(patientData.get(i),{}))
                        break;
                    }

                }
                break;
            default:
                System.out.println("You have now been logged out"); // {Nurse: Nurse} | {top}
                logout = true;
            }

            if(logout) { // {Nurse:Nurse} | {Nurse:Nurse}
                scanner.close();
                break;
            }
		}

	}

	// Input: {Bottom:} | {Nurse: Nurse}, {Bottom: } Output: {} | {}
	public static int pctPositive(int days){
		Date currentDate = new Date(); // {Nurse: Nurse} | {}
		LocalDateTime LDTcurrentDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(); // {} | {}
		LocalDateTime prevDate = LDTcurrentDate.minusDays(days); // {} | {}

		int daysBetween = (int) Duration.between(prevDate,LDTcurrentDate).toDays(); // {} | {}
		int sumPosTests=0; // {} | {} TODO change classification
		int sumTests=0; // {} | {} TODO change classification
		for (int i=0; i<patientData.size() ;i++){
			ArrayList<TestEvaluation> currPatientTests = patientData.get(i).getTests(); // {Patient:Patient,Nurse} | {Patient: Nurse} -> {Patient:Patient,Nurse} | {Patient: Nurse}
			for(int j=0; j<currPatientTests.size(); j++) {
				Date testDate = currPatientTests.get(j).getTestDate(); // {Patient:Patient,Nurse} | {Patient: Nurse} -> {} | {} TODO declassify
				LocalDateTime LDTTestDate = testDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(); // {} | {} -> {} | {} 
				if (testDate.before(currentDate) && (int) Duration.between(LDTTestDate,LDTcurrentDate).toDays() < daysBetween) { // {} | {} && {} | {} < {} | {}  TODO implicit flow
                    //if_acts_for(???,nurse/patient) then TODO how does declassification work
                    //sumTests:=declassify(sumTests,{Patient:????})
				    sumTests ++;
					if (currPatientTests.get(j).isTestResult()) { // {Patient:Patient,Nurse} | {Patient: Nurse}
						sumPosTests ++;
					}
				}
			}
		}
		if(sumTests==0){ // {} | {}
			sumTests = 1;
		}
		//if_acts_for(pctPositive, Nurse)
		return (100*sumPosTests/sumTests);
		// return = (declassify(100*sumPosTests/sumTests,{}))
	}

	// Input: {Bottom:} | {Nurse: Nurse}, {Bottom: } Output: {} | {}
	public static int numVaccinated(int days) {
		Date currentDate = new Date(); // {} | {}
		LocalDateTime LDTcurrentDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(); // {} | {}
		LocalDateTime prevDate = LDTcurrentDate.minusDays(days); // {} | {}

		int daysBetween = (int) Duration.between(prevDate,LDTcurrentDate).toDays(); // {} | {}
		int sumVaccs=0; // {} | {} TODO change classification
		for (int i=0; i<patientData.size() ;i++){
			ArrayList<Appointment> patientAppointments = patientData.get(i).getAppointments(); // {Patient:Patient,Nurse} | {Patient: Patient} -> {Patient:Patient,Nurse} | {Patient:Patient}
			for(int j=0; j<patientAppointments.size(); j++) {
				Appointment currAppointment = patientAppointments.get(j); // {Patient:Patient,Nurse} | {Patient:Patient} -> {Patient:Patient,Nurse} | {Patient:Patient} // TODO Placeholder ?
				Date vaccDate = currAppointment.getAppointmentDate(); // //{Patient:Patient,Nurse} | {Patient:Patient ->  {} | {} TODO declassify, placeholder?
				LocalDateTime LDTTestDate = vaccDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(); // {} | {} -> {} | {}
				if (vaccDate.before(currentDate) && (int) Duration.between(LDTTestDate,LDTcurrentDate).toDays() < daysBetween && currAppointment.getType()==true) { // {} | {} && {} | {} < {} | {} && {Patient:Patient,Nurse} | {Patient:Patient} TODO implicit flow 
                    //if_acts_for(???,nurse/patient) then
                    //sumVaccs:=declassify(sumVaccs,{Patient:????})
					sumVaccs ++;
				}
			}
		}
		//if_acts_for(pctPositive, Nurse)
		return sumVaccs;
		// return = (declassify(sumVaccs,{}))
	}
}
