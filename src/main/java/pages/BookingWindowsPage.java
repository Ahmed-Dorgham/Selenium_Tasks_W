package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingWindowsPage extends PageBase{

	public BookingWindowsPage(WebDriver driver) {
		super(driver);
		action = new Actions (driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	}
	@FindBy (xpath = "//*[@id=\"dc-appointment-accordion\"]/div[1]/div[2]/div[2]/span/label")
	public WebElement checkBox ;
	
	@FindBy (id = "dc-mo-0-0")
	public WebElement checkBoxAssert ;

	@FindBy (css ="div.next.next_btn_arrow")
	public WebElement firstNextButton ;
	
	@FindBy (xpath = "//*[@id=\"sec1\"]/div/div[2]/div[2]/label")
	public WebElement agreeBox ;
	
	@FindBy (id = "agree")
	public WebElement agreeBoxAssert ;
	
	@FindBy (css ="div.next.next_btn_arrow")
	public WebElement secondNextButton ;
	
	@FindBy (id = "code-tab")
	public WebElement freeCode ;
	
	
	@FindBy (id = "promo-code")
	public WebElement freeCodeInputText ;
	
	@FindBy (css ="div.next.next_btn_arrow")
	public WebElement thirdNextButton ;
	
	public void checkBox () 
	{
		//wait.until(ExpectedConditions.visibilityOf(checkBox));
		clickButton(checkBox);
	}
	public void firstNextButton () 
	{
		wait.until(ExpectedConditions.elementToBeSelected(checkBoxAssert));
		wait.until(ExpectedConditions.visibilityOf(firstNextButton));
		clickButton(firstNextButton);
	}
	public void agreeBox () 
	{
		wait.until(ExpectedConditions.visibilityOf(checkBox));
		clickButton(agreeBox);
	}
	public void secondNextButton () 
	{
		wait.until(ExpectedConditions.elementToBeSelected(agreeBoxAssert));
		wait.until(ExpectedConditions.visibilityOf(secondNextButton));
		clickButton(secondNextButton);
	}
	public void FreeCodePage ()
	{
		clickButton(freeCode);
		wait.until(ExpectedConditions.visibilityOf(freeCodeInputText));
		setTextINTextElement(freeCodeInputText, "123456");
	}
	public void thirdNextButton () 
	{
		clickButton(thirdNextButton);
	}
}
