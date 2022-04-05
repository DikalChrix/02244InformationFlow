import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.time.*;

public class main {
	public static void main(String[] args) {

		//Publicate the database
		Date date = new Date(); // {Patient:Patient,Nurse}
		Date date2 = null; // {Patient:Patient,Nurse}
		Patient Ahmed = new Patient(0000, true, date); //{Patient:Patient,Nurse}
		Patient Brian = new Patient(1234, false, date2); //{Patient:Patient,Nurse}
		Patient Charlotte = new Patient(6969, true, date); //{Patient:Patient,Nurse}

		//Add previous appointments
		Charlotte.addAppointment(date, true, "Holte"); // {Patient:Patient,Nurse}
		Brian.addAppointment(date, false, "Holte"); // {Patient:Patient,Nurse}
		Ahmed.addTestEvaluation(date, true); // {Patient:Patient,Nurse}
		Charlotte.addTestEvaluation(date, false); //{Patient:Patient,Nurse}


		//Add patients to "database"
		ArrayList<Patient> patientData = new ArrayList<Patient>(); //Nurse {Nurse:Nurse}
		patientData.add(Ahmed); //Patient -> Nurse {Patient:Nurse,Nurse:Nurse}
		patientData.add(Brian); //Patient -> Nurse {Patient:Nurse,Nurse:Nurse}
		patientData.add(Charlotte); //Patient -> Nurse {Patient:Nurse,Nurse:Nurse}




		//Functionalities:
		int userCpr = loginFunction(patientData); // Patient {Patient:Patient}

        if(userCpr>9999){
            loggedInNurse(patientData); // TODO set classification
        }else {
            // Find
            for (int i = 0; i < patientData.size(); i++) {
                if (patientData.get(i).getCpr() == userCpr) { // {Patient:Patient}
                    loggedInPatient(patientData.get(i));

                    //Test if appointment is logged
                    //System.out.println(patientData.get(i).getAppointments().get(0).getLocation());
                }
            }
        }
	}



	// Input: {Nurse:Nurse}, Output: {Patient:Patient}
	public static int loginFunction(ArrayList<Patient> patientData) {

		//Create console object
		Scanner scanner = new Scanner(System.in);

		// Intial message
		System.out.println("Welcome. Do you want to login or print a staitical report?");
		System.out.println("1: Login to the system");
		System.out.println("2: Print statistical reprot");
        System.out.println("3: Login as nurse");
		String userInput = scanner.nextLine(); // {Patient: Nurse, Patient, Public}, {Public: Nurse, Patient, Public}, {Nurse: Nurse, Patient, Public}

		switch (Integer.parseInt(userInput)) {
		case 1:
			while (true) {
				System.out.println("Please input your cpr:");
				userInput = scanner.nextLine(); // {Patient: Patient}
					if(true) {
						return Integer.parseInt(userInput);
					}

				}
		case 2:
			System.out.println("Current Statistics:");
			System.out.println("Positive percent last 7 days: "+pctPositive(patientData,7)+"%");
			System.out.println("Number of vaccinations last 7 days: "+numVaccinated(patientData,7));

			System.exit(0); // {Public: Public}
			return 0;

        case 3:
            while (true) {
                System.out.println("Please input nurse login:");
                userInput = scanner.nextLine(); // {Nurse: Nurse}
                if(true) {
                    return Integer.parseInt(userInput);
                }

            }

        default:
			System.exit(0); // {Public: Public}
			return 0;
		}

	}

