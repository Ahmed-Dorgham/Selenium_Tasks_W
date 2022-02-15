package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SystemHomePagePage;
import pages.PatientDashboardPage;
import pages.PatientHomePagePage;

public class LoginAsPatientTC  extends TestBase{

	SystemHomePagePage systemHomepageObject ; 
	PatientHomePagePage patientPageObject ;
	PatientDashboardPage PatientDashboardObject;
	
	
	@Test
	public void LoginAsPatient () throws InterruptedException
	{
		
		systemHomepageObject= new SystemHomePagePage(driver);
		patientPageObject = new PatientHomePagePage(driver);
		PatientDashboardObject = new PatientDashboardPage(driver);
		systemHomepageObject.loginAsPatient(patientEmail, patientPassword); 
		Assert.assertTrue(patientPageObject.hover.getText().contains("patient"));
		patientPageObject.logout();
		Assert.assertTrue(systemHomepageObject.loginButton.getText().contains("Login"));
}
  }