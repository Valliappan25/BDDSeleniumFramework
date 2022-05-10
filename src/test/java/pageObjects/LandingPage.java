package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

	public WebDriver driver;
	public WebDriverWait wait;
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
		//this.wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	By confirmLanding = By.xpath("//*[@id='root']/div/header/div/div[1]");
	By searchBox = By.xpath("//*[@type='search']");
	By topDeals = By.linkText("Top Deals");
	By productName = By.cssSelector("h4.product-name");
	
	public String landingPageConfirmation()
	{
		return driver.findElement(confirmLanding).getText();
	}
	
	public void clickTopDealsLink()
	{
		driver.findElement(topDeals).click();
	}
	
	public void enterproductName(String name)
	{
		driver.findElement(searchBox).sendKeys(name);	
	}
	
	public String getProductName()
	{
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver.findElement(productName).getText();
	}
}
