package pages;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PatientProfilePage extends PageBase {

	public PatientProfilePage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofMillis(1000));
	}
	
	String filePath = "Windows+Setup+Instructions.pdf";
	
	@FindBy (linkText = "Attached Files" )
	WebElement attachedFilesTab ;
	
	//@FindBy (xpath = "//*[@id=\"attachments\"]/div/div/div/label/span")
	@FindBy(css = "div.dc-filecontent.dz-filename")
	public WebElement attachedFileAssert ;
	
	@FindBy (xpath = "//*[@id=\"attachments\"]/div/div/div/label/span")
	//@FindBy(css = "div.dc-labelgroup")
	WebElement selectFileButton ;
	public void attachFile () throws AWTException
	{
		clickButton(attachedFilesTab);
		clickButton(selectFileButton);
		//wait.until(ExpectedConditions.elementToBeClickable(selectFileButton));
		
		uploadFile(filePath);
	}
}
