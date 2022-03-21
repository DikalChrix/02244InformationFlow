import java.util.Date;

public class Appointment {
	private Date appointmentDate;
	private boolean type; //True for vaccination, false for testing
	
	
	public Appointment(Date appointmentDateInit, boolean typeInit) {
		setAppointmentDate(appointmentDateInit);
		setType(typeInit);
		
	}


	public Date getAppointmentDate() {
		return appointmentDate;
	}


	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}


	public boolean isType() {
		return type;
	}


	public void setType(boolean type) {
		this.type = type;
	}
	
}
