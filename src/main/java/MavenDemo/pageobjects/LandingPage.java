package MavenDemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MavenDemo.AbstractComponants.AbstractComponet;

public class LandingPage extends AbstractComponet {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//WebElement userEmail = driver.findElement(By.id("userEmail"));
	//Using PageFactory
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement passwordEle;
	
	@FindBy(id="login")
	WebElement submitButton;
	
	@FindBy(xpath="//div[contains(@class,'toast-message')]")
	WebElement errorMessage;
	
	By findBy = By.xpath("//div[contains(@class,'toast-message')]");
	
	public String getErrorMessage() {
		
		//waitForVisibiltyofWebEle(errorMessage);
		waitForVisibiltyofEle(findBy);
		return errorMessage.getText();
		
	}
	
	public ProductCatalogue loginWebsite(String email, String password)
	{
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submitButton.click();
		ProductCatalogue pCat = new ProductCatalogue(driver);
		return pCat;
	}
	
	public void gotoWeb()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
}
