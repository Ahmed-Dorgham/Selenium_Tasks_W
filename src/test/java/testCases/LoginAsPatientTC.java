package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SystemHomePagePage;
import pages.PatientDashboardPage;
import pages.PatientHomePagePage;

public class LoginAsPatientTC  extends TestBase{

	SystemHomePagePage homepageObject ; 
	PatientHomePagePage patientPageObject ;
	PatientDashboardPage PatientDashboardObject;
	String patientEmail = "abdullah@disbox.net";
	String patientPassword = "123456789A";
	
	@Test
	public void LoginAsPatient () throws InterruptedException
	{
		
		homepageObject= new SystemHomePagePage(driver);
		patientPageObject = new PatientHomePagePage(driver);
		PatientDashboardObject = new PatientDashboardPage(driver);
		homepageObject.loginAsPatient(patientEmail, patientPassword); 
		Assert.assertTrue(patientPageObject.hover.getText().contains("patient"));
		patientPageObject.openDashboard();
}
}