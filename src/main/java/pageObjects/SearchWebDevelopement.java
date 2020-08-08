package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


// 		THIS CLASS SEARCHES FOR THE REQUIRED COURSE IN THE HOMEPAGE:



public class SearchWebDevelopement {
		public WebDriver driver;
		By search_topic=By.xpath("//input[@name='q']");

		public SearchWebDevelopement(WebDriver driver){
			this.driver=driver;
		}
		
		public void Search(String str) {
			driver.findElement(search_topic).sendKeys(str);
			driver.findElement(search_topic).sendKeys(Keys.ENTER);
		}
	}
