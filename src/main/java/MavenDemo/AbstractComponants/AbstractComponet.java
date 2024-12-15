package MavenDemo.AbstractComponants;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MavenDemo.pageobjects.CartPage;

public class AbstractComponet {
	WebDriver driver;
	
	public AbstractComponet(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//driver.findElement(By.cssSelector("button[routerlink*='cart']"))
	@FindBy(css="button[routerlink*='cart']")
	WebElement cartHeader;
	
	public CartPage goToCartPage()
	{
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}

	public void waitForVisibiltyofEle(By elementLoc) 
	{
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementLoc));  
	
	}
	
	public void waitForVisibiltyofWebEle(WebElement elementLoc) 
	{
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOf(elementLoc));  
	
	}
	
	public void waitForInvisibiltyofEle(WebElement webElementLoc) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(webElementLoc));
	}

}
