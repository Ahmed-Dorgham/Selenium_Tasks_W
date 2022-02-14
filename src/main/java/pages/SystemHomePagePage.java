package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SystemHomePagePage extends PageBase{

	public SystemHomePagePage(WebDriver driver) {
		super(driver);

	}

	@FindBy (linkText = "Join Now")
	WebElement joinNowButton ;
	
	@FindBy (id = "dc-loginbtn")
	WebElement loginButton ;
	
	@FindBy (id = "email")
	WebElement emailField ;
	
	@FindBy (id = "password")
	WebElement passwordField ;
	
	@FindBy (className = "do-login-button")
	WebElement submitButton ;
	
	
	public void openJoiningNowPage ()
	{

		clickButton(joinNowButton);
	}

	public void loginAsPatient (String email, String password)
	{

		clickButton(loginButton);
		setTextINTextElement(emailField, email);
		setTextINTextElement(passwordField, password);
		clickButton(submitButton);
		
	}
}
