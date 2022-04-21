import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.time.*;

public class main {
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
		ArrayList<Patient> patientData = new ArrayList<Patient>(); //Nurse {Nurse:Nurse} | {Nurse:Nurse}
		patientData.add(Ahmed); //Patient -> Nurse {Patient:Nurse,Nurse:Nurse} | {Patient:Nurse,Nurse:Nurse}
		patientData.add(Brian); //Patient -> Nurse {Patient:Nurse,Nurse:Nurse} | {Patient:Nurse,Nurse:Nurse}
		patientData.add(Charlotte); //Patient -> Nurse {Patient:Nurse,Nurse:Nurse} | {Patient:Nurse,Nurse:Nurse}




		//Functionalities:
		int userCpr = loginFunction(patientData); // Patient {Patient:Patient} | {Patient:Patient}


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
	public static int loginFunction(ArrayList<Patient> patientData) {

		//Create console object
		Scanner scanner = new Scanner(System.in);

		// Intial message
		System.out.println("Welcome. Do you want to login or print a staitical report?"); // {} | {}
		System.out.println("1: Login to the system"); // {} | {}
		System.out.println("2: Print statistical reprot"); // {} | {}
        System.out.println("3: Login as nurse"); // {} | {}
		String userInput = scanner.nextLine(); // {Patient: Patient, Nurse: Nurse} | {Patient: Patient, Nurse: Nurse} 

		switch (Integer.parseInt(userInput)) {
		case 1:
			while (true) {
				System.out.println("Please input your cpr:");
				userInput = scanner.nextLine(); // {Patient: Patient} | {Patient: Patient}  -> 	TODO analyse flow
					if(true) {
						return Integer.parseInt(userInput);
					}

				}
		case 2:
			System.out.println("Current Statistics:"); // {} | {}
			System.out.println("Positive percent last 7 days: "+pctPositive(patientData,7)+"%"); // {Public: Public} | {Public: Public}
			System.out.println("Number of vaccinations last 7 days: "+numVaccinated(patientData,7)); // {Public: Public} | {Public: Public}

			System.exit(0); // {} | {} 
			return 0;

        case 3:
            while (true) {
                System.out.println("Please input nurse login:"); // {} | {}
                userInput = scanner.nextLine(); // {Nurse: Nurse} | {Nurse: Nurse} -> TODO analyse flow
                if(true) {
					loggedInNurse(patientData); // TODO set classification
                    return Integer.parseInt(userInput);
                }

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

				switch (Integer.parseInt(input)) { // {Patient:Patient} | {Patient:Patient} -> TODO evaluate implicit flow
				case 1:

					Date date = new Date(1651838440); // {} | {}

					patient.addAppointment(date, false, "Copenhagen NV"); // {Patient:Patient, Nurse} | {Patient:Patient}  -> {Patient:Patient,Nurse} | {Patient: Patient}
					System.out.println("Test appointment booked!"); // {Patient: Patient} | {} 
					break;
				case 2:

					Date date2 = new Date(1652431200); // {} | {}

					patient.addAppointment(date2, false, "Lyngby"); // {Patient:Patient, Nurse} | {Patient:Patient}  -> {Patient:Patient,Nurse} | {Patient: Patient}
					System.out.println("Test appointment booked!"); // {Patient: Patient} | {} 
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

				switch (Integer.parseInt(input)) { // {Patient:Patient} | {Patient:Patient}  -> TODO evaluate implicit flow 
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
				}else{System.out.println("No tests found\n");} //{Patient:Patient,Nurse} | {Patient: A} TODO admin?

				break;
			case 4:
				System.out.println("Vaccination status: "+patient.isVaccinated()+"\n"); // {Patient:Patient,Nurse} | {Patient: Nurse}
				break;
			default:
				System.out.println("You have now been logged out"); // {} | {}
				logout = true;
			}

			if(logout) { // {Patient:Patient} | {Patient:Patient} TODO implicit flow
				scanner.close();
				break;
			}

		}
	}

	// Input: {Nurse:Nurse} | {Nurse:Nurse}, Output: N/A
	public static void loggedInNurse(ArrayList<Patient> patients) {
        Scanner scanner = new Scanner(System.in); // {Nurse:Nurse} | {Nurse:Nurse}
		boolean logout = false; // {Nurse:Nurse} | {Nurse:Nurse}
        Patient p = null; // {Nurse: Nurse} | {Nurse: Nurse}
        System.out.println("Enter cpr of patient");  // {Nurse:Nurse} | {Nurse: A} TODO admin?
        String userInput = scanner.nextLine(); // {Nurse:Nurse} | {Nurse:Nurse} -> {Nurse:Nurse} | {Nurse:Nurse}
        for(int i = 0; i<patients.size(); i++) {
            if (Integer.parseInt(userInput) == patients.get(i).getCpr()) { // TODO implicit flow
                p = patients.get(i); // {Patient: Patient, Nurse} | {Patient: Nurse} -> {Nurse: Nurse} | {Nurse: Nurse} TODO declassify
                break;
            }
        }

		while(true) {

			System.out.println("Welcome, what would you like to do?"); // {} | {}
			System.out.println("1 to add test result to patient"); // {} | {}
			System.out.println("2 to add vaccination result to patient"); // {} | {}
			System.out.println("3 to see test results of patient"); // {} | {}
			System.out.println("4 to see vaccination results of patient"); // {} | {}
            System.out.println("5 to select another patient"); // {} | {}
			System.out.println("6 to logout"); // {} | {}
            userInput = scanner.nextLine(); // {Nurse:Nurse} | {Nurse:Nurse} -> {Nurse:Nurse} | {Nurse:Nurse}
            switch (Integer.parseInt(userInput)) { // {Nurse:Nurse} | {Nurse:Nurse} TODO implicit flow

            case 1:
                System.out.println("add test result to patient"); // {Nurse: Nurse} | {top}
                break;
            case 2:
                System.out.println("add vaccination result to patient"); // {Nurse: Nurse} | {top}
                p.setVaccinated(true); // TODO change owners? 
                ArrayList <Appointment> pAppointment = p.getAppointments(); // {Patient:Patient,Nurse} | {Patient: Patient} -> {Patient:Patient,Nurse} | {Patient:Patient} 
                for(int i = 0; i<pAppointment.size(); i++){
                	if(pAppointment.get(i).getType()){ // {Patient:Patient,Nurse} | {Patient:Patient} TODO implicit flow
                		p.setVaccinationDate((pAppointment.get(i).getAppointmentDate())); // {Patient:Patient} | {Patient: top,Nurse} -> {Patient:Patient,Nurse} | {Patient: Nurse}
					}
				}

                break;
            case 3:

                ArrayList<TestEvaluation> pTests=p.getTests(); // {Patient:Patient,Nurse} | {Patient: Nurse} -> {Patient:Patient,Nurse} | {Patient: Nurse}
                System.out.println("Test data from patient: "+p.getCpr()); // {Nurse: Nurse} | {top} TODO declassify
                for(int j = 0; j<pTests.size();j++) {
                    System.out.println("Test date: "+pTests.get(j).getTestDate()+"\n\rTest result: "+pTests.get(j).isTestResult()+"\n\r"); // //{Patient:Patient,Nurse} | {Patient: Nurse} ->  {Nurse: Nurse} | {top} TODO explicit flow
                }
                 break;
            case 4:
				System.out.println("Vaccination status from patient ("+p.getCpr()+"): "+p.isVaccinated()+"\n\r"); // {Patient:Patient} | {top} UNION {Patient:Patient,Nurse} | {Patient: Nurse} -> {Nurse: Nurse} | {top} TODO declassify, explicit flow, union
                break;

            case 5:
                System.out.println("Enter cpr of patient"); // {Nurse: Nurse} | {top}
                userInput = scanner.nextLine(); // {Nurse:Nurse} | {Nurse:Nurse} -> {Nurse:Nurse} | {Nurse:Nurse}
                for(int i = 0; i<patients.size(); i++) {
                    if (Integer.parseInt(userInput) == patients.get(i).getCpr()) { // {Nurse:Nurse} | {Nurse:Nurse} == {Patient:Patient} | {top}  TODO implicit flow
                        p = patients.get(i); // {Patient: Patient, Nurse} | {Patient: Nurse} -> {Nurse: Nurse} | {Nurse: Nurse} TODO declassify
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

	// Input: {Nurse: Nurse}, {Public:} | {Nurse: Nurse}, {Public: } Output: {} | {}
	public static int pctPositive(ArrayList<Patient>patientList, int days){
		Date currentDate = new Date(); // {} | {}
		LocalDateTime LDTcurrentDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(); // {} | {}
		LocalDateTime prevDate = LDTcurrentDate.minusDays(days); // {} | {}

		int daysBetween = (int) Duration.between(prevDate,LDTcurrentDate).toDays(); // {} | {}
		int sumPosTests=0; // {} | {}
		int sumTests=0; // {} | {}
		for (int i=0; i<patientList.size() ;i++){
			ArrayList<TestEvaluation> currPatientTests = patientList.get(i).getTests(); // {Patient:Patient,Nurse} | {Patient: Nurse} -> {Patient:Patient,Nurse} | {Patient: Nurse}
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
		return (100*sumPosTests/sumTests);
	}

	// Input: {Nurse: Nurse}, {Public:} | {Nurse: Nurse}, {Public: } Output: {} | {}
	public static int numVaccinated(ArrayList<Patient>patientList, int days) {
		Date currentDate = new Date(); // {} | {}
		LocalDateTime LDTcurrentDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(); // {} | {}
		LocalDateTime prevDate = LDTcurrentDate.minusDays(days); // {} | {}

		int daysBetween = (int) Duration.between(prevDate,LDTcurrentDate).toDays(); // {} | {}
		int sumVaccs=0; // {} | {}
		for (int i=0; i<patientList.size() ;i++){
			ArrayList<Appointment> patientAppointments = patientList.get(i).getAppointments(); // {Patient:Patient,Nurse} | {Patient: Patient} -> {Patient:Patient,Nurse} | {Patient:Patient} 
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

		return sumVaccs;
	}
}
