package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Utilities.Helper;

public class TestBase {
	public   WebDriver driver;

	@BeforeClass
	@Parameters (("browser"))
	public void startDriver (@Optional ("chrome") String browserName)
	{
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/WebDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.navigate().to("http://virual-clinic.azurewebsites.net/public/");
	}
		
	@AfterMethod
	public void takeScreenshotOnFailure (ITestResult result) throws IOException
{
		if (result.getStatus()== ITestResult.FAILURE)
		{
			System.out.println("Failed!!");
			System.out.println("Taking Screenshot.......");
			Helper.takeScreenshot(driver,result.getName());
		}
	}
	
//	@AfterClass
//	
//	public void closeDriver ()
//	{
//	driver.quit();
//	}
}
