package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientDashboardPage extends PageBase{

	public PatientDashboardPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (css = "i.ti-arrow-left")
	WebElement arrow;
	
	@FindBy (linkText = "My Profile")
	WebElement profileTab;
	
	public void clickOnArrow()
	{
		clickButton(arrow);
	}
	
	
	public void openPatientProfile()
	{
		clickButton(profileTab);
	}
}
