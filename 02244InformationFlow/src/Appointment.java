import java.util.Date;

public class Appointment { //{Patient:Patient,Nurse} | {Patient:Patient} 
	private Date appointmentDate; //{Patient:Patient,Nurse} | {Patient:Patient}
	private boolean type; //True for vaccination, false for testing //{Patient:Patient,Nurse} | {Patient:Patient}
	private String location; //{Patient:Patient,Nurse} | {Patient:Patient}
	
	
	public Appointment(Date appointmentDateInit, String locationInit, boolean typeInit) { //In: {Patient:Patient,Nurse} | {Patient:Patient}, Out: //{Patient:Patient,Nurse} | {Patient:Patient}
		setAppointmentDate(appointmentDateInit);
		setType(typeInit);
		setLocation(locationInit);
		
	}


	public Date getAppointmentDate() { //In: N/A, Out: //{Patient:Patient,Nurse} | {Patient:Patient}
		return appointmentDate;
	}


	public void setAppointmentDate(Date appointmentDate) { //In: {Patient:Patient,Nurse} | {Patient:Patient}, Out: //{Patient:Patient,Nurse} | {Patient:Patient}
		this.appointmentDate = appointmentDate;
	}


	public boolean getType() { //In: N/A, Out: //{Patient:Patient,Nurse} | {Patient:Patient}
		return type;
	}


	public void setType(boolean type) { //In: {Patient:Patient,Nurse} | {Patient:Patient}, Out: //{Patient:Patient,Nurse} | {Patient:Patient}
		this.type = type;
	}


	public String getLocation() { //In: N/A, Out: //{Patient:Patient,Nurse} | {Patient:Patient}
		return location;
	}


	public void setLocation(String location) { //In: {Patient:Patient,Nurse} | {Patient:Patient}, Out: //{Patient:Patient,Nurse} | {Patient:Patient}
		this.location = location;
	}
	
}
