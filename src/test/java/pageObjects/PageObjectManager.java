package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	private WebDriver driver;
	
	private LandingPage landingPage;
	private OfferPage offerPage;
	private CheckoutPage checkOut;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public LandingPage getLandingPageInstance()
	{
		landingPage = new LandingPage(driver);
		
		return landingPage;
	}
	
	public CheckoutPage getCheckOutPageInstance()
	{
		checkOut = new CheckoutPage(driver);
		
		return checkOut;
	}
	
	public OfferPage getOfferPageInstance()
	{
		offerPage = new OfferPage(driver);
		
		return offerPage;
	}
}
