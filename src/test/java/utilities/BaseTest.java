package utilities;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class BaseTest {

	 WebDriver driver;
	 TestContextSetup testContext;
	 public CommonFunctionsClass commonFunction;
	
	 String property_browser = Constants.browser;
	 String maven_browser = System.getProperty("browser");
	 
	 String browser = maven_browser!=null ? maven_browser:property_browser;
	 
	public WebDriver initializeDriver()	{
		commonFunction = new CommonFunctionsClass(DriverFactory.getDriver());
		commonFunction.propertyFileReader();	
		if(driver == null)
		{
			
			driver = DriverFactory.openBrowser(browser);
			driverAction();
			
		}
		return driver;
	}
	
	public void driverAction()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get(Constants.url);
	}
}
