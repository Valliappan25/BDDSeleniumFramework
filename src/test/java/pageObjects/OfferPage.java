package pageObjects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OfferPage {

	public WebDriver driver;
	public WebDriverWait wait;
	public OfferPage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	}

	By searchBox = By.id("search-field");
	By searchResult = By.xpath("//*[@class='table table-bordered']/tbody/tr[1]/td[1]");
	
	public void enterProductName(String name)
	{
		driver.findElement(searchBox).sendKeys(name);
	}
	
	public String getProductName() {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(searchResult));
		return driver.findElement(searchResult).getText();
	}
	
}
