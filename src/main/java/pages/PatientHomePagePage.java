package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PatientHomePagePage extends PageBase {

	public PatientHomePagePage(WebDriver driver) {
		super(driver);
		action = new Actions (driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(1));
	}

	@FindBy (className  = "dc-userlogedin")
	public  WebElement hover ;
	
	@FindBy (css = "a[href='http://virual-clinic.azurewebsites.net/public/patient/dashboard']")  
	WebElement dashBoardTab ;
	
	@FindBy (css = "a[href='http://virual-clinic.azurewebsites.net/public/logout']")
	
	WebElement logoutTab ;
	
	
	
	
	@FindBy (linkText   = "Our Doctors")
	 private WebElement ourDoctorsButton ;
	
	@FindBy (css = "a.btn.btn-text-primary")
	List<WebElement> allDoctor ;
	
	public void openDashboard () throws InterruptedException 
	{
		action.moveToElement(hover).build().perform();	
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ti-settings")));
		clickButton(dashBoardTab);
	}
	public void logout () throws InterruptedException 
	{
		action.moveToElement(hover).build().perform();	
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.className("lnr-exit")));
		clickButton(logoutTab);
	}
	public void openOurDoctorsPage ()
	{
		clickButton(ourDoctorsButton);
	}
	public void openDoctorPage ()
	{
		clickButton(allDoctor.get(0));
	}


}
