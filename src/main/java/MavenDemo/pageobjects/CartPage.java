package MavenDemo.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MavenDemo.AbstractComponants.AbstractComponet;

public class CartPage extends AbstractComponet {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Using PageFactory
	//List<WebElement> cart = driver.findElements(By.cssSelector(".cartSection h3"));
	@FindBy(css=".cartSection h3")
	List<WebElement> cartElements;
	
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	@FindBy(css=".totalRow button")
	WebElement clickButton;
	
	
	
	public boolean verifyProductDisplay(String myProd)
	{
		boolean match = cartElements.stream().anyMatch(product -> product.getText().equals(myProd));
		return match;
	}
	
	public Payment clickCheckout()
	{
		clickButton.click();
		Payment payment = new Payment(driver);
		return payment;
	}
	
	
	
}
