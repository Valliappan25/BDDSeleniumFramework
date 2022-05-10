package utilities;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class CommonFunctionsClass {

	private WebDriver driver;

	public CommonFunctionsClass(WebDriver driver) {
		this.driver = driver;
	}
	
	public void switchToChildWindow()
	{
		String parent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		String child = null;
		
		for(String window : windows)
		{
			if(!parent.equalsIgnoreCase(window))
				child = window;
		}
		
		driver.switchTo().window(child);
	}
	
	public void propertyFileReader() {
		
		Properties properties = new Properties();
				try {
					System.out.println("Loading Properties File");
					properties.load(getClass().getResourceAsStream("/Config.properties"));
					System.out.println("property file detected and loaded successfully");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(properties.getProperty("browser"));
		Constants.browser = properties.getProperty("browser");
		Constants.url = properties.getProperty("url");
	}
}
