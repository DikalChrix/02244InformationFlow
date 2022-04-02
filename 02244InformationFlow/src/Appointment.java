import java.util.Date;

public class Appointment { // ALL PATIENT
	private Date appointmentDate;
	private boolean type; //True for vaccination, false for testing
	private String location;
	
	
	public Appointment(Date appointmentDateInit, String locationInit, boolean typeInit) {
		setAppointmentDate(appointmentDateInit);
		setType(typeInit);
		setLocation(locationInit);
		
	}


	public Date getAppointmentDate() {
		return appointmentDate;
	}


	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}


	public boolean getType() {
		return type;
	}


	public void setType(boolean type) {
		this.type = type;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}
	
}
