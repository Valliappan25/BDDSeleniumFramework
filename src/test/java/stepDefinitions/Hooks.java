package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.TestContextSetup;

public class Hooks {

	TestContextSetup testContext;
	//WebDriver driver;
	public Hooks(TestContextSetup testContext)
	{
		this.testContext = testContext;
	}
	
	@Before
	public void openBrowser()
	{
		//driver = testContext.baseTest.initializeDriver();
	}
	
	
	@After
	public void closeBrowser()
	{
		testContext.baseTest.initializeDriver().quit();
		
	}
	
	@AfterStep
	public void takeScreenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			byte[] screenshot = ((TakesScreenshot)testContext.baseTest.initializeDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}
}
