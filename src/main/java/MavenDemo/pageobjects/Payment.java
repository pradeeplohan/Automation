package MavenDemo.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MavenDemo.AbstractComponants.AbstractComponet;

public class Payment extends AbstractComponet {
	
	WebDriver driver;
	
	public Payment(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Using PageFactory
	//driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("ind");
	@FindBy(css="input[placeholder='Select Country']")
	WebElement enterCountry;
	
	//List<WebElement> countries = driver.findElements(By.xpath("//button/span"));
	@FindBy(xpath="//button/span")
	List<WebElement> searchCountryEle;
	
	//driver.findElement(By.cssSelector(".btnn")).click();
	@FindBy(css=".btnn")
	WebElement submitPay;
	
	//String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
	@FindBy(css=".hero-primary")
	WebElement message;
	
	public void typeCounty(String country)
	{
		enterCountry.sendKeys(country);
	}
	
	public List<WebElement> serchCountry()
	{
		List<WebElement> countries = searchCountryEle;
		return countries;
		
	}
	
	public WebElement filterCountry(String country)
	{
		WebElement con = serchCountry().stream().filter(countries -> 
		countries.getText().equalsIgnoreCase(country)).findAny().orElse(null);
		return con;
	}
	
	public void selectCountry(String country)
	{
		WebElement con = filterCountry(country);
		con.click();	
	}
	
	public void placeOrder()
	{
		submitPay.click();
	}
	
	public String getMessage()
	{
		String confirmMessage = message.getText();
		return confirmMessage;
	}
	
	
}
