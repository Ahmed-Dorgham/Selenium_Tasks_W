package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PatientRegisterationPage extends PageBase{

	public PatientRegisterationPage(WebDriver driver) {
		super(driver);

	}


	@FindBy(name = "name")
	WebElement nameField;

	@FindBy(xpath = "//*[@id=\"register_form\"]/fieldset/div/div[2]/div[2]/input")
	WebElement emailField;

	@FindBy(name = "medical_id")
	WebElement idNumberField;

	@FindBy(name = "phone")
	WebElement phoneField;

	@FindBy(id ="id_password")
	WebElement passwordField;

	@FindBy(xpath = "//*[@id=\"id_con_password\"]")
	WebElement confirmPasswordField;

	@FindBy(xpath = "//*[@id=\"register_form\"]/fieldset/div/div[3]/div/button")
	WebElement submitButton;

	@FindBy(xpath = "//*[@id=\"register_form\"]/fieldset/div/div[2]/div[5]/span/select")
	WebElement countries;
	Select location = new Select(countries);

	@FindBy(xpath = "//*[@id=\"register_form\"]/fieldset/div/h5")
	public WebElement parentHeader;


	public void JoinAsPatient_01 (String name , String email , String idNumber , String phone , String country, String password)
	{	

		setTextINTextElement(nameField , name);
		setTextINTextElement(emailField , email);
		setTextINTextElement(idNumberField , idNumber);
		setTextINTextElement(phoneField , phone);
		selectByVisibleTextMethod(location , country);
		setTextINTextElement(passwordField , password);
		setTextINTextElement(confirmPasswordField , password);
		clickButton(submitButton);

	}



}
