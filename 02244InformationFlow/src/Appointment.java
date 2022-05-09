import java.util.Date;

 class Appointment { // {Patient:Patient,Nurse} | {Patient:Patient}
	private Date appointmentDate; //{Patient:Patient,Nurse} | {Patient:Patient}
	private boolean type; //True for vaccination, false for testing //{Patient:Patient,Nurse} | {Patient:Patient}
	private String location; //{Patient:Patient,Nurse} | {Patient:Patient}
	
	
	 Appointment(Date appointmentDateInit, String locationInit, boolean typeInit) { // Input: {Patient:Patient,Nurse} | {Patient: Patient}, Output: {Patient:Patient,Nurse} | {Patient: Patient} 
		setAppointmentDate(appointmentDateInit);
		setType(typeInit);
		setLocation(locationInit);
		
	}


	 Date getAppointmentDate() { // Output: {Patient:Patient,Nurse} | {Patient: Patient} 
		return appointmentDate;
	}


	 void setAppointmentDate(Date appointmentDate) { // Input: {Patient:Patient,Nurse} | {Patient: Patient}, Body: {Patient:Patient,Nurse} | {Patient: Patient} 
		this.appointmentDate = appointmentDate;
	}


	 boolean getType() { // Output: {Patient:Patient,Nurse} | {Patient: Patient} 
		return type;
	}


	 void setType(boolean type) { // Input: {Patient:Patient,Nurse} | {Patient: Patient}, Body: {Patient:Patient,Nurse} | {Patient: Patient} 
		this.type = type;
	}


	 String getLocation() { // Output: {Patient:Patient,Nurse} | {Patient: Patient} 
		return location;
	}


	 void setLocation(String location) { // Input: {Patient:Patient,Nurse} | {Patient: Patient}, Body: {Patient:Patient,Nurse} | {Patient: Patient} 
		this.location = location;
	}
	
}
