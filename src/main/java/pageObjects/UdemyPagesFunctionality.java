package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


// THIS CLASS CONATAINS ALL THE FUNCTIONALITY

public class UdemyPagesFunctionality {
	public WebDriver driver;

	//	XPATH USED IN THE PROJECT
	By filterContainer= By.xpath("//div[@class='filter-panel--sidebar--L2lAU']");
	By beginner=By.xpath("//*[text()='Beginner' and @class='udlite-toggle-input-container udlite-text-sm']");
	By intermediate=By.xpath("//*[text()='Intermediate' and @class='udlite-toggle-input-container udlite-text-sm']");
	By language=By.xpath("//label[contains(text(),'Language')]");
	By english=By.xpath("//fieldset[@name='Language']//label[@class='udlite-toggle-input-container udlite-text-sm'][contains(text(),'English')]");
	By Spanish=By.xpath("//fieldset[@name='Language']//label[@class='udlite-toggle-input-container udlite-text-sm'][contains(text(),'Español')]");

	public UdemyPagesFunctionality(WebDriver driver)
	{
		this.driver=driver;
	}

//	TO MAXIMIZE THE WINDOW

	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}


	//	TO SEARCH THE ELEMENT WHERE FILTER(LEVEL=BEGINNER)
	public void selectFiltersForLevel() {
		List<WebElement> dropdowns = driver.findElements(filterContainer);

		for (int i = 0; i < dropdowns.size(); i++)
		{
			String value = driver.findElements(filterContainer).get(i)
					.getText();

			if (value.contains("Level"))
			{
				driver.findElement(beginner).click();
			}
		}
	}


//	 TO SEARCH THE ELEMENT WHERE FILTER(LEVEL=INTERMEDIATE)

	public void selectFiltersForLevelIntermediate() {
		List<WebElement> dropdowns = driver.findElements(filterContainer);

		for (int i = 0; i < dropdowns.size(); i++)
		{
			String value = driver.findElements(filterContainer).get(i)
					.getText();

			if (value.contains("Level"))
			{
				driver.findElement(intermediate).click();
			}
		}
	}


//		TO SEARCH THE ELEMENT WHERE FILTER(LANGUAGE=ENGLISH)

	public void selectFiltersForLangage() {
		List<WebElement> dropdown = driver.findElements(filterContainer);
		for (int i = 0; i < dropdown.size(); i++)
		{

			String value = driver.findElements(filterContainer).get(i).getText();

			if (value.contains("Language"))
			{

				driver.findElement(language).click();
				driver.findElement(english).click();
			}
		}
	}


	//		TO SEARCH THE ELEMENT WHERE FILTER(LANGUAGE=SPANISH)
	public void selectFiltersForLangageSpanish() {
		List<WebElement> dropdown = driver.findElements(filterContainer);
		for (int i = 0; i < dropdown.size(); i++)
		{

			String value = driver.findElements(filterContainer).get(i).getText();

			if (value.contains("Language"))
			{

				driver.findElement(language).click();
				driver.findElement(Spanish).click();
			}
		}


	}

}