package stepDefinitions;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utilities.DriverFactory;
import utilities.TestContextSetup;

public class LandingPageStepDefinition {

	public LandingPage landingPage;
	String landingPageText = null;
	TestContextSetup testContext;
	public LandingPageStepDefinition(TestContextSetup testContext)
	{
		this.testContext = testContext;
		this.landingPage = testContext.pageObjectManager.getLandingPageInstance(); 
	}
	
	@Given("user is on Greenkart Landing page")
	public void user_is_on_greenkart_landing_page() {
		  
		  String text = landingPage.landingPageConfirmation(); 
		  System.out.println(text);
		  Assert.assertTrue(text.contains("GREEN"));	
	}
	@When("user search with Shortname {string} and extract actual name of product")
	public void user_search_with_shortname_and_extract_actual_name_of_product(String name) throws InterruptedException  {
	   
		landingPage.enterproductName(name);
		Thread.sleep(2000);
		testContext.landingPageText = landingPage.getProductName().split("-")[0].trim();
		System.out.println(testContext.landingPageText);
		
	}
	
}
