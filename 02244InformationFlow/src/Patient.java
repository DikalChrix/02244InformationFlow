import java.util.ArrayList;
import java.util.Date;

public class Patient { // ALL PATIENT
	private int cpr; //{Patient:Patient}
	private boolean vaccinated; //{Patient:Patient,Nurse}
	private Date vaccinationDate; //{Patient:Patient,Nurse}
	private ArrayList<TestEvaluation> tests = new ArrayList<TestEvaluation>(); //{Patient:Patient,Nurse}
	private ArrayList<Appointment> appointments = new ArrayList<Appointment>(); //{Patient:Patient,Nurse}
	
	
	public Patient(int cprInit, boolean vaccinatedInit, Date vaccinationDateInit) { //in{Patient:Patient},out{Patient:Patient,Nurse}
		setCpr(cprInit);
		setVaccinated(vaccinatedInit);
		setVaccinationDate(vaccinationDateInit);
		
	}
	
	public void addTestEvaluation(Date date, boolean testResult) { // in{Patient:Patient,Nurse},out{Patient:Patient,Nurse}
		
		TestEvaluation testEvaluation = new TestEvaluation(date, testResult);
		
		ArrayList<TestEvaluation> testsNew = getTests();
		testsNew.add(testEvaluation);
		setTests(testsNew);
		
	}
	
	public void addAppointment(Date date, boolean type, String location) { // in{Patient:Patient,Nurse},out{Patient:Patient,Nurse}
		
		Appointment appointment = new Appointment(date, location, type);
		
		ArrayList<Appointment> appointmentsNew = getAppointments();
		appointmentsNew.add(appointment);
		setAppointments(appointmentsNew);
	}

	public int getCpr() {// in{MAYBE DECLASSIFY},out{Patient:Patient}
		return cpr;
	}

	public void setCpr(int cpr) { // in{Patient:Patient,Nurse},out{}
		this.cpr = cpr;
	}

	public boolean isVaccinated() { // in{},out{Patient:Patient,Nurse}
		return vaccinated;
	}

	public void setVaccinated(boolean vaccinated) { // in{Patient:Patient,Nurse},out{}
		this.vaccinated = vaccinated;
	}

	public Date getVaccinationDate() {  // in{},out{Patient:Patient,Nurse}
		return vaccinationDate;
	}

	public void setVaccinationDate(Date vaccinationDate) { // in{Patient:Patient,Nurse},out{}
		this.vaccinationDate = vaccinationDate;
	}

	public ArrayList<TestEvaluation> getTests() { // in{},out{Patient:Patient,Nurse}
		return tests;
	}

	public void setTests(ArrayList<TestEvaluation> tests) { // in{Patient:Patient,Nurse},out{}
		this.tests = tests;
	}

	public TestEvaluation getTest(int testNr) { // in{Patient:Patient,Nurse},out{Patient:Patient,Nurse}
		int testLen = this.getTests().size();
		if (testLen>0) {
			return tests.get(testNr);
		}else{return null;}
	}

	public ArrayList<Appointment> getAppointments() {
		return appointments;
	} // in{},out{Patient:Patient,Nurse}

	public void setAppointments(ArrayList<Appointment> appointments) { // in{Patient:Patient,Nurse},out{}
		this.appointments = appointments;
	}

}
