package MyFirstProject.AutomatingUdemy;


import org.testng.annotations.Test;
import org.testng.Assert;
import pageObjects.SearchWebDevelopement;
import pageObjects.UdemyPagesFunctionality;
import resources.BrowserSetup;
import resources.CreatingWorkbook;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners(MyFirstProject.AutomatingUdemy.Listeners.class)

public class UdemyTest extends BrowserSetup {

	WebDriver driver;
	SearchWebDevelopement obj;
	private static final Logger log = LogManager.getLogger(UdemyTest.class);


	@BeforeTest
	public void setup() throws IOException
	{
		driver=initializeDriver();

		log.info("driver is initialized");

		driver.get(prop.getProperty("url"));

		log.info("Navigated to homepage");

		UdemyPagesFunctionality ob=new UdemyPagesFunctionality(driver);

		ob.maximizeWindow(driver);

		log.info("Navigated to homepage");
	}


	@Test(priority=0)
	public void correctSearchWeb()
	{
		 obj=new SearchWebDevelopement(driver);

		obj.Search("web developement");

		boolean status=driver.findElement(By.xpath("//select[@name='sort']")).isDisplayed();
		Assert.assertTrue(status);

		log.info("Correct course searched");

	}


	@Test(priority=1)
	public void filterCheckForLevel()
	{
		UdemyPagesFunctionality ob=new UdemyPagesFunctionality(driver);

		ob.selectFiltersForLevel();

		boolean s=driver.getCurrentUrl().contains("beginner");
		Assert.assertTrue(s);

		log.info("Filters applied for level=beginner");

	}


	@Test(priority=2)
	public void filterCheckForLanguage()
	{
		UdemyPagesFunctionality ob=new UdemyPagesFunctionality(driver);

		ob.selectFiltersForLangage();

		boolean s=driver.getCurrentUrl().contains("lang=en");
		Assert.assertTrue(s);

		log.info("Filters applied for language=English");

	}


	@Test(priority=4)
	public void printConsole() throws IOException
	{

		CreatingWorkbook wb=new CreatingWorkbook(driver);
		wb.creation();
		boolean s=driver.getCurrentUrl().contains("lang=en");
		Assert.assertTrue(s);
		log.info("Available courses printed in FinalOutput.xlxs");

	}


//	NEGATIVE TESTS:-

	@Test(priority=5)
	public void wrongSearchWeb()
	{
		UdemyPagesFunctionality ob=new UdemyPagesFunctionality(driver);
		ob.searchJava();
		boolean s=driver.getCurrentUrl().contains("development");
		Assert.assertFalse(s);

		log.error("Wrong course is searched");
	}


	@Test(priority=6)
	public void negativeFilterCheckForLevel()
	{
		UdemyPagesFunctionality ob=new UdemyPagesFunctionality(driver);
		ob.selectFiltersForLevelIntermediate();

		boolean status=driver.getCurrentUrl().contains("beginner");
		Assert.assertFalse(status);
		log.error("filter for level selected is wrong");
	}


	@Test(priority=7)
	public void negativeFilterCheckForLanguage2()
	{
		UdemyPagesFunctionality ob=new UdemyPagesFunctionality(driver);
	    ob.selectFiltersForLangageBahasa();

	    boolean status=driver.getCurrentUrl().contains("lang=en");
	    Assert.assertFalse(status);
	    log.error("filter for language selected is wrong");
	}


	@AfterTest
	public void exit()
	{
		driver.quit();
	}
}

