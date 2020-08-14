package MyFirstProject.AutomatingUdemy;


import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import pageObjects.SearchWebDevelopement;
import pageObjects.UdemyPagesFunctionality;
import resources.BrowserSetup;
import resources.CreatingWorkbook;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Listeners(MyFirstProject.AutomatingUdemy.Listeners.class)

public class UdemyTest extends BrowserSetup {

	WebDriver driver;
	SearchWebDevelopement obj1;
	UdemyPagesFunctionality obj2;

	private static final Logger log = LogManager.getLogger(UdemyTest.class);


	@BeforeTest
	@Parameters("browserName")
	public void setup(String browserName) throws IOException
	{
		driver=initializeDriver(browserName);
		log.info("driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");
		obj2=new UdemyPagesFunctionality(driver);
		obj2.maximizeWindow(driver);
		log.info("Navigated to homepage");
	}


	@Test(priority=0)
	public void correctSearchWeb()
	{
		obj1=new SearchWebDevelopement(driver);
		obj1.Search("web developement");
		boolean status=driver.findElement(By.xpath("//select[@name='sort']")).isDisplayed();
		Assert.assertTrue(status);
		log.info("Correct course searched");

	}


	@Test(priority=1)
	public void filterCheckForLevel()
	{
		obj2=new UdemyPagesFunctionality(driver);
		obj2.selectFiltersForLevel();
		boolean s=driver.getCurrentUrl().contains("beginner");
		Assert.assertTrue(s);
		log.info("Filters applied for level=beginner");

	}


	@Test(priority=2)
	public void filterCheckForLanguage()
	{
		obj2=new UdemyPagesFunctionality(driver);
		obj2.selectFiltersForLangage();
		boolean s=driver.getCurrentUrl().contains("lang=en");
		Assert.assertTrue(s);
		log.info("Filters applied for language=English");

	}


	@Test(priority=3)
	public void printConsole() throws IOException
	{

		CreatingWorkbook wb=new CreatingWorkbook(driver);
		wb.creation();
		boolean s=driver.getCurrentUrl().contains("lang=en");
		Assert.assertTrue(s);
		log.info("Available courses printed in FinalOutput.xlxs");

	}


//	NEGATIVE TESTS:-

	@Test(priority=4)
	public void wrongSearchWeb()
	{
		obj1=new SearchWebDevelopement(driver);
		obj1.searchJava();
		boolean s=driver.getCurrentUrl().contains("development");
		Assert.assertFalse(s);
		log.error("Wrong course is searched");
	}


	@Test(priority=5)
	public void negativeFilterCheckForLevel()
	{
		obj2=new UdemyPagesFunctionality(driver);
		obj2.selectFiltersForLevelIntermediate();
		boolean status=driver.getCurrentUrl().contains("beginner");
		Assert.assertFalse(status);
		log.error("filter for level selected is wrong");
	}


	@Test(priority=6)
	public void negativeFilterCheckForLanguage2()
	{
		obj2=new UdemyPagesFunctionality(driver);
		obj2.selectFiltersForLangageSpanish();
		boolean status=driver.getCurrentUrl().contains("lang=en");
		Assert.assertFalse(status);
		log.error("filter for language selected is wrong");
	}

	@Test(priority=7)
	public void noCourseSearched()
	{
		obj1=new SearchWebDevelopement(driver);
		obj1.searchNoText();
		boolean s=driver.getCurrentUrl().contains("development");
		Assert.assertFalse(s);
		log.error("No course searched");
	}


	@AfterTest
	public void exit()
	{
		driver.quit();
	}
}

