package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import pageObjects.PageObjectManager;
import utilities.TestContextSetup;

public class OfferPageStepDefinition {

	//public static WebDriver driver;
	String offerPageText = null;
	OfferPage offerPage;
	PageObjectManager pageObjectManager;
	
	TestContextSetup testContext;
	public OfferPageStepDefinition(TestContextSetup testContext)
	{
		this.testContext = testContext;
	}
	
	@Then("user search for {string} Shortname in offer page.")
	public void user_search_for_shortname_in_offer_page(String name) throws InterruptedException {
		
		offerPage = testContext.pageObjectManager.getOfferPageInstance();
		
		switchToOfferPage();
		
		offerPage.enterProductName(name);
		
		offerPageText = offerPage.getProductName();
		System.out.println(offerPageText);
	}
	
	public void switchToOfferPage() throws InterruptedException
	{
		LandingPage landingPage = testContext.pageObjectManager.getLandingPageInstance();
		landingPage.clickTopDealsLink();
		testContext.commonFunction.switchToChildWindow();
		Thread.sleep(2000);
	}
	
	@And("Validate the product name in offer page with landing page")
	public void validate_the_product_name_in_offer_page_with_landing_page() {
		
		Assert.assertEquals(testContext.landingPageText, offerPageText);
	}
}
