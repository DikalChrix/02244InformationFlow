import java.util.Date;

public class TestEvaluation { //{Patient:Patient,Nurse} | {Patient: Nurse}
	private Date testDate; //{Patient:Patient,Nurse} | {Patient: Nurse}
	private boolean testResult; //{Patient:Patient,Nurse} | {Patient: Nurse}
	
		public TestEvaluation(Date testDateInit, boolean testResultInit) { //In: {Patient:Patient,Nurse} | {Patient: Nurse}, Out: //{Patient:Patient,Nurse} | {Patient: Nurse}
			setTestDate(testDateInit);
			setTestResult(testResultInit);
		}

		public Date getTestDate() { //In: N/A, Out: //{Patient:Patient,Nurse} | {Patient: Nurse}
			return testDate;
		}

		public void setTestDate(Date testDate) { //In: {Patient:Patient,Nurse} | {Patient: Nurse}, Out: //{Patient:Patient,Nurse} | {Patient: Nurse}
			this.testDate = testDate;
		}

		public boolean isTestResult() { //In: N/A, Out: //{Patient:Patient,Nurse} | {Patient: Nurse}
			return testResult;
		}

		public void setTestResult(boolean testResult) { //In: {Patient:Patient,Nurse} | {Patient: Nurse}, Out: //{Patient:Patient,Nurse} | {Patient: Nurse}
			this.testResult = testResult;
		}
	
	
	
}
