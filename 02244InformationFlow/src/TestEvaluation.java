import java.util.Date;

public class TestEvaluation { // ALL PATIENT
	private Date testDate;
	private boolean testResult;
	
		public TestEvaluation(Date testDateInit, boolean testResultInit) {
			setTestDate(testDateInit);
			setTestResult(testResultInit);
		}

		public Date getTestDate() {
			return testDate;
		}

		public void setTestDate(Date testDate) {
			this.testDate = testDate;
		}

		public boolean isTestResult() {
			return testResult;
		}

		public void setTestResult(boolean testResult) {
			this.testResult = testResult;
		}
	
	
	
}
