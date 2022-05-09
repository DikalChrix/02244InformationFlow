import java.util.Date;

public class TestEvaluation { //{Patient:Patient,Nurse} | {Patient: Nurse}
	private Date testDate; //{Patient:Patient,Nurse} | {Patient: Nurse}
	private boolean testResult; //{Patient:Patient,Nurse} | {Patient: Nurse}
	
		public TestEvaluation(Date testDateInit, boolean testResultInit) { // Input: {Patient:Patient,Nurse} | {Patient: Nurse}, Output: {Patient:Patient,Nurse} | {Patient: Nurse} 
			setTestDate(testDateInit);
			setTestResult(testResultInit);
		}

		public Date getTestDate() { // Output: {Patient:Patient,Nurse} | {Patient: Nurse} 
			return testDate;
		}

		public void setTestDate(Date testDate) { // Input: {Patient:Patient,Nurse} | {Patient: Nurse}, Body: {Patient:Patient,Nurse} | {Patient: Nurse} 
			this.testDate = testDate;
		}

		public boolean isTestResult() { // Output: {Patient:Patient,Nurse} | {Patient: Nurse} 
			return testResult;
		}

		public void setTestResult(boolean testResult) { // Input: {Patient:Patient,Nurse} | {Patient: Nurse}, Body: {Patient:Patient,Nurse} | {Patient: Nurse} 
			this.testResult = testResult;
		}
	
	
	
}
