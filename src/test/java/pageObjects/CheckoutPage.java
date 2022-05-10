package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	private WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		this.driver = driver;	
	}
	
	By cartBag =By.cssSelector("[alt='Cart']");
	By checkOutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promoCodeBox = By.cssSelector("input.promoCode");
	By promoCodeButton = By.cssSelector("button.promobtn");
	By orderButton = By.xpath("//button[contains(text(),'Place Order')]");
	By productName = By.xpath("//*[@id=\"productCartTables\"]/tbody/tr/td[2]/p");
	By quantity = By.cssSelector("input.quantity");
	By addToCart = By.xpath("//button[contains(text(),'ADD TO CART')]");
	
	public void checkOutItems()
	{
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
	}
	
	public Boolean verifyPromoCodeButton()
	{
		return driver.findElement(promoCodeButton).isDisplayed(); 
	}
	
	public Boolean verifyPlaceOrderButton()
	{
		return driver.findElement(orderButton).isDisplayed();
	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}
	
	public void enterProductQuantityAndAddToCart(String qty)
	{
		driver.findElement(quantity).clear();
		driver.findElement(quantity).sendKeys(qty);	
		driver.findElement(addToCart).click();
		
	}
}
