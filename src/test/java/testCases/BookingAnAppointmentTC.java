package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BookingWindowsPage;
import pages.DoctorPage;
import pages.PatientDashboardPage;
import pages.PatientHomePagePage;
import pages.SystemHomePagePage;

public class BookingAnAppointmentTC extends TestBase{
	
	SystemHomePagePage systemHomepageObject ; 
	PatientHomePagePage patientHomePageObject ;
	DoctorPage doctorPageObject;
	BookingWindowsPage bookingWindowsPageObject;
	PatientDashboardPage PatientDashboardObject;
	String patientEmail = "";
	String patientPassword = "";

	@Test(priority = 1)
	
	public void bookAnAppointment_1 () throws InterruptedException
	{
		systemHomepageObject= new SystemHomePagePage(driver);
		patientHomePageObject = new PatientHomePagePage(driver);
		doctorPageObject = new DoctorPage(driver);
		bookingWindowsPageObject = new BookingWindowsPage(driver);
		systemHomepageObject.loginAsPatient(patientEmail, patientPassword); 
		Assert.assertTrue(patientHomePageObject.hover.getText().contains("patient"));
		patientHomePageObject.openOurDoctorsPage();
		patientHomePageObject.openDoctorPage();
		doctorPageObject.bookExistedAppointment();
     	doctorPageObject.openBookingWindow();
     	
	}
@Test(priority = 2 ,dependsOnMethods = {"bookAnAppointment_1"})
	
	public void bookAnAppointment_2 () throws InterruptedException
	{
		systemHomepageObject= new SystemHomePagePage(driver);
		patientHomePageObject = new PatientHomePagePage(driver);
		doctorPageObject = new DoctorPage(driver);
		bookingWindowsPageObject = new BookingWindowsPage(driver);
     	bookingWindowsPageObject.checkBox();
     	Assert.assertTrue(bookingWindowsPageObject.checkBoxAssert.isSelected());
     	bookingWindowsPageObject.firstNextButton();
     	bookingWindowsPageObject.agreeBox();
     	Assert.assertTrue(bookingWindowsPageObject.agreeBoxAssert.isSelected());
     	bookingWindowsPageObject.secondNextButton();
     	bookingWindowsPageObject.FreeCodePage();
     	bookingWindowsPageObject.thirdNextButton();
	}
	
}
