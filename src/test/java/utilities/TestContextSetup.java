package utilities;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {
	
	public WebDriver driver;
	public String landingPageText = null;
	public PageObjectManager pageObjectManager;
	public BaseTest baseTest;
	public CommonFunctionsClass commonFunction;
	public TestContextSetup testContext;
	
	public TestContextSetup()
	{
		baseTest = new BaseTest();
		pageObjectManager = new PageObjectManager(baseTest.initializeDriver());
		commonFunction = new CommonFunctionsClass(baseTest.initializeDriver());
	}
}
