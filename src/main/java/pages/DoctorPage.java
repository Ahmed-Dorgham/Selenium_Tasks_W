package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DoctorPage extends PageBase{

	public DoctorPage(WebDriver driver) {

		super(driver);
		action = new Actions (driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	}
	
	@FindBy (id = "locations-tab")
	WebElement availableAppointmentsTab ;
	

	@FindBy (xpath = "//*[@id=\"location_tab\"]/div[1]/div[1]/a")
	List<WebElement> months ;
	
	@FindBy (css = "span.cursor-pointer")
	List<WebElement> allAppointments ;
	
	@FindBy (css ="button.dc-btn.btn-themecolor.ml-1.ml-md-5")
	public List<WebElement> bookNowbuttons ; 
	

	public void bookExistedAppointment () throws InterruptedException
	{
		clickButton(availableAppointmentsTab);
		wait.until(ExpectedConditions.elementToBeClickable(availableAppointmentsTab));  
		clickButton(months.get(0));
		Thread.sleep(2000);
	}

	public void openBookingWindow () 
	{
		clickButton(allAppointments.get(0));
	    wait.until(ExpectedConditions.elementToBeClickable(allAppointments.get(0)));
		clickButton(bookNowbuttons.get(0));	
	}
	
}
