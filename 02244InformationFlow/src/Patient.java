import java.util.ArrayList;
import java.util.Date;

 class Patient { // {Patient: Patient, Nurse} | {Patient: Nurse}
	private int cpr; //{Patient:Patient} | {}
	private boolean vaccinated; //{Patient:Patient,Nurse} | {Patient: Nurse} 
	private Date vaccinationDate; //{Patient:Patient,Nurse} | {Patient: Nurse}
	private ArrayList<TestEvaluation> tests = new ArrayList<TestEvaluation>(); //{Patient:Patient,Nurse} | {Patient: Nurse}
	private ArrayList<Appointment> appointments = new ArrayList<Appointment>(); //{Patient:Patient,Nurse} | {Patient: Patient}
	
	
	 Patient(int cprInit, boolean vaccinatedInit, Date vaccinationDateInit) { //in{Patient:Patient} | {Patient: top} ,out{Patient:Patient,Nurse} | {Patient: Nurse}  TODO check Admin
		setCpr(cprInit);
		setVaccinated(vaccinatedInit);
		setVaccinationDate(vaccinationDateInit);
		
	}
	
	 void addTestEvaluation(Date date, boolean testResult) { // in{Patient:Patient,Nurse} | {Patient:Nurse} ,out{Patient:Patient,Nurse} | {Patient: Nurse}
		
		TestEvaluation testEvaluation = new TestEvaluation(date, testResult); //{Patient:Patient,Nurse} | {Patient: Nurse} -> {Patient:Patient,Nurse} | {Patient: Nurse}
		
		ArrayList<TestEvaluation> testsNew = getTests(); // {Patient:Patient,Nurse} | {Patient: Nurse} -> {Patient:Patient,Nurse} | {Patient: Nurse}
		testsNew.add(testEvaluation); // {Patient:Patient,Nurse} | {Patient: Nurse} -> {Patient:Patient,Nurse} | {Patient: Nurse}
		setTests(testsNew); // {Patient:Patient,Nurse} | {Patient: Nurse} -> {Patient:Patient,Nurse} | {Patient: Nurse}
		
	}
	
	 void addAppointment(Date date, boolean type, String location) { // in{Patient:Patient,Nurse} | {Patient: Patient} ,out{Patient:Patient,Nurse} | {Patient: Patient}
		
		Appointment appointment = new Appointment(date, location, type); //{Patient:Patient,Nurse} | {Patient:Patient} -> {Patient:Patient,Nurse} | {Patient:Patient}
		
		ArrayList<Appointment> appointmentsNew = getAppointments(); //{Patient:Patient,Nurse} | {Patient:Patient} -> {Patient:Patient,Nurse} | {Patient:Patient}
		appointmentsNew.add(appointment); //{Patient:Patient,Nurse} | {Patient:Patient} -> {Patient:Patient,Nurse} | {Patient:Patient}
		setAppointments(appointmentsNew);  // {Patient:Patient,Nurse} | {Patient:Patient} -> {Patient:Patient,Nurse} | {Patient:Patient}
	}

	public int getCpr() {// in{MAYBE DECLASSIFY},out {Patient:Patient} | {Patient: top} TODO declassify?
		//if_acts_for(getCpr, Patient)
		// cpr = (declassify(cpr,{}))
		return cpr;
	}

	public void setCpr(int cpr) { // //in{Patient:Patient} | {Patient: top} ,out{Patient:Patient,Nurse} | {Patient: Nurse}
		this.cpr = cpr;
	}

	public boolean isVaccinated() { // In: N/A,out{Patient:Patient,Nurse} | {Patient: Nurse}
		return vaccinated;
	}

	public void setVaccinated(boolean vaccinated) { //in{Patient:Patient} | {Patient: top,Nurse} ,out{Patient:Patient,Nurse} | {Patient: Nurse}
		this.vaccinated = vaccinated;
	}

	public Date getVaccinationDate() {  // in N/A,out{Patient:Patient,Nurse} | {Patient:Patient,Nurse}
		return vaccinationDate;
	}

	public void setVaccinationDate(Date vaccinationDate) { // //in{Patient:Patient} | {Patient: top,Nurse} ,out{Patient:Patient,Nurse} | {Patient: Nurse}
		this.vaccinationDate = vaccinationDate;
	}

	public ArrayList<TestEvaluation> getTests() { // In: N/A,out{Patient:Patient,Nurse} | {Patient: Nurse}
		return tests;
	}

	public void setTests(ArrayList<TestEvaluation> tests) { // in{Patient:Patient,Nurse} | {Patient: Nurse},out {Patient:Patient,Nurse} | {Patient: Nurse}
		this.tests = tests;
	}

	public TestEvaluation getTest(int testNr) { // in{Patient:Patient,Nurse} | {Patient: Nurse}, out{Patient:Patient,Nurse} | {Patient: Nurse}
		int testLen = this.getTests().size(); // {Patient:Patient,Nurse} | {Patient: Nurse}
		if (testLen>0) {
			return tests.get(testNr);
		}else{return null;}
	}

	public ArrayList<Appointment> getAppointments() { // In: N/A,out{Patient:Patient,Nurse} | {Patient: Patient}
		return appointments;
	} 

	public void setAppointments(ArrayList<Appointment> appointments) { // in{Patient:Patient,Nurse} | {Patient: Patient},out{Patient:Patient,Nurse} | {Patient: Patient}
		this.appointments = appointments;
	}

}
