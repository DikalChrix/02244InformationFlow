import java.util.ArrayList;
import java.util.Date;

public class Patient { // ALL PATIENT
	private int cpr; 
	private boolean vaccinated;
	private Date vaccinationDate;
	private ArrayList<TestEvaluation> tests = new ArrayList<TestEvaluation>();
	private ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	
	
	public Patient(int cprInit, boolean vaccinatedInit, Date vaccinationDateInit) {
		setCpr(cprInit);
		setVaccinated(vaccinatedInit);
		setVaccinationDate(vaccinationDateInit);
		
	}
	
	public void addTestEvaluation(Date date, boolean testResult) {
		
		TestEvaluation testEvaluation = new TestEvaluation(date, testResult);
		
		ArrayList<TestEvaluation> testsNew = getTests();
		testsNew.add(testEvaluation);
		setTests(testsNew);
		
	}
	
	public void addAppointment(Date date, boolean type, String location) {
		
		Appointment appointment = new Appointment(date, location, type);
		
		ArrayList<Appointment> appointmentsNew = getAppointments();
		appointmentsNew.add(appointment);
		setAppointments(appointmentsNew);
	}

	public int getCpr() {
		return cpr;
	}

	public void setCpr(int cpr) {
		this.cpr = cpr;
	}

	public boolean isVaccinated() {
		return vaccinated;
	}

	public void setVaccinated(boolean vaccinated) {
		this.vaccinated = vaccinated;
	}

	public Date getVaccinationDate() {
		return vaccinationDate;
	}

	public void setVaccinationDate(Date vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}

	public ArrayList<TestEvaluation> getTests() {
		return tests;
	}

	public void setTests(ArrayList<TestEvaluation> tests) {
		this.tests = tests;
	}

	public ArrayList<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(ArrayList<Appointment> appointments) {
		this.appointments = appointments;
	}

}
