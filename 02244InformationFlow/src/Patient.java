import java.util.ArrayList;
import java.util.Date;

 class Patient { // {Patient: Patient, Nurse} | {Patient: Nurse}
	private int cpr; //{Patient:Patient} | {Patient: Bottom}
	private boolean vaccinated; //{Patient:Patient,Nurse} | {Patient: Nurse} 
	private Date vaccinationDate; //{Patient:Patient,Nurse} | {Patient: Nurse}
	private ArrayList<TestEvaluation> tests = new ArrayList<TestEvaluation>(); //{Patient:Patient,Nurse} | {Patient: Nurse}
	private ArrayList<Appointment> appointments = new ArrayList<Appointment>(); //{Patient:Patient,Nurse} | {Patient: Patient}
	
	
	 Patient(int cprInit, boolean vaccinatedInit, Date vaccinationDateInit) { // used to set "database" up // Input: {Patient:Patient} | {Patient: Nurse } , Output: {Patient:Patient,Nurse} | {Patient: Nurse}
		setCpr(cprInit);
		setVaccinated(vaccinatedInit);
		setVaccinationDate(vaccinationDateInit);
		
	}
	
	 void addTestEvaluation(Date date, boolean testResult) { // Input: {Patient:Patient,Nurse} | {Patient:Nurse}, Body: {Patient:Patient,Nurse} | {Patient:Nurse} 
		
		TestEvaluation testEvaluation = new TestEvaluation(date, testResult); //{Patient:Patient,Nurse} | {Patient: Nurse} -> {Patient:Patient,Nurse} | {Patient: Nurse}
		
		ArrayList<TestEvaluation> testsNew = getTests(); // {Patient:Patient,Nurse} | {Patient: Nurse} -> {Patient:Patient,Nurse} | {Patient: Nurse}
		testsNew.add(testEvaluation); // {Patient:Patient,Nurse} | {Patient: Nurse} -> {Patient:Patient,Nurse} | {Patient: Nurse}
		setTests(testsNew); // {Patient:Patient,Nurse} | {Patient: Nurse} -> {Patient:Patient,Nurse} | {Patient: Nurse}
		
	}
	
	 void addAppointment(Date date, boolean type, String location) { // Input: {Patient:Patient,Nurse} | {Patient: Patient}, Body: {Patient:Patient,Nurse} | {Patient: Patient}
		
		Appointment appointment = new Appointment(date, location, type); //{Patient:Patient,Nurse} | {Patient:Patient} -> {Patient:Patient,Nurse} | {Patient:Patient}
		
		ArrayList<Appointment> appointmentsNew = getAppointments(); //{Patient:Patient,Nurse} | {Patient:Patient} -> {Patient:Patient,Nurse} | {Patient:Patient}
		appointmentsNew.add(appointment); //{Patient:Patient,Nurse} | {Patient:Patient} -> {Patient:Patient,Nurse} | {Patient:Patient}
		setAppointments(appointmentsNew);  // {Patient:Patient,Nurse} | {Patient:Patient} -> {Patient:Patient,Nurse} | {Patient:Patient}
	}

	public int getCpr() {// Output: {Bottom} | {Bottom}
		//if_acts_for(getCpr, Patient)
		// cpr = (declassify(cpr,{Bottom} | {Bottom})) 
		return cpr;
	}

	public void setCpr(int cpr) { // Input: {Patient:Patient} | {Patient: } , Body: {Patient:Patient,Nurse} | {Patient:}
		this.cpr = cpr;
	}

	public boolean isVaccinated() { // Output: {Patient:Patient,Nurse} | {Patient: Nurse}
		return vaccinated;
	}

	public void setVaccinated(boolean vaccinated) { // Input: {Patient:Patient} | {Patient: Nurse } , Body: {Patient:Patient,Nurse} | {Patient: Nurse}
		this.vaccinated = vaccinated;
	}

	public Date getVaccinationDate() {  // Output: {Patient:Patient,Nurse} | {Patient: Nurse}
		return vaccinationDate;
	}

	public void setVaccinationDate(Date vaccinationDate) { // Input: {Patient:Patient} | {Patient: Nurse } , Body: {Patient:Patient,Nurse} | {Patient: Nurse}
		this.vaccinationDate = vaccinationDate;
	}

	public ArrayList<TestEvaluation> getTests() { // Output: {Patient:Patient,Nurse} | {Patient: Nurse}
		return tests;
	}

	public void setTests(ArrayList<TestEvaluation> tests) { // Input: {Patient:Patient} | {Patient: Nurse } , Body: {Patient:Patient,Nurse} | {Patient: Nurse}
		this.tests = tests;
	}

	public TestEvaluation getTest(int testNr) { // Input: {Patient:Patient} | {Patient: Nurse } , Output: {Patient:Patient,Nurse} | {Patient: Nurse}
		int testLen = this.getTests().size(); // {Patient:Patient,Nurse} | {Patient: Nurse} -> {Patient:Patient,Nurse} | {Patient: Nurse} 
		if (testLen>0) { // {Patient:Patient,Nurse} | {Patient: Nurse} -> {Patient:Patient,Nurse} | {Patient: Nurse} 
			return tests.get(testNr); // {Patient:Patient,Nurse} | {Patient: Nurse}
		}else{return null;}
	}

	public ArrayList<Appointment> getAppointments() { // Output: {Patient:Patient,Nurse} | {Patient: Patient}
		return appointments;
	} 

	public void setAppointments(ArrayList<Appointment> appointments) { // Input: {Patient:Patient} | {Patient: Patient } , Body: {Patient:Patient,Nurse} | {Patient: Patient}
		this.appointments = appointments;
	}

}
