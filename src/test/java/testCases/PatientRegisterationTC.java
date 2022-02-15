package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SystemHomePagePage;
import pages.PatientRegisterationPage;

public class PatientRegisterationTC extends TestBase{
	
	SystemHomePagePage homePageObject;
	PatientRegisterationPage PatientRegisterationPageObject;
	
	@Test
	public void patientRegisterWithValidData ()
	{

		homePageObject = new SystemHomePagePage(driver);
		homePageObject.openJoiningNowPage();
		PatientRegisterationPageObject = new PatientRegisterationPage(driver);
		PatientRegisterationPageObject.JoinAsPatient_01("Ahmed","dorgham@gmail.com","1234567891","1234567891","England","123456789Aa");
		//Assert.assertTrue(PatientRegisterationPageObject.parentHeader.getText().contains("Parents Information"));
		Assert.assertEquals(PatientRegisterationPageObject.parentHeader.getText(), "Parents Information");
	}

}
