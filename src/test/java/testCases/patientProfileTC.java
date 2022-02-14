package testCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.PatientDashboardPage;
import pages.PatientHomePagePage;
import pages.PatientProfilePage;
import pages.SystemHomePagePage;

public class patientProfileTC extends TestBase{
	SystemHomePagePage homepageObject ; 
	PatientHomePagePage patientPageObject ;
	PatientDashboardPage PatientDashboardObject;
	PatientProfilePage PatientProfilePageObject;
	String patientEmail = "abdullah@disbox.net";
	String patientPassword = "123456789A";
	private String filePath = "Windows+Setup+Instructions.pdf";
	@Test
	public void openPatientProfile() throws InterruptedException, AWTException
	{
	
		homepageObject= new SystemHomePagePage(driver);
		patientPageObject = new PatientHomePagePage(driver);
		PatientProfilePageObject = new PatientProfilePage(driver);
		PatientDashboardObject = new PatientDashboardPage(driver);
		homepageObject.loginAsPatient(patientEmail, patientPassword); 
		Assert.assertTrue(patientPageObject.hover.getText().contains("patient"));
		patientPageObject.openDashboard();
		PatientDashboardObject.clickOnArrow();
		PatientDashboardObject.openPatientProfile();
		PatientProfilePageObject.attachFile();
	    Assert.assertTrue(PatientProfilePageObject.attachedFileAssert.getText().contains(filePath));
	}
	
	
}
