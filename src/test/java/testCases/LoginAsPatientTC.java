package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataReader.ReadingDataFromExcelSheet;
import pages.SystemHomePagePage;
import pages.PatientDashboardPage;
import pages.PatientHomePagePage;

public class LoginAsPatientTC  extends TestBase{

	SystemHomePagePage systemHomepageObject ; 
	PatientHomePagePage patientPageObject ;
	PatientDashboardPage PatientDashboardObject;
	
	@DataProvider(name = "provider")
	
	public Object [][] readingData() throws IOException 
	{
		ReadingDataFromExcelSheet reading = new ReadingDataFromExcelSheet();
	
		return reading.readingDataFromExceelSheet();
	}
	
	@Test(dataProvider = "provider" , alwaysRun = true )
	public void LoginAsPatient (String email , String password) throws InterruptedException
	{
		
		systemHomepageObject= new SystemHomePagePage(driver);
		patientPageObject = new PatientHomePagePage(driver);
		PatientDashboardObject = new PatientDashboardPage(driver);
		System.out.println(email );
		System.out.println(password );
		systemHomepageObject.loginAsPatient(email, password); 
		Assert.assertTrue(patientPageObject.hover.getText().contains("patient"));
		patientPageObject.logout();
		Assert.assertTrue(systemHomepageObject.loginButton.getText().contains("Login"));
}
  }