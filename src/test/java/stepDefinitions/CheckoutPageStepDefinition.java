package stepDefinitions;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utilities.DriverFactory;
import utilities.TestContextSetup;

public class CheckoutPageStepDefinition {

	public CheckoutPage checkoutPage;
	String landingPageText = null;
	TestContextSetup testContext;
	public CheckoutPageStepDefinition(TestContextSetup testContext)
	{
		this.testContext = testContext;
		this.checkoutPage = testContext.pageObjectManager.getCheckOutPageInstance();
	}
	
	@When("Added {string} item of selected product to cart")
	public void added_item_of_selected_product_to_cart(String quantity)  {
	    
		checkoutPage.enterProductQuantityAndAddToCart(quantity);
		
	}
	@Then("user proceed to checkout and validate {string} in checkout page")
	public void user_proceed_to_checkout_and_validate_in_checkout_page(String name) throws InterruptedException {
		
		checkoutPage.checkOutItems();
		Thread.sleep(2000);
		Assert.assertTrue(checkoutPage.getProductName().contains(name));
	}
	@And("user havs ability to enter promo code and place the order")
	public void user_havs_ability_to_enter_promo_code_and_place_the_order() {
	  
		Assert.assertTrue(checkoutPage.verifyPromoCodeButton());
		Assert.assertTrue(checkoutPage.verifyPlaceOrderButton());
	}
	
}
