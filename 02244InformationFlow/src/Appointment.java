import java.util.Date;

 class Appointment { //{Patient:Patient,Nurse} | {Patient:Patient}
	private Date appointmentDate; //{Patient:Patient,Nurse} | {Patient:Patient}
	private boolean type; //True for vaccination, false for testing //{Patient:Patient,Nurse} | {Patient:Patient}
	private String location; //{Patient:Patient,Nurse} | {Patient:Patient}
	
	
	 Appointment(Date appointmentDateInit, String locationInit, boolean typeInit) { //In: {Patient:Patient,Nurse} | {Patient:Patient}, Out: //{Patient:Patient,Nurse} | {Patient:Patient}
		setAppointmentDate(appointmentDateInit);
		setType(typeInit);
		setLocation(locationInit);
		
	}


	 Date getAppointmentDate() { //In: N/A, Out: //{Patient:Patient,Nurse} | {Patient:Patient}
		return appointmentDate;
	}


	 void setAppointmentDate(Date appointmentDate) { //In: {Patient:Patient,Nurse} | {Patient:Patient}, Out: //{Patient:Patient,Nurse} | {Patient:Patient}
		this.appointmentDate = appointmentDate;
	}


	 boolean getType() { //In: N/A, Out: //{Patient:Patient,Nurse} | {Patient:Patient}
		return type;
	}


	 void setType(boolean type) { //In: {Patient:Patient,Nurse} | {Patient:Patient}, Out: //{Patient:Patient,Nurse} | {Patient:Patient}
		this.type = type;
	}


	 String getLocation() { //In: N/A, Out: //{Patient:Patient,Nurse} | {Patient:Patient}
		return location;
	}


	 void setLocation(String location) { //In: {Patient:Patient,Nurse} | {Patient:Patient}, Out: //{Patient:Patient,Nurse} | {Patient:Patient}
		this.location = location;
	}
	
}
