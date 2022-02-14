package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

	public  WebDriver driver ;
	protected Actions action;
	protected WebDriverWait wait;
	
	public PageBase (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	protected static void clickButton (WebElement button)
	{
		button.click();

	}
	public void uploadFile (String filePath) throws AWTException
	{
		String uploadedFilePath = System.getProperty("user.dir") + "\\Uploads\\"+filePath;

		StringSelection Selection = new StringSelection(uploadedFilePath);
		Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
		cb.setContents(Selection, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(200);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		//robot.delay(200);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(200);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}
	protected static void setTextINTextElement (WebElement textElement , String value)
	{
		textElement.sendKeys(value);

	}
	protected static void selectByVisibleTextMethod (Select selectList , String value)
	{
		selectList.selectByVisibleText(value);

	}
//protected static void parentWindow ()
//	{
//	    parentWindow = driver.getWindowHandle();
//		System.out.println("parent window ID" + parentWindow );
//	}
//	protected static void childWindow ()
//	{
//		System.out.println(parentWindow);
//		System.out.println(childWindow);
//
//			if (!childWindow.equals(parentWindow))
//			{
//				driver.switchTo().window(childWindow);
//			
//			System.out.println("chesrtfyuiopiutrewerwyiuoiyewsatyiild");
//				driver.close();
//			}
//	}
		

}



