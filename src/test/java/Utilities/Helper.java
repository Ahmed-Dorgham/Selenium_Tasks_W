package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	
	
public static void takeScreenshot (WebDriver driver ,String screenshotName) throws IOException
{
	TakesScreenshot screenshot = (TakesScreenshot) driver ;
	
	File src = screenshot.getScreenshotAs(OutputType.FILE);
	File dest = new File("./Screenshots/"+ screenshotName+ ".png");
	FileUtils.copyFile(src, dest);
}

}
