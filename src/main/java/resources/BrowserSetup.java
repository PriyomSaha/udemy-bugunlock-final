package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserSetup {
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver(String browserName) throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
				"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		//String browserName = prop.getProperty("Browser");

		String nodeUrl = "http://192.168.0.104:4444/wd/hub";

		if (browserName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();


			//Desired capabilities
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setBrowserName("chrome");
			capabilities.setPlatform(Platform.WIN10);
			//Options
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-infobars");
			//options.merge(capabilities);
			capabilities.setCapability(ChromeOptions.CAPABILITY,options);
			//Remote access
			driver = new RemoteWebDriver(new URL(nodeUrl), options);
		}

		else if(browserName.equalsIgnoreCase("firefox")){

			WebDriverManager.firefoxdriver().setup();
			//Desired capabilities
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setBrowserName("firefox");
			capabilities.setPlatform(Platform.WIN10);
			//Options
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--disable-infobars");
			//options.merge(capabilities);
			capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS,options);
			//Remote access
			driver = new RemoteWebDriver(new URL(nodeUrl), options);

		}

		else if(browserName.equalsIgnoreCase("edge")){

			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("opera")){

			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

}