	// Input: // {Patient:Patient,Nurse}, Output: N/A
	public static void loggedInPatient(Patient patient) {

		boolean logout = false; // {Patient:Patient}

		Scanner scanner = new Scanner(System.in);

		while(true) {

			System.out.println("Welcome, what would you like to do?");
			System.out.println("1 to book test appointment");
			System.out.println("2 to book vaccination appointment");
			System.out.println("3 to see test results");
			System.out.println("4 to see vaccination results");
			System.out.println("5 to logout");

			String input = scanner.nextLine(); // {Patient:Patient}

			switch (Integer.parseInt(input)) { // {Patient:Patient}
			case 1:
				// Book test appointment

				System.out.println("Possible locations and dates for testing: ");
				System.out.println("1: Copenhagen NV, 6th May 2022 13:00 ");
				System.out.println("2: Lyngby, 13th May 2022 09:40 ");
				System.out.println("3: Holte, 15th May 2022 17:25 ");

				input = scanner.nextLine(); // {Patient:Patient}

				switch (Integer.parseInt(input)) { // {Patient:Patient}
				case 1:

					Date date = new Date(1651838440); // {Patient:Patient}

					patient.addAppointment(date, false, "Copenhagen NV"); // {Patient:Patient, Nurse} := {Patient: Patient}
					System.out.println("Test appointment booked!");
					break;
				case 2:

					Date date2 = new Date(1652431200); // {Patient:Patient}

					patient.addAppointment(date2, false, "Lyngby"); // {Patient:Patient, Nurse} := {Patient: Patient}
					System.out.println("Test appointment booked!");
					break;
				case 3:

					Date date3 = new Date(1652631900); // {Patient:Patient}

					patient.addAppointment(date3, false, "Holte"); // {Patient:Patient, Nurse} := {Patient: Patient}
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

				input = scanner.nextLine(); // {Patient:Patient}

				switch (Integer.parseInt(input)) { // {Patient:Patient}
				case 1:

					Date date = new Date(1651838440); // {Patient:Patient}

					patient.addAppointment(date, true, "Copenhagen NV"); // {Patient:Patient, Nurse} := {Patient: Patient}
					System.out.println("Vaccination appointment booked!");
					break;
				case 2:

					Date date2 = new Date(1652431200); // {Patient:Patient}

					patient.addAppointment(date2, true, "Lyngby"); // {Patient:Patient, Nurse} := {Patient: Patient}
					System.out.println("Vaccination appointment booked!");
					break;
				case 3:

					Date date3 = new Date(1652631900); // {Patient:Patient}

					patient.addAppointment(date3, true, "Holte"); // {Patient:Patient, Nurse} := {Patient: Patient}
					System.out.println("Vacciniatoin appointment booked!");
					break;
				default:
					break;
				}
				break;
			case 3:
				int testLen = patient.getTests().size(); // {Patient:Patient, Nurse}
				TestEvaluation lstTstEval = patient.getTest(testLen-1); // {Patient:Patient, Nurse}
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

			if(logout) { // {Patient:Patient}
				scanner.close();
				break;
			}

		}
	}

	public static void loggedInNurse(ArrayList<Patient> patients) {
        Scanner scanner = new Scanner(System.in);
		boolean logout = false;
        Patient p = null;
        System.out.println("Enter cpr of patient");
        String userInput = scanner.nextLine();
        for(int i = 0; i<patients.size(); i++) {
            if (Integer.parseInt(userInput) == patients.get(i).getCpr()) {
                p = patients.get(i);
                break;
            }

        }
		while(true) {

			System.out.println("Welcome, what would you like to do?");
			System.out.println("1 to add test result to patient");
			System.out.println("2 to add vaccination result to patient");
			System.out.println("3 to see test results of patient");
			System.out.println("4 to see vaccination results of patient");
            System.out.println("5 to select another patient");
			System.out.println("6 to logout");
            userInput = scanner.nextLine();
            switch (Integer.parseInt(userInput)) { // {Nurse:Nurse}

            case 1:
                System.out.println("add test result to patient");
                break;
            case 2:
                System.out.println("add vaccination result to patient");
                break;
            case 3:

                ArrayList<TestEvaluation> pTests=p.getTests();
                System.out.println("Test data from patient: "+p.getCpr());
                for(int j = 0; j<pTests.size();j++) {
                    System.out.println("Test date: "+pTests.get(j).getTestDate()+"\n\rTest result: "+pTests.get(j).isTestResult()+"\n\r");
                }
                 break;
            case 4:

                System.out.println("See vaccination results of patient");
                break;

            case 5:
                System.out.println("Enter cpr of patient");
                userInput = scanner.nextLine();
                for(int i = 0; i<patients.size(); i++) {
                    if (Integer.parseInt(userInput) == patients.get(i).getCpr()) {
                        p = patients.get(i);
                        break;
                    }

                }
                break;
            default:
                System.out.println("You have now been logged out");
                logout = true;
            }

            if(logout) { // {Nurse:Nurse}
                scanner.close();
                break;
            }
		}

	}

	// Input: {Nurse: Nurse}, {Public: Nurse, Patient,Public} Output: {Public: Nurse, Patient, Public}
	public static int pctPositive(ArrayList<Patient>patientList, int days){
		Date currentDate = new Date(); // {Public: Nurse, Patient, Public}
		LocalDateTime LDTcurrentDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(); // {Public: Nurse, Patient, Public}
		LocalDateTime prevDate = LDTcurrentDate.minusDays(days); // {Public: Nurse, Patient, Public}

		int daysBetween = (int) Duration.between(prevDate,LDTcurrentDate).toDays(); // {Public: Nurse, Patient, Public}
		int sumPosTests=0; // {Public: Nurse, Patient, Public}
		int sumTests=0; // {Public: Nurse, Patient, Public}
		for (int i=0; i<patientList.size() ;i++){
			ArrayList<TestEvaluation> currPatientTests = patientList.get(i).getTests(); // {Patient: Nurse, Patient}
			for(int j=0; j<currPatientTests.size(); j++) {
				Date testDate = currPatientTests.get(j).getTestDate(); // {Patient: Nurse, Patient}
				LocalDateTime LDTTestDate = testDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(); // {Patient: Nurse, Patient}
				if (testDate.before(currentDate) && (int) Duration.between(LDTTestDate,LDTcurrentDate).toDays() < daysBetween) { // {Patient: Nurse, Patient} && {Patient: Nurse, Patient} < {Public: Nurse, Patient, Public} => {Patient: Nurse, Patient}
                    //if_acts_for(???,nurse/patient) then TODO how does declassification work
                    //sumTests:=declassify(sumTests,{Patient:????})
				    sumTests ++; // {Public: Nurse, Patient, Public}
					if (currPatientTests.get(j).isTestResult()) { // {Patient: Nurse, Patient}
						sumPosTests ++; // {Public: Nurse, Patient, Public}
					}
				}
			}
		}
		if(sumTests==0){ // Public
			sumTests = 1;
		}
		return (100*sumPosTests/sumTests);
	}

	// Input: {Nurse: Nurse}, {Public: Nurse, Public} Output: {Public: Nurse, Public}
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
                    //if_acts_for(???,nurse/patient) then
                    //sumVaccs:=declassify(sumVaccs,{Patient:????})
					sumVaccs ++;
				}
			}
		}

		return sumVaccs;
	}
}
