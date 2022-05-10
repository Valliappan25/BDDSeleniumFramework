package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static WebDriver driver;
	static ChromeOptions option;
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static WebDriver openBrowser(String browser) {
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().cachePath("Driver").setup();
			//option = new ChromeOptions();
			//option.addArguments("--headless");
			driver = new ChromeDriver();
			//driverAction();
			return driver;
		}
		
		else
		{
			WebDriverManager.edgedriver().cachePath("Driver").setup();
			driver = new EdgeDriver();
			//driverAction();
			return driver;
		}
	}
	
	
}
