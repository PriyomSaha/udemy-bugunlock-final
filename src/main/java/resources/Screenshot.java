package resources;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


// THIS CLASS TAKES SCREENSHOT

public class Screenshot {
	
	public static void captureScreenshot(WebDriver driver, String screenshotname) 
	{
		try 
		{
			File ts = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					
			FileUtils.copyFile(ts, new File(".\\Output\\Screenshots\\"+screenshotname+".png"));
		} 
		
		catch (Exception e) 
		{
			System.out.println("Exception while taking screenshot "+e.getMessage());
			
		} 

	}
}
